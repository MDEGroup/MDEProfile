package it.univaq.MDEProfiler.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import ghmde.Model;
import ghmde.Repository;
import ghmde.Technology;


public class TestGHMDEModel {

	public ParseDataSet pds;
	@Before
	public void initialize(){
		pds = new ParseDataSet();
	}
	
	@Test
	public void testDeserialize() {
		Model p = pds.loadModel("model/ghmde.model");
		assertNotNull(p);
	}
	
	@Test
	public void testATLTecnology(){
		Model p = pds.loadModel("model/ghmde.model");
		Technology tec = pds.getATL(p);
		assertNotNull(tec);
	}
	
	@Test
	public void testRepositories(){
		Model p = pds.loadModel("model/ghmde.model");
		Technology tec = pds.getATL(p);
		Set<Repository> rl = pds.getRepositorySet(tec);
		assertEquals(151, rl.size());
	}

	
	@Test
	public void testExistingRepository(){
		Set<Repository> rl = pds.getExistingRepository("model/ghmde.model");
		assertEquals(134, rl.size());
		
	}
//	@Ignore
//	@Test
//	public void testGithubConnection() throws IOException{
//		GitHubClient client = new GitHubClient();
//		client.setOAuth2Token("455dd5e0261139219f936846dc68e4774c1af054");
//		
//		RepositoryService service = new RepositoryService();
//		for (org.eclipse.egit.github.core.Repository repo : service.getRepositories("md2manoppello"))
//		  System.out.println(repo.getName() + " Watchers: " + repo.getWatchers());
//		
//	}

}
