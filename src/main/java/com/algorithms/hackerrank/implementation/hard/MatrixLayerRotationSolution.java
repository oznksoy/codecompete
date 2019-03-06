package com.algorithms.hackerrank.implementation.hard;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MatrixLayerRotationSolution {

	/**
	 * <p>
	 * Complete the matrixRotation function below.
	 * </p>
	 * <p>
	 * Trick is to find the even side an shrink the layers from outside to inside
	 * one step at a time.
	 * </p>
	 * 
	 * @param matrix : matrix to rotate
	 * @param r      : steps to rotate
	 */
	static void matrixRotation(List<List<Integer>> matrix, int r) {
		
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testCase1() {
		testMatrixRotation(//
				createInput(//
						"1 2 3 4", //
						"5 6 7 8", //
						"9 10 11 12", //
						"13 14 15 16"),
				2, //
				createExpected(//
						"3 4 8 12", //
						"2 11 10 16", //
						"1 7 6 15", //
						"5 9 13 14" //
				));

	}// End of Test Case

	static void testCase2() {
		testMatrixRotation(//
				createInput(//
						"1 2 3 4", //
						"7 8 9 10", //
						"13 14 15 16", //
						"19 20 21 22", //
						"25 26 27 28"//
				), 7, //
				createExpected(//
						"28 27 26 25", //
						"22 9 15 19", //
						"16 8 21 13", //
						"10 14 20 7", //
						"4 3 2 1"//
				));
	}// End of Test Case

	// Output:
	// 1 1
	// 1 1
	static void testCase3() {
		testMatrixRotation(//
				createInput(//
						"1 1", //
						"1 1"//
				), 3, //
				createExpected(//
						"1 1", //
						"1 1" //
				));
	}// End of Test Case

	static void testMatrixRotation(List<List<Integer>> matrix, int r, String expected) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		matrixRotation(matrix, r);
		System.out.flush();
		System.setOut(systemStream);
		String result = byteArrayOutputStream.toString();
		assert result.equals(expected);
	}// End of Test

	static List<List<Integer>> createInput(String... strings) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (String val : strings) {
			List<Integer> row = new ArrayList<Integer>();
			String[] vs = val.split(" ");
			for (String v : vs) {
				row.add(Integer.valueOf(v));
			}
			list.add(row);
		}
		return list;
	}// End of Method for Tests

	static String createExpected(String... strings) {
		String str = "";
		for (String val : strings) {
			str += val + System.lineSeparator();
		}
		return str;
	}// End of Method for Tests

}// End of Class
