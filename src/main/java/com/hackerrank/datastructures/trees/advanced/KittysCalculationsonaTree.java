package com.hackerrank.datastructures.trees.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;
import com.hackerrank.test.support.TestByFileRequest;
import com.hackerrank.test.support.TestByStringRequest;

public class KittysCalculationsonaTree {

	private static final long MOD = (long) Math.pow(10, 9) + 7;

	private static List<Integer> calculate(Map<Integer, Set<Integer>> adjMap, List<Set<Integer>> queries) {

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
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
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
				+ "2" + ls //
				+ "2 5"; //

		String expected = "30";

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

	private static void testCase4() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input01.txt");
		testSources.setOutputFileName("output01.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

	private static void testCase5() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input04.txt");
		testSources.setOutputFileName("output04.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

}// End of Class
