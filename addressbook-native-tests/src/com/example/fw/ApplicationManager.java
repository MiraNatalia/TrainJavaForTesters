package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

	// pattern singleton when we need only one instance of ApplicationManager
	private static ApplicationManager singleton;
	private Properties properties;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;

	public static ApplicationManager getInstance(Properties properties) throws IOException {
		if (singleton == null) {
			singleton = new ApplicationManager();
			singleton.setProperties(properties);
			singleton.start();
		}
		return singleton;
	}

	public ApplicationManager() {

	}

	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();

	}

	public void stop() {
		getProcessHelper().stopAppUnderTest();

	}

	public void setProperties(Properties vProperies) {
		this.properties = vProperies;

	}

	public String getProperties(String key) {
		return properties.getProperty(key);
	}

	public String getProperties(String key, String defaulfValue) {
		return properties.getProperty(key, defaulfValue);
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}

		return contactHelper;
	}

	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}

		return processHelper;
	}
	
	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this);
		}

		return autoItHelper;
	}

	


}
