package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager pMyManager) {
		super(pMyManager);
		// TODO Auto-generated constructor stub
	}

	public void openMainPage() {
		pMyManager.driver.get(pMyManager.baseUrl + "/addressbookv4.1.4/");
	}

	public void openGroupsPage() {
		pMyManager.driver.findElement(By.linkText("groups")).click();
	}

}
