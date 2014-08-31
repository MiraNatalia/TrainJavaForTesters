package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		// save before test state
		SortedListOf<ContactData> oldContacts = app.getContactHelper().getContactsOnMainPage();

		// actions to create a new contact
		app.getContactHelper().createContact(contact, CREATION);
		
		// save after test state
		List<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists
		oldContacts.add(contact);
		Collections.sort(oldContacts);
		Collections.sort(newContacts);
		assertEquals(newContacts,oldContacts);

	}

}
