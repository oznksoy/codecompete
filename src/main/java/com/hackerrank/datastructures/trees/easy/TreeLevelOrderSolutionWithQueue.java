package com.hackerrank.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

/**
 * <p>
 * Level order is a Breadth First Search approach on the trees. Each level is
 * listed, staring from left to right as root at initial point.
 * </p>
 * <p>
 * ROOT -> left -> right -> left.left -> left.right -> right.left ->
 * right.right... and so on
 * </p>
 * 
 * @author Ozan Aksoy
 */
public class TreeLevelOrderSolutionWithQueue {

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}// End of Private Class

	private static class TestBehaviour implements ITestBehaviour {

		Object[] input;

		public TestBehaviour(Object... input) {
			this.input = input;
		}

		@Override
		public void run() {
			Node root = Node.class.cast(input[0]);
			levelOrder(root);
		}

	}// End of Private Class

	public static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		StringBuilder strBuilder = new StringBuilder();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		levelOrder(queue, strBuilder);
		System.out.print(strBuilder.toString().trim());
	}// End of Method

	private static void levelOrder(Queue<Node> queue, StringBuilder strBuilder) {
		Node iter = queue.poll();
		while (iter != null) {
			strBuilder.append(" " + iter.data);
			if(iter.left != null) {
				queue.add(iter.left);
			}
			if(iter.right != null) {
				queue.add(iter.right);
			}
			iter = queue.poll();
		}
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
		String expected = "1 2 5 3 6 4";
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
	}// End of Test Utility Method

}// End of Class
