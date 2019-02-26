package com.algorithms.sorting;

import java.util.Random;
import java.util.stream.IntStream;

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

			int pivot = inputArray[start];
			int leftIndex = start;
			int rightIndex = end;

			int index = partition(inputArray, leftIndex, rightIndex, pivot);

			quicksort(inputArray, start, index - 1);
			quicksort(inputArray, index, end);

		}// End of Method

		public int partition(int[] inputArray, int leftIndex, int rightIndex, int pivot) {

			while (rightIndex >= leftIndex) {

				while (inputArray[leftIndex] < pivot) {
					leftIndex++;
				}

				while (inputArray[rightIndex] > pivot) {
					rightIndex--;
				}

				if (rightIndex >= leftIndex) {
					util.swap(inputArray, leftIndex, rightIndex);
					leftIndex++;
					rightIndex--;
				}

			}

			return leftIndex;

		}// End of Method

	}// End of Inner Class

	private class QuickSortMiddleIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			quicksort(inputArray, 0, inputArray.length - 1);
			return inputArray;
		}

		public void quicksort(int[] inputArray, int start, int end) {

			int length = end - start;

			if (length < 1) {
				return;
			}

			int middleIndex = start + (length - (length % 2)) / 2;
			int pivot = inputArray[middleIndex];
			int leftIndex = start;
			int rightIndex = end;

			int index = partition(inputArray, leftIndex, rightIndex, pivot);

			quicksort(inputArray, start, index - 1);
			quicksort(inputArray, index, end);

		}// End of Method

		public int partition(int[] inputArray, int leftIndex, int rightIndex, int pivot) {

			while (rightIndex >= leftIndex) {

				while (inputArray[leftIndex] < pivot) {
					leftIndex++;
				}

				while (inputArray[rightIndex] > pivot) {
					rightIndex--;
				}

				if (rightIndex >= leftIndex) {
					util.swap(inputArray, leftIndex, rightIndex);
					leftIndex++;
					rightIndex--;
				}

			}

			return leftIndex;

		}// End of Method

	}// End of Inner Class

	private class QuickSortRandomIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			quicksort(inputArray, 0, inputArray.length - 1);
			return inputArray;
		}

		public void quicksort(int[] inputArray, int start, int end) {

			int length = end - start;

			if (length < 1) {
				return;
			}

			Random random = new Random();
			IntStream intStream = random.ints(1, start, end);
			int randomIndex = intStream.iterator().nextInt();
			int pivot = inputArray[randomIndex];
			int leftIndex = start;
			int rightIndex = end;

			int index = partition(inputArray, leftIndex, rightIndex, pivot);

			quicksort(inputArray, start, index - 1);
			quicksort(inputArray, index, end);

		}// End of Method

		public int partition(int[] inputArray, int leftIndex, int rightIndex, int pivot) {

			while (rightIndex >= leftIndex) {

				while (inputArray[leftIndex] < pivot) {
					leftIndex++;
				}

				while (inputArray[rightIndex] > pivot) {
					rightIndex--;
				}

				if (rightIndex >= leftIndex) {
					util.swap(inputArray, leftIndex, rightIndex);
					leftIndex++;
					rightIndex--;
				}

			}

			return leftIndex;

		}// End of Method


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
