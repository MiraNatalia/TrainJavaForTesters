package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testNonEmptyContactCreation(ContactData contact) throws Exception {
		// save before test state
		SortedListOf<ContactData> oldContacts = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());

		// actions to create a new contact
		app.getContactHelper().createContact(contact, CREATION);

		// save after test state
		SortedListOf<ContactData> newContacts = app.getContactHelper().getContactsOnMainPage();

		// compare before and after test contact lists, HamCrest
		assertThat(newContacts, equalTo(oldContacts.withAdded(contact)));

	}

}
