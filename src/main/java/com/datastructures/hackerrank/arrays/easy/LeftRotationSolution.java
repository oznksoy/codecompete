package com.datastructures.hackerrank.arrays.easy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LeftRotationSolution {

	static void leftRotation(int n, int d, int[] a) {

		int rotation = d % n;

		for (int i = rotation; i < n; i++) {
			System.out.print(a[i]);
			System.out.print(" ");
		}
		for (int i = 0; i < rotation; i++) {
			System.out.print(a[i]);
			if (i != rotation - 1) {
				System.out.print(" ");
			}
		}

	}// End of Method

	public static void main(String[] args) {
		testLeftRotation(5, 4, createInput("1 2 3 4 5"), "5 1 2 3 4");
	}// End of Main

	static int[] createInput(String input) {
		String[] vs = input.split(" ");
		int[] array = new int[vs.length];

		for (int i = 0; i < vs.length; i++) {
			array[i] = Integer.valueOf(vs[i]).intValue();
		}
		return array;
	}// End of Method for Tests

	static void testLeftRotation(int n, int d, int[] a, String expected) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		leftRotation(n, d, a);
		System.out.flush();
		System.setOut(systemStream);
		String result = byteArrayOutputStream.toString();
		assert result.equals(expected);
	}// End of Test

}// End of Class
