package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {

	@Test
	public void deleteSomeContact() {
		
		// save before test state
		SortedListOf<ContactData> oldContacts = app.getContactHelper().getContactsOnMainPage();
		Random rnd = new Random();

		int oldContactsQuantity = oldContacts.size() - 1;
		int nextInt = rnd.nextInt(oldContactsQuantity == 0 ? 1 : oldContactsQuantity);

		// actions
		app.getContactHelper().deleteContact(nextInt);

		// save after test state
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists
		assertThat(newContacts, equalTo(oldContacts.without(nextInt)));

	}
}
