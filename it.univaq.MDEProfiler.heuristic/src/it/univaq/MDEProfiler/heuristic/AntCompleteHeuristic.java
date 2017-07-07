package it.univaq.MDEProfiler.heuristic;

import it.univaq.MDEProfiler.graph.model.graph.Graph;

public class AntCompleteHeuristic implements IHeuristic {

	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		AntHeuristic ant = new AntHeuristic();
		AntWithATLHeuristic antwATL = new AntWithATLHeuristic();
		g = ant.getGraph(repoFolder, g);
		g= antwATL.getGraph(repoFolder, g);
		return g;
	}

}
