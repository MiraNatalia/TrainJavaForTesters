package com.example.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestFolderCreation extends TestBase {

	
	@Test
	public void testFolderCreation(){
		String folder = "New Folder";
		
		Folder oldFolders = app.getFolderHelper().getFolders();
		
		app.getFolderHelper().createFolder(folder);
		
		Folder newFolders = app.getFolderHelper().getFolders();
		
		assertThat(newFolders,equalTo(oldFolders.withAdded(folder)));
	}

}
