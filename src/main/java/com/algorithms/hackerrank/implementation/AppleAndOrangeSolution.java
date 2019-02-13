package com.algorithms.hackerrank.implementation;

public class AppleAndOrangeSolution {

	// Complete the countApplesAndOranges function below.
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

		int countApples = countInDistance(s, t, a, apples);
		int countOranges = countInDistance(s, t, b, oranges);

		System.out.println(countApples);
		System.out.println(countOranges);

	}// End of method

	static int countInDistance(int start, int end, int root, int[] elements) {
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			int value = root + elements[i];
			if (start <= value && end >= value) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] apples = { -2, 2, 1 };
		int[] oranges = { 5, -6 };
		countApplesAndOranges(7, 11, 5, 15, apples, oranges);
	}// End of Main

}// End of Class
