package com.algorithms.advanced;

import java.util.Random;

public class RangeMinimumQuerySolution {

	public static void main(String[] args) {
		RangeMinimumQuerySolution solution = new RangeMinimumQuerySolution();
		solution.test();
	}// End of Class

	public void test() {
		completeTestRun(2, 100);
	}// End of Method

	private void completeTestRun(int nMin, int nMax) {
		for (int n = nMin; n <= nMax; n++) {
			int[] array = generateTestCase(n);
			SqrtDecomposition decomposition = new SqrtDecomposition(array);
			testSqrtDecomposition(n, decomposition);
		}
	}// End of Method

	private void testSqrtDecomposition(int n, SqrtDecomposition decomposition) {
		for (int a = 0; a < n - 1; a++) {
			for (int b = a + 1; b < n; b++) {
				int expected = 0;
				int actual = 0;
				try {
					expected = decomposition.runNaiveQuery(a, b);
					actual = decomposition.queryRMQ(a, b);
					if (expected != actual) {
						System.err.println("Fail!");
						System.err.println("Expected : " + expected);
						System.err.println("Actual : " + actual);
						System.err.println("a : " + a + " b : " + b + " len : " + decomposition.array.length);
					}
				} catch (Exception e) {
					System.err.println("Exception!");
					System.err.println("Expected : " + expected);
					System.err.println("a : " + a + " b : " + b + " len : " + decomposition.array.length);
				}
			}
		}
	}// End of Method

	private void runSimpleTest(int a, int b, SqrtDecomposition decomposition) {
		int expected = 0;
		int actual = 0;
		try {
			expected = decomposition.runNaiveQuery(a, b);
			actual = decomposition.queryRMQ(a, b);
			if (expected != actual) {
				System.err.println("Fail!");
				System.err.println("Expected : " + expected);
				System.err.println("Actual : " + actual);
			}
		} catch (Exception e) {

			System.err.println("Exception!");
			System.err.println("Expected : " + expected);
			System.err.println("a : " + a + " b : " + b);

			e.printStackTrace();
		}
	}

	private int[] generateTestCase(int n) {

		Random random = new Random();

		int i = 0;
		int[] randomValuesArray = new int[n];

		while (i < n) {
			randomValuesArray[i] = random.nextInt(101);
			i++;
		}

		return randomValuesArray;

	}// End of Test Method

	private class SqrtDecomposition {

		private int[] array;
		private int blockSize;
		private int[] block;

		public SqrtDecomposition(int[] array) {
			this.array = array;
			this.blockSize = (int) Math.ceil(Math.sqrt(array.length));
			this.block = new int[blockSize];
			consume();
		}// End of Constructor

		private void consume() {

			for (int i = 0; i < array.length; i++) {
				int blockIndex = i / blockSize;
				if (i == blockIndex * blockSize) {
					block[blockIndex] = array[i];
				} else if (block[blockIndex] > array[i]) {
					block[blockIndex] = array[i];
				}
			}

		}// End of Method

		public int queryRMQ(int a, int b) {

			if (a > b) {
				int t = a;
				a = b;
				b = t;
			}
			if (a == b) {
				return array[a];
			}
			if (b - a + 1 <= blockSize) {
				return runNaiveQuery(a, b);
			}

			int idx = a;
			int min = array[a];

			while (idx % blockSize != 0) {
				if (min > array[idx]) {
					min = array[idx];
				}
				idx++;
			}

			while (idx + blockSize <= b) {
				if (min > block[idx / blockSize]) {
					min = block[idx / blockSize];
				}
				idx += blockSize;
			}

			while (idx <= b) {
				if (min > array[idx]) {
					min = array[idx];
				}
				idx++;
			}

			return min;

		}

		public int runNaiveQuery(int a, int b) {

			int min = array[a];
			for (int i = a + 1; i <= b; i++) {
				if (min > array[i]) {
					min = array[i];
				}
			}
			return min;

		}// End of Method

	}// End of Method

}// End of Class
