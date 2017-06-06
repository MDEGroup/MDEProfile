package it.univaq.MDEProfiler.heuristic;

import ghmde.Repository;
import it.univaq.MDEProfiler.graph.model.graph.Graph;

public interface IHeuristic {
	Graph getGraph(Repository r, Graph g);
}
