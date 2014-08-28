package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();

		// save before test state
		List<ContactData> oldContacts = app.getContactHelper().getContactsOnPage();

		// actions to create a new contact
		app.getContactHelper().openAddNewContactPage();
//		ContactData contact = new ContactData();
//		contact.firstName = "FirstNameA";
//		contact.lastName = "LastNameA";
//		contact.address = "CountryA,CityA,StreetA 1,Appatrment1";
//		contact.homePhone = "+(343) 111-11-11";
//		contact.mobilePhone = "+7 919 1111111";
//		contact.email1 = "AB@example.com";
//		contact.email2 = "BA@example.com";
//		contact.birthDD = "1";
//		contact.birthMM = "January";
//		contact.birthYYYY = "1985";
//		//contact.contactGroup = "Group 1";
//		contact.address2 = "CountrayA1,CityA1,StreetA1 1, Appartment1";
//		contact.mobilePhone2 = "+ 7 919 2222222";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactForm();
		app.getGroupHelper().returnToHomePage();

		// save after test state
		List<ContactData> newContacts = app.getContactHelper().getContactsOnPage();

		// compare before and after test contact lists
		oldContacts.add(contact);
		Collections.sort(oldContacts);
		Collections.sort(newContacts);
		assertEquals(newContacts,oldContacts);

	}

}
