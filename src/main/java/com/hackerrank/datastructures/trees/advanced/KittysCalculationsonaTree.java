package com.hackerrank.datastructures.trees.advanced;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

public class KittysCalculationsonaTree {

	private static int[] calculateSolution(int[][] treeMatrix, List<Queue<Integer>> queries) {
		testInputStream(treeMatrix);
		testInputStream(queries);
		return null;
	}

	private static void testInputStream(int[][] treeMatrix) {
		for (int r = 0; r < treeMatrix.length; r++) {
			for (int c = 0; c < treeMatrix[0].length; c++) {
				System.out.print(treeMatrix[r][c]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}// End of Method

	private static void testInputStream(List<Queue<Integer>> queries) {
		for (Queue<Integer> query : queries) {
			Object[] arr = query.toArray();
			for (Object obj : arr) {
				Integer val = Integer.class.cast(obj);
				System.out.print(val);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}// End of Method

	private static void runCalculationSolution() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String[] fL = scanner.nextLine().split(" ");
		int n = convertToInt(fL[0]);
		int q = convertToInt(fL[1]);

		int[][] treeMatrix = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			String[] line = scanner.nextLine().split(" ");
			treeMatrix[i][0] = convertToInt(line[0]);
			treeMatrix[i][1] = convertToInt(line[1]);
		}

		List<Queue<Integer>> queries = new LinkedList<Queue<Integer>>();
		for (int i = 0; i < q; i++) {
			int k = convertToInt(scanner.nextLine());
			String[] line = scanner.nextLine().split(" ");
			Queue<Integer> queue = new PriorityQueue<Integer>();
			for (int j = 0; j < k; j++) {
				queue.add(convertToInt(line[j]));
			}
			queries.add(queue);
		}

		int[] results = calculateSolution(treeMatrix, queries);

		if (results != null) {
			for (int i = 0; i < results.length; i++) {
				System.out.println(results[i]);
			}
		} else {
			System.out.println("Results was null!");
		}

	}

	private static int convertToInt(String input) {
		return Integer.valueOf(input).intValue();
	}// End of Background Method

	static private class TestBehaviour implements ITestBehaviour {

		Object[] input;

		public TestBehaviour(Object... input) {
			this.input = input;
		}

		@Override
		public void run() {
			String data = this.input[0].toString();
			InputStream testInput = null;
			try {
				testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			InputStream old = System.in;
			try {
				System.setIn(testInput);
				runCalculationSolution();
			} finally {
				System.setIn(old);
			}
		}

	}// End of Private Class

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	private static void testCase1() {
		String ls = System.lineSeparator();
		String data = "7 3" + ls //
				+ "1 2" + ls //
				+ "1 3" + ls //
				+ "1 4" + ls //
				+ "3 5" + ls //
				+ "3 6" + ls //
				+ "3 7" + ls //
				+ "2" + ls //
				+ "2 4" + ls //
				+ "1" + ls //
				+ "5" + ls //
				+ "3" + ls //
				+ "2 4 5"; //
		String output = HackkerrankTestStream.manipulateSystemInput(new TestBehaviour(data));
		System.out.println(output);
	}

}// End of Class
