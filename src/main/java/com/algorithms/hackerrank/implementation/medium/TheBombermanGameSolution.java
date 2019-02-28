package com.algorithms.hackerrank.implementation.medium;

public class TheBombermanGameSolution {

	/**
	 * Complete the bomberMan function below.
	 * 
	 * @param n
	 * @param grid
	 * @return
	 */
	static String[] bomberMan(int n, String[] grid) {

		// Bomb : O
		return null;
	}// End of Method

	public static void main(String[] args) {

	}// End of Main

	static void testBomberMan(int n, String[] grid, String[] expected) {
		String[] result = bomberMan(n, grid);
		System.out.println("Result :");
		for (String s : result) {
			System.out.print(" " + s);
		}
		System.out.println("");
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i] == result[i];
		}

	}// End of Tester

}// End of Class
