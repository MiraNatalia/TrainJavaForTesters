package com.example.fw;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

public class ApplicationManager {

	// pattern singleton when we need only one instance of ApplicationManager
	private static ApplicationManager singleton;
	private Properties properties;
	private FolderHelper folderHelper;
	private JFrameOperator mainFrame;

	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}

	public ApplicationManager() {

	}

	public void stop() {

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

	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}

		return folderHelper;
	}

	/* as tests and app are on Java we can run it in the same process => we can
	/have direct access to app's interface
	/ driver for interface - Jemmy2*/
	public JFrameOperator getApplication() {

		if (mainFrame == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();

				// JFrameOperator is a wrapper for java Frame which allows to  manipulate it
				mainFrame = new JFrameOperator("JAddressBook");
			} catch (InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		return mainFrame;

	}
}
