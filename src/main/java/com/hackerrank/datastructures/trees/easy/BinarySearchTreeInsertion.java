package com.hackerrank.datastructures.trees.easy;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

/**
 * Insert the new value into the correct location of the binary tree. Return the
 * root of the binary search tree after inserting the value into the tree.
 * 
 * @author Ozan Aksoy
 *
 */
public class BinarySearchTreeInsertion {

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}// End of Inner Class

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

	}// End of Private Class

	public static void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}// End of Method

	/**
	 * <p>
	 * Fill the method to make input data set to the correct location of the tree.
	 * </p>
	 * <p>
	 * NOTE: this version is iterative rather than recursive. Provides less space
	 * complexity on the program stack.
	 * </p>
	 * 
	 * @param root
	 * @param data
	 * @return root of the binary search tree.
	 */
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} // else
		Node iter = root;
		while (iter != null) {
			if (iter.data <= data) { // to the right
				if (iter.right == null) {
					iter.right = new Node(data);
					break;
				} else {
					iter = iter.right;
				}
			} else { // iter.data > data -> to the left
				if (iter.left == null) {
					iter.left = new Node(data);
					break;
				} else {
					iter = iter.left;
				}
			}
		}
		return root;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 1, 2, 5, 3, 6, 4 };
		String expected = "1 2 5 3 4 6";
		test(values, expected);
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