package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
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

public class MavenWithJavaHeuristic implements IHeuristic {

	private Logger logger = Logger.getLogger(MavenWithJavaHeuristic.class);

	private Graph g;

	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(FileUtils.MavenKind)).
				collect(Collectors.toList())) {
		
			try {
				// get the .java from exec plugin and then set the link
				String referencedJava = getJavaList(n.getUri());
				for (Node n1 : g.getNodes().
						stream().
						filter(z -> z.getType().contains(FileUtils.JavaKind)).
						collect(Collectors.toList())) {
					if(n1.getName().equals(referencedJava)){
						///TO DO CREA ARCO
						Edge edge = GraphFactory.eINSTANCE.createEdge();
						//TODO RIEMPIO DATI ARCO
						edge.setSource(n);
						edge.setTarget(n1);
						g.getEdges().add(edge);
					}
				}
				
				
			} catch (IOException | XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return g;
	}

	
	// get file java that executes a certain MTL
	public String getJavaList(String path) throws IOException, XmlPullParserException{
				
				File file = new File(path);
				
				String JavaFiles_list = new String();
				
				Reader reader = new FileReader(file);
				try {
				    MavenXpp3Reader xpp3Reader = new MavenXpp3Reader();
				    Model model = xpp3Reader.read(reader);
				    System.out.println(model.getBuild().getPlugins());
				    
				    for(Object node : model.getBuild().getPlugins())
				    {
				    	Plugin p = (Plugin)node;
				    	if(p.getArtifactId().equals("exec-maven-plugin"))
				    	{
					    	String configuration = p.getConfiguration().toString();
					    	String complete_domain = configuration.substring(configuration.indexOf("mainClass") + 10 , configuration.indexOf("/mainClass") - 1);
					    	
					    	System.out.println(complete_domain.substring(complete_domain.lastIndexOf(".") + 1).concat(".java"));
					    	String linked_file = complete_domain.substring(complete_domain.lastIndexOf(".") + 1).concat(".java");
					    	JavaFiles_list = linked_file;
				    	}
				    }	
				    	
				} 
				catch (Exception e) {
					reader.close();
					return new String("invalid");
				}
				finally {
				    reader.close();
				}
				
				return JavaFiles_list;
			}
	
	
}