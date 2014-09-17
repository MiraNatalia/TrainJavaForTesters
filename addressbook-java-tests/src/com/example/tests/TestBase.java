package com.example.tests;

import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {

	// TestBase hires Application Manager; protected as all TestBase descendants
	// should be able to use it
	protected ApplicationManager app;

	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {

		if (configFile == null) {
			configFile = System.getProperty("configFile");

		}

		if (configFile == null) {
			configFile = System.getenv("configFile");

		}

		if (configFile == null) {
			configFile = System.getProperty("application.properties");

		}

		Properties properties = new Properties();
		properties.load(new FileReader(configFile));
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance().stop();

	}


}
