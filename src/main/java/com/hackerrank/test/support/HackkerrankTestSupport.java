package com.hackerrank.test.support;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HackkerrankTestSupport {

	public static String manipulateSystemInput(ITestBehavior behaviour) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		// apply the method here
		behaviour.run();
		System.out.flush();
		System.setOut(systemStream);
		return byteArrayOutputStream.toString();
	}// End of Test Util Method

}
