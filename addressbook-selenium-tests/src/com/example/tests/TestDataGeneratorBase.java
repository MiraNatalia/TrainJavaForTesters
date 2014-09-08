package com.example.tests;

import java.util.Random;

import com.example.utils.RandomEmail;
import com.example.utils.RandomString;

public class TestDataGeneratorBase {

	protected static String generateRandomString() {
		Random rnd = new Random();
		RandomString rndStr = new RandomString(20);
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "testName" + rnd.nextInt() + rndStr.nextString();
		}
	}

	protected static String generateRandomPhone() {
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "+ (" + rnd.nextInt(10) + ")" + rnd.nextInt();
		}

	}

	protected static String generateRandomMonth() {
		Random rnd = new Random();
		String[] months = new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
				"November", "December", "-" };

		return months[rnd.nextInt(12)];

	}

	protected static String generateRandomBirthDayandYear(int i) {
		Random rnd = new Random();
		return "" + rnd.nextInt(i);

	}

	protected static String generateRandomString(int i) {
		Random rnd = new Random();
		RandomString rndStr = new RandomString(i);
		if (rnd.nextInt(5) == 0) {
			return "";
		} else {

			return "testName" + rnd.nextInt(i) + rndStr.nextString();
		}

	}

	protected static String generateValidRandomEmail(int i) {
		RandomEmail rndStr = new RandomEmail(i);
		return rndStr.nextEmail();

	}

}
