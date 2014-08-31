package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {

	@Test
	public void deleteSomeContact() {
		
		// save before test state
		List<ContactData> oldContacts = app.getContactHelper().getContactsOnMainPage();
		Random rnd = new Random();

		int oldContactsQuantity = oldContacts.size() - 1;
		int nextInt = rnd.nextInt(oldContactsQuantity == 0 ? 1 : oldContactsQuantity);

		// actions
		app.getContactHelper().deleteContact(nextInt);

		// save after test state
		List<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists
		oldContacts.remove(nextInt);
		Collections.sort(oldContacts);
		Collections.sort(newContacts);
		assertEquals(newContacts, oldContacts);

	}
}
