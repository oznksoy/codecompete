package com.hackerrank.datastructures.trees.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;
import com.hackerrank.test.support.TestByFileRequest;
import com.hackerrank.test.support.TestByStringRequest;

/**
 * <p>
 * The solution would require two approaches This is an "unrooted" tree, meaning
 * that any node that is selected first can be defined as a root. There are two
 * approaches to follow if above statement is true. First option is to find the
 * optimal root. Where the selected root would resemble a balanced tree. But,
 * this will hardly effect the performance to find optimal distance. Second, we
 * can select the root as the first query element. This would naturally create a
 * tree with root being the first element.
 * </p>
 * <p>
 * To find distance, we can run a shortest path discovery and traverse the tree,
 * and also record all paths found during the initial query pair match. That is;
 * if Q:{a,b,c,d,e,..} is the query array, then (a,b), (a,c), (a,d) paths might
 * signal the lowest common ancestor between (b,c) and (b,d) and so on.
 * </p>
 * 
 */
public class KittysCalculationsonaTree {

	private static final long MOD = (long) Math.pow(10, 9) + 7;

	private static void calculate(List<Integer> adjList[], List<Integer> queries[]) {

		// precomputation
		ArrayList<Integer> eulerTour = new ArrayList<Integer>((2 * adjList.length) - 1);
		int[][] eulerMap = new int[adjList.length][3];
		int[] eulerIndexes = new int[adjList.length];
		walkEulerTour(adjList, eulerTour, eulerMap, eulerIndexes);
		SparseTable sparseTable = new SparseTable(eulerTour);

		for (int i = 0; i < queries.length; i++) {
			List<Integer> query = queries[i];
			if (query.size() < 2) {
				System.out.println("0");
			} else {
				System.out.println(calculateViaSparseTable(query, sparseTable, eulerMap, eulerIndexes));
			}
		}

	}// End of Method

	private static int calculateViaSparseTable(List<Integer> query, SparseTable sparseTable, int[][] eulerMap,
			int[] eulerIndexes) {

		long result = 0;
		for (int i = 0; i < query.size() - 1; i++) {
			for (int j = i + 1; j < query.size(); j++) {
				Integer u = query.get(i);
				Integer v = query.get(j);
				int lcaOnEulerTour = sparseTable.query(eulerMap[u - 1][2], eulerMap[v - 1][2]);
				int lca = eulerIndexes[lcaOnEulerTour];
				int dist = (eulerMap[u - 1][1] - eulerMap[lca - 1][1]) + (eulerMap[v - 1][1] - eulerMap[lca - 1][1]);
				long val = calculateDistanceSolution(u, v, dist);
				result = (result + val) % MOD;
			}
		}

		return Long.valueOf(result).intValue();
		
	}// End of Method

	private static void walkEulerTour(List<Integer>[] adjList, ArrayList<Integer> eulerTour, int[][] eulerMap,
			int[] eulerIndexes) {
		walkEulerTour(1, -1, -1, eulerTour, eulerMap, adjList, -1, eulerIndexes);
	}// End of Method

	private static int walkEulerTour(int node, int parent, int previousIndex, ArrayList<Integer> eulerTour,
			int[][] eulerMap, List<Integer> adjList[], int prevHeight, int[] eulerIndexes) {

		int currentIndex = previousIndex + 1;
		int currentHeigth = prevHeight + 1;
		eulerTour.add(currentIndex);
		eulerIndexes[currentIndex] = node;
		eulerMap[node - 1][0] = currentIndex;
		eulerMap[node - 1][1] = currentHeigth;
		eulerMap[node - 1][2] = eulerTour.size() - 1;// first seen at this index on tour

		int maxVal = currentIndex;
		List<Integer> adjacents = adjList[node - 1];
		for (Integer adj : adjacents) {
			if (adj != parent && adj != node) {
				int val = walkEulerTour(adj, node, maxVal, eulerTour, eulerMap, adjList, currentHeigth, eulerIndexes);
				eulerTour.add(currentIndex);
				if (maxVal < val) {
					maxVal = val;
				}
			}
		}
		return maxVal;

	}// End of Method

	private static class SparseTable {

		List<Integer> table[];

		public SparseTable(ArrayList<Integer> eulerTour) {
			this.consume(eulerTour);
		}

