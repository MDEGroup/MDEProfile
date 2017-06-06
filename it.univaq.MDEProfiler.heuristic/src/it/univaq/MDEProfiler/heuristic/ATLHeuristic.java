package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.util.List;

import org.eclipse.jgit.api.errors.GitAPIException;

import ghmde.Repository;
import it.univaq.MDEProfiler.gitconnector.GitHubRepositoryManager;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.graph.model.graph.NodeType;

public class ATLHeuristic implements IHeuristic {

	private String extension = ".atl";
	@Override
	public Graph getGraph(Repository r, Graph g) {
		
		GitHubRepositoryManager grm = new GitHubRepositoryManager();
		try {
			String repoFolder = grm.clone(r.getOwner().getName(), r.getName());
			File repoFolderF = new File(repoFolder);
			List<File> fList = FileUtils.getATLFiles(repoFolderF, extension);
			for (File file : fList) {
				boolean guard = g.getNodes().stream().anyMatch(s -> s.getFilePath().equals(file.getAbsolutePath()));
				if(!guard)
				{
					Node n = GraphFactory.eINSTANCE.createNode();
					n.setType(NodeType.ATL);
					n.setFilePath(file.getAbsolutePath());
					n.setName(file.getName());
					g.getNodes().add(n);
				}
			}
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}

}
