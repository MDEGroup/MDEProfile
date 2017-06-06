package it.univaq.MDEProfiler.heuristic.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import ghmde.Repository;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.heuristic.ATLHeuristic;
import it.univaq.MDEProfiler.heuristic.EcoreHeuristic;
import it.univaq.MDEProfiler.heuristic.IHeuristic;
import it.univaq.MDEProfiler.heuristic.LauncherHeuristic;
import it.univaq.MDEProfiler.resolver.ParseDataSet;

public class IHeuristicTest {

	@Ignore
	@Test
	public void testHeuristic(){
		ParseDataSet pds = new ParseDataSet();
		Set<Repository> s = pds.getExistingRepository("model/ghmde.model");
		Repository r = s.iterator().next();
		System.out.println(r.getOwner().getName() + " - " + r.getName());
		IHeuristic ecore = new EcoreHeuristic();
		IHeuristic atl = new ATLHeuristic();
		Graph g = ecore.getGraph(r, GraphFactory.eINSTANCE.createGraph());
		g = atl.getGraph(r, g);
		for (Node n : g.getNodes()) {
			System.out.println(n.getType().getLiteral() + ": " + n.getFilePath());
			
		}
	}
	
	@Test
	public void testLauncher() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException{
		File f = new File("model/WebApplication2MySql.launch");
		LauncherHeuristic le = new LauncherHeuristic();
		le.parseLauncher(f);
	}
}
