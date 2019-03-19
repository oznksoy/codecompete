package com.hackerrank.algorithms.implementation.easy;

public class ServiceLaneSolution {

	// Complete the serviceLane function below.
	static int[] serviceLane(int[] width, int[][] cases) {

		int caseIndex = cases.length - 1;
		int[] results = new int[cases.length];

		while (caseIndex >= 0) {

			int entryP = cases[caseIndex][0];
			int exitP = cases[caseIndex][1];

			int lowestValue = width[entryP];
			
			for (int i = entryP + 1; i <= exitP; i++) {
				if (lowestValue > width[i]) {
					lowestValue = width[i];
				}
			}
			
			results[caseIndex] = lowestValue;
			
			caseIndex--;

		}

		return results;
	}// End of Method

	public static void main(String[] args) {

		testServiceLane(//
				new int[] { 2, 3, 1, 2, 3, 2, 3, 3 }, //
				new int[][] { { 0, 3 }, { 4, 6 }, { 6, 7 }, { 3, 5 }, { 0, 7 } }, //
				new int[] { 1, 2, 3, 2, 1 });

		testServiceLane(//
				new int[] { 1, 2, 2, 2, 1 }, //
				new int[][] { { 2, 3 }, { 1, 4 }, { 2, 4 }, { 2, 4 }, { 2, 3 } }, //
				new int[] { 2, 1, 1, 1, 2 });

	}// End of Main

	static void testServiceLane(int[] width, int[][] cases, int[] expected) {
		int[] result = serviceLane(width, cases);
		System.out.println("Result : ");
		for (int value : result) {
			System.out.println(value);
		}
		assert result.length == expected.length;
		for (int i = 0; i < result.length; i++) {
			assert result[i] == expected[i];
		}

	}// End of Test

}// End of Class
