package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTest extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifyGroup(GroupData group) {

		// save old state
		SortedListOf<GroupData> oldGroups = app.getGroupHelper().getGroupsOnPage();
		Random rnd = new Random();
		int nextInt = rnd.nextInt(oldGroups.size() - 1);

		// actions
		app.getGroupHelper().modifyGroup(nextInt, group);

		// save new state
		SortedListOf<GroupData> newGroups = app.getGroupHelper().getGroupsOnPage();

		// compare old and new states content
		assertThat(newGroups, equalTo(oldGroups.without(nextInt).withAdded(group)));

	}

}
