package com.hackerrank.datastructures.trees.easy;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

public class TreeInorderTraversal {

	static class Node {
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
			inOrder(root);
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
	 * Inorder is left->root->right (as in reading order)
	 * </p>
	 * <p>
	 * Note that inorder is a DFS method.
	 * </p>
	 * 
	 * @param root
	 */
	public static void inOrder(Node root) {
		System.out.print(inOrderNode(root));
	}

	static String inOrderNode(Node node) {
		if (node == null) {
			return "";
		}
		String str = "";
		String left = inOrderNode(node.left);
		if (!left.trim().isEmpty()) {
			str = left;
		}
		if (!str.isEmpty()) {
			str = str + " " + String.valueOf(node.data);
		} else {
			str = String.valueOf(node.data);
		}
		String right = inOrderNode(node.right);
		if (!right.trim().isEmpty()) {
			if (!str.isEmpty()) {
				str = str + " " + right;
			} else {
				str = right;
			}
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
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 1, 2, 5, 3, 6, 4 };
		String expected = "1 2 3 4 5 6";
		testInOrder(values, expected);
	}// End of Test

	static void testInOrder(int[] values, String expected) {
		int t = values.length;
		Node root = null;
		int i = 0;
		while (t-- > 0) {
			int data = values[i];
			root = insert(root, data);
			i++;
		}
		String output = HackkerrankTestStream.manipulateSystemInput(new TestBehaviour(root)).trim();
		assert expected.equals(output);
	}

}// End of Class
