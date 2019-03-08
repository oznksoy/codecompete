package com.datastructures.hackerrank.arrays.hard;

public class ArrayManipulationSolution {

	// Complete the arrayManipulation function below.
	static long arrayManipulationWithArraySum(int n, int[][] queries) {

		long[] sumarray = new long[n];
		long highest = 0;
		for (int h = 0; h < queries.length; h++) {
			for (int i = queries[h][0] - 1; i <= queries[h][1] - 1; i++) {
				sumarray[i] += queries[h][2];
				if (highest < sumarray[i]) {
					highest = sumarray[i];
				}
			}
		}

		return highest;

	}// End of Method

	static long arrayManipulationWithDiffArray(int n, int[][] queries) {

		long[] diffArray = initializeDiffArray(n);

		for (int h = 0; h < queries.length; h++) {
			int from = queries[h][0] - 1;
			int to = queries[h][1] - 1;
			int value = queries[h][2];
			update(diffArray, from, to, value);
		}

		long highest = 0;
		for (int i = 1; i < diffArray.length; i++) {
			diffArray[i] = diffArray[i] + diffArray[i - 1];
			if (diffArray[i] > highest) {
				highest = diffArray[i];
			}
		}

		return highest;

	}// End of Method

	static long[] initializeDiffArray(int n) {

		long[] diffArray = new long[n + 1];
		for (int i = 1; i < n; i++) {
			diffArray[i] = 0;
		}
		return diffArray;

	} // End of Method

	static void update(long[] diffArray, int from, int to, int value) {
		diffArray[from] += value;
		diffArray[to + 1] -= value;
	} // End of Method

	public static void main(String[] args) {
		testCase1ArraySum();
		testCase2ArraySum();
		testCase1DiffArray();
		testCase2DiffArray();
	}// End of Main
	
	static void testCase1ArraySum() {
		testArrayManipulationWithArraySum(//
				10, //
				createQueryInput(//
						"1 5 3", //
						"4 8 7", //
						"6 9 1" //
				), 10L //
		);
	}// End of Test Case
	
	static void testCase2ArraySum() {
		testArrayManipulationWithArraySum(//
				5, //
				createQueryInput(//
						"1 2 100", //
						"2 5 100", //
						"3 4 100" //
				), 200L //
		);
	}// End of Test Case


	static void testCase1DiffArray() {
		testArrayManipulationWithDiffArray(//
				10, //
				createQueryInput(//
						"1 5 3", //
						"4 8 7", //
						"6 9 1" //
				), 10L //
		);
	}// End of Test Case

	static void testCase2DiffArray() {
		testArrayManipulationWithDiffArray(//
				5, //
				createQueryInput(//
						"1 2 100", //
						"2 5 100", //
						"3 4 100" //
				), 200L //
		);
	}// End of Test Case

	static int[][] createQueryInput(String... strings) {
		int[][] queries = new int[strings.length][strings[0].split(" ").length];
		for (int h = 0; h < strings.length; h++) {
			String[] values = strings[h].split(" ");
			for (int w = 0; w < values.length; w++) {
				queries[h][w] = Integer.valueOf(values[w]).intValue();
			}
		}
		return queries;
	}// End of Method
	
	static void testArrayManipulationWithArraySum(int n, int[][] queries, long expected) {
		long result = arrayManipulationWithArraySum(n, queries);
		assert result == expected;
	}// End of Test

	static void testArrayManipulationWithDiffArray(int n, int[][] queries, long expected) {
		long result = arrayManipulationWithDiffArray(n, queries);
		assert result == expected;
	}// End of Test

}// End of Class
