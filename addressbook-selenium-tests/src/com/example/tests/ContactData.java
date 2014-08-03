package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email1;
	public String email2;
	public String birthDD;
	public String birthMM;
	public String birthYYYY;
	public String contactGroup;
	public String address2;
	public String mobilePhone2;

	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email1, String email2, String birthDD, String birthMM,
			String birthYYYY, String contactGroup, String address2,
			String mobilePhone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email1 = email1;
		this.email2 = email2;
		this.birthDD = birthDD;
		this.birthMM = birthMM;
		this.birthYYYY = birthYYYY;
		this.contactGroup = contactGroup;
		this.address2 = address2;
		this.mobilePhone2 = mobilePhone2;
	}
	
	public ContactData() {
		
	}
	
	
}