package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File ("groups.xml"))).iterator();
	}
	// v1. test method will receive test data out of an external method(randomValidGroupGenerator)
	// v2. test method will receive test data out of an external file (groupsFromFile)	
	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {

		// save old state
		SortedListOf<GroupData> oldGroups = app.getGroupHelper().getGroupsOnPage();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new state
		SortedListOf<GroupData> newGroups = app.getGroupHelper().getGroupsOnPage();

		// compare old and new states content

		// Comment this part as we are now using SortedListOf Class
		// /*
		//  Use Collections class to sort our list All elements in the list
		// must
		// implement the Comparable interface. Furthermore, all elements in
		// the
		// list must be mutually comparable (that is, e1.compareTo(e2)
		// */
		// Collections.sort(oldGroups);

		// Comment this part as we are now using HamCrest
		// /*
		// assertEquals will by default use equals() method for Object class,
		// but we need to compare GroupData objects => we have to override
		// Equals for GroupData
		// */
		// assertEquals(newGroups, oldGroups);
		//
		// HamCrest
		assertThat(newGroups, equalTo(oldGroups.withAdded(group)));

	}
}
