package com.algorithms.sorting;

import com.algorithms.sorting.exception.SortSolutionBubbleSelectionException;

class BubbleSortSolution {

	private SortSolution activeSolution;
	private SortSolutionUtil util;

	public BubbleSortSolution(BubbleSortVersion version) throws SortSolutionBubbleSelectionException {
		util = SortSolutionUtil.getInstance();
		activeSolution = setBubbleSortSolutions(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setBubbleSortSolutions(BubbleSortVersion version) throws SortSolutionBubbleSelectionException {
		switch (version) {
		case V1:
			return new BubbleSortV1();
		case V2:
			return new BubbleSortV2();
		case V3:
			return new BubbleSortV3();
		default:
			throw new SortSolutionBubbleSelectionException();
		}
	}

	private class BubbleSortV1 implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			int count = 0;
			for (int i = 0; i < inputArray.length - 1; i++) {
				for (int j = 1; j < inputArray.length - i; j++) {
					if (inputArray[j] < inputArray[j - 1]) {
						util.swap(inputArray, j, j - 1);
					}
					count++;
				}
			}
			System.out.println("Final Step Count : " + count);
			return inputArray;
		}

	}

	private class BubbleSortV2 implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			int count = 0;
			for (int i = 0; i < inputArray.length - 1; i++) {
				boolean isSwapped = false;
				for (int j = 1; j < inputArray.length - i; j++) {
					if (inputArray[j] < inputArray[j - 1]) {
						util.swap(inputArray, j, j - 1);
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

	}

	private class BubbleSortV3 implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			int count = 0;
			int unsortedBelow = inputArray.length;
			while (unsortedBelow != 0) {
				int lastSwap = 0;
				for (int j = 1; j < unsortedBelow; j++) {
					if (inputArray[j - 1] > inputArray[j]) {
						util.swap(inputArray, j, j - 1);
						lastSwap = j;
					}
					count++;
				}
				unsortedBelow = lastSwap;
			}
			System.out.println("Final Step Count : " + count);
			return inputArray;
		}

	}

}
