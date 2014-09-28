package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase {

	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("Tester").setLastName("Tester");
		
		app.getContactHelper().createContact(contact);

		Contact testCreatedContact = app.getContactHelper().getFirstContactOnPage();
		
		Assert.assertEquals(contact, testCreatedContact);

	}

}
