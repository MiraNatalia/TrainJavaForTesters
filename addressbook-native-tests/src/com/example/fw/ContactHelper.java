package com.example.fw;

public class ContactHelper extends HelperBase {

	private static final String LASTNAME_FIELD = "TDBEdit11";
	private static final String FIRSTNAME_FIELD = "TDBEdit12";

	public ContactHelper(ApplicationManager vManager) {
		super(vManager);
	}

	public void createContact(Contact contact) {

		initContactCreation();
		fillContact(contact);
		confirmContactCreation();

	}

	/*---------------createContact-------------------*/

	private void initContactCreation() {
		myManager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("Add")
		.winWaitAndActivate("Add Contact", "", 5000);
	}

	private void fillContact(Contact contact) {
		myManager.getAutoItHelper()
		.send(FIRSTNAME_FIELD, contact.firstName)
		.send(LASTNAME_FIELD, contact.lastName);
	}

	private void confirmContactCreation() {
		myManager.getAutoItHelper()
		.click("Save")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	/*-------------------------------------------------*/

	public Contact getFirstContactOnPage() {
		initEditFirstContact();

		Contact contact = getContactOnPage();

		clickCancelOnContactPage();

		return contact;

	}

	
	/*---------------getFirstContactOnPage----------------------------------*/
	
	private void initEditFirstContact() {
		myManager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000)
		.focus("TListView1").send("{DOWN}{SPACE}")
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
	}

	private Contact getContactOnPage() {
		Contact contact = new Contact()
		.setFirstName(myManager.getAutoItHelper().getText(FIRSTNAME_FIELD))
		.setLastName(myManager.getAutoItHelper().getText(LASTNAME_FIELD));
		return contact;
	}

	private void clickCancelOnContactPage() {
		myManager.getAutoItHelper()
		.click("Cancel")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}
	/*-------------------------------------------------*/

}
