package com.algorithms.hackerrank.implementation.easy;

public class FindDigitsSolution {

	// Complete the findDigits function below.
	static int findDigits(int n) {

		int v = n;
		int count = 0;
		while (v > 0) {
			int digit = v % 10;
			if (digit != 0 && n % digit == 0) {
				count++;
			}
			v = (v - digit) / 10;
		}

		return count;

	}// End of Method

	public static void main(String[] args) {
		testFindDigits(12, 2);
		testFindDigits(1012, 3);
	}// End of Main

	static void testFindDigits(int n, int expected) {
		int result = findDigits(n);
		System.out.println(result);
		assert result == expected;
	}// End of Test

}// End of Classs
