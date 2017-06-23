package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.univaq.MDEProfiler.graph.model.graph.Edge;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class LauncherATLHeuristic implements IHeuristic {

	private static String launcherKind = "NodeType.LAUNCHER";
	private static String launcherATLKind = "NodeType.LAUNCHER_ATL";
	private static String sourceMM = "sourceMM";
	private static String targetMM = "targetMM";
	private static String launcherEdge = "launcher";
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		for (Node n : g.getNodes().
				stream().filter(z -> z.getType().
				contains(launcherKind)).
				collect(Collectors.toList())) {
			try {
				int k = g.getEdges().size();
				g = parseLauncher(n, g);
				if (g.getEdges().size() > k)
					n.getType().add(launcherATLKind);
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		return g;
	}

	private Graph parseLauncher(Node launcher, Graph g) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(launcher.getFilePath()));
		NodeList nodes = document.getElementsByTagName("launchConfiguration");
		Node atlNode = null;
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
                			Element el = (Element) nl.item(i);
            				atlNode = FileUtils.getNodeByFilePath(g, el.getAttribute("value"));
            				Edge e = GraphFactory.eINSTANCE.createEdge();
            				e.setPathDiscoveredByHeuristic(el.getAttribute("value"));
            				e.setDiscoverBy(launcher);
            				e.setExact(true);
            				if (atlNode == null){
            					atlNode = FileUtils.getNodeByFilePathLazy(g, el.getAttribute("value"));
            					e.setExact(false);
            				}
            				if (atlNode != null)
            					e.setSource(atlNode);
                		}
                	}
                	List<Edge> inputMetamodelsEdge = getEdges(g, atlNode, "//mapAttribute[@key=\"Input\"]", document);
                	List<Edge> outputMetamodelsEdge = getEdges(g, atlNode, "//mapAttribute[@key=\"Output\"]", document);
                	
                	Edge e = GraphFactory.eINSTANCE.createEdge();
                	e.setSource(launcher);
                	e.setTarget(atlNode);
                	e.setName(launcherEdge);
                	
                	for (Edge edge : outputMetamodelsEdge) {
                		edge.setName(targetMM);
                		Edge tempe = GraphFactory.eINSTANCE.createEdge();
                		tempe.setName(launcherEdge);
                		tempe.setSource(launcher);
                		tempe.setTarget(edge.getTarget());
                		tempe.setDiscoverBy(launcher);
                		g.getEdges().add(tempe);
					}
                	for (Edge edge : inputMetamodelsEdge) {
                		edge.setName(sourceMM);
                		Edge tempe = GraphFactory.eINSTANCE.createEdge();
                		tempe.setName(launcherEdge);
                		tempe.setSource(launcher);
                		tempe.setTarget(edge.getTarget());
                		g.getEdges().add(tempe);
					}
                	g.getEdges().add(e);
                	g.getEdges().addAll(inputMetamodelsEdge);
                	g.getEdges().addAll(outputMetamodelsEdge);
                }
			}
		}
		return g;
		
	}

	private String getArtifactPath(Document d, String key) throws XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
    	XPath xpath = xPathfactory.newXPath();
    	XPathExpression expr = xpath.compile("//mapAttribute[@key=\"Path\"]");
    	org.w3c.dom.Node pathNL = (org.w3c.dom.Node) expr.evaluate(d, XPathConstants.NODE);
		if(pathNL instanceof Element) {
			XPathExpression expr2 = xpath.compile("mapEntry[@key=\""+ key + "\"]");
	    	NodeList nl2 = (NodeList) expr2.evaluate(pathNL, XPathConstants.NODESET);
	    	for(int k = 0; k < nl2.getLength(); k++){
	    		if(nl2.item(k) instanceof Element) {
	    			Element e2 = (Element) nl2.item(k);
	    			return e2.getAttribute("value");
	    		}
	    	}
		}
    	return null;
	}
	private List<Edge> getEdges(Graph g, Node src, String query, Document document) throws XPathExpressionException{
		List<Edge> result = new ArrayList<Edge>();
		XPathFactory xPathfactory = XPathFactory.newInstance();
    	XPath xpath = xPathfactory.newXPath();
    	XPathExpression expr = xpath.compile(query);
    	NodeList inputMetamodels = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
    	for(int i = 0; i < inputMetamodels.getLength(); i++){
    		if(inputMetamodels.item(i) instanceof Element) {
    			Element e = (Element) inputMetamodels.item(i);
    			NodeList inputNL = e.getElementsByTagName("mapEntry");
    			for(int k = 0; i < inputNL.getLength(); i++){
    				Element el = (Element) inputNL.item(k);
    				Edge edg = GraphFactory.eINSTANCE.createEdge();
    				edg.setSource(src);
    				String path = getArtifactPath(document, el.getAttribute("value"));
    				edg.setPathDiscoveredByHeuristic(path);
    				edg.setDiscoverBy(src);
    				edg.setExact(true);
    				Node trgNode = FileUtils.getNodeByFilePath(g, path);
    				if (trgNode == null){
    					edg.setExact(false);
    					trgNode = FileUtils.getNodeByFilePathLazy(g, path);
    				}
    				if (trgNode != null){
    					edg.setTarget(trgNode);
    				}
    				if (edg.getSource() != null && edg.getTarget() != null)
    					result.add(edg);
    			}
    		}
    	}
    	return result;
	}
}
