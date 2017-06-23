package it.univaq.MDEProfiler.gitconnector;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitHubRepositoryManager {
	private static String baseUrl = "https://github.com/";  
	public String clone(String owner, String repoName, String path) 
			throws GitAPIException{
		if(!path.endsWith(File.separator))
			path += File.separator;
		 path = path + owner + 
				File.separator + repoName + File.separator;
		deleteFolder(new File(path));
		Git.cloneRepository()
			  .setURI(baseUrl + owner + "/" + repoName)
			  .setDirectory(new File(path) )
			  .call();
		return (path.endsWith(File.separator)) ? path : path + File.separator; 
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
