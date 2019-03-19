package com.hackerrank.algorithms.implementation.medium;

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
	 * @param area   : input matrix that shows elevations of 1x1 boxes
	 * @param height : y dimension
	 * @param width  : x dimension
	 * @return total area
	 */
	static int surfaceAreaV1(int[][] area, int height, int width) {

		int xyArea = 2 * height * width; // Floor area;

		int yzArea = 0; // Leaning side to y and z axis side; From Horizontal Area Calculation
		int yzWaves = 0; // Hills + Valleys; From Horizontal Area Calculation

		int xzArea = 0; // Leaning side to x and z axis side; From Vertical Area Calculation
		int xzWaves = 0; // Hills + Valleys; From Vertical Area Calculation

		for (int v = 0; v < height; v++) { // Calculate yz reflection

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

			yzArea += highestPoint * 2;
			yzWaves += sum * 2;

		}

		for (int h = 0; h < width; h++) {// Calculate xz reflection

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

			xzArea += highestPoint * 2;
			xzWaves += sum * 2;

		}

		int result = xyArea + yzArea + yzWaves + xzArea + xzWaves;

		return result;

	}// End of Method

	/**
	 * <p>
	 * Another version of the {@link #surfaceAreaV1(int[][], int, int) surfaceArea}
	 * method.
	 * </p>
	 * <p>
	 * Basic idea is to reflect the calculation indexes with X dimension as the
	 * base.
	 * </p>
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
	 * @param area   : input matrix that shows elevations of 1x1 boxes
	 * @param height : y dimension
	 * @param width  : x dimension
	 * @return total area
	 */
	static int surfaceAreaV2(int[][] area, int height, int width) {

		int xyArea = 2 * height * width; // Floor area;

		int xzArea = calculateReflectiveAreas(area, height, width, true); // Vertical Leaning x and z axis side

		int yzArea = calculateReflectiveAreas(area, height, width, false); // Horizontal Leaning y and z axis side

		return xyArea + yzArea + xzArea;

	}// End of Method

	static int calculateReflectiveAreas(int[][] area, int height, int width, boolean isXR) {

		int sides = 0; // Leaning side to x and y axis side; From Vertical Area Calculation
		int waves = 0; // Hills + Valleys; From Vertical Area Calculation

		int reflectA;
		int reflectB;

		if (isXR) {
			reflectA = width;
			reflectB = height;
		} else {
			reflectA = height;
			reflectB = width;
		}

		for (int a = 0; a < reflectA; a++) {// Calculate xz reflection

			int sum = 0;

			int lowestPoint = reflect(isXR, area, 0, a, 0);
			int highestPoint = reflect(isXR, area, 0, a, 0);

			// Was there a down turn?
			boolean isGoingUp = false;

			int b = 1;

			// Calculate areas between the valleys;
			while (b < reflectB) {

				while (b < reflectB && reflect(isXR, area, b, a, 1) < reflect(isXR, area, b, a, 0)) {// going up
					int previousElevation = reflect(isXR, area, b, a, 1);
					isGoingUp = true;
					if (lowestPoint > previousElevation) {
						lowestPoint = previousElevation;
					}
					b++;
				}

				while (b < reflectB && reflect(isXR, area, b, a, 1) > reflect(isXR, area, b, a, 0)) {// going down
					int previousElevation = reflect(isXR, area, b, a, 1);
					if (isGoingUp) { // turning Point
						isGoingUp = false;
						// calculate area of previous valley
						int reflectingElevation = 0;
						if (highestPoint < previousElevation) {
							reflectingElevation = highestPoint;
							highestPoint = previousElevation;
						} else {
							reflectingElevation = previousElevation;
						}
						sum += reflectingElevation - lowestPoint;
						lowestPoint = previousElevation;
					}
					b++;
				}

				while (b < reflectB && reflect(isXR, area, b, a, 1) == reflect(isXR, area, b, a, 0)) {// going straight
					b++;
				}

			}

			// Wrap Up after loop
			if (isGoingUp) { // Final index was about to reflect
				isGoingUp = false;
				int previousElevation = reflect(isXR, area, b, a, 1);
				// calculate area of previous valley
				int reflectingElevation = 0;
				if (highestPoint < previousElevation) {
					reflectingElevation = highestPoint;
					highestPoint = previousElevation;
				} else {
					reflectingElevation = previousElevation;
				}
				sum += reflectingElevation - lowestPoint;
				lowestPoint = previousElevation;
			}

			sides += highestPoint * 2;
			waves += sum * 2;

		}

		return sides + waves;

	}// End of Method

	static int reflect(boolean isXR, int[][] area, int b, int a, int d) {
		if (isXR) {
			return area[b - d][a];
		} else {
			return area[a][b - d];
		}
	}// End of Method

	public static void main(String[] args) {

		testSurfaceAreaV1(new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } }, 3, 3, 60);
		testSurfaceAreaV1(new int[][] { { 1 } }, 1, 1, 6);
		testSurfaceAreaV1(new int[][] { { 1, 4, 2, 3, 1, 10, 5, 3, 5 } }, 1, 9, 118);// 12 + 34*2 + 10*2 + 2*9
		testSurfaceAreaV1(new int[][] { { 0, 4, 2, 6 }, { 3, 1, 10, 1 }, { 5, 3, 5, 7 } }, 3, 4, 148);

		testSurfaceAreaV2(new int[][] { { 1, 3, 4 }, { 2, 2, 3 }, { 1, 2, 4 } }, 3, 3, 60);
		testSurfaceAreaV2(new int[][] { { 1 } }, 1, 1, 6);
		testSurfaceAreaV2(new int[][] { { 1, 4, 2, 3, 1, 10, 5, 3, 5 } }, 1, 9, 118);// 12 + 34*2 + 10*2 + 2*9
		testSurfaceAreaV2(new int[][] { { 0, 4, 2, 6 }, { 3, 1, 10, 1 }, { 5, 3, 5, 7 } }, 3, 4, 148);

	}// End of Main

	static void testSurfaceAreaV1(int[][] area, int height, int width, int expected) {
		int result = surfaceAreaV1(area, height, width);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

	static void testSurfaceAreaV2(int[][] area, int height, int width, int expected) {
		int result = surfaceAreaV2(area, height, width);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
