package com.algorithms.graphs.trees.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Code
 * 
 * @author Ozan Aksoy
 *
 */
class NaiveLowestCommonAncestorSample {

	private static int rootNode;

	/**
	 * Number of Nodes
	 */
	private static int n;

	/**
	 * Keeps track of the visited nodes
	 */
	private static boolean[] visited = new boolean[n];

	/**
	 * Keeps track of the parent of every vertex in the tree
	 */
	private static int parent[] = new int[n];

	/**
	 * The tree is stored as an undirected graph using an adjacency list
	 */
	private static List<Integer>[] tree = new ArrayList[n];

	/**
	 * getParents() function traverses the tree and computes the parent array such
	 * that The pre-order traversal begins by calling getParents(root_node,-1)
	 */
	private static void getParents(int node, int par) {

		for (int i = 0; i < tree[node].size(); ++i) {
			int selectedNode = tree[node].get(i);
			if (selectedNode != par) {
				parent[selectedNode] = node;
				getParents(selectedNode, node);
			}
		}

	}// End of Method

	private static int LCA(int u, int v) {

		int lca;
		while (true) {
			visited[u] = true;
			if (u == rootNode) {
				break;
			}
			u = parent[u];
		}

		while (true) {
			if (visited[v]) { /* Intersection of paths found at this node. */
				lca = v;
				break;
			}
			v = parent[v];
		}
		return lca;

	}// End of Method

	public static void main(String[] args) {

	}// End of Main

}// End of Method
