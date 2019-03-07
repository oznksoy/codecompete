package com.datastructures.hackerrank.arrays.easy;

public class TwoDArrayDSSolution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {

		// check the hourglass pattern
		int highestSum = -9 * 7;
		for (int h = 0; h < 4; h++) {
			for (int w = 0; w < 4; w++) {
				int top = 0;
				for (int t = w; t < w + 3; t++) {
					top += arr[h][t];
				}
				int middle = arr[h + 1][w + 1];
				int bottom = 0;
				for (int b = w; b < w + 3; b++) {
					bottom += arr[h + 2][b];
				}
				int sum = top + middle + bottom;
				if (highestSum < sum) {
					highestSum = sum;
				}
			}
		}

		return highestSum;

	}// End of Method

	public static void main(String[] args) {
		testHourglassSum(new int[][] { //
				{ -9, -9, -9, 1, 1, 1 }, //
				{ 0, -9, 0, 4, 3, 2 }, //
				{ -9, -9, -9, 1, 2, 3 }, //
				{ 0, 0, 8, 6, 6, 0 }, //
				{ 0, 0, 0, -2, 0, 0 }, //
				{ 0, 0, 1, 2, 4, 0 } //
		}, 28);

		testHourglassSum(new int[][] { //
				{ 1, 1, 1, 0, 0, 0 }, //
				{ 0, 1, 0, 0, 0, 0 }, //
				{ 1, 1, 1, 0, 0, 0 }, //
				{ 0, 0, 2, 4, 4, 0 }, //
				{ 0, 0, 0, 2, 0, 0 }, //
				{ 0, 0, 1, 2, 4, 0 } //
		}, 19);
	}// End of Main

	static void testHourglassSum(int[][] arr, int expected) {
		int result = hourglassSum(arr);
		assert result == expected;
	}// End of Test

}// End of Class
