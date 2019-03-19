package com.hackerrank.algorithms.implementation.medium;

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
	static String larrysArray(int[] array) {

		// find the smallest element
		// bring the found value to the next line to sort by rotation

		int sortedBelow = 0;
		while (sortedBelow != array.length - 1) {
			int nextToSort = findIndexOfLowestValue(array, sortedBelow);
			rotateUntilInitialUnsorted(array, sortedBelow, nextToSort);
			sortedBelow++;
		}

		if (isSorted(array)) {
			return "YES";
		} else {
			return "NO";
		}

	}// End of Method

	static boolean isSorted(int[] array) {
		for (int i = array.length - 1; i >= 1; i--) {
			if (array[i] < array[i - 1]) {
				return false;
			}
		}
		return true;
	}// End of Method

	static void rotateUntilInitialUnsorted(int[] array, int sortedBelow, int nextToSort) {
		int endIndex = nextToSort;
		int diff = endIndex - sortedBelow;
		while (diff > 0 ) {
			if (diff >= 2) {
				rotateDouble(array, endIndex);
				endIndex = endIndex - 2;
			} else if (diff == 1 && endIndex + 1 <= array.length - 1) {
				rotate(array, endIndex + 1);
				endIndex = endIndex - 1;
			} else {
				break;
			}
			diff = endIndex - sortedBelow;
		}
	}// End of Method

	static void rotate(int[] array, int endIndex) {
		int temp = array[endIndex - 2];
		array[endIndex - 2] = array[endIndex - 1];
		array[endIndex - 1] = array[endIndex];
		array[endIndex] = temp;
	}

	static void rotateDouble(int[] array, int endIndex) {
		int temp = array[endIndex - 1];
		array[endIndex - 1] = array[endIndex - 2];
		array[endIndex - 2] = array[endIndex];
		array[endIndex] = temp;
	}// End of Method

	static int findIndexOfLowestValue(int[] array, int start) {

		int indexOflowestValue = start;
		for (int i = start + 1; i < array.length; i++) {
			if (array[i] < array[indexOflowestValue]) {
				indexOflowestValue = i;
			}
		}

		return indexOflowestValue;

	}// End of Method

	public static void main(String[] args) {
		testLarrysArray(new int[] { 1, 6, 5, 2, 4, 3 }, "YES");
		testLarrysArray(new int[] { 3, 1, 2 }, "YES");
		testLarrysArray(new int[] { 1, 3, 4, 2 }, "YES");
		testLarrysArray(new int[] { 1, 2, 3, 5, 4 }, "NO");
		testLarrysArray(new int[] { 1, 6, 5, 2, 3, 4 }, "NO");
		testLarrysArray(new int[] { 7, 11, 8, 13 }, "NO");
	}// End of Main

	static void testLarrysArray(int[] a, String expected) {
		String result = larrysArray(a);
		System.out.println("Result : " + result);
		assert result.equals(expected);
	}// End of Test

}// End of Class
