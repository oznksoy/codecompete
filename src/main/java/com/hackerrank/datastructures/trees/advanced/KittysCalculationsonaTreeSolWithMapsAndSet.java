package com.hackerrank.datastructures.trees.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;
import com.hackerrank.test.support.TestByFileRequest;
import com.hackerrank.test.support.TestByStringRequest;

public class KittysCalculationsonaTreeSolWithMapsAndSet {

	private static final long MOD = (long) Math.pow(10, 9) + 7;

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
	 * @param adjMap
	 * @param queries
	 * @return
	 */
	private static List<Integer> calculate(Map<Integer, Set<Integer>> adjMap, List<Set<Integer>> queries) {

		List<Integer> results = new ArrayList<Integer>(queries.size());

		for (Set<Integer> query : queries) {// iterate through queries
			if (query.size() < 2) {
				results.add(0);
			} else {
				results.add(calculateSolution(query, adjMap));
			}
		}

		return results;

	}// End of Method

	private static Integer calculateSolution(Set<Integer> query, Map<Integer, Set<Integer>> adjMap) {

		Map<Integer, List<Integer>> routeMap = new HashMap<Integer, List<Integer>>(query.size() - 1);
		Integer init = findAndRemoveInit(query);
		Integer[] queryArray = new Integer[query.size()];
		query.toArray(queryArray);
		while (!query.isEmpty()) {
			Set<Integer> visited = new HashSet<Integer>();
			findDistanceDFS(routeMap, adjMap, visited, init, query);
		}
		// Distance to init is what map route map shows
		long result = 0;
		for (Integer target : queryArray) {
			result += calculateSolutionWithDistance(init, target, routeMap.get(target).size());
		}
		for (int i = 0; i < queryArray.length - 1; i++) {
			for (int j = i + 1; j < queryArray.length; j++) {
				List<Integer> sourceList = routeMap.get(queryArray[i]);
				List<Integer> targetList = routeMap.get(queryArray[j]);
				Integer step = 0;
				Integer sLen = sourceList.size();
				Integer tLen = targetList.size();

				for (step = 0; step < sLen & step < tLen; step++) {
					if (sourceList.get(sLen - 1 - step).intValue() != (targetList).get(tLen - 1 - step).intValue()) {
						break;
					}
				}
				int dist = (sLen + tLen) - (2 * step);
				result += calculateSolutionWithDistance(queryArray[i], queryArray[j], dist);
				result = result % MOD;
			}
		}

		return (int) result;

	}// End of Method

	private static long calculateSolutionWithDistance(long u, long v, long dist) {
		return (u * v * dist) % MOD;
	}// End of Method

	private static Integer findAndRemoveInit(Set<Integer> query) {
		Iterator<Integer> iter = query.iterator();
		Integer init = iter.next();
		query.remove(init);
		return init;
	}

	private static Integer findDistanceDFS(Map<Integer, List<Integer>> routeMap, Map<Integer, Set<Integer>> adjMap,
			Set<Integer> visited, Integer init, Set<Integer> rest) {

		if (rest.isEmpty()) {
			return null;
		}
		Set<Integer> adjacents = adjMap.get(init);
		visited.add(init);
		for (Iterator<Integer> values = adjacents.iterator(); values.hasNext();) {
			Integer value = values.next();
			if (rest.contains(value)) {
				List<Integer> route = new LinkedList<Integer>();
				route.add(value);
				routeMap.put(value, route);
				rest.remove(value);
				return value;
			}
			if (!visited.contains(value)) {
				Integer receivedValue = findDistanceDFS(routeMap, adjMap, visited, value, rest);
				if (receivedValue != null) {
					routeMap.get(receivedValue).add(value);
					return receivedValue;
				}
			}
		}

		return null;

	}// End of Method

	/**
	 * Entry Method. To be replaced with main while deployment of the solution.
	 */
	private static void runCalculationSolution() {

		Scanner inputScanner = new Scanner(System.in);

		Map<Integer, Set<Integer>> adjMap;
		List<Set<Integer>> queries;

		try {

			int n = inputScanner.nextInt();
			int q = inputScanner.nextInt();
			adjMap = new HashMap<Integer, Set<Integer>>(n);
			for (int edge = 1; edge < n; edge++) {
				Integer from = inputScanner.nextInt();
				Integer to = inputScanner.nextInt();
				if (!adjMap.containsKey(from)) {
					Set<Integer> set = new HashSet<Integer>();
					adjMap.put(from, set);
				}
				if (!adjMap.containsKey(to)) {
					Set<Integer> set = new HashSet<Integer>();
					adjMap.put(to, set);
				}
				adjMap.get(from).add(to);
				adjMap.get(to).add(from);
			}

			queries = new ArrayList<Set<Integer>>(q);
			for (int qc = 0; qc < q; qc++) {
				int numOfElements = inputScanner.nextInt();
				Set<Integer> set = new HashSet<Integer>(numOfElements);
				for (int ec = 0; ec < numOfElements; ec++) {
					int queryElement = inputScanner.nextInt();
					set.add(queryElement);
				}
				queries.add(set);
			}

			List<Integer> results = calculate(adjMap, queries);
			for (Integer value : results) {
				System.out.println(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[Fetching values] has failed.");
		} finally {
			inputScanner.close();
		}

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
//		testCase01();
//		testCase04();
		testCase08();
//		testCase14();
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

	private static void testCase01() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input01.txt");
		testSources.setOutputFileName("output01.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCase04() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input04.txt");
		testSources.setOutputFileName("output04.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCase08() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input08.txt");
		testSources.setOutputFileName("output08.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCase14() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input14.txt");
		testSources.setOutputFileName("output14.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

}// End of Class
