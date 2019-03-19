package com.hackerrank.algorithms.implementation.medium;

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
		} // 3,4,5 cycles;

		// Every odd cycle is repetition of the third cycle or the fifth cycle
		// Every even cycle is a full bombed grid

		int mod = (n - 2) % 2;
		if (mod == 1) {
			int rep = ((n - 1) / 2) % 2;
			if (rep == 1) { // repetition of the third cycle
				return fillThirdCycle(grid);
			} else { // repetition of the fifth cycle
				return fillFifthCycle(grid);
			}
		} else { // (mod == 0)
			return fullBombedGrid(grid[0].length(), grid.length);
		}

	}// End of Method

	/**
	 * Reverse the third cycle state
	 * 
	 * @param grid : playground
	 * @return fifth state
	 */
	static String[] fillFifthCycle(String[] grid) {
		String[] fifthCycle = new String[grid.length];
		String[] thridCycle = fillThirdCycle(grid);

		int rows = thridCycle[0].length();
		int columns = thridCycle.length;
		for (int c = 0; c < columns; c++) {
			String level = "";
			for (int r = 0; r < rows; r++) {
				if (isThisAnImpactZone(r, c, thridCycle, rows, columns)) {
					level = level.concat(".");
				} else {
					level = level.concat("O");
				}
			}
			fifthCycle[c] = level;
		}

		return fifthCycle;
	}// End of Method

	/**
	 * Fill third second's state as third cycle and fill the grid
	 * 
	 * @param grid
	 * @return third second's state
	 */
	static String[] fillThirdCycle(String[] grid) {
		String[] thridCycle = new String[grid.length];
		int rows = grid[0].length();
		int columns = grid.length;
		for (int c = 0; c < columns; c++) {
			String level = "";
			for (int r = 0; r < rows; r++) {
				if (isThisAnImpactZone(r, c, grid, rows, columns)) {
					level = level.concat(".");
				} else {
					level = level.concat("O");
				}
			}
			thridCycle[c] = level;
		}
		return thridCycle;
	}// End of Method

	/**
	 * Turns true if there is bomb nearby
	 * 
	 * @param r       : row index
	 * @param c       : column index
	 * @param grid    : playground
	 * @param rows    : total number of rows
	 * @param columns : total number of columns
	 * @return
	 */
	static boolean isThisAnImpactZone(int r, int c, String[] grid, int rows, int columns) {

		// check self

		if ('O' == grid[c].charAt(r)) {
			return true;
		}

		// check up
		char up;
		if (c > 0) {
			up = grid[c - 1].charAt(r);
		} else {
			up = '.';
		}

		if (up == 'O') {
			return true;
		}

		// check down
		char down;
		if (c < columns - 1) {
			down = grid[c + 1].charAt(r);
		} else {
			down = '.';
		}

		if (down == 'O') {
			return true;
		}

		// check left
		char left;
		if (r > 0) {
			left = grid[c].charAt(r - 1);
		} else {
			left = '.';
		}

		if (left == 'O') {
			return true;
		}

		// check left
		char right;
		if (r < rows - 1) {
			right = grid[c].charAt(r + 1);
		} else {
			right = '.';
		}

		if (right == 'O') {
			return true;
		}

		return false;

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
	}// End of Method

	public static void main(String[] args) {

		testBomberMan(1, //
				new String[] { "...O", "...O", "...O", "...O" }, //
				new String[] { "...O", "...O", "...O", "...O" } //
		);
		testBomberMan(2, //
				new String[] { "...O", "...O", "...O", "...O" }, //
				new String[] { "OOOO", "OOOO", "OOOO", "OOOO" } //
		);

		testBomberMan(3, //
				new String[] { ".......", "...O...", "....O..", ".......", "OO.....", "OO....." }, //
				new String[] { "OOO.OOO", "OO...OO", "OOO...O", "..OO.OO", "...OOOO", "...OOOO" } //
		);
		testBomberMan(5, //
				new String[] { ".......", "...O.O.", "....O..", "..O....", "OO...OO", "OO.O..." }, //
				new String[] { ".......", "...O.O.", "...OO..", "..OOOO.", "OOOOOOO", "OOOOOOO" } //
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
