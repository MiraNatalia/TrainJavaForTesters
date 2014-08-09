package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	//TestBase hires Application Manager; protected as all TestBase descendants should be able to use it 
	protected ApplicationManager app;
	
	
	@BeforeTest
	public void setUp() throws Exception {
		
		app = new ApplicationManager();
			  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }

}
