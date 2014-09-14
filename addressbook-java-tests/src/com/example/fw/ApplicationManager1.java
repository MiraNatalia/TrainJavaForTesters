package com.example.fw;

import java.util.Properties;

public class ApplicationManager1 {

	private static ApplicationManager1 singleton;
	private Properties properies;

	public static ApplicationManager1 getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager1();
		}
		return singleton;
	}

	public ApplicationManager1() {

	}

	public void stop() {

	}

	public void setProperties(Properties vProperies) {
		this.properies = vProperies;

	}
	
	public String getProperties(String key){
		return properies.getProperty(key);
	}

}
