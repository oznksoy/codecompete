package com.hackerrank.algorithms.implementation.medium;

// Magic Box is a patterned structure.
// for a 3x3 matrix to be filled with numbers from 1 to 9 with equal sums from
// rows, columns and diagonals; it must have fixed structure of number
// sequences.
// lets say that there are 3 rows of numbers totaling to the same value:
// a + b + c = y
// d + f + g = y
// h + i + j = y
// a + b + c + d+ f + g + h + i + j = 3y
// Sum of all numbers from 1 to 9 is 9 * (9 + 1) / 2 = 45;
// y = 15; thus a sum of a row, column or diagonal has to be 15.
// What are the conditions that fit to a + b + c = 15 ?
// 1 + 9 + 5;
// 2 + 8 + 5;
// 3 + 7 + 5;
// 4 + 6 + 5;
/// Notice that once we cross to increase the initial number to 5, the other
// numbers have to adjust to repeat the sum patterns above;
// like 5 + 7 + 3 <=> 3 + 7 + 5;
// But we can still adjust the values as
// 6 + 7 + 2;
// 6 + 1 + 8;
// 4 + 3 + 8;
// 4 + 9 + 2;
// Notice that middle values are odd numbers that does not repeat.
// Finally, we can say that the fix pattern is:
//
// 8 1 6 | 2 7 6 | 8 3 4 | 4 9 2
// 3 5 7 | 9 5 1 | 1 5 9 | 3 5 7
// 4 9 2 | 4 3 8 | 6 7 2 | 8 1 6
//
// 2 9 4 | 6 7 2 | 4 3 8 | 6 1 8
// 7 5 3 | 1 5 9 | 9 5 1 | 7 5 3
// 6 1 8 | 8 3 4 | 2 7 6 | 2 9 4
//
// These 8 possible combinations are rotation and reflections of each other.
// Simple rules are:
// - center value is always 5.
// - odd values are always at the middle/center.
// - 1 is always across 9; 3 is always across 7
// - 1 and 3 always neighbors 8,
// - 7 and 1 always neighbors 6,
// - 7 and 9 always neighbors 2,
// - 9 and 3 always neighbors 4.
// - 8, 6, 2 and 4 is always at the corner.
public class FormingAMagicSquareSolution {

	/**
	 * the magic constant for a 1 to 9 3x3 dimentional matrix is 15 Question is to
	 * locate the correct location to alter the value of. Also, it should be the
	 * lowest cost possible Where cost is |number - requiredValue|
	 * 
	 * @param s
	 * @return
	 */
	static int formingMagicSquare(int[][] s) {

		int[][][] magicBoxes = generateMagicSquare();

		int lowestCost = 45; // initially set to the highest cost
		for (int z = 0; z < 8; z++) {
			int cost = 0;
			for (int y = 0; y < 3; y++) {
				for (int x = 0; x < 3; x++) {
					cost += Math.abs(magicBoxes[z][y][x] - s[x][y]);
				}
			}
			if (lowestCost > cost) {
				lowestCost = cost;
			}
		}

		return lowestCost;

	}// End of Method

	static int[][][] generateMagicSquare() {

		int[][][] mbxs = new int[][][] { // z, y ,x
				{ { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }, //
				{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }, //
				{ { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } }, //
				{ { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }, //
				{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } }, //
				{ { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } }, //
				{ { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } }, //
				{ { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } } //
		};
		return mbxs;

	}// End of Method

	public static void main(String[] args) {

		testFormingMagicSquare(new int[][] { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 5 } }, 1);
		testFormingMagicSquare(new int[][] { { 4, 8, 2 }, { 4, 5, 7 }, { 6, 1, 6 } }, 4);

	}// End of Main

	static void testFormingMagicSquare(int[][] s, int expected) {
		int result = formingMagicSquare(s);
		System.out.println(result);
		assert result == expected;
	}// End of Test

}// End of Class
