package com.hackerrank.datastructures.trees.easy;

/**
 * <p>
 * he height of a binary tree is the number of edges between the tree's root and
 * its furthest leaf.Complete the getHeight or height function in the editor. It
 * must return the height of a binary tree as an integer.
 * </p>
 * <p>
 * -The Height of binary tree with single node is taken as zero.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class TreeHeightofaBinaryTree {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}// End of Inner Class

	/*
	 * you only have to complete the function given below. Node is defined as
	 * 
	 * class Node { int data; Node left; Node right; }
	 * 
	 */
	public static int height(Node root) {
		return height(root, -1);
	}

	static int height(Node node, int hVal) {
		if (node == null) {
			return hVal;
		}
		hVal = hVal + 1;
		int left = height(node.left, hVal);
		int right = height(node.right, hVal);
		return left > right ? left : right;
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
		int[] values = new int[] { 3, 5, 2, 1, 4, 6, 7 };
		int expected = 3;
		testHeight(values, expected);
	}// End of Test

	static void testHeight(int[] values, int expected) {
		int t = values.length;
		Node root = null;
		int i = 0;
		while (t-- > 0) {
			int data = values[i];
			root = insert(root, data);
			i++;
		}
		int output = height(root);
		assert expected == output;
	}// End of test

}// End of Class
