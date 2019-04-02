package com.hackerrank.datastructures.trees.easy;

import java.util.Stack;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

/**
 * <p>
 * You are given pointer to the root of the binary search tree and two values v1
 * and v2. You need to return the lowest common ancestor (LCA) of and in the
 * binary search tree.
 * </p>
 * <p>
 * Lowest Common Ancestor is the node at the lowest level that two given nodes
 * can be traversed to each other. Naturally, LCA is at upper level than two
 * compared nodes.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class BinarySearchTreeLowestCommonAncestor {

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}// End of Background Inner Class

	/**
	 * Write your code here. Fill the LCA method.
	 * 
	 * @param root
	 * @param v1
	 * @param v2
	 * @return lowest common ancestor node of v1 and v2
	 */
	public static Node lca(Node root, int v1, int v2) {

		// Tree can be recorded to a stack until both v1 and v2 is found.
		Stack<Node> stack = new Stack<Node>();

		return null;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}// End of Background Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 4, 2, 3, 1, 7, 6 };
		int expected = 4;
		test(values, 1, 7, expected);
	}// End of Test

	static void testCase2() {
		int[] values = new int[] { 1, 2 };
		int expected = 1;
		test(values, 1, 2, expected);
	}// End of Test

	static void testCase3() {
		int[] values = new int[] { 5, 3, 8, 2, 4, 6, 7 };
		int expected = 5;
		test(values, 7, 3, expected);
	}// End of Test

	static void testCase4() {
		int[] values = new int[] { 7, 6, 12, 5, 8, 10, 13, 3, 4, 9, 11, 15, 1, 2 };
		int expected = 6;
		test(values, 8, 1, expected);
	}// End of Test

	static void testCase5() {
		int[] values = new int[] { 7, 6, 12, 5, 8, 10, 13, 3, 4, 9, 11, 15, 1, 2 };
		int expected = 12;
		test(values, 9, 15, expected);
	}// End of Test

	static void testCase6() {
		int[] values = new int[] { 7, 6, 12, 5, 8, 10, 13, 3, 4, 9, 11, 15, 1, 2 };
		int expected = 10;
		test(values, 9, 11, expected);
	}// End of Test

	private static void test(int[] values, int v1, int v2, int expected) {

		int t = values.length;
		Node root = null;
		int i = 0;
		while (t-- > 0) {
			int data = values[i];
			root = insert(root, data);
			i++;
		}

		Node output = lca(root, v1, v2);
		System.out.println(output.data);
		assert expected == output.data;

	}// End of Test

}// End of Class
