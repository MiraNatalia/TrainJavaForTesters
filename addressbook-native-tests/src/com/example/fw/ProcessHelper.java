package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase {

	private Process process;

	public ProcessHelper(ApplicationManager vManager) {
		super(vManager);
	}

	public void startAppUnderTest() throws IOException {
		String command = myManager.getProperties("app.path");
		// to run application we are to test
		process = Runtime.getRuntime().exec(command);

	}

	public void stopAppUnderTest() {
		//exit without saving
		process.destroy();
	}
}
