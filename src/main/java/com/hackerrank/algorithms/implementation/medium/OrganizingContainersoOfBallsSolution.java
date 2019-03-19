package com.hackerrank.algorithms.implementation.medium;

public class OrganizingContainersoOfBallsSolution {

	// Complete the organizingContainers function below.
	static String organizingContainers(int[][] container) {

		String impossible = "Impossible";
		String possible = "Possible";

		int matDimVal = container.length;

		int[] containerCapacity = new int[matDimVal];
		int[] elementCount = new int[matDimVal];

		for (int containerId = 0; containerId < matDimVal; containerId++) {
			int capacity = 0;
			for (int elementId = 0; elementId < matDimVal; elementId++) {
				int numOfElements = container[containerId][elementId];
				capacity += numOfElements;
				elementCount[elementId] += numOfElements;
			}
			containerCapacity[containerId] = capacity;
		}

		sort(containerCapacity);
		sort(elementCount);

		for (int i = 0; i < matDimVal; i++) {
			if (containerCapacity[i] != elementCount[i]) {
				return impossible;
			}
		}

		return possible;

	} // End of Method

	static void sort(int[] inputArray) {
		mergesort(inputArray, new int[inputArray.length], 0, inputArray.length - 1);
	}

	static void mergesort(int[] inputArray, int[] memo, int start, int end) {

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

	static void merge(int inputArray[], int memo[], int start, int mid, int end) {

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

	public static void main(String[] args) {

		String impossible = "Impossible";
		String possible = "Possible";
		testOrganizingContainers(new int[][] { { 1, 1 }, { 1, 1 } }, possible);
		testOrganizingContainers(new int[][] { { 0, 2 }, { 1, 1 } }, impossible);
		testOrganizingContainers(new int[][] { { 1, 3, 1 }, { 2, 1, 2 }, { 3, 3, 3 } }, impossible);
		testOrganizingContainers(new int[][] { { 0, 2, 1 }, { 1, 1, 1 }, { 2, 0, 0 } }, possible);

	} // End of Main

	static void testOrganizingContainers(int[][] container, String expected) {
		String result = organizingContainers(container);
		System.out.println(result);
		assert result.contentEquals(result);
	}// End of Test

}// End of Class
