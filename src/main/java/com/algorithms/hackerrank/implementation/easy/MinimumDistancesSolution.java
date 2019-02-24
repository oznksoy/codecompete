package com.algorithms.hackerrank.implementation.easy;

public class MinimumDistancesSolution {

	// Complete the minimumDistances function below.
	static int minimumDistances(int[] a) {

		int dist = -1;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					int candidate = j - i;
					if (candidate < dist) {
						dist = candidate;
					} else if (dist == -1) {
						dist = candidate;
					}
				}
			}
		}

		return dist;

	}// End of Method

	public static void main(String[] args) {
		testMinimumDistances(new int[] { 7, 1, 3, 4, 1, 7 }, 3);
	}// End of Main

	static void testMinimumDistances(int[] a, int expected) {
		int result = minimumDistances(a);
		System.out.println("Result : " + result);
		assert result == expected;
	}

}// End of Class
