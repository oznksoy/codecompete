package com.hackerrank.datastructures.arrays.easy;

public class ArraysDSSolution {

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
		int[] reverse = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			reverse[reverse.length - 1 - i] = a[i];
		}
		return reverse;
	}// End of Method

	public static void main(String[] args) {
		testReverseArray(//
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, //
				new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 } //
		);
	}// End of Main

	static void testReverseArray(int[] a, int[] expected) {

		int[] result = reverseArray(a);
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert result[i] == expected[i];
		}

	}// End of Test

}// End of Class