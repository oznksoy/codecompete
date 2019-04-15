package com.hackerrank.test.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class HackkerrankTestStream {

	public static String manipulateSystemInput(ITestBehaviour behaviour) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		behaviour.run();
		System.out.flush();
		System.setOut(systemStream);
		return byteArrayOutputStream.toString();

	}// End of Test Utility Method

	public static ByteArrayOutputStream manipulateSystemStreamInAndOut(ITestBehaviour behaviour) {

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		behaviour.run();
		System.out.flush();
		System.setOut(systemStream);
		return byteArrayOutputStream;

	}// End of Test Utility Method

	public static void putStreamFromResource(TestByStringRequest testSources) {

		putStreamFromResource(//
				testSources.getBehaviour(), //
				testSources.getInput(), //
				testSources.getOutput(), //
				testSources.isPrintOutput()//
		);//

	}// End of Test Utility Method

	private static void putStreamFromResource(ITestBehaviour behaviour, String input, String output,
			boolean printOutput) {

		try {
			InputStream inputStream = new ByteArrayInputStream(input.getBytes("UTF-8"));
			InputStream originalStream = System.in;
			System.setIn(inputStream);
			testRun(behaviour, output, printOutput);
			System.setIn(originalStream);
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// End of Test Utility Method

	public static void putStreamFromResource(TestByFileRequest testSources) {
		putStreamFromResource( //
				testSources.getTestBehaviour(), //
				testSources.getDir(), //
				testSources.getInputFileName(), //
				testSources.getOutputFileName() //
		); //
	}// End of Test Utility Method

	private static void putStreamFromResource(ITestBehaviour testBehaviour, String dir, String inputFileName,
			String outputFileName) {

		File inputFile = new File(dir + inputFileName);
		File outputFile = new File(dir + outputFileName);

		try {
			FileInputStream inputs = new FileInputStream(inputFile);
			InputStream orj = System.in;
			System.setIn(inputs);
			FileInputStream expectedOutputs = new FileInputStream(outputFile);
			testRun(testBehaviour, expectedOutputs, dir, outputFileName);
			System.setIn(orj);
			inputs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// End of Test from file source

	public static void testRun(ITestBehaviour testBehavior, String expectedOutput, boolean printOutput) {

		String actualOutput = HackkerrankTestStream.manipulateSystemInput(testBehavior);
		if (printOutput) {
			System.out.print(actualOutput);
		}
		Scanner expected = new Scanner(expectedOutput);
		Scanner actual = new Scanner(actualOutput);
		try {
			while (expected.hasNext()) {
				assert expected.nextLine().equals(actual.nextLine());
			}
			assert !expected.hasNext() && !actual.hasNext();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (expected != null) {
				expected.close();
			}
			if (actual != null) {
				actual.close();
			}
		}

	}// End of Test Runner

	public static void testRun(ITestBehaviour testBehavior, FileInputStream expectedOutput, String dir,
			String outputFileName) {

		ByteArrayOutputStream actualOutput = HackkerrankTestStream.manipulateSystemStreamInAndOut(testBehavior);
		if (outputFileName != null && dir != null && !outputFileName.trim().isEmpty() && !dir.trim().isEmpty()) {
			HackkerrankTestStream.writeOutputToFile(dir, outputFileName, actualOutput);
		}
		Scanner expected = new Scanner(expectedOutput);
		Scanner actual = new Scanner(new ByteArrayInputStream(actualOutput.toByteArray()));
		try {
			while (expected.hasNext()) {
				assert expected.nextLine().equals(actual.nextLine());
			}
			assert !expected.hasNext() && !actual.hasNext();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (expected != null) {
				expected.close();
			}
			if (actual != null) {
				actual.close();
			}
		}

	}// End of Test Runner

	public static void writeOutputToFile(String dir, String outputFileName, ByteArrayOutputStream actualOutput) {

		String actualOutputFileName = outputFileName.split("\\.")[0];
		try {
			File actualOutputFile = new File(dir + actualOutputFileName + "_actual.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(actualOutputFile);
			actualOutput.writeTo(fileOutputStream);
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// End of Test Utility Method

}// End of Test Support Class
