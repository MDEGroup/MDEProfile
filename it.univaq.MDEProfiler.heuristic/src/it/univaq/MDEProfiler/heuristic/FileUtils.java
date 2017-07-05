package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		for(Node node : g.getNodes()){
			if(node.getFilePath().contains(filePath)){
				return node;
			}
		}
		return null;
	}
	public static Node getNodeByFilePathLazy(Graph g, String fileName) {
		Optional<Node> s = g.getNodes().stream()
				.filter(n -> 
				fileName.contains(n.getName())).findFirst();
		if(s.isPresent())
			return s.get();
		else return null;
	}
	
	///
	private static final char DEFAULT_SEPARATOR = ',';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }

}
