package com.hackerrank.datastructures.trees.easy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

public class TreePreorderTraversal {

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
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 1, 2, 5, 3, 6, 4 };
		String expected = "1 2 5 3 4 6";
		testPreOrder(values, expected);
	}// End of Test

	static void testPreOrder(int[] values, String expected) {
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
