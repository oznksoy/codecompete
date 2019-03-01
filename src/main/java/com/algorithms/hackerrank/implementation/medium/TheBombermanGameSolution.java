package com.algorithms.hackerrank.implementation.medium;

public class TheBombermanGameSolution {

	/**
	 * Complete the bomberMan function below.
	 * <p>
	 * Idea is to count to a state where it creates a pattern that repeats in
	 * cycles. Seems like this condition occurs after 5th cycle. After 5th, every
	 * second cycle is a repetition of the inverse of 5th cycle, which is 3th is
	 * cycle.</
	 * <p>
	 * <li>Bomb : O</li>
	 * <li>Empty : .</li>
	 * 
	 * @param n    : 1 <= n <= 10^9 : an integer, the number of seconds to simulate
	 * @param grid : 1 <= row, column <= 200 : an array of strings that represents
	 *             the grid
	 * @return
	 */
	static String[] bomberMan(int n, String[] grid) {

		if (n == 1) {// Since n starts from 1, then
			return grid;
		} else if (n == 2) { // Since n can be 2 also, then
			return fullBombedGrid(grid[0].length(), grid.length);
		}

		return null;
	}// End of Method

	static String[] fullBombedGrid(int row, int column) {
		String bomb = "O";
		String[] bombedGrid = new String[column];
		for (int c = 0; c < column; c++) {
			String s = "";
			for (int r = 0; r < row; r++) {
				s = s.concat(bomb);
			}
			bombedGrid[c] = s;
		}
		return bombedGrid;
	}

	public static void main(String[] args) {

		testBomberMan(1, //
				new String[] { "...O", "...O", "...O", "...O" }, //
				new String[] { "...O", "...O", "...O", "...O" } //
		);
		testBomberMan(2, //
				new String[] { "...O", "...O", "...O", "...O" }, //
				new String[] { "OOOO", "OOOO", "OOOO", "OOOO" } //
		);

	}// End of Main

	static void testBomberMan(int n, String[] grid, String[] expected) {
		String[] result = bomberMan(n, grid);
		System.out.println("Result :");
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println("");
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i].equals(result[i]);
		}

	}// End of Tester

}// End of Class
