package com.algorithms.sorting;

class BruteSortSolution implements SortSolution {

	SortSolutionUtil util = SortSolutionUtil.getInstance();

	/**
	 * Method to sort the input array in plain sorting
	 */
	@Override
	public int[] sort(int[] inputArray) {
		return sortWithoutPrint(inputArray);
	}

	private int[] sortWithoutPrint(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[i] < inputArray[j]) {
					swap(inputArray, j, i);
				}
			}
		}
		return inputArray;
	}

	public int[] sortWithPrint(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(i + ". Step Starts With: " + util.convertArrayToString(inputArray));
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[i] < inputArray[j]) {
					System.out.print(inputArray[i] + " < " + inputArray[j] + " thus " + i + " switches with " + j);
					swap(inputArray, j, i);
					System.out.println(". New Placement: " + util.convertArrayToString(inputArray));
				} else {
					System.out.println(inputArray[i] + " >= " + inputArray[j] + " hence continues");
				}
			}
		}
		return inputArray;
	}

	private void swap(int[] arr, int index1, int index2) {
		int transferable = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = transferable;
	}

}
