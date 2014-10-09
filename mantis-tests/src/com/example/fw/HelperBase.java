package com.example.fw;

public class HelperBase {

	protected ApplicationManager myManager;

	public HelperBase(ApplicationManager pMyManager) {

		this.myManager = pMyManager;
	}

	protected void pauseHelper(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
