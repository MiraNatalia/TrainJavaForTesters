package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("(//img[@alt='Edit'])[" + (index +1) + "]"));

	}

	public void returnToHomePage() {
		click(By.linkText("home page"));

	}

	public void updateContact() {
		click(By.name("update"));

	}

	public void initDetailsContact(int index) {
		click(By.xpath("(//img[@alt='Details'])[" + index + "]"));

	}

	public void modifyContact() {
		click(By.name("modifiy"));
	}

	public List<ContactData> getContactsOnPage() {
		List<ContactData> contactsOpPage = new ArrayList<ContactData>();

		List<WebElement> edits = driver.findElements(By
				.xpath("//img[@alt='Edit']"));

		int size = edits.size();

		for (int index = 0; index < size; index++) {
			initEditContact(index);

			WebElement contactFirstNameOnPage;
			WebElement contactLastNameOnPage;
			contactFirstNameOnPage = driver.findElement(By.name("firstname"));
			contactLastNameOnPage = driver.findElement(By.name("lastname"));

			String firstName = contactFirstNameOnPage.getAttribute("value");
			String lastName = contactLastNameOnPage.getAttribute("value");

			ContactData contact = new ContactData();
			contact.firstName = firstName;
			contact.lastName = lastName;
			contactsOpPage.add(contact);

			click(By.linkText("home"));

		}

		return contactsOpPage;
	}

}
