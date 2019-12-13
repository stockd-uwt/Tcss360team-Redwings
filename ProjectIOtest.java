package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.ProjectIO;

class ProjectIOtest {

	ProjectIO io;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		io = new ProjectIO();
	}

	@Test
	void addProject() {
		io.setNewProject("Project1");
		assertTrue(io.myProjectMap.containsKey("Project1"));
	}
	
	@Test
	void addItemToProject() {
		io.setNewProject("Project1");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		assertTrue(io.myProjectMap.get("Project1").containsKey("Item1"));
	}
	
	/**
	 * This tests that multiple projects can be created and have functional items added.
	 * @author Benjamin De Jager
	 */
	@Test
	void addItemToTwoProjects() {
		io.setNewProject("Project1");
		io.setNewProject("Project2");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		io.myProjectMap.get("Project2").put("Item2", "filePath.txt");
		assertTrue(io.myProjectMap.get("Project1").containsKey("Item1"));
		assertTrue(io.myProjectMap.get("Project2").containsKey("Item2"));
	}
	
	@Test
	void addItemToProjectAndLocatePath() {
		io.setNewProject("Project1");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		assertEquals("filePath.txt", (io.myProjectMap.get("Project1").get("Item1")));
	}
	
	/**
	 * This tests that multiple items can be added to a project.
	 */
	@Test
	void addMultipleItemsToProjectAndLocatePath() {
		io.setNewProject("Project1");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		io.myProjectMap.get("Project1").put("Item2", "filePath.txt");
		io.myProjectMap.get("Project1").put("Item3", "filePath.txt");
		assertEquals("filePath.txt", (io.myProjectMap.get("Project1").get("Item1")));
		assertEquals("filePath.txt", (io.myProjectMap.get("Project1").get("Item2")));
		assertEquals("filePath.txt", (io.myProjectMap.get("Project1").get("Item3")));
	}
	
	@Test
	void deleteProject() {
		io.setNewProject("Project1");
		io.deleteProject("Project1");
		assertFalse(io.myProjectMap.containsKey("Project1"));
	}
	
	@Test
	void deleteItemInProjectButEnsureProjectIsStillThere() { // I'm good at names :)
		io.setNewProject("Project1");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		io.deleteItem("Project1", "Item1");
		assertTrue(io.myProjectMap.containsKey("Project1"));
	}
	
	@Test
	void deleteItem() {
		io.setNewProject("Project1");
		io.myProjectMap.get("Project1").put("Item1", "filePath.txt");
		io.deleteItem("Project1", "Item1");
		assertFalse(io.myProjectMap.get("Project1").containsKey("Item1"));
	}

}