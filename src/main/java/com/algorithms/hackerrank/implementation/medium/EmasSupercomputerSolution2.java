package com.algorithms.hackerrank.implementation.medium;

public class EmasSupercomputerSolution2 {

	/**
	 * Complete the twoPluses function below.
	 * <p>
	 * Note: The two pluses cannot overlap, and the product of their areas should be
	 * maximal.
	 * </p>
	 * <p>
	 * Seems like the issue is, how to understand "mixed" patterns. Such as:
	 * </p>
	 * <ol>
	 * B1BBBB
	 * </ol>
	 * <ol>
	 * 1112BB
	 * </ol>
	 * <ol>
	 * B1222B
	 * </ol>
	 * <ol>
	 * GGG2GG
	 * </ol>
	 * <p>
	 * Where "1" denotes a plus sign, and "2" is the secondary match to plus sign;
	 * bordering areas might mix up the pattern recognition.
	 * <p>
	 * <p>
	 * Aim is to find two longest plus signs, and also to remember that a single
	 * longer plus sign is less valuable then two smaller plus signs.
	 * </p>
	 * 
	 * @param grid: n x m matrix; 2 <= n, m <= 15
	 * @return integer denoting the maximum product of two largest valid pluses
	 */
	static int twoPluses(String[] grid) {

		int count = countCentralGs(grid);
		if (count == 0) {
			if (isGInside(grid)) {
				return 1;
			} else {
				return 0;
			}
		} else if (count == 1) {
			int[][] gs = new int[count][2];
			findCentralGs(gs, grid);
			for (int inc = 2;; inc++) {
				if (!isPlusPatternArea(grid, inc, gs[0][0], gs[0][1])) {
					return calculateArea(inc - 1);
				}
			}
		} // else if(count > 1);

		int[][] gs = new int[count][2];
		findCentralGs(gs, grid);
		int area = checkGrowth(grid, gs);

		return area;

	}// End of Method

	static boolean isGInside(String[] grid) {

		for (int c = 0; c < grid.length; c++) {
			for (int r = 0; r < grid[0].length(); r++) {
				char t = grid[c].charAt(r);
				if (t == 'G') {
					return true;
				}
			}
		}

		return false;

	}// End of Method

	static int checkGrowth(String[] grid, int[][] gs) {

		int widestArea = 0;
		for (int i = 0; i < gs.length - 1; i++) {
			int ac = gs[i][0];
			int ar = gs[i][1];
			int selectedArea = calculateArea(0);
			for (int aInc = 1; isPlusPatternArea(grid, aInc, ac, ar); aInc++) {
				int area = growArea(grid, gs, i, aInc, ac, ar);
				if (area > selectedArea) {
					selectedArea = area;
				}
			}
			if (selectedArea > widestArea) {
				widestArea = selectedArea;
			}
		}

		return widestArea;

	}// End of Method

	static int growArea(String[] grid, int[][] gs, int a, int aInc, int ac, int ar) {

		int aArea = calculateArea(aInc);
		int selected = aArea;
		for (int i = a + 1; i < gs.length; i++) {
			int bc = gs[i][0];
			int br = gs[i][1];
			for (int bInc = 1; isPlusPatternArea(grid, bInc, bc, br); bInc++) {
				int bArea = 1;
				if (canAreaGrow(grid, aInc, ac, ar, bInc, bc, br)) {
					bArea = calculateArea(bInc);
				}
				int total = aArea * bArea;
				if (total > selected) {
					selected = total;
				}
			}
		}

		return selected;
	}// End of Method

	static int calculateArea(int inc) {
		return (inc * 4) + 1;
	}

	static boolean canAreaGrow(String[] grid, int aInc, int ac, int ar, int bInc, int bc, int br) {

		int colDist = abs(ac - bc);
		int rowDist = abs(ar - br);
		int totalDistance = colDist + rowDist;

		int min = aInc < bInc ? aInc : bInc;

		if (colDist <= min || rowDist <= min) {
			int absMinDistance;
			if (ac == bc || ar == br) {
				absMinDistance = aInc + bInc + 1;
			} else {
				int max = aInc > bInc ? aInc : bInc;
				int mv = 0;
				if (colDist <= min) {
					mv = colDist;
				} else if (rowDist <= min) {
					mv = rowDist;
				}
				absMinDistance = max + mv + 1;
			}
			if (totalDistance < absMinDistance) {
				return false;
			}
		} else {
			int absMinDistance = 2 * (min + 1);
			if (totalDistance < absMinDistance) {
				return false;
			}
		}

		return true;

	}// End of Method

