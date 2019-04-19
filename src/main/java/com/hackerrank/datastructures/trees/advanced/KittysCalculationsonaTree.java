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

	private static List<Integer> calculate(Map<Integer, Set<Integer>> adjMap, List<List<Integer>> queries) {

		List<Integer> results = new ArrayList<Integer>(queries.size());
		Integer root = (adjMap.size() / 2); // there are adjMap.size()+1 vertices.
		Map<Integer, List<Integer>> routeMap = generateRouteMap(root, adjMap);

		for (List<Integer> query : queries) {// iterate through queries
			if (query.size() < 2) {
				results.add(0);
			} else {
				results.add(calculateViaRouteMap(root, routeMap, query));
			}
		}

		return results;

	}// End of Method

	private static Integer calculateViaRouteMap(Integer root, Map<Integer, List<Integer>> routeMap,
			List<Integer> query) {

		// Distance to init is what map route map shows
		long result = 0;
		for (int i = 0; i < query.size() - 1; i++) {
			for (int j = i + 1; j < query.size(); j++) {
				Integer u = query.get(i);
				Integer v = query.get(j);
				if (u.equals(root) || v.equals(root)) {
					Integer target = u.equals(root) ? v : u;
					result += calculateSolutionWithDistance(root, target, routeMap.get(target).size());
					result = result % MOD;
				} else {
					List<Integer> sourceList = routeMap.get(query.get(i));
					List<Integer> targetList = routeMap.get(query.get(j));
					Integer step = 0;
					Integer sLen = sourceList.size();
					Integer tLen = targetList.size();

					for (step = 0; step < sLen & step < tLen; step++) {
						if (sourceList.get(step) != (targetList).get(step)) {
							break;
						}
					}
					int dist = (sLen + tLen) - (2 * step);
					result += calculateSolutionWithDistance(u, v, dist);
					result = result % MOD;
				}
			}
		}

		return (int) result;

	}// End of Method

	private static Map<Integer, List<Integer>> generateRouteMap(Integer root, Map<Integer, Set<Integer>> adjMap) {

		Map<Integer, List<Integer>> routeMap = new HashMap<Integer, List<Integer>>(adjMap.size() - 1);
		// Find all destinations and distances and map them to the route map
		Set<Integer> keySet = adjMap.keySet();

		for (Integer key : keySet) {
			if (!key.equals(root))
				routeMap.put(key, new ArrayList<Integer>());
		}

		Set<Integer> visited = new HashSet<Integer>(adjMap.size());
		visited.add(root);
		Queue<Integer> routes = new LinkedList<Integer>();
		Queue<Set<Integer>> adjQueue = new LinkedList<Set<Integer>>();
		Set<Integer> initAdjSet = adjMap.get(root);

		for (Integer route : initAdjSet) {
			routeMap.get(route).add(route);
			routes.add(route);
			adjQueue.add(adjMap.get(route));
			visited.add(route);
		}
		routes.remove(root);

		while (visited.size() != adjMap.size()) {

			Queue<Integer> nextRoutes = new LinkedList<Integer>();
			Queue<Set<Integer>> nextAdjQueue = new LinkedList<Set<Integer>>();

			while (adjQueue.peek() != null && routes.peek() != null) {
				Set<Integer> adjSet = adjQueue.poll();
				Integer previousRoute = routes.poll();
				for (Integer route : adjSet) {
					if (!visited.contains(route)) {
						List<Integer> trail = routeMap.get(previousRoute);
						List<Integer> currentRoute = new ArrayList<Integer>();
						currentRoute.addAll(trail);
						currentRoute.add(route);
						routeMap.put(route, currentRoute);
						nextRoutes.add(route);
						nextAdjQueue.add(adjMap.get(route));
						visited.add(route);
					}
				}
			}
			routes = nextRoutes;
			adjQueue = nextAdjQueue;
			
		}

		return routeMap;

	}// End of Method

	private static long calculateSolutionWithDistance(long u, long v, long dist) {
		long result = (u * v * dist) % MOD;
		return result;
	}// End of Method

	/**
	 * Entry Method. To be replaced with main while deployment of the solution.
	 */
	private static void runCalculationSolution() {

		Scanner inputScanner = new Scanner(System.in);

		Map<Integer, Set<Integer>> adjMap;
		List<List<Integer>> queries;

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

			queries = new ArrayList<List<Integer>>(q);
			for (int qc = 0; qc < q; qc++) {
				int numOfElements = inputScanner.nextInt();
				ArrayList<Integer> set = new ArrayList<Integer>(numOfElements);
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
//		testCaseFile01();
//		testCaseFile04();
		testCaseFile08();
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
