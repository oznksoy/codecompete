package com.algorithms.hackerrank.implementation.easy;

public class BeautifulDaysattheMoviesSolution {

	// Complete the beautifulDays function below.
	static int beautifulDays(int i, int j, int k) {
		int value = i;
		int count = 0;
		while (value >= i && value <= j) {
			if (abs(value - reverse(value)) % k == 0) {
				count++;
			}
			value++;
		}
		return count;
	}// End of Method

	static int abs(int v) {
		return v < 0 ? -v : v;
	}// End of Method

	static int reverse(int v) {
		int value = v;
		int reverse = 0;
		while (value > 0) {
			int dgt = value % 10;
			value = (value - dgt) / 10;
			reverse = reverse * 10 + dgt;
		}
		return reverse;
	}// End of Method

	public static void main(String[] args) {
		testBeautifulDays(20, 23, 6, 2);
	}// End of Main

	static void testBeautifulDays(int i, int j, int k, int expected) {
		int result = beautifulDays(i, j, k);
		System.out.print(result);
		assert result == expected;
	}// End of Test

}// End of Class
