package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
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
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
	

}