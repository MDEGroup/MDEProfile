package it.univaq.MDEProfiler.gitconnector.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import it.univaq.MDEProfiler.gitconnector.ATLZooRepositoryManager;
import it.univaq.MDEProfiler.gitconnector.GitHubRepositoryManager;

public class TestJsoup {
	ATLZooRepositoryManager atl;
	GitHubRepositoryManager grm;
	@Before
	public void init(){
		atl = new ATLZooRepositoryManager();
		grm = new GitHubRepositoryManager();
	}
	
	@Test
	public void testJsoup(){
		
		assertEquals(atl.getProjectURLFromATLZooSite().size(), 92);
	}
	
	@Test
	public void testClone() throws InvalidRemoteException, TransportException, GitAPIException, IOException{
		//assertEquals(false, new File (Properties.getProperties("gitLocation")+"annecaroline/guided-inspection-tool").exists());
		GitHubRepositoryManager g = new GitHubRepositoryManager();
		assertEquals(g.clone("annecaroline", "guided-inspection-tool", "/home/juri/MDEProfiler/"), 
				"/home/juri/MDEProfiler/annecaroline/guided-inspection-tool/");
		assertEquals(true, new File ("/home/juri/MDEProfiler/annecaroline/guided-inspection-tool").exists());
	}
	
	@Test
	public void testDownload(){
		try {
			assertEquals(grm.clone("christiankerl", "org.eclipselab.emf.ecore.protobuf", 
					"/home/juri/MDEProfiler/"),"/home/juri/MDEProfiler/christiankerl/org.eclipselab.emf.ecore.protobuf/");
			assertEquals(atl.unZipProjectZipFile("/home/juri/MDEProfiler/",
					"Java2Table/Java2Table.zip"),"/home/juri/MDEProfiler/Java2Table/JavaSource2Table/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
