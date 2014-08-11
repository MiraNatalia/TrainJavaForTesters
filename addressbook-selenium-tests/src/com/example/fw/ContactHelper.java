package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager pMyManager) {
		super(pMyManager);
	}

	public void submitContactForm() {
		click(By.name("submit"));
	}

	public void openAddNewContactPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData) {

		type(By.name("firstname"), contactData.firstName);
		type(By.name("lastname"), contactData.lastName);
		type(By.name("address"), contactData.address);
		type(By.name("home"), contactData.homePhone);
		type(By.name("mobile"), contactData.mobilePhone);
		type(By.name("work"), contactData.workPhone);
		type(By.name("email"), contactData.email1);
		type(By.name("email2"), contactData.email2);
		select(By.name("bday"), contactData.birthDD);
		select(By.name("bmonth"), contactData.birthMM);
		type(By.name("byear"), contactData.birthYYYY);
		select(By.name("new_group"), contactData.contactGroup);
		type(By.name("address2"), contactData.address2);
		type(By.name("phone2"), contactData.mobilePhone2);

	}

	public void deleteContact(int index) {

		// click edit pic at home page to initiate contact edition
		initEditContact(index);

		// xPath for Delete button
		click(By.xpath("(//input[@name='update'])[2]"));

	}

	public void initEditContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));

	}

	public void returnToHomePage() {
		click(By.linkText("home page"));

	}

	public void modifyContact() {
		click(By.name("update"));

	}

}
