package it.univaq.MDEProfiler.heuristic;

import java.io.File;
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

public class AntWithKM3Heuristic implements IHeuristic {

	private Logger logger = Logger.getLogger(AntWithKM3Heuristic.class);
	private String nodeKind = "NodeType.ANT";
	private String modelKind = "NodeType.Model";
	private String ecoreNodeString = "NodeType.ECORE";
	private Graph g;
	private static String source = "SOURCE";
	private static String target = "TARGET";
	private static String lib = "LIBRARY";
	private static String modelIn = "MODEL_INPUT";
	private static String modelOut = "MODEL_OUT";
	private static String metamodelConformance = "CONFORM2";
	private static Node ecoreNode;
	public AntWithKM3Heuristic(){
		ecoreNode = GraphFactory.eINSTANCE.createNode();
		ecoreNode.setName("Ecore");
		ecoreNode.getType().add(ecoreNodeString);
	}
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

	public Project getProject(String pathBuildFile) throws Exception{
		Project project = new Project();
		File buildFile = new File(pathBuildFile);
		project.init();
		ProjectHelper.configureProject(project, buildFile);
		return project;
	}

	public List<Edge> getEdges(Node antScriptNode) {
		List<Edge> results = new ArrayList<Edge>();
		
		return results;
	}


	
}
