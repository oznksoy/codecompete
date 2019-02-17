package com.algorithms.hackerrank.implementation;

public class ViralAdvertisingSolution {

	// Complete the viralAdvertising function below.
	static int viralAdvertising(int n) {

		int likedBy = 2;
		int cumulative = 2;
		for (int i = 1; i < n; i++) {
			int liked = likedBy * 3;
			int shared = (liked - (liked % 2)) / 2;
			likedBy = shared;
			cumulative += shared;
		}
		return cumulative;
	}

	public static void main(String[] args) {
		testViralAdvertising(3, 9);
	}// End of Main

	static void testViralAdvertising(int n, int expected) {
		int result = viralAdvertising(n);
		System.out.println(result);
		assert expected == result;
	}// End of Test
}
