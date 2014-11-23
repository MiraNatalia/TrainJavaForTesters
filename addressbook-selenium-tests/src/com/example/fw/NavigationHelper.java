package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends WebDriverHelperBase {

	public NavigationHelper(ApplicationManager pMyManager) {
		super(pMyManager);
		// TODO Auto-generated constructor stub
	}

	public void mainPage() {
		if (!onMainPage()) {
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.findElements(By.id("maintable")).size() > 0);
	}

	public void groupsPage() {
		if (!onGroupsPage()) {
			click(By.linkText("groups"));
		}

	}

	private boolean onGroupsPage() {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("group.php")) {
			List<WebElement> buttonsNewGroup = driver.findElements(By.name("new"));
			if (buttonsNewGroup.size() > 0) {
				return true;
			}
		}
		return false;
	}

}
