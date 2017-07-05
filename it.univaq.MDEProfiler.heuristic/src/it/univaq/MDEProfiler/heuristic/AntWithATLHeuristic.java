package it.univaq.MDEProfiler.heuristic;

import java.awt.GradientPaint;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.Task;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import it.univaq.MDEProfiler.graph.model.graph.Edge;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class AntWithATLHeuristic implements IHeuristic {

	private Logger logger = Logger.getLogger(AntWithATLHeuristic.class);
	private String nodeKind = "NodeType.ANT";
	private String modelKind = "NodeType.Model";
	private Graph g;
	private String metametamodel = "NodeType.MetaMetaModel";
	private static String ecoreNodeString = "NodeType.Ecore";
	private static Node ecoreNode;
	private static String source = "SOURCE";
	private static String target = "TARGET";
	private static String lib = "LIBRARY";
	private static String modelIn = "MODEL_INPUT";
	private static String modelOut = "MODEL_OUT";
	private static String metamodelConformance = "CONFORM2";
	private HashMap<String, RuntimeConfigurable> loadModel = new HashMap<String, RuntimeConfigurable>();
	public AntWithATLHeuristic(){
		ecoreNode = GraphFactory.eINSTANCE.createNode();
		ecoreNode.setName("Ecore");
		ecoreNode.setFilePath("Ecore");
		ecoreNode.getType().add(ecoreNodeString );
	}
	
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(nodeKind)).
				collect(Collectors.toList())) {
			g.getEdges().addAll(getEdges(n));
		}
		return g;
	}

	public Project getProject(String pathBuildFile) throws Exception{
		Project project = new Project();
		// "/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/build.xml"
		File buildFile = new File(pathBuildFile);
		project.init();
		ProjectHelper.configureProject(project, buildFile);
		return project;
	}

	public List<Edge> getEdges(Node antScriptNode) {
		List<Edge> results = new ArrayList<Edge>();
		try {
		Project project = getProject(antScriptNode.getFilePath());
		Hashtable<String, Target> t = project.getTargets();
		Set<String> keys = t.keySet();
		
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			// Getting Key
			String str = itr.next();
			List<Task> tasks = Arrays.asList(t.get(str).getTasks());
			for (Task task : tasks.stream().
					filter(task -> task.getTaskName().equals("am3.loadModel")).
					collect(Collectors.toList())) {
				String taskName = (String) task.getRuntimeConfigurableWrapper().getAttributeMap().get("name");
				loadModel.put(getRealValue(taskName, project), task.getRuntimeConfigurableWrapper());
			}
		}
		itr = keys.iterator();
		while (itr.hasNext()) {
			String str = itr.next();
			List<Task> tasks = Arrays.asList(t.get(str).getTasks());
			for (Task task : tasks.stream().
					filter(task -> task.getTaskName().equals("am3.atl")).
					collect(Collectors.toList())) {
				String trafoPath = (String) task.getRuntimeConfigurableWrapper().getAttributeMap().get("path");
				String realTrafoPath = getRealValue(trafoPath, project).replaceAll("\\.asm", ".atl");
				File antFile = new File(antScriptNode.getFilePath());
				Node trafoNode = FileUtils.getNodeByFilePath(g, antFile.getParent() +"/" + realTrafoPath);
				if (trafoNode == null) 
					trafoNode = FileUtils.getNodeByFilePathLazy(g, realTrafoPath);
				if (trafoNode != null) {
					Enumeration<RuntimeConfigurable> childs = task.getRuntimeConfigurableWrapper().getChildren();
					HashMap<String, ModelInfo> modelInfoMap = recoveryLink(trafoNode);
					while (childs.hasMoreElements()) {
						Edge ed = GraphFactory.eINSTANCE.createEdge();
						ed.setPathDiscoveredByHeuristic(realTrafoPath);
						ed.setDiscoverBy(antScriptNode);
						ed.setExact(true);
						ed.setSource(trafoNode);
						RuntimeConfigurable ne = childs.nextElement();
						if (ne.getElementTag().equals("inModel")) {
							
							
							
							String elementRealValue = getRealValue(ne.getAttributeMap().get("model").toString(), project);
							ModelInfo elementInfo = modelInfoMap.get(elementRealValue);
							if(elementInfo != null){
								//Potrebbe essere null il path,
								//Guardare nel caso nsUri
								if(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("path") != null){
									String antValue = loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("path").toString();
									String antResolvedValue = getRealValue(antFile.getParent() + "/" + antValue, project);
									antResolvedValue += getLastValue(antValue, project);
									Node metamodel = FileUtils.getNodeByFilePath(g, antResolvedValue);
									if(metamodel == null){
										metamodel = FileUtils.getNodeByFilePathLazy(g, antResolvedValue);
										ed.setExact(false);
									}
									ed.setTarget(metamodel);
									if(elementInfo.isInput())
										ed.setName(source);
									if(elementInfo.isOutput())
										ed.setName(target);
								}
								if(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("nsUri") != null){
									Node uri;
									Optional<Node> node = g.getNodes().stream().
										filter(z -> z.getFilePath().equals(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("nsUri").toString())).findFirst();
									if(node.isPresent())
										uri = node.get();
									else {
										uri = GraphFactory.eINSTANCE.createNode();
										uri.setDerivedOrNotExists(false);
										uri.setName(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("name").toString());
										uri.setFilePath(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("nsUri").toString());
										uri.getType().add(metametamodel);
										g.getNodes().add(uri);
									}
									ed.setTarget(uri);
									if(elementInfo.isInput())
										ed.setName(source);
									if(elementInfo.isOutput())
										ed.setName(target);
								}
							}
							else{
								//IN MODEL
								if(elementRealValue.equals("%EMF")){
									g.getNodes().add(ecoreNode);
									Edge e = GraphFactory.eINSTANCE.createEdge();
									e.setExact(true);
									
									
								}
								else if(loadModel.get(elementRealValue).getAttributeMap().get("path")!=null){
									String modelAntValue = loadModel.get(elementRealValue).getAttributeMap().get("path").toString();
									modelAntValue = getRealValue(modelAntValue, project);
									String metamodelANTValue = getRealValue(loadModel.get(elementRealValue).getAttributeMap().get("metamodel").toString(),project);
									RuntimeConfigurable metamodelRuntimeConfigurable = loadModel.get(metamodelANTValue);
									Node model = FileUtils.getNodeByFilePath(g, antFile.getParent() + File.separator + modelAntValue);
									if (model == null) {
										model = FileUtils.getNodeByFilePathLazy(g, antFile.getParent() + File.separator + modelAntValue);
									}
									if (model == null){
										model = GraphFactory.eINSTANCE.createNode();
										model.setDerivedOrNotExists(true);
										model.setFilePath(antFile.getPath() + File.separator + modelAntValue);
										g.getNodes().add(model);
									}
									String modelAntName = getRealValue(ne.getAttributeMap().get("model").toString(), project);
									String metamodelName = getRealValue(loadModel.get(modelAntName).getAttributeMap().get("metamodel").toString(),project);
									if(loadModel.get(metamodelName).getAttributeMap().get("path") != null){
										String metamodelPath = getRealValue(loadModel.get(metamodelName).getAttributeMap().get("path").toString(), project);
										Node metamodelNode = FileUtils.getNodeByFilePath(g, metamodelPath);
										Edge e = GraphFactory.eINSTANCE.createEdge();
										e.setExact(true);
										if(metamodelNode == null){
											metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodelPath);
											e.setExact(false);
										}
										e.setDiscoverBy(antScriptNode);
										e.setName(metamodelConformance);
										e.setTarget(metamodelNode);
										e.setSource(model);
										g.getEdges().add(e);
										ed.setTarget(model);
										ed.setName(modelIn);
									}
									if(loadModel.get(metamodelName).getAttributeMap().get("nsUri") != null){
										Edge e = GraphFactory.eINSTANCE.createEdge();
										e.setExact(true);
										Node metamodelNode;
										Optional<Node> node = g.getNodes().stream().
											filter(z -> z.getFilePath().equals(loadModel.get(metamodelName).getAttributeMap().get("nsUri").toString())).findFirst();
										if(node.isPresent())
											metamodelNode = node.get();
										else {
											metamodelNode = GraphFactory.eINSTANCE.createNode();
											metamodelNode.setDerivedOrNotExists(false);
											metamodelNode.setName(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("name").toString());
											metamodelNode.setFilePath(loadModel.get(elementInfo.getMetamodelName()).getAttributeMap().get("nsUri").toString());
											metamodelNode.getType().add(metametamodel);
											g.getNodes().add(metamodelNode);
										}
										e.setDiscoverBy(antScriptNode);
										e.setName(metamodelConformance);
										e.setTarget(metamodelNode);
										e.setSource(model);
										g.getEdges().add(e);
										ed.setTarget(model);
										ed.setName(modelIn);
									}
								}
								
							}
						}
						if(ne.getElementTag().equals("library")){
							ed.setName(lib);
							String elementRealValue = getRealValue(ne.getAttributeMap().get("path").toString(), project);
							Node metamodel = FileUtils.getNodeByFilePath(g, elementRealValue);
							if(metamodel == null){
								metamodel = FileUtils.getNodeByFilePathLazy(g, elementRealValue);
								ed.setExact(false);
							}
							ed.setTarget(metamodel);
						}
						if(ne.getElementTag().equals("outModel")){
							Node model = getNodeOut(ne, project, antScriptNode);
							ed.setTarget(model);
							ed.setName(modelOut);
						}
						results.add(ed);
					}
				}
			}
		}
		}
		catch (Exception e) {
			antScriptNode.getType().remove("NodeType.ANT");
			logger.error(e.getMessage());
		}
		return results;
	}
	
	private Node getNodeOut(RuntimeConfigurable trafoElementRuntimeConfigurable, Project project, Node antScriptNode){
		File antFile = new File(antScriptNode.getFilePath());
		String modelRC = getRealValue(trafoElementRuntimeConfigurable.getAttributeMap().get("model").toString(), project);
		String name = getRealValue(trafoElementRuntimeConfigurable.getAttributeMap().get("name").toString(), project);
		String metamodel = getRealValue(trafoElementRuntimeConfigurable.getAttributeMap().get("metamodel").toString(), project);
		String outputPat = antFile.getParent() + File.separator + modelRC;
		trafoElementRuntimeConfigurable.setAttribute("path", outputPat);
		loadModel.put(modelRC, trafoElementRuntimeConfigurable);
		Node modelNode = FileUtils.getNodeByFilePath(g, outputPat); 
		if(modelNode == null){
			modelNode = GraphFactory.eINSTANCE.createNode();
			modelNode.setName(modelRC);
			modelNode.setFilePath(antFile.getParent() + File.separator + modelRC);
			modelNode.getType().add(modelKind);
			modelNode.setDerivedOrNotExists(true);
			g.getNodes().add(modelNode);
		}
		File tempFile = new File(modelNode.getFilePath());
		if(tempFile.exists())
			modelNode.setDerivedOrNotExists(true);

		if(!metamodel.equals("%EMF")){
			Node metamodelNode = FileUtils.getNodeByFilePath(g, metamodel);
			
			Edge conformanceEdge = GraphFactory.eINSTANCE.createEdge();
			conformanceEdge.setExact(true);
			if(metamodelNode == null){
				metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
				conformanceEdge.setExact(false);
			}
			conformanceEdge.setSource(modelNode);
			conformanceEdge.setDiscoverBy(antScriptNode);
			conformanceEdge.setName(metamodelConformance);
			if(metamodelNode == null){
				metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
			}
			conformanceEdge.setTarget(metamodelNode);
			
			//Aggiungere al grafo l'edge
			g.getEdges().add(conformanceEdge);
		}
		else {
			Edge conformanceEdge = GraphFactory.eINSTANCE.createEdge();
			conformanceEdge.setExact(true);
			conformanceEdge.setSource(modelNode);
			conformanceEdge.setTarget(ecoreNode);
			conformanceEdge.setDiscoverBy(antScriptNode);
			conformanceEdge.setName(metamodelConformance);
		}
		return modelNode;
	}
	
