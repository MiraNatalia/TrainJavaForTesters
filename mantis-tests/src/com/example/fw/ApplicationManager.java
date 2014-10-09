package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {

	private WebDriver driver;
	public String baseUrl;

	// hires helpers
	private Properties properties;
	private HibernateHelper hibenateHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;

	public ApplicationManager(Properties properties) {

		this.properties = properties;

	}

	public void stop() {
		driver.quit();

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

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);
		}
		return mailHelper;
	}

	public JamesHelper getJamesManager() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		}
		return jamesHelper;
	}
}
