package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class GroupDataGenerator extends TestDataGeneratorBase {

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

		List<GroupData> groups = generateRandomGroups(amount);
		if ("csv".equals(format)) {
			saveGroupsToCsvFile(groups, file);
		} else if ("xml".equals(format)) {
			saveGroupsToXmlFile(groups, file);
		} else {
			System.out.println("Unknown format" + format);
		}

	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);

		for (GroupData group : groups) {
			writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + "!" + "\n");
		}

		writer.close();

	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
		XStream xstr = new XStream();
		xstr.alias("group", GroupData.class);
		String xml = xstr.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();

		for (int i = 0; i < amount; i++) {
			GroupData group = new GroupData().withName(generateRandomString()).withHeader(generateRandomString()).withFooter(generateRandomString());
			list.add(group);

		}

		return list;
	}

	public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		FileReader reader = new FileReader(file);
		BufferedReader buffReader = new BufferedReader(reader);
		String line = buffReader.readLine();
		while (line != null) {
			String[] split = line.split(",");
			GroupData group = new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2]);
			line = buffReader.readLine();
			list.add(group);
		}

		buffReader.close();
		return list;
	}

	public static List<GroupData> loadGroupsFromXmlFile(File file) throws IOException {
		XStream xstr = new XStream();
		xstr.alias("group", GroupData.class);
		return (List<GroupData>) xstr.fromXML(file);
	}
}
