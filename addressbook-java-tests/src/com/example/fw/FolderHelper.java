package com.example.fw;

import org.netbeans.jemmy.operators.JFrameOperator;

import com.example.tests.Folder;

public class FolderHelper {

	private ApplicationManager myManager;

	public FolderHelper(ApplicationManager applicationManager) {
		this.myManager = applicationManager;
	}

	public Folder getFolders() {
		JFrameOperator mainFrame = myManager.getApplication();
		return null;
	}

	public void createFolder(String folder) {
		// TODO Auto-generated method stub
		
	}

}
