package com.algorithms.sorting;

public class SelectionSortSolution implements SortSolution {

	SortSolutionUtil util;

	public SelectionSortSolution() {
		this.util = SortSolutionUtil.getInstance();
	}

	@Override
	public int[] sort(int[] inputArray) {
		for (int i = 0; i < inputArray.length - 1; i++) {
			int selected = i;
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < inputArray[selected]) {
					selected = j;
				}
			}
			util.swap(inputArray, selected, i);
		}
		return inputArray;
	}

}
