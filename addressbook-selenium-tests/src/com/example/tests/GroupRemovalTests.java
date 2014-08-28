package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {

	@Test
	public void deleteSomeGroup() {

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openGroupsPage();

		// save old state
		List<GroupData> oldGroups = app.getGroupHelper().getGroupsOnPage();
		Random rnd = new Random();
		int nextInt = rnd.nextInt(oldGroups.size()-1);
		
		// actions
		app.getGroupHelper().deleteGroup(nextInt);
		app.getGroupHelper().returnToGoupsPage();

		// save new state
		List<GroupData> newGroups = app.getGroupHelper().getGroupsOnPage();

		// compare old and new states content
		oldGroups.remove(nextInt);
		Collections.sort(oldGroups);
		assertEquals(newGroups, oldGroups);

	}

}
