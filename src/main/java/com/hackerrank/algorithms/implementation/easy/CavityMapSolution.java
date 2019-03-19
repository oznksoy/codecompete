package com.hackerrank.algorithms.implementation.easy;

/**
 * <p>
 * You are given a square map as a matrix of integer strings. Each cell of the
 * map has a value denoting its depth. We will call a cell of the map a cavity
 * if and only if this cell is not on the border of the map and each cell
 * adjacent to it has strictly smaller depth. Two cells are adjacent if they
 * have a common side, or edge.
 * </p>
 * <p>
 * Find all the cavities on the map and replace their depths with the uppercase
 * character X.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class CavityMapSolution {
	
	/**
	 * * Complete the cavityMap function below.
	 * 
	 * @param grid : 1 <= size <= 100
	 * @return an array of strings, each representing a line of the completed map in
	 *         which cavities should be replaced with the character X
	 */
	static String[] cavityMap(String[] grid) {

		String[] gridCopy = grid.clone();

		char xrep = 'X';
		int horizontalLength = grid[0].length();
		// vertical
		for (int v = 1; v < grid.length - 1; v++) {
			// horizontal
			for (int h = 1; h < horizontalLength - 1; h++) {
				char source = grid[v].charAt(h);
				char up = grid[v - 1].charAt(h);
				char down = grid[v + 1].charAt(h);
				char left = grid[v].charAt(h - 1);
				char right = grid[v].charAt(h + 1);
				if (source > up && source > down && source > left && source > right) {
					// Cavity Found
					char[] chr = gridCopy[v].toCharArray();
					chr[h] = xrep;
					gridCopy[v] = String.copyValueOf(chr);
					h++;
				}
			}
		}

		return gridCopy;
	}// End of Method

	public static void main(String[] args) {

		testCavityMap(//
				new String[] { "989", "191", "111" }, //
				new String[] { "989", "1X1", "111" } //
		);

		testCavityMap(//
				new String[] { "1112", "1912", "1892", "1234" }, //
				new String[] { "1112", "1X12", "18X2", "1234" } //
		);

	}// End of Main

	static void testCavityMap(String[] grid, String[] expected) {
		String[] result = cavityMap(grid);
		System.out.println("Result :");
		for (String str : result) {
			System.out.println(str);
		}
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i].equals(result[i]);
		}
	}// End of Method

}// End of Class
