package com.algorithms.sorting;

import com.algorithms.sorting.exception.BubbleSortSolutionSelectionException;

class BubbleSortSolution {

	private SortSolution activeSolution;
	private SortSolutionUtil util;

	public BubbleSortSolution(BubbleSortVersion version) throws BubbleSortSolutionSelectionException {
		util = SortSolutionUtil.getInstance();
		activeSolution = setBubbleSortSolutions(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setBubbleSortSolutions(BubbleSortVersion version) throws BubbleSortSolutionSelectionException {
		switch (version) {
		case UNCHECKED_SWAPS:
			return new BubbleSortUncheckedSwaps();
		case IS_SWAP_CHECKED:
			return new BubbleSortIsSwappedCheck();
		case LAST_SWAP_INDEX_CHECK:
			return new BubbleSortWithLastSwapIndexCheck();
		default:
			throw new BubbleSortSolutionSelectionException();
		}
	}

	private class BubbleSortUncheckedSwaps implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			for (int i = 0; i < inputArray.length - 1; i++) {
				for (int j = 1; j < inputArray.length - i; j++) {
					if (inputArray[j] < inputArray[j - 1]) {
						util.swap(inputArray, j, j - 1);
					}
				}
			}
			return inputArray;
		}

	}

	private class BubbleSortIsSwappedCheck implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			for (int i = 0; i < inputArray.length - 1; i++) {
				boolean isSwapped = false;
				for (int j = 1; j < inputArray.length - i; j++) {
					if (inputArray[j] < inputArray[j - 1]) {
						util.swap(inputArray, j, j - 1);
						isSwapped = true;
					}
				}
				if (!isSwapped) {
					break;
				}
			}
			return inputArray;
		}

	}

	private class BubbleSortWithLastSwapIndexCheck implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			int unsortedBelow = inputArray.length;
			while (unsortedBelow != 0) {
				int lastSwap = 0;
				for (int j = 1; j < unsortedBelow; j++) {
					if (inputArray[j - 1] > inputArray[j]) {
						util.swap(inputArray, j, j - 1);
						lastSwap = j;
					}
				}
				unsortedBelow = lastSwap;
			}
			return inputArray;
		}

	}

}
