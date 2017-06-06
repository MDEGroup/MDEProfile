package it.univaq.MDEProfiler.gitconnector.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Test;

import it.univaq.MDEProfiler.gitconnector.GitHubRepositoryManager;
import it.univaq.MDEProfiler.gitconnector.Properties;

public class CloneTestClass {

	@Test
	public void testClone() throws InvalidRemoteException, TransportException, GitAPIException, IOException{
		//assertEquals(false, new File (Properties.getProperties("gitLocation")+"annecaroline/guided-inspection-tool").exists());
		GitHubRepositoryManager g = new GitHubRepositoryManager();
		g.clone("annecaroline", "guided-inspection-tool");
		assertEquals(true, new File (Properties.getProperties("gitLocation")+"annecaroline/guided-inspection-tool").exists());
	}
}
