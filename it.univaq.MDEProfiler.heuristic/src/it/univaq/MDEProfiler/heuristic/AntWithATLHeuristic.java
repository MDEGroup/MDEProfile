package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

	private String nodeKind = "NodeType.ANT";
	private String modelKind = "NodeType.Model";
	private Graph g;
	private static String source = "SOURCE";
	private static String target = "TARGET";
	private static String lib = "LIBRARY";
	private static String modelIn = "MODEL_INPUT";
	private static String modelOut = "MODEL_OUT";
	private static String metamodelConformance = "CONFORM2";

	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		// TODO
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(nodeKind)).
				collect(Collectors.toList())) {
			g.getEdges().addAll(getEdges(n));
		}
		return g;
	}

	public Project getProject(String pathBuildFile) {
		Project project = new Project();
		// "/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/build.xml"
		File buildFile = new File(pathBuildFile);
		project.init();
		ProjectHelper.configureProject(project, buildFile);
		return project;
	}

	public List<Edge> getEdges(Node antScriptNode) {
		List<Edge> results = new ArrayList<Edge>();
		Project project = getProject(antScriptNode.getFilePath());
		Hashtable<String, Target> t = project.getTargets();
		Set<String> keys = t.keySet();
		HashMap<String, RuntimeConfigurable> modelNode = new HashMap<String, RuntimeConfigurable>();
		Iterator<String> itr = keys.iterator();
		while (itr.hasNext()) {
			// Getting Key
			String str = itr.next();
			List<Task> tasks = Arrays.asList(t.get(str).getTasks());
			for (Task task : tasks.stream().
					filter(task -> task.getTaskName().equals("am3.loadModel")).
					collect(Collectors.toList())) {
				String taskName = (String) task.getRuntimeConfigurableWrapper().getAttributeMap().get("name");
				modelNode.put(getRealValue(taskName, project), task.getRuntimeConfigurableWrapper());
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
				String realTrafoPath = getRealValue(trafoPath, project) + ".atl";
				File f = new File(antScriptNode.getFilePath());
				Node trafoNode = FileUtils.getNodeByFilePath(g, f.getParent() +"/" + realTrafoPath);
				if (trafoNode == null) 
					trafoNode = FileUtils.getNodeByFilePathLazy(g, realTrafoPath);
				if (trafoNode != null) {
					Enumeration<RuntimeConfigurable> childs = task.getRuntimeConfigurableWrapper().getChildren();
					HashMap<String, ModelInfo> modelInfoMap = recoveryLink(trafoNode);
					while (childs.hasMoreElements()) {
						Edge ed = GraphFactory.eINSTANCE.createEdge();
						ed.setPathDiscoveredByHeuristic(realTrafoPath);
						ed.setDiscoverBy(antScriptNode);
						ed.setSource(antScriptNode);
						ed.setExact(true);
						ed.setSource(trafoNode);
						RuntimeConfigurable ne = childs.nextElement();
						if (ne.getElementTag().equals("inModel")) {
							String elementRealValue = getRealValue(ne.getAttributeMap().get("model").toString(), project);
							ModelInfo elementInfo = modelInfoMap.get(elementRealValue);
							if(elementInfo != null){
								String antValue = modelNode.get(elementInfo.getMetamodelName()).getAttributeMap().get("path").toString();
								String antResolvedValue = getRealValue(f.getParent() + "/" + antValue, project);
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
								if(elementInfo.isInOut())
									System.out.println("Discovered Metamodel" + elementInfo);
							}
							else{
								//IN MODEL
								String antValue = modelNode.get(elementRealValue).getAttributeMap().get("path").toString();
								antValue = getRealValue(antValue, project);
								System.out.println("IN MODEL " + antValue);
								String antMMValue = getRealValue(modelNode.get(elementRealValue).getAttributeMap().get("metamodel").toString(),project);
								RuntimeConfigurable metamodelRuntimeConfigurable = modelNode.get(antMMValue);
								System.out.println("IN METAMODEL " + getRealValue(metamodelRuntimeConfigurable.getAttributeMap().get("path").toString(),project));
								//Controllare se il modello esiste nel grafo 
								//Se esiste restituirlo
								//Se non esiste crearlo e controllare se esiste nel filesystem
								Node model = FileUtils.getNodeByFilePath(g, f.getParent() + File.separator + antValue);
								if (model == null) {
									model = FileUtils.getNodeByFilePathLazy(g, f.getParent() + File.separator + antValue);
								}
								if (model == null){
									model = GraphFactory.eINSTANCE.createNode();
									model.setDerivedOrNotExists(true);
									model.setFilePath(f.getPath() + File.separator + antValue);
									g.getNodes().add(model);
								}
								String modelAntName = getRealValue(ne.getAttributeMap().get("model").toString(), project);
								String metamodelName = getRealValue(modelNode.get(modelAntName).getAttributeMap().get("metamodel").toString(),project);
								String metamodelPath = getRealValue(modelNode.get(metamodelName).getAttributeMap().get("path").toString(), project);
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
							// DA PUTTERE IN mapNode
							String s = getRealValue(ne.getAttributeMap().get("model").toString(), project);
							ne.setAttribute("path", f.getParent() + File.separator + s);
							modelNode.put(s, ne);
							Node model = GraphFactory.eINSTANCE.createNode();
							model.setName(s);
							model.setFilePath(f.getParent() + File.separator + s);
							model.getType().add(modelKind);
							g.getNodes().add(model);
							File tempFile = new File(model.getFilePath());
							if(tempFile.exists())
								model.setDerivedOrNotExists(true);
							String metamodel = getRealValue(ne.getAttributeMap().get("metamodel").toString(), project);
							Node metamodelNode = FileUtils.getNodeByFilePath(g, metamodel);
							Edge e = GraphFactory.eINSTANCE.createEdge();
							e.setExact(true);
							if(metamodelNode == null){
								metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
								e.setExact(false);
							}
							e.setSource(model);
							e.setDiscoverBy(antScriptNode);
							e.setName(metamodelConformance);
							if(metamodelNode == null){
								metamodelNode = FileUtils.getNodeByFilePathLazy(g, metamodel);
							}
							e.setTarget(metamodelNode);
							results.add(e);
							ed.setTarget(model);
							ed.setName(modelOut);
						}
							
						results.add(ed);
					}
				}
			}
		}
		return results;
	}


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
