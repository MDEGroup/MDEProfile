package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class HeuristicManager {

	/*
	 * The file parameter is a directory
	 */
	
	public static Set<Node> getDanglingNodes(Graph g){
		Set<Node> src = g.getEdges().stream().map(z -> z.getSource()).collect(Collectors.toSet());
		Set<Node> trg = g.getEdges().stream().map(z -> z.getTarget()).collect(Collectors.toSet());
		Set<Node> dsc = g.getEdges().stream().map(z -> z.getDiscoverBy()).collect(Collectors.toSet());
		Set<Node> dangling = g.getNodes().stream().filter(node -> !src.contains(node) && !trg.contains(node) && !dsc.contains(node)).collect(Collectors.toSet());
		return dangling;
	}
	
	public Graph harvestProject(File file, List<IHeuristic> heuristics) {
		String repo = file.getAbsolutePath();
		Graph g = GraphFactory.eINSTANCE.createGraph();
		g.setName(file.getAbsolutePath());
		for (IHeuristic iHeuristic : heuristics) {
			g = iHeuristic.getGraph(repo, g);
		}
		return g;
	}
	public Graph launcherEcore(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
		
	}
	public Graph launcherEcore_ATL(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	
	public Graph launcherEcore_ATL_KM3(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	public Graph launcherEcore_ATL_KM3_Launcher(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		heuristics.add(new LauncherHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	
	public Graph launcherEcore_ATL_KM3_Launcher_ANT(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		heuristics.add(new LauncherHeuristic());
		heuristics.add(new AntHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	
	public Graph launcherEcore_ATL_ATLWithPath(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		heuristics.add(new LauncherHeuristic());
		heuristics.add(new AntHeuristic());
		heuristics.add(new ATLWithPathHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	
	public Graph launcherEcore_ATL_ATLWithPathLaucher_LauncherATL(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		heuristics.add(new LauncherHeuristic());
		heuristics.add(new AntHeuristic());
		heuristics.add(new ATLWithPathHeuristic());
		heuristics.add(new LauncherATLHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}

	
	
	public Graph launcherEcore_ATL_ATLWithPathLaucher_LauncherATL_ANT_ANTWithATL(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new JavaHeuristic());
		heuristics.add(new ATLHeuristic());
		heuristics.add(new KM3Heuristic());
		heuristics.add(new LauncherHeuristic());
		heuristics.add(new AntHeuristic());
		heuristics.add(new ATLWithPathHeuristic());
		heuristics.add(new LauncherATLHeuristic());
		heuristics.add(new AntWithATLHeuristic());
		Graph g = harvestProject(file, heuristics);

		return g;
	}
	
	
	public Graph launcherTest(File file){
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new JavaHeuristic());
		heuristics.add(new MTLHeuristic());
		heuristics.add(new MavenHeuristic());
		heuristics.add(new MTLWithJavaHeuristic());
		heuristics.add(new MTLWithEcoreHeuristic());
		heuristics.add(new MavenWithJavaHeuristic());
		Graph g = harvestProject(file, heuristics);
		return g;
	}
	
}
