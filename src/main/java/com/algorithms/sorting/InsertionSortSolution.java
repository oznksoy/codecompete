package com.algorithms.sorting;

public class InsertionSortSolution implements SortSolution {

	SortSolutionUtil util;

	public InsertionSortSolution() {
		this.util = SortSolutionUtil.getInstance();
	}

	@Override
	public int[] sort(int[] inputArray) {
		return sortWithoutPrint(inputArray);
	}// End of Method

	public int[] sortWithoutPrint(int[] inputArray) {
		int n = inputArray.length;
		for (int i = 1; i < n; ++i) {
			int valueToInsert = inputArray[i];
			int sortedBelow = i - 1;
			while (sortedBelow >= 0 && inputArray[sortedBelow] > valueToInsert) {
				inputArray[sortedBelow + 1] = inputArray[sortedBelow];
				sortedBelow = sortedBelow - 1;
			}
			inputArray[sortedBelow + 1] = valueToInsert;
		}
		return inputArray;
	}// End of Method

	public int[] sortWithPrint(int[] inputArray) {
		int count = 0;
		int n = inputArray.length;
		System.out.println("Array :" + util.convertArrayToString(inputArray));
		for (int i = 1; i < n; ++i) {
			count++;
			int valueToInsert = inputArray[i];
			int sorted = i - 1;
			System.out.println("Value to Insert : " + valueToInsert + " at index " + i);
			System.out.println("Starts Sorting at index : " + sorted);

			while (sorted >= 0 && inputArray[sorted] > valueToInsert) {
				System.out.println(inputArray[sorted] + " is injected to index " + (sorted + 1));
				count++;
				inputArray[sorted + 1] = inputArray[sorted];
				sorted = sorted - 1;
				System.out.println("Sorted index steps back to " + (sorted));
			}
			inputArray[sorted + 1] = valueToInsert;
			System.out.println("Value Inserted to " + (sorted + 1));
		}
		System.out.println("Final Step Count : " + count);
		return inputArray;
	}// End of Method

}// End of Class
