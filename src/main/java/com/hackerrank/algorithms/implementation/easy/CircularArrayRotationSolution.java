package com.hackerrank.algorithms.implementation.easy;

public class CircularArrayRotationSolution {

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {

		int length = a.length;
		int rotation = k % length;
		int[] results = new int[queries.length];

		int index = 0;
		for (int query : queries) {
			int actualIndex =  ((length - rotation) + query) % length ; 
			results[index] = a[actualIndex];
			index++;
		}

		return results;

	}// End of Method

	public static void main(String[] args) {
		testCircularArrayRotation( //
				new int[] { 1, 2, 3 }, //
				2, //
				new int[] { 0, 1, 2 }, //
				new int[] { 2, 3, 1 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				5, //
				new int[] { 0, 1, 4 }, //
				new int[] { 5, 6, 9 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				1, //
				new int[] { 6 }, //
				new int[] { 5 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				1, //
				new int[] { 0, 1, 2, 3, 4 }, //
				new int[] { 5, 9, 7 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				2, //
				new int[] { 0, 1, 2, 3, 4 }, //
				new int[] { 9, 7, 6 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				3, //
				new int[] { 0, 1, 2, 3, 4 }, //
				new int[] { 8, 6, 5 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				4, //
				new int[] { 0, 1, 2, 3, 4 }, //
				new int[] { 8, 6, 5 }//
		);
		testCircularArrayRotation( //
				new int[] { 5, 6, 7, 8, 9 }, //
				5, //
				new int[] { 0, 1, 2, 3, 4 }, //
				new int[] { 8, 6, 5 }//
		);
	}// End of Main

	static void testCircularArrayRotation(int[] a, int k, int[] queries, int[] expected) {
		int[] result = circularArrayRotation(a, k, queries);
		for (int value : result) {
			System.out.println(value);
		}
		System.out.println("------------");
		if (expected.length != result.length) {
			assert false;

		} else {
			for (int i = 0; i < result.length; i++) {
				assert result[i] == expected[i];
			}
		}

	}// End of Method

}// End of Class
