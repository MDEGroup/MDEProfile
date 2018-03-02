package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import it.univaq.MDEProfiler.graph.model.graph.Edge;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class MTLWithEcoreHeuristic implements IHeuristic {

	private Logger logger = Logger.getLogger(MTLWithEcoreHeuristic.class);

	private Graph g;

	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(FileUtils.MTLKind)).
				collect(Collectors.toList())) {
		
			try {
				String referencedEcore = getEcoreFromMTL(n.getUri());
				for (Node n1 : g.getNodes().
						stream().
						filter(z -> z.getType().contains(FileUtils.ecoreKind)).
						collect(Collectors.toList())) {
					List<String> ecoreNSuris = getNSUris(n1.getUri());
					if(ecoreNSuris.contains(referencedEcore)){
						///TO DO CREA ARCO
						Edge edge = GraphFactory.eINSTANCE.createEdge();
						//TODO RIEMPIO DATI ARCO
						edge.setSource(n);
						edge.setTarget(n1);
						g.getEdges().add(edge);
					}
				}
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return g;
	}

	/*
	 * Get ECORE nsURI from MTL
	 */
	private String getEcoreFromMTL(String path) throws FileNotFoundException {

		File file = new File(path);
		Scanner inputFile = new Scanner(file);
		String ecore = null;
		while (inputFile.hasNext()) {
			String familyName = inputFile.nextLine();

			if (familyName.contains("module generate") || familyName.contains("module deployment")) {
				String resultString = familyName.replaceFirst("\\[\\s+ ", "\\[");
				resultString = resultString.replaceFirst("\\s+\\]", "\\]");

				Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(resultString);
				while (m.find()) {
					ecore = m.group(1);
					ecore = ecore.replace("'", "");
				}
			}

		}
		return ecore;
	}

	private List<String> getNSUris(String ecoreMetamodel) {
		List<String> result = new ArrayList<String>();
		String path = ecoreMetamodel;
		File fileName = new File(path);
		URI uri = URI.createFileURI(fileName.getAbsolutePath());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		// enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
		Resource r = rs.getResource(uri, true);
		List<EObject> eObject = r.getContents();
		for (EObject eObject2 : eObject) {
			if (eObject2 instanceof EPackage) {
				EPackage p = (EPackage) eObject2;
				String s = p.getNsURI();
				if (s != null && !s.isEmpty())
					result.add(p.getNsURI());
				result.addAll(getNSUris(p));
			}
		}
		return result;
	}

	private List<String> getNSUris(EPackage p) {
		List<String> result = new ArrayList<String>();
		EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
		for (EPackage pack : p.getESubpackages()) {
			String s = pack.getNsURI();
			if (s != null && !s.isEmpty())
				result.add(pack.getNsURI());
			result.addAll(getNSUris(pack));
		}
		return result;
	}
}