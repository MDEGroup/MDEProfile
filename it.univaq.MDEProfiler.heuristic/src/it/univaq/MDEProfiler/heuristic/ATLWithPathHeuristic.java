package it.univaq.MDEProfiler.heuristic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atlext.ATL.ATLPackage;
import anatlyzer.atlext.ATL.LocatedElement;
import it.univaq.MDEProfiler.graph.model.graph.Edge;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class ATLWithPathHeuristic implements IHeuristic {


	
	private Graph g;
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(FileUtils.ATLKind)).
				collect(Collectors.toList())) {
			try {
				int k = g.getEdges().size();
				List<Edge> eds = getEdges(n);
				g.getEdges().addAll(eds);
				if (g.getEdges().size() > k)
					n.getType().add(FileUtils.ATL_WitPathKind);
			} catch (ATLCoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return g;
	}
	private List<Edge> getEdges(Node atl) throws ATLCoreException{
		List<Edge> edges = new ArrayList<Edge>();
		AtlParser atlParser = new AtlParser();
		ModelFactory modelFactory = new EMFModelFactory();
		IReferenceModel atlMetamodel = modelFactory
				.getBuiltInResource("ATL.ecore");
		EMFModel atlDynModel = (EMFModel) modelFactory.newModel(atlMetamodel);
		atlParser.inject(atlDynModel, atl.getUri());

		Resource originalTrafo = atlDynModel.getResource();

		ATLModel atlModel = new ATLModel(originalTrafo, originalTrafo.getURI()
				.toFileString(), true);
		try {
			List<String> commentList = getComments(atlModel);
			List<ModelInfo> listInfos = ATLUtils.getModelInfo(atlModel);
			List<String> inMMs = getInMMPaths(commentList, listInfos);
			List<String> outMMs = getOutMMPaths(commentList, listInfos);
			for (String string : inMMs) {
				Edge ed = GraphFactory.eINSTANCE.createEdge();
				ed.setExact(true);
				ed.setDiscoverBy(atl);
				ed.setPathDiscoveredByHeuristic(string);
				Node n = FileUtils.getNodeByFilePath(g, string);
				if (n == null){
					ed.setExact(false);
					n = FileUtils.getNodeByFilePathLazy(g, string);
				}
				if (n != null){
					ed.setName(FileUtils.source);
					ed.setSource(atl);
					ed.setTarget(n);
					edges.add(ed);
				}
			}
			for (String string : outMMs) {
				Edge ed = GraphFactory.eINSTANCE.createEdge();
				ed.setExact(true);
				ed.setDiscoverBy(atl);
				ed.setPathDiscoveredByHeuristic(string);
				Node n = FileUtils.getNodeByFilePath(g, string);
				if (n == null)
					n = FileUtils.getNodeByFilePathLazy(g, string);
				if (n != null){
					ed.setName(FileUtils.target);
					ed.setTarget(n);
					ed.setSource(atl);
					edges.add(ed);
				}
			}
			//MISS INOUT METAMODEL
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return edges;
		
	}

	private static List<String> getInMMPaths(List<String> commentList, List<ModelInfo> modelsInfo) {
		List<String> result = new ArrayList<String>();
		for (String string : commentList) {
			if(string.contains("@path") && string.contains("=")){
				String k = string.replace("--", "");
				k = k.replace("@path", "");
				k = k.trim();
				String[] nameSplit = k.split("=");
				List<ModelInfo> outPuts;
				outPuts = modelsInfo.stream().filter(z->z.isInput()).collect(Collectors.toList());
				if(outPuts.stream().anyMatch(z->z.getMetamodelName().equals(nameSplit[0])))
					result.add(nameSplit[1]);
			}
		}
		return result;
	}
	private static List<String> getOutMMPaths(List<String> commentList, List<ModelInfo> modelsInfo) {
		List<String> result = new ArrayList<String>();
		for (String string : commentList) {
			if(string.contains("@path") && string.contains("=")){
				String k = string.replace("--", "");
				k = k.replace("@path", "");
				k = k.trim();
				String[] nameSplit = k.split("=");
				List<ModelInfo> outPuts;
				outPuts = modelsInfo.stream().filter(z->z.isOutput()).collect(Collectors.toList());
				if(outPuts.stream().anyMatch(z->z.getMetamodelName().equals(nameSplit[0])))
					result.add(nameSplit[1]);
			}
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	private static List<String> getInOutMMPaths(List<String> commentList, List<ModelInfo> modelsInfo) {
		List<String> result = new ArrayList<String>();
		for (String string : commentList) {
			if(string.contains("@path") && string.contains("=")){
				String k = string.replace("--", "");
				k = k.replace("@path", "");
				k = k.trim();
				String[] nameSplit = k.split("=");
				List<ModelInfo> outPuts;
				outPuts = modelsInfo.stream().filter(z->z.isInOut()).collect(Collectors.toList());
				if(outPuts.stream().anyMatch(z->z.getMetamodelName().equals(nameSplit[0])))
					result.add(nameSplit[1]);
			}
		}
		return result;
	}
	
	private static List<String> getComments(ATLModel atlModel) throws ParserException {
		//DEFINE OCL AND HELPER
		OCL<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, Constraint, EClass, EObject> ocl;
		OCLHelper<EClassifier, ?, ?, Constraint> helper;
		
		//INSTANCIATE OCL
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		//INSTANCIATE NEW HELPER FROM OCLEXPRESSION
		helper = ocl.createOCLHelper();
		//SET HELPER CONTEXT
		helper.setContext(ATLPackage.eINSTANCE.getModule());
		
		//CREATE OCLEXPRESSION
		OCLExpression<EClassifier> expression = helper.createQuery("LocatedElement.allInstances()->select(x | x.commentsBefore->size() > 0)");
		//CREATE QUERY FROM OCLEXPRESSION
		Query<EClassifier, EClass, EObject> query = ocl.createQuery(expression);
		
		//EVALUATE OCL
		@SuppressWarnings("unchecked")
		HashSet<Object> success = (HashSet<Object>) query.evaluate(atlModel.getRoot());
		List<String> callableMethods = new ArrayList<String>();
		for (Object object : success) {
			((LocatedElement) object).getCommentsBefore().forEach(x -> callableMethods.add(x));
		}
		
		return callableMethods;
	}


}
