package com.example.tests;

//GroupData class has to implement all methods from Comparable Interface which is only <<public int compareTo(T o);>>
public class GroupData implements Comparable<GroupData> {
	public String name;
	public String header;
	public String footer;

	public GroupData(String groupname, String header, String footer) {
		this.name = groupname;
		this.header = header;
		this.footer = footer;
	}

	public GroupData() {

	}

	@Override
	public String toString() {
		return "GroupData [name=" + name + ", header=" + header + ", footer="
				+ footer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * compareTo method will be called from an instance of GroupData class.
	 * This.name is a reference to the object whose CompareTo method is being
	 * called
	 */

	@Override
	public int compareTo(GroupData another) {
		return this.name.toLowerCase().compareTo(another.name.toLowerCase());
	}
}