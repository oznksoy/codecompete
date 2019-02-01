package com.algorithms.sorting;

public class BubbleSortSolution implements SortSolution {

	@Override
	public int[] sort(int[] inputArray) {

		return sortVersion2(inputArray);

	}

	private int[] sortVersion1(int[] inputArray) {
		int count = 0;
		for (int i = 0; i < inputArray.length - 1; i++) {
			for (int j = 1; j < inputArray.length - i; j++) {
				if (inputArray[j] < inputArray[j - 1]) {
					swap(inputArray, j, j - 1);

				}
				count++;
			}
		}
		System.out.println("Final Step Count : " + count);
		return inputArray;
	}

	private int[] sortVersion2(int[] inputArray) {
		int count = 0;
		for (int i = 0; i < inputArray.length - 1; i++) {
			boolean isSwapped = false;
			for (int j = 1; j < inputArray.length - i; j++) {
				if (inputArray[j] < inputArray[j - 1]) {
					swap(inputArray, j, j - 1);
					isSwapped = true;
				}
				count++;
			}
			if (!isSwapped) {
				break;
			}
		}
		System.out.println("Final Step Count : " + count);
		return inputArray;
	}

	private int[] sortVersion3(int[] inputArray) {
		int count = 0;
		int unsortedBelow = inputArray.length;
		while (unsortedBelow != 0) {
			int lastSwap = 0;
			for (int j = 1; j < unsortedBelow; j++) {
				if (inputArray[j - 1] > inputArray[j]) {
					swap(inputArray, j, j - 1);
					lastSwap = j;
				}
				count++;
			}
			unsortedBelow = lastSwap;
		}
		System.out.println("Final Step Count : " + count);
		return inputArray;
	}

	private void swap(int[] array, int i, int j) {
		int transferable = array[i];
		array[i] = array[j];
		array[j] = transferable;
	}

}
