package com.hackerrank.datastructures.trees.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * This is a simple yet very convoluted question with many layers!
 * </p>
 * <p>
 * Swapping: Swapping subtrees of a node means that if initially node has left
 * subtree L and right subtree R, then after swapping, the left subtree will be
 * R and the right subtree, L.
 * </p>
 * <p>
 * You are given a tree of n nodes where nodes are indexed from [1..n] and it is
 * rooted at 1. You have to perform t swap operations on it, and after each swap
 * operation print the in-order traversal of the current state of the tree.
 * </p>
 * <p>
 * Complete the swapNodes function in the editor below. It should return a
 * two-dimensional array where each element is an array of integers representing
 * the node indices of an in-order traversal after a swap operation.
 * 
 * swapNodes has the following parameter(s): - indexes: an array of integers
 * representing index values of each node[i], beginning with node[1], the first
 * element, as the root.
 * </p>
 * <p>
 * Given a tree and an integer, k, in one operation, we need to swap the
 * subtrees of all the nodes at each depth h, where h in [k, 2k, 3k,...]. In
 * other words, if h is a multiple of k, swap the left and right subtrees of
 * that level.
 * </p>
 * <p>
 * - queries: an array of integers, each representing a value.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class SwapNodesAlgo {

	private static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}// End of Inner Background Class

	/**
	 * Write your code here.
	 * 
	 * @param indexes
	 * @param queries
	 * @return
	 */
	static int[][] swapNodes(int[][] indexes, int[] queries) {

		int[][] result = new int[queries.length][indexes.length];// all nodes + root node as 1
		if (indexes != null) {
			Node root = generateBinaryTree(indexes);
			int h = heightOf(root);
			for (int i = 0; i < queries.length; i++) {
				int query = queries[i];
				while (query <= h) {
					swap(root, query);
					writeNodesToResult(result, i, 0, root);
					query += queries[i];
				}
			}
		}
		return result;

	}// End of Method

	private static int heightOf(Node root) {
		return heightOf(root, 0);
	}// End of Method

	private static int heightOf(Node root, int h) {
		if (root == null) {
			return h;
		}
		h++;
		int hLeft = heightOf(root.left, h);
		int hRight = heightOf(root.right, h);
		return hLeft < hRight ? hRight : hLeft;
	}// End of Method

	private static int writeNodesToResult(int[][] result, int row, int column, Node root) {

		if (root == null) {
			return column;
		}
		column = writeNodesToResult(result, row, column, root.left);
		result[row][column] = root.data;
		column++;
		column = writeNodesToResult(result, row, column, root.right);
		return column;

	}// End of Method

	private static void swap(Node root, int query) {
		if (root == null) {
			return;
		}
		if (query > 1) {
			query--;
			swap(root.left, query);
			swap(root.right, query);
		} else {
			Node left = root.left;
			root.left = root.right;
			root.right = left;
		}
	}// End of Method

	private static Node generateBinaryTree(int[][] indexes) {
		Node root = new Node(1);
		int rowStart = 0;
		int rowEnd = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		generateBinaryTree(rowStart, rowEnd, indexes, queue);
		return root;
	}// End of Method

	private static void generateBinaryTree(int rowStart, int rowEnd, int[][] indexes, Queue<Node> queue) {
		if (rowStart >= indexes.length) {
			return;
		}
		int rowCount = 0;
		for (int row = rowStart; row <= rowEnd; row++) {
			Node node = queue.poll();
			Node left = null, right = null;
			if (indexes[row][0] != -1) {
				left = new Node(indexes[row][0]);
				queue.add(left);
				rowCount++;
			}
			if (indexes[row][1] != -1) {
				right = new Node(indexes[row][1]);
				queue.add(right);
				rowCount++;
			}
			node.left = left;
			node.right = right;
		}
		int newRowStart = rowEnd + 1;
		int newRowEnd = rowEnd + rowCount;
		generateBinaryTree(newRowStart, newRowEnd, indexes, queue);
	}// End of Method

	public static void main(String[] args) {

		testCase1();
		testCase2();
		testCase3();
		testCase4();

	}// End of Main

	private static void testCase1() {

		int[][] indexes = new int[][] { //
				{ 2, 3 }, //
				{ -1, -1 }, //
				{ -1, -1 } //
		};
		int[] queries = new int[] { 1, 1 };
		String[] expected = new String[] { //
				"3 1 2", //
				"2 1 3" //
		};
		testSwapNodes(indexes, queries, expected);

	}// End of Test Case

	private static void testCase2() {

		int[][] indexes = new int[][] { //
				{ 2, 3 }, //
				{ -1, 4 }, //
				{ -1, 5 }, //
				{ -1, -1 }, //
				{ -1, -1 }//
		};
		int[] queries = new int[] { 2 };
		String[] expected = new String[] { //
				"4 2 1 5 3", //
		};
		testSwapNodes(indexes, queries, expected);

	}// End of Test Case

	private static void testCase3() {

		int[][] indexes = new int[][] { //
				{ 2, 3 }, //
				{ 4, -1 }, //
				{ 5, -1 }, //
				{ 6, -1 }, //
				{ 7, 8 }, //
				{ -1, 9 }, //
				{ -1, -1 }, //
				{ 10, 11 }, //
				{ -1, -1 }, //
				{ -1, -1 }, //
				{ -1, -1 }//
		};
		int[] queries = new int[] { 2, 4 };
		String[] expected = new String[] { //
				"2 9 6 4 1 3 7 5 11 8 10", //
				"2 6 9 4 1 3 7 5 10 8 11" //
		};
		testSwapNodes(indexes, queries, expected);

	}// End of Test Case

	private static void testCase4() {

		int[][] indexes = new int[][] { //
				{ 2, 3 }, //
				{ 4, 5 }, //
				{ 6, -1 }, //
				{ -1, 7 }, //
				{ 8, 9 }, //
				{ 10, 11 }, //
				{ 12, 13 }, //
				{ -1, 14 }, //
				{ -1, -1 }, //
				{ 15, -1 }, //
				{ 16, 17 }, //
				{ -1, -1 }, //
				{ -1, -1 }, //
				{ -1, -1 }, //
				{ -1, -1 }, //
				{ -1, -1 }, //
				{ -1, -1 }//
		};
		int[] queries = new int[] { 2, 3 };
		String[] expected = new String[] { //
				"14 8 5 9 2 4 13 7 12 1 3 10 15 6 17 11 16", //
				"9 5 14 8 2 13 7 12 4 1 3 17 11 16 6 10 15"//
		};
		testSwapNodes(indexes, queries, expected);

	}// End of Test Case

	private static void testSwapNodes(int[][] indexes, int[] queries, String[] expected) {

		int[][] output = swapNodes(indexes, queries);
		String[] lines = new String[output.length];
		for (int row = 0; row < output.length; row++) {
			String line = "";
			for (int column = 0; column < output[0].length; column++) {
				line = line.concat(output[row][column] + " ");
			}
			lines[row] = line.trim();
		}
		assert expected.length == lines.length;
		for (int i = 0; i < expected.length; i++) {
			System.out.println(lines[i]);
			assert expected[i].equals(lines[i]);
		}

	}// End of Test

}// End of Class
