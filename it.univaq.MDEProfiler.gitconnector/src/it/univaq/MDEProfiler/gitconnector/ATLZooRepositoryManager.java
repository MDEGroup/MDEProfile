package it.univaq.MDEProfiler.gitconnector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ATLZooRepositoryManager {

	private String projectUrl = "https://www.eclipse.org/atl/atlTransformations/";

	/*
	 * Get all url of zip file contained in ATLZoo
	 */
	public List<String> getProjectURLFromATLZooSite() {
		List<String> result = new ArrayList<String>();
		Set<String> zip = new HashSet<String>();
		try {
			Document doc = Jsoup.connect(projectUrl).timeout(10000).get();
			Elements uls = doc.getElementsByTag("a");
			for (Element element : uls) {
				if (element.attr("href").endsWith("zip") && element.text().equals("Source files"))
					zip.add(element.attr("href"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		result.addAll(zip);
		return result;
	}

	/*
	 * Download file and put it into a new folder contained in basePath
	 */
	private String downloadProjectFile(String basePath, String relativeLocation) throws Exception {
		String result = null;
		URL website;
		FileOutputStream fos = null;
		if(!basePath.endsWith(File.separator))
			basePath += File.separator;
		try {
			if(relativeLocation.startsWith("http"))
				website = new URL(relativeLocation);
			else website = new URL(projectUrl + relativeLocation);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			
			String [] splitted = relativeLocation.split("/");
			String path;
			if(!(splitted.length == 2))
				path = splitted[0];
			else path = splitted[splitted.length-2];
			result = basePath + path + File.separator + splitted[splitted.length - 1];
			if(!basePath.endsWith(File.separator))
				basePath += File.separator;
			File folder = new File(basePath + path);
			if(!folder.exists())
				folder.mkdirs();
			fos = new FileOutputStream(basePath + path + File.separator + splitted[splitted.length - 1]);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

			fos.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * Return the relate path of project
	 */
	public String unZipProjectZipFile(String basePath, String zipFile) throws Exception {
		String zipFilePath = downloadProjectFile(basePath, zipFile);
		//zipFilePath = zipFilePath.replaceAll(basePath, "");
		String projectFolder = zipFilePath.substring(0, zipFilePath.lastIndexOf("/"));
		Unzip.unzip(zipFilePath, projectFolder);
		return (projectFolder.endsWith("/"))? projectFolder : projectFolder + File.separator;
	}

}
