package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

	@Test
	public void modifySomeContactViaEdit() {

		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initEditContact(1);

		ContactData contact = new ContactData();
		contact.firstName = "Dmitry";

		app.getContactHelper().fillContactForm(contact);

		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();

	}

	@Test
	public void modifySomeContactViaDetails() {

		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initDetailsContact(2);
		app.getContactHelper().modifyContact();

		ContactData contact = new ContactData();
		contact.firstName = "Natalie";

		app.getContactHelper().fillContactForm(contact);

		app.getContactHelper().updateContact();
		app.getContactHelper().returnToHomePage();

	}

}
