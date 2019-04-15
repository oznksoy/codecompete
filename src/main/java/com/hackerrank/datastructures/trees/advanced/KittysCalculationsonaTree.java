package com.hackerrank.datastructures.trees.advanced;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;
import com.hackerrank.test.support.TestByFileRequest;
import com.hackerrank.test.support.TestByStringRequest;

public class KittysCalculationsonaTree {

	private static final long MOD = (long) Math.pow(10, 9) + 7;

	private static class Node {

		private int data;
		private int height;
		private List<Node> nodes;

		private Node(int data, int height) {
			this.data = data;
			this.height = height;
			this.nodes = null;
		}

	}// End of Background Inner Class

	private static int[] calculateSolution(int[][] treeMatrix, List<int[][]> queries) {
		Node root = generateTree(treeMatrix);
		Iterator<int[][]> iter = queries.iterator();
		int[] results = new int[queries.size()];
		int i = 0;
		while (iter.hasNext()) {
			int[][] query = iter.next();
			results[i] = (int) calculateOnPairs(root, query);
			i++;
		}
		return results;
	}// End of Method

	private static long calculateOnPairs(Node root, int[][] query) {
		long result = 0;
		if (query == null || root == null) {
			return result;
		}
		for (int i = 0; i < query.length; i++) {
			long a = query[i][0];
			long b = query[i][1];
			result = ((a * b * findDistance(root, query[i][0], query[i][1])) + result) % MOD;
		}
		return result;
	}// End of Method

	private static long findDistance(Node root, int a, int b) {
		// how to find the distance in optimal way...
		NodesAtDistance nodes = new NodesAtDistance();
		nodes = findLCA(root, a, b);
		long result = (nodes.bNode.height - nodes.lca.height) + (nodes.aNode.height - nodes.lca.height);
		return result;
	}// End of Method

	private static class NodesAtDistance {
		Node lca;
		Node aNode;
		Node bNode;
	}

	private static NodesAtDistance findLCA(Node root, int a, int b) {
		// how to find the distance in optimal way...
		NodesAtDistance nodes = new NodesAtDistance();
		if (root.data == a) {
			nodes.aNode = root;
			// return nodes;
		} else if (root.data == b) {
			nodes.bNode = root;
			// return nodes;
		}
		if (root.nodes != null) {
			for (Node node : root.nodes) {
				NodesAtDistance found = findLCA(node, a, b);
				if (found.aNode != null) {
					nodes.aNode = found.aNode;
				} else if (found.bNode != null) {
					nodes.bNode = found.bNode;
				}
				if (nodes.aNode != null && nodes.bNode != null) {
					if (found.lca == null) {
						nodes.lca = root;
					}
					return nodes;
				}
			}
		}
		return nodes;
	}// End of Method

	private static Node generateTree(int[][] treeMatrix) {

		Node root = null;
		for (int row = 0; row < treeMatrix.length; row++) {
			int from = treeMatrix[row][0];
			int to = treeMatrix[row][1];
			root = insert(root, from, to);
		}
		return root;

	}// End of Method

	private static Node insert(Node root, int from, int to) {
		if (root == null) {
			root = new Node(from, 0);
		}
		Node node = traverse(root, from);
		if (node != null && node.nodes != null) {
			for (Node subnode : node.nodes) {
				if (subnode.data == to) {
					return root;
				}
			}
			node.nodes.add(new Node(to, node.height + 1));
		} else if (node != null) {
			node.nodes = new LinkedList<Node>();
			node.nodes.add(new Node(to, node.height + 1));
		}
		return root;
	}// End of Method

	private static Node traverse(Node node, int value) {
		if (node == null) {
			return null;
		}
		if (node.data == value) {
			return node;
		}
		if (node.nodes != null) {
			for (Node subNode : node.nodes) {
				Node found = traverse(subNode, value);
				if (found != null) {
					return found;
				}
			}
		}
		return null;
	}// End of Method

	private static void runCalculationSolution() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		String[] fL = scanner.nextLine().split(" ");
		int n = convertToInt(fL[0]);
		int q = convertToInt(fL[1]);

		if (n < 2) {
			for (int i = 0; i < q; i++) {
				System.out.println("0");
			}
			return;
		}

		int[][] treeMatrix = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			String[] line = scanner.nextLine().split(" ");
			treeMatrix[i][0] = convertToInt(line[0]);
			treeMatrix[i][1] = convertToInt(line[1]);
		}
		List<int[][]> queries = new LinkedList<int[][]>();
		for (int i = 0; i < q; i++) {
			int k = convertToInt(scanner.nextLine());
			String[] line = scanner.nextLine().split(" ");
			int[] values = new int[k];
			for (int j = 0; j < k; j++) {
				values[j] = convertToInt(line[j]);
			}
			int[][] query = generatePairs(values);
			queries.add(query);
		}
		int[] results = calculateSolution(treeMatrix, queries);
		if (results != null) {
			for (int i = 0; i < results.length; i++) {
				System.out.println(results[i]);
			}
		} else {
			System.out.println("Results was null!");
		}
	}// End of Method

	private static int[][] generatePairs(int[] values) {
		int size = values.length;
		if (size < 2) {
			return null;
		}
		int total = ((size - 1) * size) / 2;
		int[][] pairs = new int[total][2];
		int index = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				pairs[index][0] = values[i];
				pairs[index][1] = values[j];
				index++;
			}
		}
		return pairs;
	}// End of Method

	private static int convertToInt(String input) {
		return Integer.valueOf(input).intValue();
	}// End of Background Method

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
