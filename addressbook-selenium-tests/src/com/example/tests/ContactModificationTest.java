package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactViaEdit(ContactData contact) {

		app.getNavigationHelper().openMainPage();

		// save before test state
		List<ContactData> oldContacts = app.getContactHelper().getContactsOnPage();
		Random rnd = new Random();

		int oldContactsQuantity = oldContacts.size() - 1;
		int nextInt = rnd.nextInt(oldContactsQuantity == 0 ? 1 : oldContactsQuantity);

		app.getContactHelper().initEditContact(nextInt);

		// ContactData contact = new ContactData();
		// contact.firstName = "Dmitry";

		app.getContactHelper().fillContactForm(contact);

		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();

		// save after test state
		List<ContactData> newContacts = app.getContactHelper().getContactsOnPage();

		// compare before and after test contact lists
		oldContacts.remove(nextInt);
		oldContacts.add(contact);
		Collections.sort(oldContacts);
		Collections.sort(newContacts);
		assertEquals(newContacts, oldContacts);

	}
	/*
	 * // @Test // public void modifySomeContactViaDetails() { // //
	 * app.getNavigationHelper().openMainPage(); //
	 * app.getContactHelper().initDetailsContact(2); //
	 * app.getContactHelper().modifyContact(); // // ContactData contact = new
	 * ContactData(); // contact.firstName = "Natalie"; // //
	 * app.getContactHelper().fillContactForm(contact); // //
	 * app.getContactHelper().updateContact(); //
	 * app.getContactHelper().returnToHomePage(); // // }
	 */
}
