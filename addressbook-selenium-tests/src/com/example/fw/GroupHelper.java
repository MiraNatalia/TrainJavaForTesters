package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager pMyManager) {
		super(pMyManager);
		// TODO Auto-generated constructor stub
	}

	public void initGroupCreation() {
		ApplicationManager.driver.findElement(By.name("new")).click();
	}

	public void returnToGoupsPage() {
		ApplicationManager.driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		ApplicationManager.driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(ApplicationManager applicationManager, TestBase testBase, GroupData group) {
		ApplicationManager.driver.findElement(By.name("group_name")).clear();
	    ApplicationManager.driver.findElement(By.name("group_name")).sendKeys(group.name);
	    ApplicationManager.driver.findElement(By.name("group_header")).clear();
	    ApplicationManager.driver.findElement(By.name("group_header")).sendKeys(group.header);
	    ApplicationManager.driver.findElement(By.name("group_footer")).clear();
	    ApplicationManager.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void returnToHomePage() {
		ApplicationManager.driver.findElement(By.linkText("home page")).click();
	}

}
