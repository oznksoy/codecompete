package com.hackerrank.algorithms.implementation.easy;

public class DivisibleSumPairsSolution {

	// Complete the divisibleSumPairs function below.
	static int divisibleSumPairs(int n, int k, int[] ar) {

		int pairCount = 0;
		int index = ar.length - 1;

		while (index > 0) {
			int step = 1;
			while (step <= index) {
				if ((ar[index] + ar[index - step]) % k == 0) {
					pairCount++;
				}
				step++;
			}
			index--;
		}

		return pairCount;
	}

	public static void main(String[] args) {
		int[] pairs = { 1, 3, 2, 6, 1, 2 };
		System.out.println(divisibleSumPairs(pairs.length, 3, pairs));

	}

}
