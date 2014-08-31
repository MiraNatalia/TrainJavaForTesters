package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

	// test method will receive test data out of an external
	// method(randomValidGroupGenerator)
	@Test(dataProvider = "randomValidGroupGenerator")
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
