package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.util.Serializer;

public class HeuristicManager {

	/*
	 * The file parameter is a directory
	 */
	public void launcher(){
		File file = new File("<REPO_FOLDER_PATH>");
		List<IHeuristic> heuristics = new ArrayList<IHeuristic>();
		heuristics.add(new ATLHeuristic());
		heuristics.add(new EcoreHeuristic());
		heuristics.add(new LauncherHeuristic());
		heuristics.add(new LauncherATLHeuristic());
		heuristics.add(new ATLWithPathHeuristic());
		heuristics.add(new AntHeuristic());
		heuristics.add(new AntWithATLHeuristic());
		heuristics.add(new KM3Heuristic());
		Graph g = harvestProject(file, heuristics);
		Serializer.serializeModel(g, file.getAbsolutePath() + ".xmi");
	}
	
	public Graph harvestProject(File file, List<IHeuristic> heuristics) {
		String repo = file.getAbsolutePath();
		Graph g = GraphFactory.eINSTANCE.createGraph();
		g.setName(file.getAbsolutePath());
		for (IHeuristic iHeuristic : heuristics) {
			g=iHeuristic.getGraph(repo, g);
		}
		return g;
	}
}
