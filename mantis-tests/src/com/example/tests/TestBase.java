package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	// TestBase hires Application Manager; protected as all TestBase descendants
	// should be able to use it
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile",
				"application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

}
