package it.univaq.MDEProfiler.resolver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import ghmde.GhmdePackage;
import ghmde.Model;
import ghmde.Repository;
import ghmde.Technology;

public class ParseDataSet {

	public Model loadModel(String modelPath) {
		// Initialize the model
		GhmdePackage.eINSTANCE.eClass();
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("model", new XMIResourceFactoryImpl());
        ResourceSet resSet = new ResourceSetImpl();
        Resource resource = resSet.getResource(URI
                .createURI(modelPath), true);
        Model myWeb = (Model) resource.getContents().get(0);
        return myWeb;
	}
	
	public Technology getATL (Model model){
		return model.getTechnologies().stream().filter(x -> x.getName().equals("atl")).findFirst().get();
	}
	
	public Technology getATL (String path){
		Model model = loadModel(path);
		return model.getTechnologies().stream().filter(x -> x.getName().equals("atl")).findFirst().get();
	}
	
	public List<Repository> getRepositoriesList (Technology tech){
		List<Repository> list = tech.getFiles().stream().map(e -> e.eContainer()).map(e -> (Repository)e).collect(Collectors.toList());
		return list;
	}
	
	public Set<Repository> getRepositorySet(Technology tech){
		return getRepositoriesList(tech).stream().collect(Collectors.toSet());
	}
	
	public List<Repository> getRepositoriesList (String path){
		Technology tech = getATL(path);
		List<Repository> list = tech.getFiles().stream().map(e -> e.eContainer()).map(e -> (Repository)e).collect(Collectors.toList());
		return list;
	}
	
	public Set<Repository> getRepositorySet(String path){
		Technology tech = getATL(path);
		return getRepositoriesList(tech).stream().collect(Collectors.toSet());
	}
	
	public Set<Repository> getExistingRepository(String path){
		Technology tech = getATL(path);
		Set<Repository> rl = getRepositoriesList(tech).stream().collect(Collectors.toSet());
		Set<Repository> repoNotExist = new HashSet<Repository>();
		for (Repository repository : rl) {	
			try {
				URL token = new URL("https://github.com/" + repository.getOwner().getName() + "/" + repository.getName());
				HttpURLConnection conn;
				conn = (HttpURLConnection) token.openConnection();
				conn.setRequestMethod("GET");
				if (conn.getResponseCode() != 200) {
					conn.disconnect();
					repoNotExist.add(repository);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rl.removeAll(repoNotExist);
		return rl;
	}
	
}