		private void consume(ArrayList<Integer> arraylist) {

			int n = arraylist.size();
			int logn = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
			table = new ArrayList[logn + 1];

			table[0] = new ArrayList<Integer>();
			for (Integer val : arraylist) {
				table[0].add(val);
			}

			for (int p = 1; p <= logn; p++) {
				table[p] = new ArrayList<Integer>();
				for (int i = 0; i + (1 << p) - 1 < n; i++) {
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

		public int query(int a, int b) {

			if (a > b) {
				int t = a;
				a = b;
				b = t;
			}
			int numOfEls = b - a + 1;
			int logn = log2(numOfEls);
			int diff = numOfEls - (1 << logn);

			int v1 = table[logn].get(a);
			int v2 = table[logn].get(a + diff);

			if (v1 < v2) {
				return v1;
			} else {
				return v2;
			}

		}// End of Method

		private int log2(int value) {
			return Integer.numberOfTrailingZeros(Integer.highestOneBit(value));
		}// End of Method

	}// End of Inner Class

	private static long calculateDistanceSolution(long u, long v, long dist) {
		long result = (u * v * dist) % MOD;
		return result;
	}// End of Method

	/**
	 * Entry Method. To be replaced with main while deployment of the solution.
	 */
	private static void runCalculationSolution() {

		Scanner inputScanner = new Scanner(System.in);

		try {

			int n = inputScanner.nextInt();
			int q = inputScanner.nextInt();

			List<Integer> adjList[] = fillAdjList(n, inputScanner);
			List<Integer> queries[] = fillQueries(q, inputScanner);

			calculate(adjList, queries);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[Fetching values] has failed.");
		} finally {
			inputScanner.close();
		}

	}// End of Method

	private static List<Integer>[] fillAdjList(int n, Scanner inputScanner) {

		List<Integer> adjList[] = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int edge = 1; edge < n; edge++) {
			Integer from = inputScanner.nextInt();
			Integer to = inputScanner.nextInt();
			int v1 = from - 1;
			int v2 = to - 1;

			if (!adjList[v1].contains(to)) {
				adjList[v1].add(to);
			}
			if (!adjList[v2].contains(from)) {
				adjList[v2].add(from);
			}

		}
		return adjList;

	}// End of Method

	private static List<Integer>[] fillQueries(int q, Scanner inputScanner) {

		List<Integer> queries[] = new ArrayList[q];
		for (int qc = 0; qc < q; qc++) {
			int numOfElements = inputScanner.nextInt();
			ArrayList<Integer> query = new ArrayList<Integer>(numOfElements);
			for (int ec = 0; ec < numOfElements; ec++) {
				int queryElement = inputScanner.nextInt();
				query.add(queryElement);
			}
			queries[qc] = query;
		}
		return queries;

	}// End of Method

	static private class TestBehaviour implements ITestBehaviour {

		@SuppressWarnings("unused")
		Object[] input;

		public TestBehaviour(Object... input) {
			this.input = input;
		}

		@Override
		public void run() {
			runCalculationSolution();
		}

	}// End of Private Class

	public static void main(String[] args) {
//		testCase1();
//		testCase2();
//		testCase3();
		testCaseFile01();
//		testCaseFile04();
//		testCaseFile08();
//		testCaseFile14();
	}// End of Main

	private static void testCase1() {

		String ls = System.lineSeparator();

		String input = "7 3" + ls //
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

		String expected = "16" + ls//
				+ "0" + ls//
				+ "106";//

		TestByStringRequest testSources = new TestByStringRequest();
		testSources.setBehaviour(new TestBehaviour());
		testSources.setInput(input);
		testSources.setOutput(expected);
		testSources.setPrintOutput(true);
		HackkerrankTestStream.putStreamFromResource(testSources);

	}// End of Test Case

	private static void testCase2() {

		String ls = System.lineSeparator();

		String input = "7 1" + ls //
				+ "1 2" + ls //
				+ "1 3" + ls //
				+ "1 4" + ls //
				+ "3 5" + ls //
				+ "3 6" + ls //
				+ "3 7" + ls //
				+ "3" + ls //
				+ "2 4 5";

		String expected = "106";

		TestByStringRequest testSources = new TestByStringRequest();
		testSources.setBehaviour(new TestBehaviour());
		testSources.setInput(input);
		testSources.setOutput(expected);
		testSources.setPrintOutput(true);
		HackkerrankTestStream.putStreamFromResource(testSources);

	}// End of Test Case

	private static void testCase3() {

		String ls = System.lineSeparator();

		String input = "7 1" + ls //
				+ "1 2" + ls //
				+ "1 3" + ls //
				+ "1 4" + ls //
				+ "3 5" + ls //
				+ "3 6" + ls //
				+ "3 7" + ls //
				+ "2" + ls //
				+ "1 5"; //

		String expected = "10";

		TestByStringRequest testSources = new TestByStringRequest();
		testSources.setBehaviour(new TestBehaviour());
		testSources.setInput(input);
		testSources.setOutput(expected);
		testSources.setPrintOutput(true);
		HackkerrankTestStream.putStreamFromResource(testSources);

	}// End of Test Case

	private static void testCaseFile01() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input01.txt");
		testSources.setOutputFileName("output01.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCaseFile04() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input04.txt");
		testSources.setOutputFileName("output04.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCaseFile08() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input08.txt");
		testSources.setOutputFileName("output08.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCaseFile14() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input14.txt");
		testSources.setOutputFileName("output14.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

}// End of Class
