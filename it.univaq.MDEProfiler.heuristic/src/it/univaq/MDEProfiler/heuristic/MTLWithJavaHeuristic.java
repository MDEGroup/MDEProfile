package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import it.univaq.MDEProfiler.graph.model.graph.Edge;
import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.GraphFactory;
import it.univaq.MDEProfiler.graph.model.graph.Node;

public class MTLWithJavaHeuristic implements IHeuristic {

	private Logger logger = Logger.getLogger(MTLWithJavaHeuristic.class);

	private Graph g;

	@Override
	public Graph getGraph(String repoFolder, Graph g) {
		this.g = g;
		for (Node n : g.getNodes().
				stream().
				filter(z -> z.getType().contains(FileUtils.MTLKind)).
				collect(Collectors.toList())) {
		
			try {
				// prendere il nome del file .MTL
				String filenameMTL = n.getName(); 
				
				for (Node n1 : g.getNodes().
						stream().
						filter(z -> z.getType().contains(FileUtils.JavaKind)).
						collect(Collectors.toList())) {
					
					//get MTL filename from file .java (clearly if exist)
					String referencedMTL = getMTL(n1.getUri());
					
					//si suppone di avere il corretto MODULE_FILE_NAME
					referencedMTL = referencedMTL.substring(referencedMTL.lastIndexOf("/")+1).concat(".mtl");
					if(referencedMTL.equals(filenameMTL)){
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
	 * Get MTL name from file Java
	 */
	private String getMTL(String path) throws FileNotFoundException {
		
			InputStream inputStream = new FileInputStream(path);
	        
	        CompilationUnit cu = JavaParser.parse(inputStream);
	        
	        String string_find = "MODULE_FILE_NAME";
	        String string_find_check = "TEMPLATE_NAMES";
	        
	        List<com.github.javaparser.ast.Node> node_list = cu.getChildNodes();
	        String result = new String("null");
	        
	        int i = 0;
	        while(true)
	        {
		        try
		        {
		        	com.github.javaparser.ast.Node node = node_list.get(i);
		            String main_string = node.toString();

		            if(main_string.indexOf(string_find) !=-1 && main_string.indexOf(string_find_check) !=-1)
		            {
		            	int index = main_string.indexOf(string_find); 
		            	int index_final = main_string.indexOf(";",index);
		            	//index + offset
		            	result = new String(main_string.substring(index+20,index_final-1));
		            	
		            }
			        i = i + 1;
		        }
		        
		        catch(Exception exc)
		        {
		        	break;
		        }
	        }
			return result;
	}
	
	
	
}