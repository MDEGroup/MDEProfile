package it.univaq.MDEProfiler.heuristic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;

import org.apache.tools.ant.Project;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ghmde.Repository;
import it.univaq.MDEProfiler.gitconnector.ATLZooRepositoryManager;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.heuristic.ATLHeuristic;
import it.univaq.MDEProfiler.heuristic.ATLWithPathHeuristic;
import it.univaq.MDEProfiler.heuristic.AntHeuristic;
import it.univaq.MDEProfiler.heuristic.AntWithATLHeuristic;
import it.univaq.MDEProfiler.heuristic.EcoreHeuristic;
import it.univaq.MDEProfiler.heuristic.FileUtils;
import it.univaq.MDEProfiler.heuristic.IHeuristic;
import it.univaq.MDEProfiler.heuristic.KM3Heuristic;
import it.univaq.MDEProfiler.heuristic.LauncherATLHeuristic;
import it.univaq.MDEProfiler.heuristic.LauncherHeuristic;
import it.univaq.MDEProfiler.resolver.ParseDataSet;
public class IHeuristicTest {
	private IHeuristic ecore;
	private IHeuristic atl;
	private IHeuristic launcher;
	private IHeuristic launcherGraph;
	private IHeuristic atlPath;
	private IHeuristic ant;
	private AntWithATLHeuristic antATL;
	private IHeuristic km3;
	private ParseDataSet pds;
	@Before
	public void init(){
		atl = new ATLHeuristic();
		ecore = new EcoreHeuristic();
		launcher = new LauncherHeuristic();
		launcherGraph = new LauncherATLHeuristic();
		atlPath = new ATLWithPathHeuristic();
		ant = new AntHeuristic();
		antATL = new AntWithATLHeuristic();
		km3 = new KM3Heuristic();
		pds = new ParseDataSet();
		
			
	}
	@Ignore
	@Test
	public void testHeuristic() throws GitAPIException{
		String repoFolder = "/home/juri/MDEProfiler/lolybc88/pATL/";
		Graph g = ecore.getGraph(repoFolder, GraphFactory.eINSTANCE.createGraph());
		g.setName(repoFolder);
		g = atl.getGraph(repoFolder, g);
		g = launcher.getGraph(repoFolder, g);
		System.out.println(g);
		g.getNodes().forEach(s -> System.out.println(s.getFilePath()));
		it.univaq.MDEProfiler.graph.util.Serializer.serializeModel(g, "/home/juri/MDEProfiler/graph.xmi");
	}
	@Ignore
	@Test
	public void testDimitrisModelGithub() throws GitAPIException{
		Set<Repository> s = pds.getExistingRepository("model/ghmde.model");
		Repository r = s.iterator().next();
		System.out.println("JJJ" + r.getName());
	}
	@Ignore
	@Test
	public void testATLZoo(){
		ATLZooRepositoryManager arm = new ATLZooRepositoryManager();
		List<String> list = arm.getProjectURLFromATLZooSite();
		int count = 0;
		for (String string : list) {
			try {
				System.out.println(arm.unZipProjectZipFile(FileUtils.getRootFolder(), string));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(count);
	}
	@Ignore
	@Test
	public void testAllHeuristics(){
		String repo = "/home/juri/MDEProfiler/Table2SVGBarChart/";
		//String repo = "/home/juri/MDEProfiler/SideEffect";
		
		Graph g = GraphFactory.eINSTANCE.createGraph();
		ecore.getGraph(repo, g);
		atl.getGraph(repo, g);
		launcher.getGraph(repo, g);
		launcherGraph.getGraph(repo, g);
		atlPath.getGraph(repo, g);
		ant.getGraph(repo, g);
		antATL.getGraph(repo, g);
		it.univaq.MDEProfiler.graph.util.Serializer.serializeModel(g, "/home/juri/AAAgraph.xmi");
	}
	@Test
	public void learnRegErp(){
		String s = "${transformations.dir}${source.metamodel.name}2${target.name}.asm";
		assertEquals(antATL.getProperties(s).size(),3);
	}
	
	@Test
	public void testRevolvePath(){
		Project p = antATL.getProject("/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/build.xml");
		assertNotNull(p);
		assertNotNull(antATL.getRealValue("${transformations.dir}${source.metamodel.name}2${target.name}.asm", p));
	}
	@Test
	public void testProperties(){
		assertNotNull(FileUtils.getRootFolder());
	}
	@Test
	public void testANTATLPath(){
		String repo = "/home/juri/MDEProfiler/Table2SVGBarChart/";
		Graph g = GraphFactory.eINSTANCE.createGraph();
		g.setName("/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/");
		ecore.getGraph(repo, g);
		atl.getGraph(repo, g);
		km3.getGraph(repo, g);
		ant.getGraph(repo, g);
		antATL.getGraph(repo, g);
		it.univaq.MDEProfiler.graph.util.Serializer.serializeModel(g, "/home/juri/MDEProfiler/graph.xmi");
		//transformations/TableSVGBarChart.atl
	}
	
	@Test
	public void testeFileUtil(){
		String repo = "/home/juri/MDEProfiler/Table2SVGBarChart/";
		Graph g = GraphFactory.eINSTANCE.createGraph();
		g.setName("/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/");
		atl.getGraph(repo, g);
		Node m = GraphFactory.eINSTANCE.createNode();
		m.setDerivedOrNotExists(false);
		m.setName("asd");
		m.setFilePath("/home/juri/MDEProfiler/Table2SVGBarChart/Table2SVGBarChart/build.xml");
		Node s1 = FileUtils.getNodeByFilePathLazy(g, g.getName() + "transformations/Table2SVGBarChart.atl");
		assertNotNull(s1);
		Node s2 = FileUtils.getNodeByFilePath(g, g.getName() + "transformations/Table2SVGBarChart.atl");
		assertNotNull(s2);
		//transformations/TableSVGBarChart.atl
	}
}
