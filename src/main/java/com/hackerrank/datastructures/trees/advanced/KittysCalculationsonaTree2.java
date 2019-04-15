package com.hackerrank.datastructures.trees.advanced;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;
import com.hackerrank.test.support.TestByFileRequest;

public class KittysCalculationsonaTree2 {

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

		String dir = "src/main/resources/datastructures/kittyscalculationsonatree/";
		File outputFile = new File(dir + "output01.txt");

		try {
			Scanner inputScanner = new Scanner(outputFile);
			while (inputScanner.hasNextLine()) {
				System.out.println(inputScanner.nextLine());
			}
			inputScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
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
	}// End of Main

	private static void testCase1() {
		TestByFileRequest testSources = new TestByFileRequest();
		testSources.setDir("src/main/resources/datastructures/kittyscalculationsonatree/");
		testSources.setInputFileName("input01.txt");
		testSources.setOutputFileName("output01.txt");
		testSources.setTestBehaviour(new TestBehaviour());
		HackkerrankTestStream.putStreamFromResource(testSources);
	}// End of Test Case

}// End of Class
