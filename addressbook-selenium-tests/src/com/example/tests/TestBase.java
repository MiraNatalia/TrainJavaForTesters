package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.utils.RandomString;

public class TestBase {

	// TestBase hires Application Manager; protected as all TestBase descendants
	// should be able to use it
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {

		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	// Iterator is used to iterate over a collection
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {

		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();

			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();

			// we need to initiate each massive of Objects in the List
			list.add(new Object[] { group });

		}

		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		RandomString rndStr = new RandomString(20);
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "testName" + rnd.nextInt() + rndStr.nextString();
		}

	}

}
