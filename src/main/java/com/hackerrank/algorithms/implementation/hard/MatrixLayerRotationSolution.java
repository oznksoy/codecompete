package com.hackerrank.algorithms.implementation.hard;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * You are given a 2D matrix of n*m dimension and a positive integer r. You have
 * to rotate the matrix r times and print the resultant matrix. Rotation should
 * be in anti-clockwise direction. It is guaranteed that the minimum of m and n
 * will be even.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class MatrixLayerRotationSolution {

	/**
	 * <p>
	 * Complete the matrixRotation function below.
	 * </p>
	 * <p>
	 * Trick is to find the even side an shrink the layers from outside to inside
	 * one step at a time.
	 * </p>
	 * 
	 * @param matrix : matrix to rotate; 2<=m,n<=300, and 1 <= a(i,j) <= 10^8
	 * @param r      : steps to rotate; 1 <= r <= 10^9
	 */
	static void matrixRotation(List<List<Integer>> matrix, int r) {

		int height = matrix.size();
		int width = matrix.get(0).size();

		int min = min(height, width);

		int count = min / 2;

		for (int step = 0; step < count; step++) {

			int totalRoute = 2 * (height + width - 2) - 8 * step;
			int rotation = r % totalRoute;

			List<Integer> overwritten = new ArrayList<Integer>();

			int wInit = step;
			int hInit = step;

			for (int countBackwards = rotation; countBackwards > 0; countBackwards--) {
				int movement = totalRoute - countBackwards;
				int[] toMemorize = calculateLoc(hInit, wInit, step, movement, height, width);
				overwritten.add(matrix.get(toMemorize[1]).get(toMemorize[0]));
			}

			for (int forward = 0; forward < rotation; forward++) {

				int[] loc = calculateLoc(hInit, wInit, step, forward, height, width);
				int w = loc[0];
				int h = loc[1];
				int jump = rotation;
				int temp = matrix.get(h).get(w);
				while (jump < totalRoute) {

					int[] jLoc = calculateLoc(h, w, step, rotation, height, width);
					int val = temp;
					w = jLoc[0];
					h = jLoc[1];
					temp = matrix.get(h).get(w);
					matrix.get(h).set(w, val);
					
					jump += rotation;

				}
			}

			for (int forward = 0; forward < rotation; forward++) {
				int[] loc = calculateLoc(hInit, wInit, step, forward, height, width);
				matrix.get(loc[1]).set(loc[0], overwritten.get(forward));
			}

		}
		
		printMatrix(matrix);

	}// End of Method

	static void printMatrix(List<List<Integer>> matrix) {

		for (List<Integer> row : matrix) {
			for (int i = 0; i < row.size(); i++) {
				System.out.print(row.get(i));
				if (i != row.size() - 1) {
					System.out.print(" ");
				}
			}
			System.out.print(System.lineSeparator());
		}

	}// End of Method

	static int[] calculateLoc(int hIndex, int wIndex, int step, int rotation, int height, int width) {

		int w = wIndex;
		int h = hIndex;

		int top = step;
		int bottom = height - 1 - step;
		int left = step;
		int right = width - 1 - step;

		int movement = rotation;

		while (movement > 0) {
			int moves = 0;
			if (w == left && top <= h && bottom > h) {// goes down
				moves = bottom - h;
				if (moves <= movement) {
					h = bottom;
				} else { // moves > movement;
					h += movement;
				}
			} else if (w == right && top < h && bottom >= h) {// goes up
				moves = h - top;
				if (moves <= movement) {
					h = top;
				} else { // moves > movement;
					h -= movement;
				}
			} else if (h == top && left < w && right >= w) {// goes left
				moves = w - left;
				if (moves <= movement) {
					w = left;
				} else { // moves > movement;
					w -= movement;
				}
			} else if (h == bottom && left <= w && right > w) {// goes right
				moves = right - w;
				if (moves <= movement) {
					w = right;
				} else { // moves > movement;
					w += movement;
				}
			}
			movement -= moves;
		}

		int[] loc = new int[2]; // 0 -> w; 1 -> h;
		loc[0] = w;
		loc[1] = h;

		return loc;

	}// End of Method

	static int min(int a, int b) {
		return a < b ? a : b;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testCase1() {
		testMatrixRotation(//
				createInput(//
						"1 2 3 4", //
						"5 6 7 8", //
						"9 10 11 12", //
						"13 14 15 16"),
				2, //
				createExpected(//
						"3 4 8 12", //
						"2 11 10 16", //
						"1 7 6 15", //
						"5 9 13 14" //
				));

	}// End of Test Case

	static void testCase2() {
		testMatrixRotation(//
				createInput(//
						"1 2 3 4", //
						"7 8 9 10", //
						"13 14 15 16", //
						"19 20 21 22", //
						"25 26 27 28"//
				), 7, //
				createExpected(//
						"28 27 26 25", //
						"22 9 15 19", //
						"16 8 21 13", //
						"10 14 20 7", //
						"4 3 2 1"//
				));
	}// End of Test Case

	static void testCase3() {
		testMatrixRotation(//
				createInput(//
						"1 1", //
						"1 1"//
				), 3, //
				createExpected(//
						"1 1", //
						"1 1" //
				));
	}// End of Test Case

	static void testMatrixRotation(List<List<Integer>> matrix, int r, String expected) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		matrixRotation(matrix, r);
		System.out.flush();
		System.setOut(systemStream);
		String result = byteArrayOutputStream.toString();
		assert result.equals(expected);
	}// End of Test

	static List<List<Integer>> createInput(String... strings) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (String val : strings) {
			List<Integer> row = new ArrayList<Integer>();
			String[] vs = val.split(" ");
			for (String v : vs) {
				row.add(Integer.valueOf(v));
			}
			list.add(row);
		}
		return list;
	}// End of Method for Tests

	static String createExpected(String... strings) {
		String str = "";
		for (String val : strings) {
			str += val + System.lineSeparator();
		}
		return str;
	}// End of Method for Tests

}// End of Class
