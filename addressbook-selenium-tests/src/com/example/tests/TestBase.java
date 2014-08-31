package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.utils.RandomEmail;
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
			GroupData group = new GroupData().withName(generateRandomString()).withHeader(generateRandomString()).withFooter(generateRandomString());

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

	public String generateRandomPhone() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "+ (" + rnd.nextInt(10) + ")" + rnd.nextInt();
		}

	}

	public String generateRandomMonth() {
		Random rnd = new Random();
		String[] months = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December", "-" };

		return months[rnd.nextInt(12)];

	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {

		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 2; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withEmail1(generateValidRandomEmail(25))
					.withEmail2(generateValidRandomEmail(30))
					.withAddress(generateRandomString(20) + ", " + generateRandomString(10) + ", " + generateRandomString(5))
					.withAddress2(generateRandomString(20) + ", " + generateRandomString(10) + ", " + generateRandomString(5))
					.withHomePhone(generateRandomPhone())
					.withMobilePhone2(generateRandomPhone())
					.withMobilePhone(generateRandomPhone())
					.withWorkPhone(generateRandomPhone())
					.withBirthYYY(generateRandomBirthDayandYear(2014)).withBirthMM(generateRandomMonth()).withBirthDD(generateRandomBirthDayandYear(31));

			// we need to initiate each massive of Objects in the List
			list.add(new Object[] { contact });

		}

		return list.iterator();
	}

	private String generateRandomBirthDayandYear(int i) {
		Random rnd = new Random();
		return "" + rnd.nextInt(i);

	}

	private String generateRandomString(int i) {
		Random rnd = new Random();
		RandomString rndStr = new RandomString(i);
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "testName" + rnd.nextInt(i) + rndStr.nextString();
		}

	}

	private String generateValidRandomEmail(int i) {
		RandomEmail rndStr = new RandomEmail(i);
		return rndStr.nextEmail();

	}

}
