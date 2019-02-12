package com.algorithms.sorting;

import com.algorithms.sorting.exception.MergeSortSolutionSelectionException;

public class MergeSortSolution {

	private SortSolution activeSolution;

	public MergeSortSolution(MergeSortVersion version) throws MergeSortSolutionSelectionException {
		activeSolution = setMergeSortSolution(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setMergeSortSolution(MergeSortVersion version) throws MergeSortSolutionSelectionException {
		switch (version) {
		case RECURSIVE_SORTED_BY_INSERTION:
			return new RecursiveSortedByInsertionMergeSortSolution();
		case RECURSIVE_N_SPACE:
			return new RecursiveNSpaceMergeSortSolution();
		case RECURSIVE_NLOGN_SPACE:
			return new RecursiveNLogNSpaceMergeSortSolution();
		case RECURSIVE_ONE_SPACE:
			return new RecursiveNaiveOneSpaceMergeSortSolution();
		case RECURSIVE_NLOGN_SPACE_DIVISION_ON_MERGE:
			return new RecursiveFromGeekByGeekMergeSortSolution();
		case RECURSIVE_ARRAY_COPY:
			return new RecursiveArrayCopyMergeSortSolution();
		case NON_RECURSIVE_WHILE_LOOP:
			return new NonRecursiveMergeSortSolutionWhileLoop();
		case NON_RECURSIVE_FOR_LOOP:
			return new NonRecursiveMergeSortSolutionForLoop();
		case NON_RECURSIVE_PRINCETON:
			return new NonRecursiveMergeSortSolutionPrinceton();
		default:
			throw new MergeSortSolutionSelectionException();
		}
	}

	/**
	 * <p>
	 * Easy but wrong implementation for the mergesort. Mergesort is slowed down by
	 * both internal sorting by insertion sort, and both creating of extra space by
	 * generation of temporary left and right sections of array before merge. this
	 * have N*((LogN)^2) and space complexity of NLogN. Note that since insertion
	 * sort is done during the merging operation, it is not time complexity of n^2.
	 * <p>
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class RecursiveSortedByInsertionMergeSortSolution implements SortSolution {

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
			int[] mergedOutput = merge(leftOutput, rightOutput);

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

	}// End of Inner Class

	/**
	 * <p>
	 * This mergesort solution is easier to code by slower to work because of extra
	 * space complexity caused by two temporary arrays for left and right sections
	 * of the sub arrays. This causes Time complexity of N*LogN and Space Complexity
	 * of N*logN
	 * </p>
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class RecursiveNLogNSpaceMergeSortSolution implements SortSolution {

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
			int[] mergedOutput = merge(leftOutput, rightOutput);

			return mergedOutput;
		}

		public int[] merge(int[] leftSide, int[] rightSide) {

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

	/**
	 * <p>
	 * Optimal Mergesort solution. Only uses N space and with time complexity of
	 * N*LogN. Notice that final injection from temporary array to main array is
	 * done in merge action. I tried to move it into mergesort method thnking that
	 * this would reduce the number of copying iterations; however to my suprise
	 * this change was causing a minor slow down. This slowdown was ~%15. For
	 * example, the sorting performance was around 0.073s compared to 0.063s for
	 * 5000000 integers between the values of 0 to 200.
	 * </p>
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class RecursiveNSpaceMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray, new int[inputArray.length], 0, inputArray.length - 1);
			return inputArray;
		}

		public void mergesort(int[] inputArray, int[] memo, int start, int end) {

			if (end - start <= 0) {
				return;
			}

			int length = end - start + 1;
			int pivot = length % 2 > 0 ? (length + 1) / 2 : length / 2;
			int mid = start + pivot;

			mergesort(inputArray, memo, start, (mid - 1));
			mergesort(inputArray, memo, mid, end);
			merge(inputArray, memo, start, mid, end);

		}

		public void merge(int inputArray[], int memo[], int start, int mid, int end) {

			int leftIndex = start;
			int rightIndex = mid;
			int index = start;

			while (leftIndex < mid && rightIndex <= end) {
				if (inputArray[leftIndex] < inputArray[rightIndex]) {
					memo[index] = inputArray[leftIndex];
					leftIndex++;
				} else {
					memo[index] = inputArray[rightIndex];
					rightIndex++;
				}
				index++;
			}

			while (leftIndex < mid) {
				memo[index] = inputArray[leftIndex];
				leftIndex++;
				index++;
			}

			while (rightIndex <= end) {
				memo[index] = inputArray[rightIndex];
				rightIndex++;
				index++;
			}

			for (int i = start; i < index; i++) {
				inputArray[i] = memo[i];
			}

		}// End of Method

	}// End of Inner Class

	/**
	 * <p>
	 * This solution focuses on minimizing the space requirement for the mergesort.
	 * It uses a sorting iteration logic that is similar to Insertion Sort. The
	 * values are not stored, by pushed forward on the input array itself. However,
	 * this would cause a substantially increased time complexity. Time complexity
	 * will increase to N*((LogN)^2), where extra logN coming from the shuffling of
	 * array elements on top of NLogN mergesort complexity.
	 * </p>
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class RecursiveNaiveOneSpaceMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray, 0, inputArray.length - 1);
			return inputArray;
		}

		public void mergesort(int[] inputArray, int start, int end) {

			if (end - start <= 0) {
				return;
			}

			int length = end - start + 1;
			int pivot = length % 2 > 0 ? (length + 1) / 2 : length / 2;
			int mid = start + pivot;

			mergesort(inputArray, start, (mid - 1));
			mergesort(inputArray, mid, end);
			merge(inputArray, start, mid, end);

		}

		public void merge(int inputArray[], int start, int mid, int end) {

			int leftIndex = start;
			int rightIndex = mid;
			int midIndex = mid;

			while (leftIndex < midIndex && rightIndex <= end) {
				if (inputArray[leftIndex] > inputArray[rightIndex]) {
					int valueToPush = inputArray[rightIndex];
					int index = rightIndex;
					while (index != leftIndex) {
						inputArray[index] = inputArray[index - 1];
						index--;
					}
					inputArray[leftIndex] = valueToPush;
					midIndex++;
					rightIndex++;
				}
				leftIndex++;
			}

		}// End of Method

	}// End of Inner Class

	/**
	 * 
	 * <p>
	 * I came across this algorithm white trying to compare my own solution to
	 * others. It was interesting to see a direct use of the system library. I
	 * wondered if there was any difference in performance to my N space merge sort
	 * solution. At least on my test configurations, it seems like there is a
	 * difference. ArrayCopy Method a little faster compared to
	 * {@link RecursiveNSpaceMergeSortSolution my N space mergesort solution}
	 * </p>
	 * <p>
	 * For 5000000 random entries from 0 to 200 value range
	 * <li>{@linkplain RecursiveNSpaceMergeSortSolution N Space Iterative Copy
	 * MergeSortSolution } gets 0.063s</li>
	 * <li>{@linkplain RecursiveArrayCopyMergeSortSolution N Space Array Copy
	 * MergeSortSolution } gets 0.059s</li>
	 * <p>
	 * 
	 * @see <a href= "https://youtu.be/KF2j-9iSf4Q">Algorithms: Merge Sort by
	 *      Hackerrank</a>
	 * @author Gayle Laakmann McDowel
	 *
	 */
	private class RecursiveArrayCopyMergeSortSolution implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray, new int[inputArray.length], 0, inputArray.length - 1);
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

			System.arraycopy(array, left, temp, index, leftEnd - left + 1);
			System.arraycopy(array, right, temp, index, rightEnd - right + 1);
			System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);

		}// End of Method

	}// End of Inner Class

	/**
	 * <p>
	 * I have found this solution while trying to find other mergesort solutions to
	 * compare to my solutions. This solution is also similar to
	 * {@linkplain RecursiveNLogNSpaceMergeSortSolution my NlogN space NlogN time
	 * complexity solution}, since it constantly creates temporary arrays for left
	 * and right sides of the sub arrays. However this solution is ought to be
	 * slower, since it calculates indexes that can be attained from sub arrays, and
	 * also it creates sub arrays within the merge function, rather than the
	 * mergesort method.
	 * </p>
	 * 
	 * @see <a href=
	 *      "https://www.geeksforgeeks.org/java-program-for-merge-sort/">Java
	 *      Program for Merge Sort</a>
	 * @author Rajat Mishra
	 *
	 */
	private class RecursiveFromGeekByGeekMergeSortSolution implements SortSolution {

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

	/**
	 * My Own nonrecursive mergesort solution via while loop
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class NonRecursiveMergeSortSolutionWhileLoop implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray);
			return inputArray;
		}

		public void mergesort(int[] inputArray) {

			int[] memo = new int[inputArray.length];

			if (inputArray.length <= 1) {
				return;
			}

			int step = 1;
			int mergeLenght = pow(step);
			int subarrayLength = mergeLenght / 2;
			while (subarrayLength < inputArray.length) {
				int start = 0;
				while (start < inputArray.length - subarrayLength) {
					int end = calcEnd(start, mergeLenght, inputArray.length);
					int mid = start + subarrayLength;
					merge(inputArray, memo, start, mid, end);
					start = end + 1;
				}
				step = step + 1;
				mergeLenght = pow(step);
				subarrayLength = mergeLenght / 2;
			}

		}// End of Method

		public int pow(int value) {
			int pw = 1;
			for (int i = 0; i < value; i++) {
				pw = pw * 2;
			}
			return pw;
		}

		public int calcEnd(int start, int mergeLenght, int arrayLength) {
			int end = start + mergeLenght - 1;
			int result = end < arrayLength ? end : (arrayLength - 1);
			return result;

		}// End of Method

		public void merge(int inputArray[], int memo[], int start, int mid, int end) {

			int leftIndex = start;
			int rightIndex = mid;
			int index = start;

			while (leftIndex < mid && rightIndex <= end) {
				if (inputArray[leftIndex] < inputArray[rightIndex]) {
					memo[index] = inputArray[leftIndex];
					leftIndex++;
				} else {
					memo[index] = inputArray[rightIndex];
					rightIndex++;
				}
				index++;
			}

			while (leftIndex < mid) {
				memo[index] = inputArray[leftIndex];
				leftIndex++;
				index++;
			}

			while (rightIndex <= end) {
				memo[index] = inputArray[rightIndex];
				rightIndex++;
				index++;
			}

			for (int i = start; i < index; i++) {
				inputArray[i] = memo[i];
			}

		}// End of Method

	} // End of Inner Class

	/**
	 * My Own nonrecursive mergesort solution via for loop. I have implemented the
	 * algorithm from the {@linkplain NonRecursiveMergeSortSolutionPrinceton
	 * princeton example} and deviced a separate solution.
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class NonRecursiveMergeSortSolutionForLoop implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray);
			return inputArray;
		}

		public void mergesort(int[] inputArray) {

			if (inputArray.length <= 1) {
				return;
			}

			int[] temp = new int[inputArray.length];

			for (int sublength = 1; sublength < inputArray.length; sublength = 2 * sublength) {
				for (int start = 0; start < inputArray.length - sublength; start = start + 2 * sublength) {
					int mid = start + sublength;
					int end = (mid + sublength - 1) < inputArray.length ? mid + sublength - 1 : inputArray.length - 1;
					merge(inputArray, temp, start, mid, end);
				}
			}

		}

		public void merge(int inputArray[], int memo[], int start, int mid, int end) {

			int leftIndex = start;
			int rightIndex = mid;
			int index = start;

			while (leftIndex < mid && rightIndex <= end) {
				if (inputArray[leftIndex] < inputArray[rightIndex]) {
					memo[index] = inputArray[leftIndex];
					leftIndex++;
				} else {
					memo[index] = inputArray[rightIndex];
					rightIndex++;
				}
				index++;
			}

			while (leftIndex < mid) {
				memo[index] = inputArray[leftIndex];
				leftIndex++;
				index++;
			}

			while (rightIndex <= end) {
				memo[index] = inputArray[rightIndex];
				rightIndex++;
				index++;
			}

			for (int i = start; i < index; i++) {
				inputArray[i] = memo[i];
			}

		}// End of Method

	}// End of Inner Classs

	/**
	 * <p>
	 * A Mergesort solution I found from princeton university lectures in order to
	 * compare with my own solution.
	 * </p>
	 * 
	 * @see <a href=:"https://algs4.cs.princeton.edu/22mergesort/"> Princeton Non
	 *      Recursive Mergesort Solution</a>
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private class NonRecursiveMergeSortSolutionPrinceton implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			mergesort(inputArray);
			return inputArray;
		}

		public void mergesort(int[] a) {
			int n = a.length;
			int[] aux = new int[n];
			for (int len = 1; len < n; len *= 2) {
				for (int lo = 0; lo < n - len; lo += len + len) {
					int mid = lo + len - 1;
					int hi = Math.min(lo + len + len - 1, n - 1);
					merge(a, aux, lo, mid, hi);
				}
			}
		}

		private void merge(int[] a, int[] aux, int lo, int mid, int hi) {

			// copy to aux[]
			for (int k = lo; k <= hi; k++) {
				aux[k] = a[k];
			}

			// merge back to a[]
			int i = lo, j = mid + 1;
			for (int k = lo; k <= hi; k++) {
				if (i > mid)
					a[k] = aux[j++]; // this copying is unneccessary
				else if (j > hi)
					a[k] = aux[i++];
				else if (aux[j] < aux[i])
					a[k] = aux[j++];
				else
					a[k] = aux[i++];
			}

		}

	}// End of Inner Classs

} // End of Class
