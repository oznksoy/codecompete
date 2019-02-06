package com.algorithms.sorting;

public class InsertionSortSolution implements SortSolution {

	boolean isPrinting = true;
	SortSolutionUtil util;

	public InsertionSortSolution() {
		this.util = SortSolutionUtil.getInstance();
	}

	@Override
	public int[] sort(int[] inputArray) {
		int count = 0;
		int n = inputArray.length;
		if (isPrinting)
			System.out.println("Array :" + util.convertArrayToString(inputArray));
		for (int i = 1; i < n; ++i) {
			count++;
			int valueToInsert = inputArray[i];
			int sorted = i - 1;
			if (isPrinting) {
				System.out.println("Value to Insert : " + valueToInsert + " at index " + i);
				System.out.println("Starts Sorting at index : " + sorted);
			}

			while (sorted >= 0 && inputArray[sorted] > valueToInsert) {
				if (isPrinting)
					System.out.println(inputArray[sorted] + " is injected to index " + (sorted + 1));
				count++;
				inputArray[sorted + 1] = inputArray[sorted];
				sorted = sorted - 1;
				if (isPrinting)
					System.out.println("Sorted index steps back to " + (sorted));
			}
			inputArray[sorted + 1] = valueToInsert;
			if (isPrinting)
				System.out.println("Value Inserted to " + (sorted + 1));
		}
		if (isPrinting)
			System.out.println("Final Step Count : " + count);
		return inputArray;

	}// End of Method

	public int[] sorWithoutPrint(int[] inputArray) {
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

}// End of Class
