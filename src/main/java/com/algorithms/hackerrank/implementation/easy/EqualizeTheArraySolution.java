package com.algorithms.hackerrank.implementation.easy;

public class EqualizeTheArraySolution {

	// Complete the equalizeArray function below.
	static int equalizeArray2(int[] arr) {

		int[] memory = new int[101];
		for (int i = 0; i < arr.length; i++) {
			memory[arr[i]] = memory[arr[i]] + 1;
		}

		int highest = 0;
		for (int i = 0; i < arr.length; i++) {
			if (highest < memory[arr[i]]) {
				highest = memory[arr[i]];
			}
		}

		return arr.length - highest;

	}// End of Method

	// Complete the equalizeArray function below.
	static int equalizeArray(int[] arr) {

		insertionSort(arr);

		int highestCount = 0;
		for (int i = 0; i < arr.length;) {
			int j;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[i] != arr[j]) {
					break;
				}
			}
			int count = j - i;
			if (highestCount < count) {
				highestCount = count;
			}
			i = j;
		}

		return arr.length - highestCount;

	}// End of Method

	static void insertionSort(int[] inputArray) {
		int n = inputArray.length;
		for (int i = 1; i < n; ++i) {
			int valueToInsert = inputArray[i];
			int sortedBelow = i - 1;
			while (sortedBelow >= 0 && inputArray[sortedBelow] > valueToInsert) {
				inputArray[sortedBelow + 1] = inputArray[sortedBelow];
				sortedBelow = sortedBelow - 1;
			}
			inputArray[sortedBelow + 1] = valueToInsert;
		}
	}// End of Method

	public static void main(String[] args) {
		testEqualizeTheArraySolution(new int[] { 3, 3, 2, 1, 3 }, 2);
	}// End of Main

	static void testEqualizeTheArraySolution(int[] arr, int expected) {
		int result = equalizeArray(arr);
		System.out.println(result);
		assert result == expected;
	}

}// End of Class
