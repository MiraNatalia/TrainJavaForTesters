package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {
	
	@Test
	public void modifyGroup(){
		
	app.getNavigationHelper().openMainPage();
	app.getNavigationHelper().openGroupsPage();
	app.getGroupHelper().initGroupModification(1);
	
	
	GroupData group = new GroupData(); 
	group.name = "Modified name";
	
	app.getGroupHelper().fillGroupForm(group);
	app.getGroupHelper().submitGroupModification();
	app.getGroupHelper().returnToGoupsPage();

	}

}
