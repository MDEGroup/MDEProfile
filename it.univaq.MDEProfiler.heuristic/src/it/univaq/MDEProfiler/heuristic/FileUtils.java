package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import it.univaq.MDEProfiler.graph.model.graph.Graph;
import it.univaq.MDEProfiler.graph.model.graph.Node;


public class FileUtils {

	public static List<File> getFilesByEndingValue(File rootFolder, String extension) {
		List<File> result = new ArrayList<File>();
		if (rootFolder.isDirectory())
			result.addAll(Arrays.asList(rootFolder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					File f = new File(dir.getAbsolutePath()+ "/" + filename);
					return filename.toLowerCase().endsWith(extension) && !f.isDirectory();
				}
			})));
		List<File> listFolder = Arrays.asList(rootFolder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				File f = new File(dir.getAbsolutePath() + File.separator + filename);
				return f.isDirectory();
			}
		}));
		for (File file : listFolder) {
			result.addAll(getFilesByEndingValue(file, extension));
		}
		return result;
	}
	public static String getRootFolder() {
		java.util.Properties prop = new java.util.Properties();
		String propFileName = "resources/properties.properties";
		InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(propFileName);
		try {
			if (inputStream != null) prop.load(inputStream);
			else throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			String user = prop.getProperty("gitLocation");
			return user;
		} catch (IOException e) {
				return "";
		}
	}
	
	public static Node getNodeByFilePath(Graph g, String filePath){
		Optional<Node> s = g.getNodes().stream()
				.filter(n -> 
				n.getFilePath().contains(filePath)).findFirst();
		if(s.isPresent())
			return s.get();
		else return null;
	}
	public static Node getNodeByFilePathLazy(Graph g, String fileName) {
		Optional<Node> s = g.getNodes().stream()
				.filter(n -> 
				fileName.contains(n.getName())).findFirst();
		if(s.isPresent())
			return s.get();
		else return null;
	}
}
