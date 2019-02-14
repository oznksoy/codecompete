package com.algorithms.hackerrank.implementation;

public class SockMerchantSolution {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {

		// sort and count
		for (int i = 1; i < ar.length; i++) {
			int valueToInsert = ar[i];
			int index = i - 1;
			while (index >= 0 && ar[index] > valueToInsert) {
				ar[index + 1] = ar[index];
				index--;
			}
			ar[index + 1] = valueToInsert;
		}

		int pairCount = 0;
		int i = 0;
		while (i < ar.length - 1) {
			int j = i + 1;
			while (j < ar.length) {
				if (ar[i] != ar[j]) {
					break;
				}
				j++;
			}
			int count = j - i;
			pairCount += (count - count % 2) / 2;
			i += count;
		}

		return pairCount;

	}

	public static void main(String[] args) {

		int[] ar1 = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		int result = sockMerchant(ar1.length, ar1);
		System.out.println(result);
		assert result == 3;
		
		int[] ar2 = { 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };
		int result2 = sockMerchant(ar2.length, ar2);
		System.out.println(result2);
		assert result2 == 4;

	}

}
