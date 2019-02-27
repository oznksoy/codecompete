package com.algorithms.hackerrank.implementation.medium;

public class AbsolutePermutation {

	/**
	 * <p>
	 * Complete the absolutePermutation function below.
	 * </p>
	 * <p>
	 * It should return an integer that represents the smallest lexicographically
	 * smallest permutation, or if there is none.
	 * </p>
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	static int[] absolutePermutation(int n, int k) {

		int[][] p = new int[n][2];

		//maps permutation possibilities
		for (int i = 0; i < n; i++) {

			int base = i + 1;
			int lowOption = base - k;
			if (lowOption <= n && lowOption >= 1) {
				p[i][0] = lowOption;
			} else {
				p[i][0] = -1;
			}
			int highOption = base + k;
			if (highOption <= n && highOption >= 1) {
				p[i][1] = lowOption;
			} else {
				p[i][1] = -1;
			}
			// which permutation option is viable?

		}

		
		
		return null;

	}// End of Method

	public static void main(String[] args) {

	}// End of Main

	static void testAbsolutePermutation(int n, int k, int[] expected) {
		int[] result = absolutePermutation(n, k);
		System.out.println("Result : ");
		for (int value : result) {
			System.out.println(value);
		}
		assert expected.length == result.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i] == result[i];
		}
	}// End of Test

}// End of Class
