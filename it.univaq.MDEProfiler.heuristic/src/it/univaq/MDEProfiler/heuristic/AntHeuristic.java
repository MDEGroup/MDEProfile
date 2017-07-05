package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.util.List;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class AntHeuristic implements IHeuristic {

	private String extension = ".xml";
	private String nodeKind = "NodeType.ANT";
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		File repoFolderF = new File(repoFolder);
		List<File> fList = FileUtils.getFilesByEndingValue(repoFolderF, extension);
		for (File file : fList) {
			boolean guard = g.getNodes().stream().anyMatch(s -> s.getFilePath().equals(file.getAbsolutePath()));
			if(!guard)
			{
				Node n = GraphFactory.eINSTANCE.createNode();
				n.setDerivedOrNotExists(false);
				n.getType().add(nodeKind);
				n.setFilePath(file.getAbsolutePath());
				n.setName(file.getName());
				g.getNodes().add(n);
			}
		}
		return g;
	}
}
