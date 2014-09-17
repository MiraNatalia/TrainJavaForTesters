package com.example.tests;

import java.util.ArrayList;
import java.util.List;

//wrapper for collection
public class Folder {

	private List<String> storedFolders = null;

	public Folder(List<String> folders) {
		//create new list on the bases of a  received one
		
		this.storedFolders = new ArrayList<String>(folders);
	}

	public Folder withAdded(String folder) {
		
		/*  oldFolders.withAdded - when we are describing an instance method we can use all 
		 fields of its instance class. e.g we can write <<new Folder(storedFolders)>> */
		
		/*here we create a "copy" of oldFolders*/
		Folder newList = new Folder(this.storedFolders);
		
		newList.storedFolders.add(folder);
		
		return newList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storedFolders == null) ? 0 : storedFolders.hashCode());
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
		Folder other = (Folder) obj;
		if (storedFolders == null) {
			if (other.storedFolders != null)
				return false;
		} else if (!storedFolders.equals(other.storedFolders))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Folder [storedFolders=" + storedFolders + "]";
	}


	
	
	

}
