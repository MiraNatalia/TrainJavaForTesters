package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactViaEdit(ContactData contact) {
		
		// save before test state
		SortedListOf<ContactData> oldContacts = app.getContactHelper().getContactsOnMainPage();
		Random rnd = new Random();

		int oldContactsQuantity = oldContacts.size() - 1;
		int nextInt = rnd.nextInt(oldContactsQuantity == 0 ? 1 : oldContactsQuantity);

		app.getContactHelper().modifyContact(nextInt, contact, MODIFICATION);

		// save after test state
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists
		assertThat(newContacts, equalTo(oldContacts.without(nextInt).withAdded(contact)));

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
