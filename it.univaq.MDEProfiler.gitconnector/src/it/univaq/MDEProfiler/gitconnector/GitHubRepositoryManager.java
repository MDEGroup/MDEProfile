package it.univaq.MDEProfiler.gitconnector;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitHubRepositoryManager {
	private static String baseUrl = "https://github.com/";  
	public String clone(String owner, String repoName) 
			throws GitAPIException{
		String path = Properties.getProperties("gitLocation") + 
				File.separator + owner + 
				File.separator + repoName;
		deleteFolder(new File(path));
		Git.cloneRepository()
			  .setURI(baseUrl + owner + "/" + repoName)
			  .setDirectory(new File(path) )
			  .call();
		return path; 
	}
	private static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null)
	        for(File f: files) 
	            if(f.isDirectory()) deleteFolder(f);
	            else f.delete();
	    folder.delete();
	}
}