	static int abs(int value) {
		return value < 0 ? -1 * value : value;
	}

	static void findCentralGs(int[][] gs, String[] grid) {

		int columns = grid.length;
		int rows = grid[0].length();

		int cs = 0;
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				if (isPlusPatternArea(grid, 1, c, r)) {
					gs[cs][0] = c;
					gs[cs][1] = r;
					cs++;
				}
			}
		}

	}// End of Method

	static int countCentralGs(String[] grid) {

		int columns = grid.length;
		int rows = grid[0].length();

		if (columns < 3 || rows < 3) {
			return 0;
		}

		int count = 0;
		for (int c = 1; c < columns - 1; c++) {
			for (int r = 1; r < rows - 1; r++) {
				if (isPlusPatternArea(grid, 1, c, r)) {
					count++;
				}
			}
		}

		return count;

	}// End of Method

	static boolean isPlusPatternArea(String[] grid, int inc, int c, int r) {

		char t = grid[c].charAt(r);

		if (t != 'G') {
			return false;
		}

		// check up
		int up = c - inc;
		if (!(up >= 0 && 'G' == grid[up].charAt(r))) {
			return false;
		}

		// check down
		int down = c + inc;
		if (!(down <= grid.length - 1 && 'G' == grid[down].charAt(r))) {
			return false;
		}

		// check left
		int left = r - inc;
		if (!(left >= 0 && 'G' == grid[c].charAt(left))) {
			return false;
		}

		// check right
		int right = r + inc;
		if (!(right <= grid[0].length() - 1 && 'G' == grid[c].charAt(right))) {
			return false;
		}

		return true;

	}// End of Method

	public static void main(String[] args) {

		testTwoPluses(new String[] { //
				"BBGBBBGBB", //
				"BBGBBBGBB", //
				"GGGGGGGGG", //
				"BBGBBBGBB", //
				"BBGBGBGBB" //
		}, 45);

		testTwoPluses(new String[] { //
				"BBBBBBBBB", //
				"BBGBBBGBB", //
				"BGGGGGGGB", //
				"BBGBBBGBB", //
				"BBBBGBBBB" //
		}, 25);

		testTwoPluses(new String[] { //
				"BBBBBBBBB", //
				"BBGBBBBBB", //
				"BGGGGBBBB", //
				"BBGGGGBBB", //
				"BBBBGBBBB" //
		}, 25);

		testTwoPluses(new String[] { //
				"BBBBBBBBB", //
				"BBBGBBBBB", //
				"BBBGBBGBB", //
				"BGGGGGGBB", //
				"BBBGGGGGG", //
				"BBBGBBGBB", //
				"BBBBBBGBB", //
				"BBBBBBBBB" //
		}, 81);

		testTwoPluses(new String[] { //
				"BBBBBBBBB", //
				"BBBGBBBBB", //
				"BBBGBBBBB", //
				"BGGGGGBBB", //
				"BBBGGBBBB", //
				"BBBGGBBBB", //
				"BBGGGGGBB", //
			    "BBBBGBBBB", //
				"BBBBGBBBB", //
				"BBBBBBBBB", //
				"BBBBBBBBB", //
				"BBBBBBBBB" //
		}, 81);
		
		testTwoPluses(new String[] { //
				"GGGGGGGGGGGG", //
				"GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
			    "GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GGGGGGGGGGGG", //
				"GBGGBBBBBBBG" //
		}, 81);

		testTwoPluses(new String[] { //
				"GGGGGGGGGGGG", //
				"GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
				"GGGGGGGGGGGG", //
			    "GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GBGGBBBBBBBG", //
				"GGGGGGGGGGGG", //
				"GBGGBBBBBBBG" //
		}, 81);

		testTwoPluses(new String[] { //
				"BBBBBBBBBBBBBBB", //
				"BBBBBBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBGBBBBBB", //
				"BGGGGGGGGBBBBBB", //
				"BBBBGBBBGBBBBBB", //
			    "BBBBGBBBGBBBBBB", //
				"BBBBGBBBGBBBBBB", //
				"BBBGGGGGGGGGGGB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
			    "BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
		}, 273);
		
		testTwoPluses(new String[] { //
				"BBBBBBBBBBBBBBB", //
				"BBBBBBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBGBBBBBB", //
				"BGGGGGGGGBBBBBB", //
				"BBBBGBBBGBBBBBB", //
			    "BBBBGBBBGBBBBBB", //
				"BBBBGBBBGBBBBBB", //
				"BBBGGGGGGGGGGGB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
			    "BBBBBBGGGGGBBBB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
		}, 273);
		
		testTwoPluses(new String[] { //
				"BBBBBBBBBBBBBBB", //
				"BBBBBBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBBBBBBBB", //
				"BBBBGBBBGBBBBBB", //
				"BGGGGGGGGBBBBBB", //
				"BBGGGGGGGBBBBBB", //
			    "BBGGGGGGGBBBBBB", //
				"BBGGGGGGGBBBBBB", //
				"BBGGGGGGGGGGGGB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
			    "BBBBBBGGGGGBBBB", //
				"BBBBBBBBGBBBBBB", //
				"BBBBBBBBGBBBBBB", //
		}, 273);
		
		testTwoPluses(new String[] { //
				"BBBB", //
				"BBBB", }, //
				0);

		testTwoPluses(new String[] { //
				"GGGGGG", //
				"GBBBGB", }, //
				1);

		testTwoPluses(new String[] { //
				"BBB", //
				"GGG", //
				"BBB", }, //
				1);

		testTwoPluses(new String[] { //
				"BGB", //
				"GGG", //
				"BGB", }, //
				5);

		testTwoPluses(new String[] { //
				"BGGBBB", //
				"GGGGGB", //
				"BGGBBB", }, //
				5);

		testTwoPluses(new String[] { //
				"GGGGGG", //
				"GBBBGB", //
				"GGGGGG", //
				"GGBBGB", //
				"GGGGGG" //
		}, 5);

		testTwoPluses(new String[] { //
				"BGBBGB", //
				"GGGGGG", //
				"BGBBGB", //
				"GGGGGG", //
				"BGBBGB", //
				"BGBBGB" //
		}, 25);

		testTwoPluses(new String[] { //
				"BGBBBBGGG", //
				"GGGGBBGGG", //
				"BGGGGBGGG", //
		}, 25);

		testTwoPluses(new String[] { //
				"BGBBBB", //
				"GGGGBB", //
				"BGGGGB", //
				"GGGGGG", //
		}, 25);

		testTwoPluses(new String[] { //
				"GGGGGG", //
				"GGGGGG", //
				"GGGGGG", //
				"GGGGGG", //
				"GGGGGG", //
				"GGGGGG" //
		}, 45);

		testTwoPluses(new String[] { //
				"GGGGGGG", //
				"GGGGGGG", //
				"GGGGGGG", //
				"GGGGGGG", //
				"GGGGGGG", //
				"GGGGGGG", //
				"GGGGGGG" //
		}, 65);

		testTwoPluses(new String[] { //
				"BBBGBBB", //
				"BBBGBBB", //
				"BBBGBBB", //
				"GGGGGGG", //
				"BBBGBGB", //
				"BBBGGGG", //
				"BBBGBGB" //
		}, 65);

		testTwoPluses(new String[] { //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
				"BGGGGGGGBB", //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
		}, 13);

		testTwoPluses(new String[] { //
				"BBBBGBBGBB", //
				"BBBBGBGGGG", //
				"BBBBGBBGBB", //
				"BGGGGGGGBB", //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
				"BBBBGBBBBB", //
		}, 65);

		testTwoPluses(new String[] { //
				"BGBBGBBGBB", //
				"GGGBGBGGGG", //
				"BGBBGBBGBB", //
				"BGGGGGGGGG", //
				"BGBBGBBBGB", //
				"GGGBGBBGGG", //
				"BGBBGBBBGB", //
		}, 65);

		testTwoPluses(new String[] { //
				"BGBBGBBGBB", //
				"GGGBGBGGGG", //
				"BGBBGBBGBB", //
				"BGGGGGGGGG", //
				"BGBBGBBBGB", //
				"GGGBGBBGGG", //
				"BGBBGBBBGB", //
		}, 65);
		
		testTwoPluses(new String[] { //
				"BGBBGBBGBBBB", //
				"GGGBGBGGGGBB", //
				"BGBBGBBGBGBB", //
				"BGGGGGGGGGGG", //
				"BGBBGBBBGGBB", //
				"GGGBGBBGGGBB", //
				"BGBBGBBBGBBB", //
		}, 81);

	}// End of Main

	static void testTwoPluses(String[] grid, int expected) {
		int result = twoPluses(grid);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
