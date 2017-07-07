package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.util.List;

import org.eclipse.jgit.util.FileUtil;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class EcoreHeuristic implements IHeuristic {

	private static String extension = ".ecore";
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		
		//GitHubRepositoryManager grm = new GitHubRepositoryManager();
		//String repoFolder = grm.clone(r.getOwner().getName(), r.getName(), FileUtils.getRootFolder());
		File repoFolderF = new File(repoFolder);
		List<File> fList = FileUtils.getFilesByEndingValue(repoFolderF, extension);
		for (File file : fList) {
			boolean guard = g.getNodes().stream().anyMatch(s -> s.getUri().equals(file.getAbsolutePath()));
			if(!guard)
			{
				Node n = GraphFactory.eINSTANCE.createNode();
				n.setDerivedOrNotExists(false);
				n.getType().add(FileUtils.ecoreKind);
				n.setUri(file.getAbsolutePath());
				n.setName(file.getName());
				g.getNodes().add(n);
			}
		}
		return g;
	}
}
