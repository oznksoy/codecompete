package com.algorithms.hackerrank.implementation;

public class CutTheSticksSolution {

	// Complete the cutTheSticks function below.
	static int[] cutTheSticks(int[] arr) {
		quicksort(arr, 0, arr.length - 1);

		int[] cutsarr = new int[arr.length];
		int k = 0;
		for (int i = 0; i < arr.length;) {
			int cut = arr[i];
			int cuts = 0;
			for (int j = i; j < arr.length; j++) {
				arr[j] = arr[j] - cut;
				cuts++;
				if (arr[j] == 0) {
					i++;
				}
			}
			cutsarr[k] = cuts;
			k++;
		}
		
		int [] res = new int[k];
		for(int i = 0; i < k; i++) {
			res[i] = cutsarr[i];
		}
		
		return res;
		
	}

	static void quicksort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = array[(left + right) / 2];
		int index = partition(array, left, right, pivot);
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
	}// End of Method

	static int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}// End of Method

	static void swap(int[] array, int i, int j) {
		int transferable = array[i];
		array[i] = array[j];
		array[j] = transferable;
	}

	public static void main(String[] args) {
		testCutTheSticks(//
				new int[] { 5, 4, 4, 2, 2, 8 }, //
				new int[] { 6, 4, 2, 1 } //
		);
		testCutTheSticks(//
				new int[] { 1, 2, 3, 4, 3, 3, 2, 1 }, //
				new int[] { 8, 6, 4, 1 } //
		);
	}// End of Main

	static void testCutTheSticks(int[] arr, int[] expected) {
		int[] result = cutTheSticks(arr);
		for (int v : result) {
			System.out.println(v);
		}
		assert result.length == expected.length;
		for (int i = 0; i < result.length; i++) {
			assert result[i] == expected[i];
		}

	}// End of Test

} // End of Class
