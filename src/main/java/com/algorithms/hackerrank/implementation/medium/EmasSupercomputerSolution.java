package com.algorithms.hackerrank.implementation.medium;

public class EmasSupercomputerSolution {

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

		int maxColumn = grid.length - 1;
		int maxRow = grid[0].length() - 1;

		int highestValue = 0;

		for (int c = 1; c < maxColumn; c++) {
			for (int r = 1; r < maxRow; r++) {
				char t = grid[c].charAt(r);
				if (t == 'G') {
					int area = findPlusPatternAreas(c, r, grid, maxColumn, maxRow);
					if (area > highestValue) {
						highestValue = area;
					}
				}

			}
		}

		return highestValue;

	}// End of Method

	static int findPlusPatternAreas(int c, int r, String[] grid, int maxColumn, int maxRow) {

		for (int inc = 1;; inc++) {
			if (isPlusPatternArea(c, r, grid, inc, 0, maxColumn, 0, maxRow)) {
				int area = ((inc * 4) + 1);
				int secondPlusArea = calculateSecondaryPlusPatternArea(c, r, grid, inc);
				return secondPlusArea * area;
			} else {
				return (inc - 1) * 4 + 1;
			}
		}

	}// End of Method

	static boolean isPlusPatternArea(int c, int r, String[] grid, int inc, int lc, int hc, int lr, int hr) {

		char t = grid[c].charAt(r);

		if (t != 'G') {
			return false;
		}

		// check up
		int up = c - inc;
		if (!(up >= lc && 'G' == grid[up].charAt(r))) {
			return false;
		}

		// check down
		int down = c + inc;
		if (!(down <= hc && 'G' == grid[down].charAt(r))) {
			return false;
		}

		// check left
		int left = r - inc;
		if (!(left >= lr && 'G' == grid[c].charAt(left))) {
			return false;
		}

		// check right
		int right = r + inc;
		if (!(right <= hr && 'G' == grid[c].charAt(right))) {
			return false;
		}

		return true;

	}// End of Method

	static int calculateSecondaryPlusPatternArea(int c, int r, String[] grid, int inc) {

		// there are four possible sides to calculate

		int maxColumn = grid.length - 1;
		int maxRow = grid[0].length() - 1;

		int additionalArea = 1;

		if (3 < c && 3 < r) { // up and left
			for (int nc = 1; nc < c - 1; nc++) {
				for (int nr = 1; nr < r - 1; nr++) {
					int value = calculateDependentPlusPatternArea(c, r, inc, nc, nr, grid);
					if (additionalArea < value) {
						additionalArea = value;
					}
				}
			}
		} else if (3 < (maxColumn - c) && 3 < r) { // down and left
			for (int nc = 1; nc > c + 1; nc++) {
				for (int nr = 1; nr < r - 1; nr++) {
					int value = calculateDependentPlusPatternArea(c, r, inc, nc, nr, grid);
					if (additionalArea < value) {
						additionalArea = value;
					}
				}
			}
		} else if (3 < c && 3 < (maxRow - r)) {// up and right
			for (int nc = 1; nc < c - 1; nc++) {
				for (int nr = 1; nr > r + 1; nr++) {
					int value = calculateDependentPlusPatternArea(c, r, inc, nc, nr, grid);
					if (additionalArea < value) {
						additionalArea = value;
					}
				}
			}
		} else if (3 < (maxColumn - c) && 3 < (maxRow - r)) {// down and right
			for (int nc = 1; nc > c + 1; nc++) {
				for (int nr = 1; nr > r + 1; nr++) {
					int value = calculateDependentPlusPatternArea(c, r, inc, nc, nr, grid);
					if (additionalArea < value) {
						additionalArea = value;
					}
				}
			}
		}

		return additionalArea;

	}// End of Method

	static int calculateDependentPlusPatternArea(int bc, int br, int bl, int c, int r, String[] grid) {

		// Get target character
		char t = grid[c].charAt(r);
		if (t != 'G') {
			return 0;
		}

		int maxColumn = grid.length - 1;
		int maxRow = grid[0].length() - 1;

		int lowRow = 0;
		int highRow = 0;
		int lowColumn = 0;
		int highColumn = 0;

		if (bc > c && br > r) { // Up and left side of reference
			if (r < (br - bl)) {
				highColumn = maxColumn;
			} else {// there is a column clash
				highColumn = bc - 1;
			}
			if (c < (bc - bl)) {
				highRow = maxRow;
			} else {
				highRow = br - 1;
			}
			lowColumn = 0;
			lowRow = 0;
		} else if (bc < c && br > r) {// Down and left side of reference
			if (r < (br - bl)) {
				lowColumn = 0;
			} else {// there is a column clash
				lowColumn = bc + 1;
			}
			if (c > (bc + bl)) {
				highRow = maxRow;
			} else {
				highRow = br - 1;
			}
			highColumn = maxColumn;
			lowRow = 0;
		} else if (bc > c && br < r) { // Up and right side of reference
			if (r > (br + bl)) {
				highColumn = maxColumn;
			} else { // there is a column clash
				highColumn = bc - 1;
			}
			if (c < (bc - bl)) {
				lowRow = 0;
			} else {
				lowRow = br + 1;
			}
			lowColumn = 0;
			highRow = maxRow;
		} else if (bc < c && br < r) { // Down and right side of reference
			if (r > (br + bl)) {
				lowColumn = 0;
			} else {
				lowColumn = bc + 1;
			}
			if (c > (bc + bl)) {
				lowRow = 0;
			} else {
				lowRow = br + 1;
			}
			highColumn = maxColumn;
			highRow = maxRow;
		}

		int area = 1;

		for (int inc = 1;; inc++) {

			if (isPlusPatternArea(c, r, grid, inc, lowColumn, highColumn, lowRow, highRow)) {
				area += 4;// If all directions are valid, add area
			} else {
				break;
			}

		}

		return area;

	}

//	// check up
//	int up = c - inc;
//	if (!(up >= lowColumn && 'G' == grid[up].charAt(r))) {
//		break;
//	}
//
//	// check down
//	int down = c + inc;
//	if (!(down <= highColumn && 'G' == grid[down].charAt(r))) {
//		break;
//	}
//
//	// check left
//	int left = r - inc;
//	if (!(left >= lowRow && 'G' == grid[c].charAt(left))) {
//		break;
//	}
//
//	// check right
//	int right = r + inc;
//	if (!(right <= highRow && 'G' == grid[c].charAt(right))) {
//		break;
//	}

	public static void main(String[] args) {

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
		}, 0);

	}// End of Main

	static void testTwoPluses(String[] grid, int expected) {
		int result = twoPluses(grid);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
