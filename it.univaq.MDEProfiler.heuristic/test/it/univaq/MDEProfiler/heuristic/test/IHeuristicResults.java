package it.univaq.MDEProfiler.heuristic.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import it.univaq.MDEProfiler.heuristic.HeuristicManager;
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
	private HeuristicManager heuristicManager;
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
		heuristicManager = new HeuristicManager();
	}
	@Ignore
	@Test
	public void download(){
		List<String> list = ATLRepoManager.getProjectURLFromATLZooSite();
		for (String string : list) {
			try {
				String s = ATLRepoManager.unZipProjectZipFile(baseFolder, string);
			} catch (Exception e) {
			}
			
		}
	}
	
	
	@Test
	public void harvesterManager() throws IOException{
		String csvFile = "/home/juri/Scrivania/davideResults.csv";
		FileWriter writer = new FileWriter(csvFile);
		
		
		File baseFolderFile = new File(baseFolder);
		String LastHeuristic = "Last Heuristic";
		String NODES = "#NODES";
		String EDGES = "#EDGES";
		String DANGLING = "#DANGLING";
		String AVG_GRAPH_DENCITY = "AVG_GRAPH_DENCITY";
		String INVOLVED_PROJECTS_LAST_HEU_ = "INVOLVED PROJECTS BY LAST HEU";
		String PERC_DANGLING = "%DANGLING";
		
		FileUtils.writeLine(writer, Arrays.asList(LastHeuristic, NODES, EDGES, DANGLING, AVG_GRAPH_DENCITY,INVOLVED_PROJECTS_LAST_HEU_, PERC_DANGLING));
		int _NODES = 0;
		int _EDGES = 0;
		int _DANGLING = 0;
		double _AVG_GRAPH_DENCITY = 0;
		int _INVOLVED_PROJECTS_LAST_HEU_ = 0;
		double _PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.ecoreKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"Ecore",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.ATLKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"ATL",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_KM3(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.KM3Kind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"KM3",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_KM3_Launcher(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.launcherKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"Launcher",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_KM3_Launcher_ANT(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.ANTKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"Ant",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_ATLWithPath(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.ATL_WitPathKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"ATL with path",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_ATLWithPathLaucher_LauncherATL(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.launcherATLKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"Launcher ATL",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
		
		_NODES = 0;
		_EDGES = 0;
		_DANGLING = 0;
		_AVG_GRAPH_DENCITY = 0;
		_INVOLVED_PROJECTS_LAST_HEU_ = 0;
		_PERC_DANGLING = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = GraphFactory.eINSTANCE.createGraph();
			g = heuristicManager.launcherEcore_ATL_ATLWithPathLaucher_LauncherATL_ANT_ANTWithATL(file);
			int _GRAPH_NODES = g.getNodes().size();
			int _GRAPH_EDGES = g.getEdges().size();
			int _GRAPH_DANGLING = HeuristicManager.getDanglingNodes(g).size();;
			double _GRAPH_AVG_GRAPH_DENCITY = (_GRAPH_EDGES != 0)? ((2 * _GRAPH_EDGES)*1.0)/((_GRAPH_NODES*(_GRAPH_NODES-1))*1.0) : 0;
			if(g.getNodes().stream().anyMatch(z -> z.getType().contains(FileUtils.ANT_ATLKind)))
				_INVOLVED_PROJECTS_LAST_HEU_ ++;
			double _GRAPH_PERC_DANGLING = (_GRAPH_DANGLING != 0)?(_GRAPH_DANGLING * 1.0) / (_GRAPH_NODES * 1.0):0;
			
			_NODES += _GRAPH_NODES;
			_EDGES += _GRAPH_EDGES;
			_DANGLING += _GRAPH_DANGLING;
			_AVG_GRAPH_DENCITY += _GRAPH_AVG_GRAPH_DENCITY;
			_PERC_DANGLING += _GRAPH_PERC_DANGLING;
		}
		FileUtils.writeLine(writer, Arrays.asList(
				"ANT ATL",
				"" + _NODES, 
				"" + _EDGES, 
				"" + _DANGLING, 
				"" + (_AVG_GRAPH_DENCITY/90),
				"" + _INVOLVED_PROJECTS_LAST_HEU_, 
				"" + (_PERC_DANGLING/90)));
		writer.flush();
		
        writer.close();
		
	}
	
	
	@Ignore
	@Test
	public void stats() throws IOException{
		File baseFolderFile = new File(resultsFolder);
		String csvFile = "/home/juri/Scrivania/abc3.csv";
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
				concatenateDandling += node.getUri() + " -> " + b.toString() + " | ";
			}
			FileUtils.writeLine(writer, Arrays.asList(g.getName(), g.getNodes().size() + "", concatenateType, dangling.size() + "", concatenateDandling));
	        writer.flush();
		}
		writer.close();
	}
	@Ignore
	@Test
	public void stats2() throws IOException{
		File baseFolderFile = new File(resultsFolder);
		int count = 0;
		for (File file : baseFolderFile.listFiles()) {
			Graph g = it.univaq.MDEProfiler.graph.util.Serializer.deserializeModel(file.getAbsolutePath());
			if(g.getNodes().stream().filter(z-> z.getType().contains("NodeType.LAUNCHER")).collect(Collectors.toList()).size()!=0)
				count++;
		}
		System.out.println(count);
	}
}
