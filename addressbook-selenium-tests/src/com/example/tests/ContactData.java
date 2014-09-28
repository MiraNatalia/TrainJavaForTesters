package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String email1;
	private String email2;
	private String birthDD;
	private String birthMM;
	private String birthYYYY;
	private String contactGroup;
	private String address2;
	private String mobilePhone2;

	public ContactData() {

	}

	@Override
	public int compareTo(ContactData another) {

		int i = this.firstName.toLowerCase().compareTo(another.firstName.toLowerCase());
		if (i == 0) {
			int y = this.lastName.toLowerCase().compareTo(another.lastName.toLowerCase());
			return y;
		} else
			return i;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email1=" + email1 + "]";
	}

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public ContactData withMobilePhone2(String mobilePhone2) {
		this.mobilePhone2 = mobilePhone2;
		return this;
	}

	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public ContactData withBirthYYY(String birthYYY) {
		birthYYYY = birthYYY;
		return this;
	}

	public ContactData withBirthMM(String birthMM) {
		this.birthMM = birthMM;
		return this;
	}

	public ContactData withBirthDD(String birthDD) {
		this.birthDD = birthDD;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthDD() {
		return birthDD;
	}

	public String getBirthMM() {
		return birthMM;
	}

	public String getBirthYYYY() {
		return birthYYYY;
	}

	public String getContactGroup() {
		return contactGroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getMobilePhone2() {
		return mobilePhone2;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBirthDD(String birthDD) {
		this.birthDD = birthDD;
	}

	public void setBirthMM(String birthMM) {
		this.birthMM = birthMM;
	}

	public void setBirthYYYY(String birthYYYY) {
		this.birthYYYY = birthYYYY;
	}

	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setMobilePhone2(String mobilePhone2) {
		this.mobilePhone2 = mobilePhone2;
	}

}