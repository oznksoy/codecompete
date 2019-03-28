package com.hackerrank.datastructures.trees.easy;

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
public class TreeLevelOrder {

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

	/**
	 * Minor ADT for level order solution
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	static private class LinkNode {
		Node node;
		LinkNode next;

		public LinkNode(Node node) {
			this.node = node;
		}

		/**
		 * Adds tree node to the linked list
		 * 
		 * @param root
		 * @param node
		 */

	}// End of Private Class

	private static void insert(LinkNode root, Node node) {
		if (root == null || node == null) {
			return;
		}
		LinkNode iter = root;
		while (iter.next != null) {
			iter = iter.next;
		}
		iter.next = new LinkNode(node);
	}

	public static void levelOrder(Node root) {

		if (root == null) {
			return;
		}
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(root.data);

		LinkNode linkNode = null;
		if (root.left != null) {
			linkNode = new LinkNode(root.left);
		}
		if (root.right != null) {
			if (linkNode != null) {
				insert(linkNode, root.right);
			} else {
				linkNode = new LinkNode(root.right);
			}
		}

		levelOrder(linkNode, strBuilder);

		System.out.print(strBuilder.toString());

	}// End of Method

	private static void levelOrder(LinkNode listRoot, StringBuilder strBuilder) {
		if (listRoot == null) {
			return;
		}
		LinkNode iter = listRoot;
		LinkNode levelBelow = null;
		while (iter != null) {
			strBuilder.append(" " + iter.node.data);
			if (iter.node.left != null) {
				if (levelBelow == null) {
					levelBelow = new LinkNode(iter.node.left);
				} else {
					insert(levelBelow, iter.node.left);
				}
			}
			if (iter.node.right != null) {
				if (levelBelow == null) {
					levelBelow = new LinkNode(iter.node.right);
				} else {
					insert(levelBelow, iter.node.right);
				}
			}
			iter = iter.next;
		}
		levelOrder(levelBelow, strBuilder);
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
