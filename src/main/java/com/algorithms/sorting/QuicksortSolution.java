package com.algorithms.sorting;

import com.algorithms.sorting.exception.QuickSortSortSolutionSelectionException;

class QuicksortSolution {

	private SortSolution activeSolution;
	private SortSolutionUtil util;

	public QuicksortSolution(QuickSortVersion version) throws QuickSortSortSolutionSelectionException {
		util = SortSolutionUtil.getInstance();
		activeSolution = setQuickSortSolutions(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setQuickSortSolutions(QuickSortVersion version) throws QuickSortSortSolutionSelectionException {
		switch (version) {
		case INITIAL_PIVOT:
			return new QuickSortInitialPivot();
		case MIDDLE_PIVOT:
			return new QuickSortMiddleIndexPivot();
		case RANDOM_PIVOT:
			return new QuickSortRandomIndexPivot();
		case DUAL_PIVOT:
			return new QuickSortDualPivot();
		default:
			throw new QuickSortSortSolutionSelectionException();
		}
	}

	private class QuickSortInitialPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {

			quicksort(inputArray, 0, inputArray.length - 1);
			return inputArray;

		}// End of Method

		public void quicksort(int[] inputArray, int start, int end) {

			int length = end - start;

			if (length < 1) {
				return;
			}

			int pivot = start;
			int leftIndex = start + 1;
			int rightIndex = end;

			while (rightIndex >= leftIndex) {

				while (rightIndex > leftIndex && inputArray[leftIndex] <= inputArray[pivot]) {
					leftIndex++;
				}

				while (rightIndex > leftIndex && inputArray[rightIndex] > inputArray[pivot]) {
					rightIndex--;
				}

				if(rightIndex >= leftIndex) {
					util.swap(inputArray, leftIndex, rightIndex);
					leftIndex++;
					rightIndex--;
				}

			}

			util.swap(inputArray, pivot, leftIndex);

			quicksort(inputArray, start, leftIndex - 1);
			quicksort(inputArray, rightIndex, end);

		}// End of Method

	}

	private class QuickSortMiddleIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

	private class QuickSortRandomIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

	private class QuickSortDualPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

}
