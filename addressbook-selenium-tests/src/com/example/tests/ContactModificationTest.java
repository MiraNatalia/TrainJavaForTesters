package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

	@Test
	public void modifySomeContact() {

		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initEditContact(2);

		ContactData contact = new ContactData();
		contact.firstName = "Nathalie";

		app.getContactHelper().fillContactForm(contact);
		
		app.getContactHelper().modifyContact();
		app.getContactHelper().returnToHomePage();

	}

}
