package it.univaq.MDEProfiler.presentantion.main;

import java.io.File;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.util.Serializer;
import it.univaq.MDEProfiler.heuristic.HeuristicManager;

public class Run {

	private static String resultsFolder = "/home/juri/MDEProfilerResults/";
	private static String baseFolder = "/home/juri/MDEProfiler2";
	private static String modelFolder = "/home/juri/modelResult/";
	private static String outFolder = "/home/juri/graphResults2";
	private static HeuristicManager heuristicManager = new HeuristicManager();  
	public static void main (String[] args){
//		runAnalysis();
		File baseFolderFile = new File("/home/juri/modelResult");
		for (File file : baseFolderFile.listFiles()) {
			System.out.println("<a href='" + file.getName().replace("xmi", "") + 
								"html'>" + file.getName().substring(0, file.getName().length()-4) + "</a>");
			Generate.run(file.getAbsolutePath(), outFolder);
			
		}
	}
	private static void runAnalysis(){
		File folder = new File(baseFolder);
		for (File file : folder.listFiles()) {
			Graph g = heuristicManager.launcherEcore_ATL_ATLWithPathLaucher_LauncherATL_ANT_ANTWithATL(file);
			Serializer.serializeModel(g, modelFolder + file.getName() + ".xmi");
		}
	}
	
	
}
