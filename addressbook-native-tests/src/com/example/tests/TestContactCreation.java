package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;
import com.example.fw.ContactHelper;

public class TestContactCreation extends TestBase {

	@Test
	public void shouldCreateContactWithValidData() {
		Contact contact = new Contact().setFirstName("Tester").setLastName("Tester");
		ContactHelper contactHelper = app.getContactHelper();
		
		contactHelper.createContact(contact);

		Contact testCreatedContact = app.getContactHelper().getFirstContactOnPage();
		
		Assert.assertEquals(contact, testCreatedContact);

	}

}
