package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {

	private WebDriver driver;
	public String baseUrl;

	// hires helpers
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private Properties properties;
	private HibernateHelper hibenateHelper;

	public ApplicationManager(Properties properties) {

		this.properties = properties;

	}

	public void stop() {
		driver.quit();

	}

	// lazy initialization - App. Manager creates Navigation Helper for himself
	// and sends him a reference on himself
	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}

		return navigationHelper;
	}

	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}

		return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}

		return contactHelper;
	}

	public WebDriver getDriver() {
		String browser = properties.getProperty("browser");

		if (driver == null) {

			if ("firefox".equals(browser)) {
				driver = new FirefoxDriver();
			} else if ("ie".equals(browser)) {
				driver = new InternetExplorerDriver();
			} else
				throw new Error("Unsupported browser");

			baseUrl = properties.getProperty("baseUrl");
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl);
		}

		return driver;
	}

	public HibernateHelper getHibernateHelper() {
		if (hibenateHelper == null) {
			hibenateHelper = new HibernateHelper(this);
		}

		return hibenateHelper;
	}

		
	}


