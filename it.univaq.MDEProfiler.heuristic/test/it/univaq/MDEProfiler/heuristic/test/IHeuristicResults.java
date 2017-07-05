package it.univaq.MDEProfiler.heuristic.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import it.univaq.MDEProfiler.gitconnector.ATLZooRepositoryManager;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.heuristic.ATLHeuristic;
import it.univaq.MDEProfiler.heuristic.ATLWithPathHeuristic;
import it.univaq.MDEProfiler.heuristic.AntHeuristic;
import it.univaq.MDEProfiler.heuristic.AntWithATLHeuristic;
import it.univaq.MDEProfiler.heuristic.EcoreHeuristic;
import it.univaq.MDEProfiler.heuristic.FileUtils;
import it.univaq.MDEProfiler.heuristic.IHeuristic;
import it.univaq.MDEProfiler.heuristic.KM3Heuristic;
import it.univaq.MDEProfiler.heuristic.LauncherATLHeuristic;
import it.univaq.MDEProfiler.heuristic.LauncherHeuristic;
import it.univaq.MDEProfiler.resolver.ParseDataSet;
public class IHeuristicResults {
	private IHeuristic ecore;
	private ATLZooRepositoryManager ATLRepoManager;
	private IHeuristic atl;
	private IHeuristic launcher;
	private IHeuristic launcherGraph;
	private IHeuristic atlPath;
	private IHeuristic ant;
	private AntWithATLHeuristic antATL;
	private IHeuristic km3;
	private ParseDataSet pds;
	private String resultsFolder = "/home/juri/MDEProfilerResults/";
	private String baseFolder = "/home/juri/MDEProfiler2/";
	
	@Before
	public void init(){
		atl = new ATLHeuristic();
		ecore = new EcoreHeuristic();
		launcher = new LauncherHeuristic();
		launcherGraph = new LauncherATLHeuristic();
		atlPath = new ATLWithPathHeuristic();
		ant = new AntHeuristic();
		antATL = new AntWithATLHeuristic();
		km3 = new KM3Heuristic();
		pds = new ParseDataSet();
		ATLRepoManager = new ATLZooRepositoryManager();
	}
	@Ignore
	@Test
	public void download(){
		List<String> list = ATLRepoManager.getProjectURLFromATLZooSite();
		for (String string : list) {
			try {
				if(string.startsWith("IntroduceP"))
					System.out.println(string);
				String s = ATLRepoManager.unZipProjectZipFile(baseFolder, string);
				if(s.equals("/"))
					System.out.println("error");
				System.out.println(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Ignore
	@Test
	public void heu(){
		File baseFolderFile = new File(baseFolder);
		int cont = 1;
		for (File file : baseFolderFile.listFiles()) {
			String repo = file.getAbsolutePath();
			System.out.println(cont++ + " _ " + file.getName());
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g.setName(file.getAbsolutePath());
			ecore.getGraph(repo, g);
			atl.getGraph(repo, g);
			km3.getGraph(repo, g);
			launcher.getGraph(repo, g);
			launcherGraph.getGraph(repo, g);
			atlPath.getGraph(repo, g);
			ant.getGraph(repo, g);
			antATL.getGraph(repo, g);
			it.univaq.MDEProfiler.graph.util.Serializer.serializeModel(g, resultsFolder + file.getName() + ".xmi");
		}
	}
	@Test
	public void stats() throws IOException{
		File baseFolderFile = new File(resultsFolder);
		String csvFile = "/home/juri/Scrivania/abc2.csv";
		FileWriter writer = new FileWriter(csvFile);
		FileUtils.writeLine(writer, Arrays.asList("Project Name", "#Elements", "Types", "#Dangling", "Dangling"));
		for (File file : baseFolderFile.listFiles()) {
			Graph g = it.univaq.MDEProfiler.graph.util.Serializer.deserializeModel(file.getAbsolutePath());
			for (Node node : g.getNodes()) {
				if(node.getType().size()==0){
					node.getType().add("NodeType.XML");
				}
			}
			Set<String> typeForProject = g.getNodes().stream().flatMap(z -> z.getType().stream()).collect(Collectors.toSet());
			String concatenateType = "";
			for (String string : typeForProject) {
				concatenateType += string + " - "; 
			}
			Set<Node> src = g.getEdges().stream().map(z -> z.getSource()).collect(Collectors.toSet());
			Set<Node> trg = g.getEdges().stream().map(z -> z.getTarget()).collect(Collectors.toSet());
			Set<Node> dsc = g.getEdges().stream().map(z -> z.getDiscoverBy()).collect(Collectors.toSet());
			Set<Node> dangling = g.getNodes().stream().filter(node -> !src.contains(node) && !trg.contains(node) && !dsc.contains(node)).collect(Collectors.toSet());
			String concatenateDandling = "";
			for (Node node : dangling) {
				StringBuilder b = new StringBuilder();
				node.getType().forEach(b::append);
				concatenateDandling += node.getFilePath() + " -> " + b.toString() + " | ";
			}
			FileUtils.writeLine(writer, Arrays.asList(g.getName(), g.getNodes().size() + "", concatenateType, dangling.size() + "", concatenateDandling));
	        writer.flush();
		}
		writer.close();
	}
//	@Ignore
//	@Test
//	public void stats2() throws IOException{
//		File baseFolderFile = new File(resultsFolder);
//		int count = 0;
//		for (File file : baseFolderFile.listFiles()) {
//			Graph g = it.univaq.MDEProfiler.graph.util.Serializer.deserializeModel(file.getAbsolutePath());
//			if(g.getNodes().stream().filter(z-> z.getType().contains("NodeType.LAUNCHER")).collect(Collectors.toList()).size()!=0)
//				count++;
//		}
//		System.out.println(count);
//	}
}
