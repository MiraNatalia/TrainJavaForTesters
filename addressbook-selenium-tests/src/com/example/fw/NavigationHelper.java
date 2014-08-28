package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	//To create an instance of child class we need to initialize both child and father=>if father doesn't have default constructor 
	//we need to use father's constructor by calling super and transmitting the constructor parameters 
	public NavigationHelper(ApplicationManager pMyManager) {
		super(pMyManager);
		// TODO Auto-generated constructor stub
	}

	public void openMainPage() {
		driver.get(myManager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openGroupsPage() {
		click(By.linkText("groups"));
	}

}
