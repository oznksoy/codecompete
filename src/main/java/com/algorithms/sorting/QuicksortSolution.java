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
		case GAYLE_MCDOWELL:
			return new QuickSortGayleLaakmannMcDowell();
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

				// while (rightIndex > leftIndex && inputArray[leftIndex] <= inputArray[pivot])
				// {
				while (inputArray[leftIndex] < inputArray[pivot]) {
					leftIndex++;
				}

				// while (rightIndex > leftIndex && inputArray[rightIndex] > inputArray[pivot])
				// {
				while (inputArray[rightIndex] > inputArray[pivot]) {
					rightIndex--;
				}

				if (rightIndex >= leftIndex) {
					util.swap(inputArray, leftIndex, rightIndex);
					leftIndex++;
					rightIndex--;
				}

			}

//			util.swap(inputArray, pivot, leftIndex);

			quicksort(inputArray, start, leftIndex - 1);
			quicksort(inputArray, rightIndex, end);

		}// End of Method

	}// End of Inner Class

	private class QuickSortMiddleIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}// End of Inner Class

	private class QuickSortRandomIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}// End of Inner Class

	private class QuickSortDualPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}// End of Inner Class

	private class QuickSortGayleLaakmannMcDowell implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			quicksort(inputArray, 0, inputArray.length - 1);
			return inputArray;
		}

		public void quicksort(int[] array, int left, int right) {
			if (left >= right) {
				return;
			}
			int pivot = array[(left + right) / 2];
			int index = partition(array, left, right, pivot);
			quicksort(array, left, index - 1);
			quicksort(array, index, right);
		}// End of Method

		public int partition(int[] array, int left, int right, int pivot) {
			while (left <= right) {
				while (array[left] < pivot) {
					left++;
				}
				while (array[right] > pivot) {
					right--;
				}
				if (left <= right) {
					util.swap(array, left, right);
					left++;
					right--;
				}
			}
			return left;
		}// End of Method

	}// End of Inner Class

}
