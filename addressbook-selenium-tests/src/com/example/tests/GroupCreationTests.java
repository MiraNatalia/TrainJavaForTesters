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
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {

		// save old state
		SortedListOf<GroupData> oldGroups = app.getHibernateHelper().listGroups();

		// actions
		app.getGroupHelper().createGroup(group);

		// save new state
		SortedListOf<GroupData> newGroups = app.getGroupHelper().getGroupsOnPage();

		// compare old and new states content,HamCrest
		assertThat(newGroups, equalTo(oldGroups.withAdded(group)));

	}

}
