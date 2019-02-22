package com.algorithms.hackerrank.implementation;

public class QueensAttackIISolution {

	// Complete the queensAttack function below.
	// matrix : (row, column)
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		// Analyze obstacles

		// What is the total sum of available moves?
		int north = n - r_q;
		int south = r_q - 1;
		int east = n - c_q;
		int west = c_q - 1;
		int northeast = north < east ? north : east;
		int northwest = north < west ? north : west;
		int southeast = south < east ? south : east;
		int southwest = south < west ? south : west;

		// which one is the closest to queen and it blocks the queen's path?
		for (int i = 0; i < obstacles.length; i++) {
			int row = obstacles[i][0];
			int column = obstacles[i][1];
			int cDiff = column - c_q;
			int rDiff = row - r_q;
			if (row == r_q) {
				if (cDiff < 0 && west > -cDiff - 1) {
					west = -cDiff - 1;
				} else if (cDiff > 0 && east > cDiff - 1) {
					east = cDiff - 1;
				}
			}
			if (column == c_q) {
				if (rDiff < 0 && south > -rDiff - 1) {
					south = -rDiff - 1;
				} else if (rDiff > 0 && north > rDiff - 1) {
					north = rDiff - 1;
				}
			}
			if ((cDiff) == (rDiff)) {
				if (cDiff < 0 && southwest > -cDiff - 1) {
					southwest = -cDiff - 1;
				} else if (cDiff > 0 && northeast > cDiff - 1) {
					northeast = cDiff - 1;
				}
			}
			if (cDiff == -rDiff) {
				if (cDiff < 0 && northwest > -cDiff - 1) {
					northwest = -cDiff - 1;
				} else if (cDiff > 0 && southeast > cDiff - 1) {
					southeast = cDiff - 1;
				}
			}

		}

		int totalMoves = north + south + east + west + northeast + northwest + southeast + southwest;

		return totalMoves;

	}// End of Method

	public static void main(String[] args) {
		testQueensAttack(1, 0, 1, 1, new int[][] {}, 0);
		testQueensAttack(4, 0, 4, 4, new int[][] {}, 9);
		testQueensAttack(5, 3, 4, 3, new int[][] { { 5, 5 }, { 4, 2 }, { 2, 3 } }, 10);
		testQueensAttack(5, 3, 4, 3, new int[][] { { 5, 5 }, { 4, 2 }, { 2, 3 }, { 4, 4 } }, 8);
		testQueensAttack(5, 3, 4, 3, new int[][] { { 5, 5 }, { 4, 2 }, { 2, 3 }, { 4, 4 }, { 1, 5 } }, 8);
		testQueensAttack(5, 3, 4, 3, new int[][] { { 5, 5 }, { 4, 2 }, { 2, 3 }, { 4, 4 }, { 1, 5 }, { 3, 4 } }, 6);
		testQueensAttack(5, 8, 4, 3, new int[][] { //
				{ 4, 2 }, { 3, 3 }, { 4, 4 }, { 5, 3 }, //
				{ 5, 2 }, { 5, 4 }, { 3, 2 }, { 3, 4 }//
		}, 0);
		testQueensAttack(5, 8, 3, 3, new int[][] { //
				{ 5, 3 }, { 3, 1 }, { 1, 3 }, { 3, 5 }, //
				{ 1, 1 }, { 5, 1 }, { 5, 5 }, { 1, 5 }//
		}, 8);
		testQueensAttack(5, 8, 3, 3, new int[][] { //
				{ 5, 3 }, { 3, 1 }, { 1, 3 }, { 3, 5 }, //
				{ 2, 2 }, { 5, 1 }, { 5, 5 }, { 1, 5 }//
		}, 7);
		testQueensAttack(5, 8, 1, 1, new int[][] { //
				{ 5, 3 }, { 3, 1 }, { 1, 3 }, { 3, 5 }, //
				{ 2, 2 }, { 5, 1 }, { 5, 5 }, { 1, 5 }//
		}, 2);
		testQueensAttack(6, 8, 1, 1, new int[][] { //
				{ 5, 3 }, { 3, 1 }, { 1, 3 }, { 3, 5 }, //
				{ 2, 2 }, { 5, 1 }, { 5, 5 }, { 1, 5 }//
		}, 2);
	}// End of Main

	static void testQueensAttack(int n, int k, int r_q, int c_q, int[][] obstacles, int expected) {
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println(result);
		assert result == expected;
	}// End of Test

}// End of Class
