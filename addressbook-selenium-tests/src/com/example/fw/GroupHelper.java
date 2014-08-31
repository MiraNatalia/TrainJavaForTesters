package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager pMyManager) {
		super(pMyManager);
	}

	/* HIGH LEVEL METHODS */
	
	//Create Cash not to load oldlist of Groups on Page right after previous test, as test1.newlist=test2.oldlist

	private SortedListOf<GroupData> cashedGroupsOnPage;

	public SortedListOf<GroupData> getGroupsOnPage() {

		if (cashedGroupsOnPage == null) {
			rebuildCash();

		}
		return cashedGroupsOnPage;
	}

	private List<GroupData> rebuildCash() {
		cashedGroupsOnPage = new SortedListOf<GroupData>();
		myManager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			cashedGroupsOnPage.add(new GroupData().withName(name));
		}
		return cashedGroupsOnPage;

	}

	public GroupHelper createGroup(GroupData group) {
		myManager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupForm(group);
		submitGroupCreation();
		returnToGoupsPage();
		rebuildCash();
		return this;

	}

	public GroupHelper modifyGroup(int nextInt, GroupData group) {
		//myManager.navigateTo().groupsPage();
		initGroupModification(nextInt);
		fillGroupForm(group);
		submitGroupModification();
		returnToGoupsPage();
		rebuildCash();
		return this;

	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGoupsPage();
		rebuildCash();
		return this;

	}

	/* LOW LEVEL METHODS */

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper returnToGoupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		cashedGroupsOnPage = null;
		return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {

		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());

		/*
		 * InLine - we can use one line syntax for : WebElement webelement =
		 * driver.findElement(By.name("group_name")); webelement.clear();
		 * 
		 * name - static method of BY Object
		 * driver.findElement(By.name("group_name")).clear();
		 */
		return this;

	}

	public GroupHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		cashedGroupsOnPage = null;
		return this;

	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
		cashedGroupsOnPage = null;
	}

}
