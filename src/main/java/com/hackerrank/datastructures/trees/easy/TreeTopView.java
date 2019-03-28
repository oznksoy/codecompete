package com.hackerrank.datastructures.trees.easy;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

/**
 * <p>
 * Top View of a tree is the "visible" nodes of a tree from the top side from
 * left to right, as vertically any edges of the topological order of the tree
 * is visible. This includes nodes of the subtrees that extends from underneath
 * of the tree structure in horizontal manner.
 * </p>
 * <p>
 * --top-view--<br>
 * V: Visible<br>
 * H: Hidden<br>
 * vvvvvvvvvvvv<br>
 * -----V------<br>
 * ----V-V-----<br>
 * ---V-H-V----<br>
 * ----H-H-----<br>
 * ---H---H----<br>
 * -V------V--<br>
 * </p>
 * 
 * @author Ozan Aksoy
 */
public class TreeTopView {

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
			topView(root);
		}

	}// End of Private Class

	private static int leftEdge;
	private static int rightEdge;

	public static void topView(Node root) {

		if (root != null) {
			leftEdge = 0;
			rightEdge = 0;
			StringBuilder builder = new StringBuilder().append(String.valueOf(root.data));
			topView(root, 0, 0, builder);
			System.out.print(builder.toString());
		}
	}// End of Method

	static void topView(Node node, int distLeft, int distRight, StringBuilder strBuilder) {

		// current distance and level is input distance and level.
		if (node == null) {
			return;
		}

		// iterate to the left
		Node left = node.left;
		int currentDistleft = distLeft;
		while (left != null) {
			currentDistleft++;
			if (leftEdge < currentDistleft) {
				strBuilder.insert(0, String.valueOf(left.data) + " ");
			}
			left = left.left;
		}

		// iterate to the right
		Node right = node.right;
		int currentDistRight = distRight;
		while (right != null) {
			currentDistRight++;
			if (rightEdge < currentDistRight) {
				strBuilder.append(" " + String.valueOf(right.data));
			}
			right = right.right;
		}

		if (currentDistleft > leftEdge) {
			leftEdge = currentDistleft;
		}

		if (currentDistRight > rightEdge) {
			rightEdge = currentDistRight;
		}

		topView(node.left, distLeft + 1, distRight - 1, strBuilder);
		topView(node.right, distLeft - 1, distRight + 1, strBuilder);

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
		testCase3();
	}// End of Main

	static void testCase1() {
		int[] values = new int[] { 1, 2, 5, 3, 6, 4 };
		String expected = "1 2 5 6";
		test(values, expected);
	}// End of Test

	static void testCase2() {
		int[] values = new int[] { 4, 6, 3, 5, 10, 7, 8, 9, 1, 2 };
		String expected = "1 3 4 6 10 9";
		test(values, expected);
	}// End of Test

	static void testCase3() {
		int[] values = new int[] { 8, 6, 15, 4, 7, 30, 1, 24, 45, 23, 26, 22, 27, 21, 28, 20, 29, 17, 16, 18, 19 };
		String expected = "16 17 1 4 6 8 15 30 45 28 29";
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
