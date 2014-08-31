package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager pMyManager) {
		super(pMyManager);
	}

	/* HIGHT LEVEL METHODS */

	private List<ContactData> cashedContactsOpPage;

	public List<ContactData> getContactsOnMainPage() {

		if (cashedContactsOpPage == null) {
			rebuildCashe();
		}

		return cashedContactsOpPage;

	}

	private List<ContactData> rebuildCashe() {
		List<ContactData> cashedContactsOpPage = new ArrayList<ContactData>();
		myManager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			String firstName = row.findElement(By.xpath(".//td[2]")).getText();
			String lastName = row.findElement(By.xpath(".//td[3]")).getText();
			cashedContactsOpPage.add(new ContactData().withFirstName(firstName).withLastName(lastName));
		}

		return cashedContactsOpPage;

	}

	public ContactHelper createContact(ContactData contact, boolean cREATION2) {
		// myManager.navigateTo().mainPage();
		openAddNewContactPage();
		fillContactForm(contact, CREATION);
		submitContactForm();
		returnToHomePage();
		rebuildCashe();
		return this;

	}

	public ContactHelper modifyContact(int nextInt, ContactData contact, boolean mODIFICATION2) {
		myManager.navigateTo().mainPage();
		initEditContact(nextInt);
		fillContactForm(contact, MODIFICATION);
		updateContact();
		returnToHomePage();
		rebuildCashe();
		return this;

	}

	public ContactHelper deleteContact(int index) {
		myManager.navigateTo().mainPage();

		// click edit pic at home page to initiate contact edition
		initEditContact(index);

		// xPath for Delete button
		pushContactDeleteButton();

		returnToHomePage();
		rebuildCashe();

		return this;
	}

	/* LOW LEVEL METHODS */

	public ContactHelper submitContactForm() {
		click(By.name("submit"));
		cashedContactsOpPage = null;
		return this;
	}

	public ContactHelper openAddNewContactPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contactData, boolean formType) {

		type(By.name("firstname"), contactData.getFirstName());
		type(By.name("lastname"), contactData.getLastName());
		type(By.name("address"), contactData.getAddress());
		type(By.name("home"), contactData.getHomePhone());
		type(By.name("mobile"), contactData.getMobilePhone());
		type(By.name("work"), contactData.getWorkPhone());
		type(By.name("email"), contactData.getEmail1());
		type(By.name("email2"), contactData.getEmail2());
		select(By.name("bday"), contactData.getBirthDD());
		select(By.name("bmonth"), contactData.getBirthMM());
		type(By.name("byear"), contactData.getBirthYYYY());

		if (formType == CREATION) {

			// select(By.name("new_group"), "Group 1");
		} else {

			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group Selector exists in Contact Modification Form");
			}

		}

		select(By.name("new_group"), contactData.getContactGroup());
		type(By.name("address2"), contactData.getAddress2());
		type(By.name("phone2"), contactData.getMobilePhone2());

		return this;
	}

	private void pushContactDeleteButton() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cashedContactsOpPage = null;
	}

	public ContactHelper initEditContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper updateContact() {
		click(By.name("update"));
		cashedContactsOpPage = null;
		return this;
	}

	public ContactHelper initDetailsContact(int index) {
		click(By.xpath("(//img[@alt='Details'])[" + index + "]"));
		return this;
	}

//	public ContactHelper initContactModification() {
//		click(By.name("modifiy"));
//		return this;
//	}

	public List<WebElement> getContactRows() {

		List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
		int i = rows.size() - 1;

		rows.remove(i);
		rows.remove(0);

		return rows;
	}

}
