package com.algorithms.hackerrank.implementation.medium;

public class ThreeDSurfaceAreaSolution {

	/**
	 * <p>
	 * Complete the surfaceArea function below.
	 * </p>
	 * <p>
	 * Idea is, trying to query rows to a border of one side, and columns to one
	 * side; multiply with 2 and wuala! However, it must be noticed that there can
	 * be hills in a row or a column. This means that there are additional areas to
	 * consider if such wavy locations exits.
	 * </p>
	 * 
	 * @param area
	 * @return
	 */

	static int surfaceArea(int[][] area, int height, int width) {

		int xyArea = 2 * height * width; // Floor area;

		int yzArea = 0; // Leaning side to y and z axis side; From Horizontal Area Calculation
		int yzWaves = 0; // Hills + Valleys; From Horizontal Area Calculation

		int xzArea = 0; // Leaning side to x and y axis side; From Vertical Area Calculation
		int xzWaves = 0; // Hills + Valleys; From Vertical Area Calculation

		for (int v = 0; v < height; v++) {

			int sum = 0;
			int h = 1;
			int lowestPoint = area[v][0];
			int highestPoint = area[v][0];
			// Was there a down turn?
			boolean isGoingUp = false;

			// Calculate areas between the valleys;
			while (h < width) {

				while (h < width && area[v][h - 1] < area[v][h]) {// going up
					isGoingUp = true;
					if (lowestPoint > area[v][h - 1]) {
						lowestPoint = area[v][h - 1];
					}
					h++;
				}

				while (h < width && area[v][h - 1] > area[v][h]) {// going down
					if (isGoingUp) { // turning Point
						isGoingUp = false;
						// calculate area of previous valley
						int reflectingElevation = 0;
						if (highestPoint < area[v][h - 1]) {
							reflectingElevation = highestPoint;
							highestPoint = area[v][h - 1];
						} else {
							reflectingElevation = area[v][h - 1];
						}
						sum += reflectingElevation - lowestPoint;
						lowestPoint = area[v][h - 1];
					}
					h++;
				}

				while (h < width && area[v][h - 1] == area[v][h]) {// going straight
					h++;
				}

			}

			// Wrap Up after loop
			if (isGoingUp) {
				if (isGoingUp) { // turning Point
					isGoingUp = false;
					// calculate area of previous valley
					int reflectingElevation = 0;
					if (highestPoint < area[v][h - 1]) {
						reflectingElevation = highestPoint;
						highestPoint = area[v][h - 1];
					} else {
						reflectingElevation = area[v][h - 1];
					}
					sum += reflectingElevation - lowestPoint;
					lowestPoint = area[v][h - 1];
				}
			}

			yzArea += highestPoint * 2;
			yzWaves += sum * 2;

		}

		for (int h = 0; h < width; h++) {

			int sum = 0;
			int v = 1;
			int lowestPoint = area[0][h];
			int highestPoint = area[0][h];
			// Was there a down turn?
			boolean isGoingUp = false;

			// Calculate areas between the valleys;
			while (v < height) {

				while (v < height && area[v - 1][h] < area[v][h]) {// going up
					isGoingUp = true;
					if (lowestPoint > area[v - 1][h]) {
						lowestPoint = area[v - 1][h];
					}
					v++;
				}

				while (v < height && area[v - 1][h] > area[v][h]) {// going down
					if (isGoingUp) { // turning Point
						isGoingUp = false;
						// calculate area of previous valley
						int reflectingElevation = 0;
						if (highestPoint < area[v - 1][h]) {
							reflectingElevation = highestPoint;
							highestPoint = area[v - 1][h];
						} else {
							reflectingElevation = area[v - 1][h];
						}
						sum += reflectingElevation - lowestPoint;
						lowestPoint = area[v - 1][h];
					}
					v++;
				}

				while (v < height && area[v - 1][h] == area[v][h]) {// going straight
					v++;
				}

			}

			// Wrap Up after loop
			if (isGoingUp) {
				if (isGoingUp) { // turning Point
					isGoingUp = false;
					// calculate area of previous valley
					int reflectingElevation = 0;
					if (highestPoint < area[v - 1][h]) {
						reflectingElevation = highestPoint;
						highestPoint = area[v - 1][h - 1];
					} else {
						reflectingElevation = area[v - 1][h];
					}
					sum += reflectingElevation - lowestPoint;
					lowestPoint = area[v - 1][h];
				}
			}

			xzArea += highestPoint * 2;
			xzWaves += sum * 2;

		}

		int result = xyArea + yzArea + yzWaves + xzArea + xzWaves;

		return result;

	}// End of Method

	public static void main(String[] args) {
		testSurfaceArea(new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } }, 3, 3, 60);
		testSurfaceArea(new int[][] { { 1 } }, 1, 1, 6);
	}// End of Main

	static void testSurfaceArea(int[][] area, int height, int width, int expected) {
		int result = surfaceArea(area, height, width);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
