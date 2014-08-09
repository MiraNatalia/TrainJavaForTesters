package com.example.tests;

import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.contactHelper.openAddNewContactPage();
    ContactData contact = new ContactData();
    contact.firstName = "FirstNameA";
    contact.lastName = "LastNameA";
    contact.address = "CountryA,CityA,StreetA 1,Appatrment1";
    contact.homePhone = "+(343) 111-11-11";
    contact.mobilePhone = "+7 919 1111111";
    contact.email1 = "AB@example.com";
    contact.email2 = "BA@example.com";
    contact.birthDD = "1";
    contact.birthMM = "January";
    contact.birthYYYY = "1985";
    contact.contactGroup = "Group 1";
    contact.address2 = "CountrayA1,CityA1,StreetA1 1, Appartment1";
    contact.mobilePhone2 = "+ 7 919 2222222";
    app.contactHelper.fillContactForm(app, this, contact);
    app.contactHelper.submitContactForm();
    app.groupHelper.returnToHomePage();
  }
  
  
 
}
