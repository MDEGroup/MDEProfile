package it.univaq.MDEProfiler.heuristic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ghmde.Model;
import it.univaq.MDEProfiler.gitconnector.ATLZooRepositoryManager;
import it.univaq.MDEProfiler.gitconnector.GitHubRepositoryManager;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.heuristic.ATLHeuristic;
import it.univaq.MDEProfiler.heuristic.ATLWithPathHeuristic;
import it.univaq.MDEProfiler.heuristic.AntHeuristic;
import it.univaq.MDEProfiler.heuristic.AntWithATLHeuristic;
import it.univaq.MDEProfiler.heuristic.EcoreHeuristic;
import it.univaq.MDEProfiler.heuristic.FileUtils;
import it.univaq.MDEProfiler.heuristic.HeuristicManager;
import it.univaq.MDEProfiler.heuristic.IHeuristic;
import it.univaq.MDEProfiler.heuristic.JavaHeuristic;
import it.univaq.MDEProfiler.heuristic.KM3Heuristic;
import it.univaq.MDEProfiler.heuristic.LauncherATLHeuristic;
import it.univaq.MDEProfiler.heuristic.LauncherHeuristic;
import it.univaq.MDEProfiler.heuristic.MTLHeuristic;
import it.univaq.MDEProfiler.heuristic.MTLWithEcoreHeuristic;
import it.univaq.MDEProfiler.heuristic.MTLWithJavaHeuristic;
import it.univaq.MDEProfiler.heuristic.MavenHeuristic;
import it.univaq.MDEProfiler.heuristic.MavenWithJavaHeuristic;
import it.univaq.MDEProfiler.resolver.ParseDataSet;
public class LiveTest {
	
	private IHeuristic ecore;
	private IHeuristic java;
	private IHeuristic maven;
	private IHeuristic mtl;
	
	private IHeuristic mvnWithJava;
	private IHeuristic mtlWithecore;
	private IHeuristic mtlWithjava;
	
	public ParseDataSet pds;
	HeuristicManager hm;
	@Before
	public void initialize(){
		pds = new ParseDataSet();
		hm = new HeuristicManager();
		
		java = new JavaHeuristic();
		ecore = new EcoreHeuristic();
		maven = new MavenHeuristic();
		mtl = new MTLHeuristic();
		
		mvnWithJava = new MavenWithJavaHeuristic();
		mtlWithecore = new MTLWithEcoreHeuristic();
		mtlWithjava = new MTLWithJavaHeuristic();
	}
	@Ignore
	@Test
	public void test(){
		Model p = pds.loadModel("model/model_final.model");
		assertNotNull(p);
	}
	
	@Test
	public void testConnetor() throws GitAPIException{
		
		String repo = "./model/";
		
		//String repoFolder1 = "c:/opencms";
//		String repoFolder1 = "c:/servicereasoning";
		String repoFolder1 = "c:/control-modeler";
		Graph g1 = GraphFactory.eINSTANCE.createGraph();
		ecore.getGraph(repoFolder1, g1);
		java.getGraph(repoFolder1, g1);
		maven.getGraph(repoFolder1, g1);
		mtl.getGraph(repoFolder1, g1);
		
		mvnWithJava.getGraph(repoFolder1, g1);
		mtlWithecore.getGraph(repoFolder1, g1);
		mtlWithjava.getGraph(repoFolder1, g1);
		
		
		Set<Node> src = g1.getEdges().stream().map(z -> z.getSource()).collect(Collectors.toSet());
		Set<Node> trg = g1.getEdges().stream().map(z -> z.getTarget()).collect(Collectors.toSet());
		Set<Node> dangling = g1.getNodes().stream().filter(node -> !src.contains(node) && !trg.contains(node)).collect(Collectors.toSet());
		//System.out.println("Size:"+  dangling.size());
		g1.getNodes().removeAll(dangling);

		g1.setName("home/target/graph");
		it.univaq.MDEProfiler.graph.util.Serializer.serializeModel(g1, repo+"model_final.xmi");
		
		
	}
	
}
