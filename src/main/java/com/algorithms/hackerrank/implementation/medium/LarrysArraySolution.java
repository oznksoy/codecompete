package com.algorithms.hackerrank.implementation.medium;

public class LarrysArraySolution {

	// Complete the larrysArray function below.
	/**
	 * <p>
	 * For the input array, write a function "rotate" so that the array will be
	 * sorted. Rotate method will be taking 3 elements from the array while keeping
	 * the index form and push the initial index to the last index, and pull the
	 * rest of the indexed backwards. Such as ABC -> BCA
	 * </p>
	 * <p>
	 * Can a sorted array be achieved?
	 * </p>
	 * 
	 * @param a : array of integers with n length. 3<=n<=1000 and 1<=A[i]<=n
	 * @return "YES" or "NO" depending of availability of creating a sorted sequence
	 */
	static String larrysArray(int[] a) {
		return null;
	}// End of Method

	public static void main(String[] args) {

	}// End of Main

	static void testLarrysArray(int[] a, String expected) {

		testLarrysArray(new int[] { 1, 6, 5, 2, 4, 3 }, "YES");
		testLarrysArray(new int[] { 3, 1, 2 }, "YES");
		testLarrysArray(new int[] { 1, 3, 4, 2 }, "YES");
		testLarrysArray(new int[] { 1, 2, 3, 5, 4 }, "NO");
		testLarrysArray(new int[] { 1, 6, 5, 2, 3, 4 }, "NO");
		testLarrysArray(new int[] { 7, 11, 8, 13 }, "NO");


	}// End of Test

}// End of Class
