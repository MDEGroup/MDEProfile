package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ghmde.Repository;
import it.univaq.MDEProfiler.gitconnector.GitHubRepositoryManager;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;
import it.univaq.MDEProfiler.graph.model.graph.NodeType;

public class LauncherHeuristic implements IHeuristic {

	private static String extension = ".launch";
	@Override
	public Graph getGraph(Repository r, Graph g) {

		GitHubRepositoryManager grm = new GitHubRepositoryManager();
		try {
			String repoFolder = grm.clone(r.getOwner().getName(), r.getName());
			File repoFolderF = new File(repoFolder);
			List<File> fList = FileUtils.getATLFiles(repoFolderF, extension);
			for (File file : fList) {
				boolean guard = g.getNodes().stream().anyMatch(s -> s.getFilePath().equals(file.getAbsolutePath()));
				if (!guard) {
					Node n = GraphFactory.eINSTANCE.createNode();
					n.setType(NodeType.LAUNCHER);
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

	public void parseLauncher(File f) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(f);
		NodeList nodes = document.getElementsByTagName("launchConfiguration");
		for (int temp = 0; temp < nodes.getLength(); temp++) {
			org.w3c.dom.Node v = nodes.item(0);
			if (v.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element launchConfiguration = (Element) v;
                if(launchConfiguration.getAttribute("type").equals("org.eclipse.m2m.atl.adt.launching.atlTransformation")){
                	XPathFactory xPathfactory = XPathFactory.newInstance();
                	XPath xpath = xPathfactory.newXPath();
                	XPathExpression expr = xpath.compile("//stringAttribute[@key=\"ATL File Name\"]");
                	NodeList nl = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
                	for(int i = 0; i < nl.getLength(); i++){
                		if(nl.item(i) instanceof Element) {
                			Element e = (Element) nl.item(i);
                			System.out.println(e.getAttribute("value"));
                		}
                	}
                	
                }
			}
		}
		
	}
}
