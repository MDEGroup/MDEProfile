package it.univaq.MDEProfiler.heuristic;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

	public static List<File> getATLFiles(File rootFolder, String extension) {
		List<File> result = new ArrayList<File>();
		if (rootFolder.isDirectory())
			result.addAll(Arrays.asList(rootFolder.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String filename) {
					return filename.endsWith(extension);
				}
			})));
		List<File> listFolder = Arrays.asList(rootFolder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				File f = new File(dir.getAbsolutePath() + File.separator + filename);
				return f.isDirectory();
			}
		}));
		for (File file : listFolder) {
			result.addAll(getATLFiles(file, extension));
		}
		return result;
	}
}
