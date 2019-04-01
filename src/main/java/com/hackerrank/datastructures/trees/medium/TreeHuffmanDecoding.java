package com.hackerrank.datastructures.trees.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.hackerrank.test.support.HackkerrankTestStream;
import com.hackerrank.test.support.ITestBehaviour;

/**
 * <p>
 * Huffman tree is an encoding method for a set of characters, which is usually
 * used in compression and documentation. Trick to build Huffman trees is to
 * count the occurrence of each unique element; creating leaf nodes of the tree
 * depending on the least frequent to most frequent and ensuring that the most
 * frequent elements are at the upper levels of the tree. Making most frequent
 * elements easier to decode would speed up the algorithm. Lastly, each leaf
 * would be linked to a binder node which represents a leap point. If the
 * huffman tree is right leaning, right nodes would be coded as 1, and left
 * nodes would be coded as 0.
 * </p>
 * <p>
 * In order to decode the tree, iterate though the huffman tree and encoded bits
 * in parallel; once an element is found, continue to the root of the tree and
 * repeat the process.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class TreeHuffmanDecoding {

	private static abstract class Node implements Comparable<Node> {

		public int frequency; // the frequency of this tree
		public char data;
		public Node left, right;

		public Node(int freq) {
			frequency = freq;
		}

		// compares on the frequency
		public int compareTo(Node tree) {
			return frequency - tree.frequency;
		}

	}// End of Background Private Class

	private static class HuffmanLeaf extends Node {

		public HuffmanLeaf(int freq, char val) {
			super(freq);
			data = val;
		}

	}// End of Background Private Class

	private static class HuffmanNode extends Node {

		public HuffmanNode(Node l, Node r) {
			super(l.frequency + r.frequency);
			left = l;
			right = r;
		}

	}// End of Background Private Class

	/**
	 * Fill the <code>decode</code> method
	 * 
	 * @author Ozan Aksoy
	 *
	 */
	private static class Decoding {

		/**
		 * There is one line of input containing the plain string, <i>s</i>. Background
		 * code creates the Huffman tree then passes the head node and the encoded
		 * string to the function. Output the decoded string on a single line.
		 * 
		 * @param s
		 * @param root
		 */
		void decode(String s, Node root) {
			StringBuilder pool = new StringBuilder();
			pool.append(s);
			traverse(pool, root);
		}// End of Method

		void traverse(StringBuilder pool, Node root) {

			if (pool.length() <= 0) {
				return;
			}
			Node node = root;
			// Iterate until the leaf node
			while (node.right != null || node.left != null) {
				char c = pool.charAt(0);
				pool.deleteCharAt(0);
				if (c == '1') {
					node = node.right;
				} else if (c == '0') {
					node = node.left;
				}
			}
			// Print decoded value
			System.out.print(node.data);
			// Continue to traverse
			traverse(pool, root);

		}// End of Method

	}// End of Background Inner Class

	private static class TestBehaviour implements ITestBehaviour {

		Object[] input;

		public TestBehaviour(Object... input) {
			this.input = input;
		}

		@Override
		public void run() {
			String s = String.class.cast(input[0]);
			Node tree = Node.class.cast(input[1]);
			Decoding d = new Decoding();
			d.decode(s.toString(), tree);
		}

	}// End of Private Class

	static class Solution {

		public static Map<Character, String> mapA = new HashMap<Character, String>();

		// input is an array of frequencies, indexed by character code
		public static Node buildTree(int[] charFreqs) {

			PriorityQueue<Node> trees = new PriorityQueue<Node>();
			// initially, we have a forest of leaves
			// one for each non-empty character
			for (int i = 0; i < charFreqs.length; i++)
				if (charFreqs[i] > 0)
					trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));

			assert trees.size() > 0;

			// loop until there is only one tree left
			while (trees.size() > 1) {
				// two trees with least frequency
				Node a = trees.poll();
				Node b = trees.poll();

				// put into new node and re-insert into queue
				trees.offer(new HuffmanNode(a, b));
			}

			return trees.poll();
		}

		public static void main(String[] args) {
			testCase1();
			testCase2();
			testCase3();
		}// End of Main

		private static void testCase1() {
			String input = "ABACA";
			testDecode(input, input);
		}// End of Test Case

		private static void testCase2() {
			String input = "Rumpelstiltskin";
			testDecode(input, input);
		}// End of Test Case

		private static void testCase3() {
			String input = "howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?";
			testDecode(input, input);
		}// End of Test Case

		private static void testDecode(String input, String expected) {

			String test = input;
			// we will assume that all our characters will have
			// code less than 256, for simplicity
			int[] charFreqs = new int[256];

			// read each character and record the frequencies
			for (char c : test.toCharArray())
				charFreqs[c]++;

			// build tree
			Node tree = buildTree(charFreqs);

			// print out results
			printCodes(tree, new StringBuffer());
			StringBuffer s = new StringBuffer();

			for (int i = 0; i < test.length(); i++) {
				char c = test.charAt(i);
				s.append(mapA.get(c));
			}

			String output = HackkerrankTestStream.manipulateSystemInput(new TestBehaviour(s.toString(), tree)).trim();
			System.out.println(output);
			assert expected.equals(output);

		} // End of Test

		public static void printCodes(Node tree, StringBuffer prefix) {

			assert tree != null;

			if (tree instanceof HuffmanLeaf) {
				HuffmanLeaf leaf = (HuffmanLeaf) tree;

				// print out character, frequency, and code for this leaf (which is just the
				// prefix)
				// System.out.println(leaf.data + "\t" + leaf.frequency + "\t" + prefix);
				mapA.put(leaf.data, prefix.toString());

			} else if (tree instanceof HuffmanNode) {
				HuffmanNode node = (HuffmanNode) tree;

				// traverse left
				prefix.append('0');
				printCodes(node.left, prefix);
				prefix.deleteCharAt(prefix.length() - 1);

				// traverse right
				prefix.append('1');
				printCodes(node.right, prefix);
				prefix.deleteCharAt(prefix.length() - 1);
			}

		}// End of Background Method

	}// End of Background Class

}// End of Class
