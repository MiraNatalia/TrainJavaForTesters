package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator extends TestDataGeneratorBase {

	public static void main(String[] args) throws IOException {

		if (args.length < 3) {
			System.out.println("Please specify parametrs: <amount of test data> <file> <format>");
		}

		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];

		if (file.exists()) {
			System.out.println("File already exists, please delete it manually: " + file);
			return;
		}

		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
		}

	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstr = new XStream();
		xstr.alias("contact", ContactData.class);
		String xml = xstr.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);

		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() 
					+ "," + contact.getLastName() 
					+ "," + contact.getAddress() 
					+ "," + contact.getAddress2() 
					+ "," + contact.getBirthDD() 
					+ "," + contact.getBirthMM() 
					+ "," + contact.getBirthYYYY() 
					+ "," + contact.getEmail1() + "," + contact.getEmail2() 
					+ "," + contact.getHomePhone() 
					+ "," + contact.getMobilePhone() 
					+ "," + contact.getMobilePhone2() + ","
					+ contact.getWorkPhone() 
					+ "," + contact.getContactGroup() + "!" + "\n");
		}

		writer.close();
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();

		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withEmail1(generateValidRandomEmail(25))
					.withEmail2(generateValidRandomEmail(30))
					.withAddress(generateRandomString(20) )
					.withAddress2(generateRandomString(20))
					.withHomePhone(generateRandomPhone())
					.withMobilePhone2(generateRandomPhone())
					.withMobilePhone(generateRandomPhone())
					.withWorkPhone(generateRandomPhone())
					.withBirthYYY(generateRandomBirthDayandYear(2014))
					.withBirthMM(generateRandomMonth())
					.withBirthDD(generateRandomBirthDayandYear(31));

			list.add(contact);

		}
		return list;
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader buffReader = new BufferedReader(reader);
		String line = buffReader.readLine();
		
		while (line !=null){
			String[] split = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(split[0])
			.withLastName(split[1])
			.withAddress(split[2])
			.withAddress2(split[3])
			.withBirthDD(split[4])
			.withBirthMM(split[5])
			.withBirthYYY(split[6])
			.withEmail1(split[7])
			.withEmail2(split[8])
			.withHomePhone(split[9])
			.withMobilePhone(split[10])
			.withMobilePhone2(split[11])
			.withWorkPhone(split[12]);	
			
			list.add(contact);
			line = buffReader.readLine();
		}
		

		buffReader.close();
		return list;
	}

	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstr = new XStream();
		xstr.alias("contact", ContactData.class);
		return (List<ContactData>) xstr.fromXML(file);
	}

}
