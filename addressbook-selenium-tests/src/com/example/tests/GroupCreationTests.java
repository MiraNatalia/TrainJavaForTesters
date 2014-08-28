package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

	// test method will receive test data out of an external
	// method(randomValidGroupGenerator)
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group)
			throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openGroupsPage();

		// save old state
		List<GroupData> oldGroups = app.getGroupHelper().getGroupsOnPage();

		// actions
		app.getGroupHelper().initGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGoupsPage();

		// save new state
		List<GroupData> newGroups = app.getGroupHelper().getGroupsOnPage();

		// compare old and new states content
		oldGroups.add(group);

		/*
		 * Use Collections class to sort our list 
		 * All elements in the list must implement the Comparable interface. 
		 * Furthermore, all elements in the list must be mutually comparable (that is, e1.compareTo(e2)
		 */
		Collections.sort(oldGroups);

		/*
		 * assertEquals will by default use equals() method for Object class, 
		 * but we need to compare GroupData objects => we have to override Equals for GroupData
		 */
		assertEquals(newGroups, oldGroups);

	}

}
