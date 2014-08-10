package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

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