//	private Node getMetamodel(String metamodel){
//		if(!metamodel.equals("%EMF")){
//			Node metamodelNode = FileUtils.getNodeByFilePath(g, metamodel);
//			
//			Edge conformanceEdge = GraphFactory.eINSTANCE.createEdge();
//			conformanceEdge.setExact(true);
//			if(metamodelNode == null){
//				metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
//				conformanceEdge.setExact(false);
//			}
//			conformanceEdge.setSource(modelNode);
//			conformanceEdge.setDiscoverBy(antScriptNode);
//			conformanceEdge.setName(metamodelConformance);
//			if(metamodelNode == null){
//				metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
//			}
//			conformanceEdge.setTarget(metamodelNode);
//			
//			//Aggiungere al grafo l'edge
//			g.getEdges().add(conformanceEdge);
//		}
//	}


	private HashMap<String, ModelInfo> recoveryLink(Node trafoNode)  {
		
		HashMap<String, ModelInfo> result = new HashMap<String, ModelInfo>();
		AtlParser atlParser = new AtlParser();
		ModelFactory modelFactory = new EMFModelFactory();
		IReferenceModel atlMetamodel;
		try {
			atlMetamodel = modelFactory
					.getBuiltInResource("ATL.ecore");
			EMFModel atlDynModel = (EMFModel) modelFactory.newModel(atlMetamodel);
			atlParser.inject(atlDynModel, trafoNode.getFilePath());
			Resource originalTrafo = atlDynModel.getResource();
			ATLModel atlModel = new ATLModel(originalTrafo, originalTrafo.getURI()
					.toFileString(), true);
			List<ModelInfo> s = ATLUtils.getModelInfo(atlModel);
			for (ModelInfo modelInfo : s) {
				result.put(modelInfo.getMetamodelName(), modelInfo);
			}
			
		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getRealValue(String trafoPath, Project project) {
		String regExp = "\\$\\{[\\w.]*\\}";
		Pattern pattern = Pattern.compile(regExp);
		java.util.regex.Matcher matcher = pattern.matcher(trafoPath);
		if (!matcher.find())
			return trafoPath;
		String result = "";
		List<String> s = getProperties(trafoPath);
		int count = 0;
		String[] splitted = trafoPath.split(regExp);
		for (String string : s) {
			if (splitted.length > count)
				result += splitted[count++];

			result += project.getProperty(string);
		}
		if(splitted.length != 0)
			result += splitted[splitted.length-1];
		return result;
	}
	private String getLastValue(String trafoPath, Project project) {
		String regExp = "\\$\\{[\\w.]*\\}";
		Pattern pattern = Pattern.compile(regExp);
		java.util.regex.Matcher matcher = pattern.matcher(trafoPath);
		if (!matcher.find())
			return "";
		String[] splitted = trafoPath.split(regExp);
		if(splitted.length >= 1)
			return splitted[splitted.length-1];
		return "";
	}

	public List<String> getProperties(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null)
			return result;
		String regExp = "\\$\\{[\\w.]*\\}";
		Pattern pattern = Pattern.compile(regExp);
		java.util.regex.Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			result.add(matcher.group(0).replaceAll("\\$\\{", "").replaceAll("}", ""));
		}
		return result;
	}

}
