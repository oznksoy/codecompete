package com.hackerrank.algorithms.implementation.easy;

public class BeautifulTripletsSolution {

	// Complete the beautifulTriplets function below.
	/**
	 * 
	 * @param d   : distance between elements
	 * @param arr : array of elements
	 * @return number of triplets that can be formed from the array elements
	 */
	static int beautifulTriplets(int d, int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int k = arr.length - 1; k > i; k--) {
				int diff2 = arr[k] - arr[i];
				if (diff2 % 2 == 0 && diff2 == 2 * d) {
					for (int j = i + 1; j < k; j++) {
						if (arr[j] - arr[i] == d) {
							count++;
						}
					}
				}

			}
		}
		return count;

	} // End of Method

	public static void main(String[] args) {
//		testBeautifulTriplets(3, new int[] { 1, 2, 4, 5, 7, 8, 10 }, 3);
//		testBeautifulTriplets(3, new int[] { 1, 6, 7, 7, 8, 10, 12, 13, 14, 19 }, 2);
	}// End of Main

	static void testBeautifulTriplets(int d, int[] arr, int expected) {
		int result = beautifulTriplets(d, arr);
		System.out.println("Result : " + result);
		assert expected == result;
	}

}// End of Class
