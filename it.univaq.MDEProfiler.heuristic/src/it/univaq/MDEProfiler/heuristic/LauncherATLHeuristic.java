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

	
	private static String source = "SOURCE";
	private static String target = "TARGET";
	private static String lib = "LIBRARY";
	private static String modelIn = "MODEL_INPUT";
	private static String modelOut = "MODEL_OUT";
	private static String metamodelConformance = "CONFORM2";

	private Node currentLauncher;
	private Graph g;
	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().filter(z -> z.getType().
				contains(FileUtils.launcherKind)).
				collect(Collectors.toList())) {
			try {
				int k = g.getEdges().size();
				currentLauncher = n;
				g = parseLauncher(n, g);
				if (g.getEdges().size() > k)
					n.getType().add(FileUtils.launcherATLKind);
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
		}
		return g;
	}

	private Graph parseLauncher(Node launcher, Graph g) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(launcher.getUri()));
		NodeList nodes = document.getElementsByTagName("launchConfiguration");
		Node atlNode = null;
		for (int temp = 0; temp < nodes.getLength(); temp++) {
			org.w3c.dom.Node v = nodes.item(0);
			if (v.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element launchConfiguration = (Element) v;			
                if(launchConfiguration.getAttribute("type").equals("org.eclipse.m2m.atl.adt.launching.atlTransformation") ||
                		launchConfiguration.getAttribute("type").equals("org.atl.eclipse.adt.launching.atlTransformation")){
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
                	List<Edge> inputMetamodelsEdge = getEdgesIn(g, atlNode, document);
                	List<Edge> outputMetamodelsEdge = getEdgesOut(g, atlNode, document);
                	outputMetamodelsEdge.forEach(z-> z.setName(target));
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
	private List<Edge> getEdgesIn(Graph g, Node src, Document document) throws XPathExpressionException{
		List<Edge> result = new ArrayList<Edge>();
		XPathFactory xPathfactory = XPathFactory.newInstance();
    	XPath xpath = xPathfactory.newXPath();
    	XPathExpression expr = xpath.compile("//mapAttribute[@key=\"Input\"]");
    	NodeList inputMetamodels = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
    	for(int i = 0; i < inputMetamodels.getLength(); i++){
    		if(inputMetamodels.item(i) instanceof Element) {
    			Element e = (Element) inputMetamodels.item(i);
    			NodeList inputNL = e.getElementsByTagName("mapEntry");
    			for(int k = 0; i < inputNL.getLength(); i++){
    				Element el = (Element) inputNL.item(k);
    				Edge sourceMM = GraphFactory.eINSTANCE.createEdge();
    				sourceMM.setName(source);
    				sourceMM.setSource(src);
    				String pathEcore = getArtifactPath(document, el.getAttribute("value"));
    				sourceMM.setPathDiscoveredByHeuristic(pathEcore);
    				sourceMM.setDiscoverBy(currentLauncher);
    				
    				sourceMM.setExact(true);
    				Node mmNode = FileUtils.getNodeByFilePath(g, pathEcore);
    				if (mmNode == null){
    					sourceMM.setExact(false);
    					mmNode = FileUtils.getNodeByFilePathLazy(g, pathEcore);
    				}
    				if (mmNode != null){
    					sourceMM.setTarget(mmNode);
    				}
    				if (sourceMM.getSource() != null && sourceMM.getTarget() != null)
    					result.add(sourceMM);
    				
    				
    				String pathModel = getArtifactPath(document, el.getAttribute("key"));
    				Node model = getModelNode(pathModel);
    				Edge conformance = GraphFactory.eINSTANCE.createEdge();
    				conformance.setSource(model);
    				conformance.setTarget(mmNode);
    				conformance.setDiscoverBy(currentLauncher);
    				conformance.setName(metamodelConformance);
    				result.add(conformance);
    				
    				
    				Edge modelEdgIn = GraphFactory.eINSTANCE.createEdge();
    				modelEdgIn.setSource(model);
    				modelEdgIn.setTarget(src);
    				modelEdgIn.setDiscoverBy(currentLauncher);
    				modelEdgIn.setName(modelIn);
    				
    				result.add(modelEdgIn);
    				
    				result.add(conformance);
    				
    				
    			}
    		}
    	}
    	return result;
	}
	private List<Edge> getEdgesOut(Graph g, Node src, Document document) throws XPathExpressionException{
		List<Edge> result = new ArrayList<Edge>();
		XPathFactory xPathfactory = XPathFactory.newInstance();
    	XPath xpath = xPathfactory.newXPath();
    	XPathExpression expr = xpath.compile("//mapAttribute[@key=\"Output\"]");
    	NodeList inputMetamodels = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
    	for(int i = 0; i < inputMetamodels.getLength(); i++){
    		if(inputMetamodels.item(i) instanceof Element) {
    			Element e = (Element) inputMetamodels.item(i);
    			NodeList inputNL = e.getElementsByTagName("mapEntry");
    			for(int k = 0; i < inputNL.getLength(); i++){
    				Element el = (Element) inputNL.item(k);
    				Edge targetMM = GraphFactory.eINSTANCE.createEdge();
    				targetMM.setName(target);
    				targetMM.setSource(src);
    				String pathEcore = getArtifactPath(document, el.getAttribute("value"));
    				targetMM.setPathDiscoveredByHeuristic(pathEcore);
    				targetMM.setDiscoverBy(currentLauncher);
    				
    				targetMM.setExact(true);
    				Node mmNode = FileUtils.getNodeByFilePath(g, pathEcore);
    				if (mmNode == null){
    					targetMM.setExact(false);
    					mmNode = FileUtils.getNodeByFilePathLazy(g, pathEcore);
    				}
    				if (mmNode != null){
    					targetMM.setTarget(mmNode);
    				}
    				if (targetMM.getSource() != null && targetMM.getTarget() != null)
    					result.add(targetMM);
    				
    				
    				String pathModel = getArtifactPath(document, el.getAttribute("key"));
    				Node model = getModelNode(pathModel);
    				Edge conformance = GraphFactory.eINSTANCE.createEdge();
    				conformance.setSource(model);
    				conformance.setTarget(mmNode);
    				conformance.setDiscoverBy(currentLauncher);
    				conformance.setName(metamodelConformance);
    				
    				Edge modelEdgOut = GraphFactory.eINSTANCE.createEdge();
    				modelEdgOut.setSource(model);
    				modelEdgOut.setTarget(src);
    				modelEdgOut.setDiscoverBy(currentLauncher);
    				modelEdgOut.setName(modelOut);
    				
    				result.add(modelEdgOut);
    				
    				result.add(conformance);
    				
    			}
    		}
    	}
    	return result;
	}
	private Node getModelNode(String path){
		File f = new File(currentLauncher.getUri());
		String s = f.getParent();
		Node n = FileUtils.getNodeByFilePath(g, path);
		if( n == null){
			n = GraphFactory.eINSTANCE.createNode();
			n.setName(path);
			File f2 = new File(s + path);
			if(f2.exists()) n.setDerivedOrNotExists(false);
			else n.setDerivedOrNotExists(true);
			n.setUri(f2.getAbsolutePath());
			n.getType().add(FileUtils.modelKind);
			g.getNodes().add(n);
			return n;
		}
		else return n;
	}
	
}
