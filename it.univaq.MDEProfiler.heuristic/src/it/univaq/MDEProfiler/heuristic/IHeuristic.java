package it.univaq.MDEProfiler.heuristic;

import it.univaq.MDEProfiler.graph.model.graph.Graph;

public interface IHeuristic {
	Graph getGraph(String repoFolder, Graph g);
}
