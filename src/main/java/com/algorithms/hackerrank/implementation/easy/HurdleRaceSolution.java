package com.algorithms.hackerrank.implementation.easy;

public class HurdleRaceSolution {

	// Complete the hurdleRace function below.
	static int hurdleRace(int k, int[] height) {

		// find the max height
		int maxHeight = 0;
		for (int h : height) {
			if (maxHeight < h) {
				maxHeight = h;
			}
		}

		if (maxHeight > k) {
			return maxHeight - k;
		} else {
			return 0;
		}

	}// End of Method

	public static void main(String[] args) {
		testHurdleRace(4, new int[] { 1, 6, 3, 5, 2 }, 2);
		testHurdleRace(7, new int[] { 2, 5, 4, 5, 2 }, 0);
	}// End of Main

	static void testHurdleRace(int k, int[] height, int expected) {
		int result = hurdleRace(k, height);
		System.out.println(result);
		assert result == expected;
	}

}// End of Class
