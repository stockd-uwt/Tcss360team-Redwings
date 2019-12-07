//Checked Out By: n/a

/* Team RedWings (David, Daniel, and Ben)
 * 
 * Tcss 360
 * 
 * Project 1
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Class to handle project and project item IO. 
 * 
 * @author David Melanson
 * 
 * @version Alpha 0.0.09
 */
public class ProjectIO {
	
	/*
	 * Class uses EITHER a list if "node" objects OR a map of type <Project-name, Map<File-name, File-address>>,
	 * So long as getMap returns the map for the correct project either works, 
	 * map of maps is more efficient once loaded.
	 */
	
	//uncomment for list of nodes implementation.
	//private List<Node> myData;
	
	private HashMap<String, Map<String, String>> myProjectMap;
	
	protected ProjectIO() {
		//myData = new LinkedList<Node>();
		myProjectMap = new HashMap<String, Map<String, String>>();
	}
	//load projects from file.
	private void load() throws IOException {
		
		BufferedReader projects = new BufferedReader(new FileReader("./projects.txt")); 
		BufferedReader items = new BufferedReader(new FileReader("./items.txt")); 
		
		String project;
		while ((project = projects.readLine()) != null) {
			myProjectMap.put(project, new TreeMap<String, String>());
			String item;
			while ((item = items.readLine()) != null && !(item.equals("///***///"))) {
				myProjectMap.get(project).put(item, items.readLine()); // next item is path
			}
		}
		
		projects.close();
		items.close();
	}
	
//	//load items belonging to projects to their project map.
//	private void loadProjectItems() {
//		
//	}
	//returns the keySet or list of projects (implementation dependent
	//- Change return type to list for node implementation)
	protected Set<String> getProjects() {
		return myProjectMap.keySet();
	}
	
	//Please pas a copy, not the original map...
	protected Map<String,String> getMap(String theProject) {
		TreeMap<String, String> tree = new TreeMap<>();
		
		for (String key : myProjectMap.get(theProject).keySet()) {
			tree.put(key, myProjectMap.get(theProject).get(key));
		}
		
		return tree;
		
	}
	
	//Self explanatory names
	protected void setNewItem(String project, String theItem, String theLocation) {
		myProjectMap.get(project).put(theItem, theLocation);
	}
	protected void setNewProject(String theProject) {
		myProjectMap.put(theProject, new TreeMap<String, String>());
	}
	protected void deleteItem(String theProject, String theItem) {
		myProjectMap.get(theProject).remove(theItem);
	}
	protected void deleteProject(String theProject) {
		myProjectMap.remove(theProject);
	}
	protected boolean saveData() {
		PrintWriter writerProject = null;
		PrintWriter writerItems = null;
		try {
			writerProject = new PrintWriter("./projects.txt");
			writerItems = new PrintWriter("./items.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		for (String project : myProjectMap.keySet()) {
			writerProject.write(project);
			writerProject.write("\n");
			for (String fileName : myProjectMap.get(project).keySet()) {
				writerItems.write(fileName + ", ");
				writerItems.write(myProjectMap.get(project).get(fileName));
				writerItems.write("\n");
			}
			writerItems.write("///***///");
			writerItems.write("\n");
		}
		
		writerProject.close();
		writerItems.close();
		return true;
	}
	
//	public static void main(String[] args) throws IOException {
//		ProjectIO p = new ProjectIO();
//		p.myProjectMap.put("Project1", new TreeMap<String, String>());
//		p.myProjectMap.get("Project1").put("Item1", "path1");
//		p.myProjectMap.get("Project1").put("Item2", "path2");
//		
//		p.myProjectMap.put("Proj1", new TreeMap<String, String>());
//		
//		p.myProjectMap.put("Project2", new TreeMap<String, String>());
//		p.myProjectMap.get("Project2").put("Item21", "path21");
//		p.myProjectMap.get("Project2").put("Item22", "path22");
//		
//		p.saveData();
//		
//		p.load();
//		
//		p.saveData();
//	}
}
