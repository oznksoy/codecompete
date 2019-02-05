package com.algorithms.sorting;

class PlainSortSolution implements SortSolution {

	boolean isPrinting = false;

	/**
	 * Method to sort the input array in plain sorting
	 */
	@Override
	public int[] sort(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			if (isPrinting)
				System.out.println(i + ". Step Starts With: " + printArray(inputArray));
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[i] < inputArray[j]) {
					if (isPrinting)
						System.out.print(inputArray[i] + " < " + inputArray[j] + " thus " + i + " switches with " + j);
					swap(inputArray, j, i);
					if (isPrinting)
						System.out.println(". New Placement: " + printArray(inputArray));
				} else if (isPrinting)
					System.out.println(inputArray[i] + " >= " + inputArray[j] + " hence continues");

			}
		}
		return inputArray;
	}

	private String printArray(int[] array) {
		String outputStr = "";
		for (int index : array) {
			outputStr = outputStr.concat(index + " ");
		}
		return outputStr.trim();
	}

	private void swap(int[] arr, int index1, int index2) {
		int transferable = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = transferable;
	}

}
