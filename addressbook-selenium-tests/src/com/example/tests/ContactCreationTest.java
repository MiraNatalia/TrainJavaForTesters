package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists, HamCrest
		assertThat(newContacts, equalTo(oldContacts.withAdded(contact)));

	}

}
