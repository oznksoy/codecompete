package com.hackerrank.datastructures.trees.easy;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

public class TreePreorderTraversal {

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}

	static private class TestBehaviour implements ITestBehaviour {

		Object[] input;

		public TestBehaviour(Object... input) {
			this.input = input;
		}

		@Override
		public void run() {
			Node root = Node.class.cast(input[0]);
			preOrder(root);
		}

	}

	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */

	/**
	 * <p>
	 * Preorder is root->left->right ( obviously, before any ordered setup, there
	 * should be root).
	 * </p>
	 * <p>
	 * Note that preoder is a DFS method.
	 * </p>
	 * 
	 * @param root
	 */
	public static void preOrder(Node root) {
		System.out.print(preOrderNode(root));
	}// End of Method

	static String preOrderNode(Node node) {
		if (node == null) {
			return "";
		}
		String str = String.valueOf(node.data);
		String left = preOrderNode(node.left);
		if (!left.trim().isEmpty()) {
			str = str + " " + left;
		}
		String right = preOrderNode(node.right);
		if (!right.trim().isEmpty()) {
			str = str + " " + right;
		}
		return str;
	}// End of Method

	static Node insert(Node root, int data) {
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
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 1, 2, 5, 3, 6, 4 };
		String expected = "1 2 5 3 4 6";
		test(values, expected);
	}// End of Test

	static void testCase2() {
		int[] values = new int[] { 7, 6, 12, 5, 8, 10, 13, 3, 4, 9, 11, 15, 1, 2 };
		test(values, "7 6 5 3 1 2 4 12 8 10 9 11 13 15");
	}// End of Test

	static void test(int[] values, String expected) {
		int t = values.length;
		Node root = null;
		int i = 0;
		while (t-- > 0) {
			int data = values[i];
			root = insert(root, data);
			i++;
		}
		String output = HackkerrankTestStream.manipulateSystemInput(new TestBehaviour(root)).trim();
		System.out.println(output);
		assert expected.equals(output);
	}

}// End of Class
