package com.algorithms.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RangeMinimumQuerySolution {

	public static void main(String[] args) {
		RangeMinimumQuerySolution solution = new RangeMinimumQuerySolution();
		solution.testSqrtDecompositor();
		solution.testSparseTable();
	}// End of Class

	public void testSparseTable() {
		completeTestRunSparseTable(2, 100);
	}// End of Method

	private void completeTestRunSparseTable(int nMin, int nMax) {
		for (int n = nMin; n <= nMax; n++) {
			int[] array = generateTestCase(n);
			SparseTable sparseTable = new SparseTable(array);
			testSparseTable(n, sparseTable);
		}
	}// End of Method

	private void testSparseTable(int n, SparseTable sparseTable) {
		for (int a = 0; a < n - 1; a++) {
			for (int b = a + 1; b < n; b++) {
				int expected = 0;
				int actual = 0;
				try {
					expected = sparseTable.runNaiveQuery(a, b);
					actual = sparseTable.queryRMQ(a, b);
					if (expected != actual) {
						System.err.println("Fail!");
						System.err.println("Expected : " + expected);
						System.err.println("Actual : " + actual);
						System.err.println("a : " + a + " b : " + b);
					}
				} catch (Exception e) {
					System.err.println("Exception!");
					System.err.println("Expected : " + expected);
					System.err.println("a : " + a + " b : " + b);
				}
			}
		}
	}// End of Method

	public void testSqrtDecompositor() {
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

	}// End of Inner Class

	private class SparseTable {

		private List<Integer> table[];

		public SparseTable(int[] array) {
			consume(array);
		}// End of Constructor

		private void consume(int[] array) {

			int n = array.length;
			int logn = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));

			table = new ArrayList[logn + 1];

			table[0] = new ArrayList<Integer>();
			for (int i = 0; i < array.length; i++) {
				table[0].add(array[i]);
			}

			for (int p = 1; p <= logn; p++) {
				table[p] = new ArrayList<Integer>();
				for (int i = 0; (i + (1 << p) - 1) < n; i++) {
					int v1 = table[p - 1].get(i);
					int v2 = table[p - 1].get(i + (1 << (p - 1)));
					if (v1 < v2) {
						table[p].add(v1);
					} else {
						table[p].add(v2);
					}
				}
			}

		}// End of Method

		public int queryRMQ(int a, int b) {

			if (a == b) {
				return table[0].get(a);
			} else if (a > b) {
				int t = a;
				a = b;
				b = t;
			}

			int min = table[0].get(a);
			int numOfEls = b - a + 1;

			int logn = Integer.numberOfTrailingZeros(Integer.highestOneBit(numOfEls));
			int diff = numOfEls - (1 << logn);

			if (diff != 0) {
				int v1 = table[logn].get(a);
				int v2 = table[logn].get(a + diff);
				if (v1 < v2) {
					min = v1;
				} else {
					min = v2;
				}
			} else {
				min = table[logn].get(a);
			}

			return min;

		}// End of Method

		public int runNaiveQuery(int a, int b) {
			List<Integer> arraylist = table[0];
			int min = arraylist.get(a);
			for (int i = a + 1; i <= b; i++) {
				if (min > arraylist.get(i)) {
					min = arraylist.get(i);
				}
			}
			return min;
		}// End of Method

	}// End of Inner Class

}// End of Class
