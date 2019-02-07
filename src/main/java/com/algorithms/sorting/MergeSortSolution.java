package com.algorithms.sorting;

import com.algorithms.sorting.exception.MergeSortSolutionSelectionException;

public class MergeSortSolution {

	private SortSolution activeSolution;
	private SortSolutionUtil util;

	public MergeSortSolution(MergeSortVersion version) throws MergeSortSolutionSelectionException {
		util = SortSolutionUtil.getInstance();
		activeSolution = setMergeSortSolution(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setMergeSortSolution(MergeSortVersion version) throws MergeSortSolutionSelectionException {
		switch (version) {
		case RECURSIVE_NAIVE:
			return new RecursiveNaiveMergeSortSolution();
		case RECURSIVE_POLISHED:
			return new RecursivePolishedMergeSortSolution();
		case RECURSIVE_ARRAY_COPY:
			return new RecursiveArrayCopyMergeSortSolution();
		case NON_RECURSIVE:
			return new NonRecursiveMergeSortSolution();
		default:
			throw new MergeSortSolutionSelectionException();
		}
	}

	private class RecursiveNaiveMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			int[] sortedArray = mergesort(inputArray);
			return sortedArray;
		}

		public int[] mergesort(int[] inputArray) {

			int length = inputArray.length;

			if (length <= 1) {
				return inputArray;
			}

			int pivot = length % 2 > 0 ? (length + 1) / 2 : length / 2;

			int[] leftSide = new int[length - pivot];

			int[] rightSide = new int[pivot];

			for (int i = 0; i < leftSide.length; i++) {
				leftSide[i] = inputArray[i];
			}

			for (int i = leftSide.length; i < length; i++) {
				rightSide[i - leftSide.length] = inputArray[i];
			}

			int[] leftOutput = mergesort(leftSide);
			int[] rightOutput = mergesort(rightSide);
			int[] mergedOutput = mergeWithOnlyWhile(leftOutput, rightOutput);

			return mergedOutput;
		}

		public int[] merge(int[] leftSide, int[] rightSide) {

			int[] mergeArray = new int[leftSide.length + rightSide.length];

			int i = 0;
			while (i < mergeArray.length) {
				if (i < leftSide.length) {
					mergeArray[i] = leftSide[i];
				} else {
					mergeArray[i] = rightSide[i - leftSide.length];
				}
				i++;
			}

			for (int j = 1; j < mergeArray.length; j++) {
				int valueToInsert = mergeArray[j];
				int sortedBelow = j - 1;
				while (sortedBelow >= 0 && mergeArray[sortedBelow] > valueToInsert) {
					mergeArray[sortedBelow + 1] = mergeArray[sortedBelow];
					sortedBelow--;
				}
				mergeArray[sortedBelow + 1] = valueToInsert;
			}

			return mergeArray;

		}

		public int[] mergeWithOnlyWhile(int[] leftSide, int[] rightSide) {

			int[] mergeArray = new int[leftSide.length + rightSide.length];

			int leftIndex = 0;
			int rightIndex = 0;
			int index = 0;

			while (leftIndex < leftSide.length && rightIndex < rightSide.length) {
				if (leftSide[leftIndex] <= rightSide[rightIndex]) {
					mergeArray[index] = leftSide[leftIndex];
					leftIndex++;
				} else { // if (leftSide[leftIndex] > rightSide[rightIndex])
					mergeArray[index] = rightSide[rightIndex];
					rightIndex++;
				}
				index++;
			}

			while (rightIndex < rightSide.length) {
				mergeArray[index] = rightSide[rightIndex];
				rightIndex++;
				index++;
			}
			while (leftIndex < leftSide.length) {
				mergeArray[index] = leftSide[leftIndex];
				leftIndex++;
				index++;
			}

			return mergeArray;

		}

	}// End of Inner Class

	private class RecursiveArrayCopyMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray, new int[inputArray.length], 0, inputArray.length - 1);
			System.out.println("Array Copy Method Output : " + util.convertArrayToString(inputArray));
			return inputArray;
		}

		public void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
			if (leftStart >= rightEnd) {
				return;
			}
			int middle = (leftStart + rightEnd) / 2;
			mergesort(array, temp, leftStart, middle);
			mergesort(array, temp, middle + 1, rightEnd);
			mergeHalves(array, temp, leftStart, rightEnd);
		}// End of Method

		public void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
			int leftEnd = (rightEnd + leftStart) / 2;
			int rightStart = leftEnd + 1;
			int size = rightEnd - leftStart + 1;

			int left = leftStart;
			int right = rightStart;
			int index = leftStart;

			while (left <= leftEnd && right <= rightEnd) {
				if (array[left] < array[right]) {
					temp[index] = array[left];
					left++;
				} else {
					temp[index] = array[right];
					right++;
				}
				index++;
			}

//			if (right < rightEnd) {
//				temp[index] = array[right];
//			} else if (left < leftEnd) {
//				temp[index] = array[left];
//			}

//			int remainingLeft = leftEnd - left + 1;
//			int remainingRight = rightEnd - right + 1;

//			if (remainingLeft != 0 && left + 1 < array.length)
			System.arraycopy(array, left, temp, index, leftEnd - left + 1);
//			if (remainingRight != 0 && right + 1 < array.length)
			System.arraycopy(array, right, temp, index, rightEnd - right + 1);

			System.arraycopy(temp, leftStart, temp, leftStart, size);

		}// End of Method

	}// End of Inner Class

	private class RecursivePolishedMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray, 0, inputArray.length - 1);
			return inputArray;
		}

		// Main function that sorts arr[l..r] using
		// merge()
		void mergesort(int arr[], int l, int r) {
			if (l < r) {
				// Find the middle point
				int m = (l + r) / 2;

				// Sort first and second halves
				mergesort(arr, l, m);
				mergesort(arr, m + 1, r);

				// Merge the sorted halves
				merge(arr, l, m, r);
			}
		}

		void merge(int arr[], int l, int m, int r) {
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

	}

	private class NonRecursiveMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
