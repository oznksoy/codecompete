package com.algorithms.sorting;

class SortSolutionUtil {

	private static SortSolutionUtil instance;

	private SortSolutionUtil() {
	}

	public static SortSolutionUtil getInstance() {
		if (instance == null) {
			instance = new SortSolutionUtil();
		}
		return instance;
	}

	public void swap(int[] array, int i, int j) {
		int transferable = array[i];
		array[i] = array[j];
		array[j] = transferable;
	}

}
