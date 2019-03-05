package com.algorithms.hackerrank.implementation.medium;

public class AlmostSortedSolution {

	/**
	 * <p>
	 * Complete the almostSorted function below.
	 * </p>
	 * <p>
	 * Given an array of integers, determine whether the array can be sorted in
	 * ascending order using only one of the following operations one time.
	 * </p>
	 * <li>Swap two elements.</li>
	 * <li>Reverse one sub-segment.</li>
	 * <p>
	 * Determine whether one, both or neither of the operations will complete the
	 * task. If both work, choose swap.
	 * </p>
	 * <p>
	 * </p>
	 * 
	 * @param arr : 2<=n<=100000; 0<=arr[i]<=1000000; all arr[i] are distinct.
	 */
	static void almostSorted(int[] arr) {

		int first = -1;
		int second = -1;
		int third = -1;

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				if (first == -1) {
					first = i;
				} else if (second == -1) {
					second = i - 1;
				} else {
					third = i - 1;
				}
			}
		}

		if (first == -1) {// already sorted
			System.out.println("yes");
		} else if (first != -1 && second == -1 && third == -1) {
			if (first > 0 && isSwapPossible(arr, first, first - 1)) {
				System.out.println("yes");
				System.out.println("swap " + (first) + " " + (first + 1));
			} else {
				System.out.println("no");
			}
		} else if (first != -1 && second != -1 && third == -1) {
			if (isSwapPossible(arr, first, second)) {
				System.out.println("yes");
				System.out.println("swap " + (second + 1) + " " + (first + 1));
			} else {
				System.out.println("no");
			}
		} else if (first != -1 && third != -1) {
			if (isReversePossible(arr, first, third)) {
				System.out.println("yes");
				System.out.println("reverse " + (third + 1) + " " + (first + 1));
			} else {
				System.out.println("no");
			}
		}

	}// End of Method

	static boolean isReversePossible(int[] arr, int first, int third) {

		for (int i = third; i < first; i++) {
			if (arr[i] < arr[i + 1]) {
				return false;
			}
		}

		if (!(arr[first - 1] < arr[third])) {
			return false;
		}

		if (third > 0 && arr[third - 1] > arr[first]) {
			return false;
		}

		return true;

	}// End of Method

	static boolean isSwapPossible(int[] arr, int first, int second) {

		if (first - second == 1) {
			if (second != 0 && (arr[first] < arr[second - 1])) {
				return false;
			}
			if (first != arr.length - 1 && (arr[second] > arr[first + 1])) {
				return false;
			}
			return true;
		}

		if (first == arr.length - 1) {
			if (!(arr[first - 1] < arr[second])) {
				return false;
			}
		} else if (first < arr.length - 1) {
			if (!(arr[first - 1] < arr[second] && arr[second] < arr[first + 1])) {
				return false;
			}
		}

		if (second == 0) {
			if (!(arr[first] < arr[second + 1])) {
				return false;
			}
		} else if (second > 0) {
			if (!(arr[second - 1] < arr[first] && arr[first] < arr[second + 1])) {
				return false;
			}
		}

		return true;

	}// End of Method

	public static void main(String[] args) {
//		testAlmostSorted(new int[] { 4, 2 });// "yes","swap 1 2"
//		testAlmostSorted(new int[] { 5, 4, 3, 6, 7 });// "yes","reverse 1 3"
//		testAlmostSorted(new int[] { 3, 1, 2 });// "no"
//		testAlmostSorted(new int[] { 1, 2, 3 });// "yes"
//		testAlmostSorted(new int[] { 1, 2, 3, 4, 5, 6 });// "yes"
//		testAlmostSorted(new int[] { 1, 5, 4, 3, 2, 6 });// "yes","reverse 2 5"
//		testAlmostSorted(new int[] { 1, 2, 4, 3, 5, 6, 7, 8 });// "yes","swap 3 4"
//		testAlmostSorted(new int[] { 1, 2, 3, 6, 5, 4, 7, 8 });// "yes","reverse 4 6"
//		testAlmostSorted(new int[] { 1, 8, 3, 4, 5, 6, 7, 2 });// "yes","swap 2 8"
//		testAlmostSorted(new int[] { 1, 2, 3, 6, 5, 4, 7, 8, 9, 12, 11, 10 });// "no"
//		testAlmostSorted(new int[] { 1, 2, 3, 10, 5, 6, 7, 8, 9, 4, 11, 12 });// "yes","swap 4 10"

	}// End of Main

	static void testAlmostSorted(int[] arr) {
		almostSorted(arr);
	}// End of Test

}// End of Class
