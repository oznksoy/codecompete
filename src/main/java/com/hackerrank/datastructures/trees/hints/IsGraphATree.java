package com.hackerrank.datastructures.trees.hints;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.hackerrank.test.support.TestSupportConstants;

class IsGraphATree {
	// data structure to store graph edges
	private static class Edge {
		int source, dest;

		public Edge(int source, int dest) {
			this.source = source;
			this.dest = dest;
		}
	};

	// class to represent a graph object
	private static class Graph {
		// An array of Lists to represent adjacency list
		List<List<Integer>> adjList = null;

		// Constructor
		Graph(List<Edge> edges, int N) {
			adjList = new ArrayList<>(N);
			for (int i = 0; i < N; i++) {
				adjList.add(i, new ArrayList<>());
			}

			// add edges to the undirected graph
			for (int i = 0; i < edges.size(); i++) {
				int src = edges.get(i).source;
				int dest = edges.get(i).dest;

				adjList.get(src).add(dest);
				adjList.get(dest).add(src);
			}
		}
	}

	// Perform DFS on graph and returns true if any back-edge
	// is found in the graph
	public static boolean DFS(Graph graph, int v, boolean[] discovered, int parent) {
		// mark current node as discovered
		discovered[v] = true;

		// do for every edge (v -> w)
		for (int w : graph.adjList.get(v)) {
			// w is not discovered
			if (!discovered[w]) {
				if (!DFS(graph, w, discovered, v))
					return false;
			}

			// w is discovered and w is not a parent
			else if (w != parent) {
				// we found a back-edge (cycle)
				return false;
			}
		}

		// No back-edges found in the graph
		return true;
	}

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	private static void testCase1() {

		// vector of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(4, 5),
				new Edge(5, 0)
		// edge (5->0) introduces a cycle in the graph
		);

		// Number of vertices in the graph
		final int numberOfVertices = 6;

		testRun(edges, numberOfVertices);

	}// End of Method

	private static void testCase2() {
		testFromResource("input01.txt");
	}// End of Test Case
	private static void testCase3() {
		testFromResource("input04.txt");
	}// End of Test Case

	private static void testRun(List<Edge> edges, int numberOfVertices) {
		// construct graph
		Graph graph = new Graph(edges, numberOfVertices);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[numberOfVertices];

		// boolean flag to store if the graph is tree or not
		boolean isTree = true;

		// Do DFS traversal from first vertex
		isTree = DFS(graph, 0, discovered, -1);

		for (int i = 0; isTree && i < numberOfVertices; i++) {
			// any undiscovered vertex means graph is not connected
			if (!discovered[i])
				isTree = false;
		}

		if (isTree)
			System.out.println("Graph is a Tree");
		else
			System.out.println("Graph is not a Tree");

	}// End of Method

	static void testFromResource(String fileName) {

		String dir = "src/main/resources/datastructures/isgraphatree/";
		File inputFile = new File(dir + fileName);

		try {

			Scanner inputScanner = new Scanner(inputFile);

			int numberOfVertices = inputScanner.nextInt();

			inputScanner.skip(TestSupportConstants.SKIP_CHAR_SET_REGEX);

			// vector of graph edges as per above diagram
			List<Edge> edges = new ArrayList<Edge>();

			for (int edgeCount = 1; edgeCount < numberOfVertices; edgeCount++) {
				int from = inputScanner.nextInt();
				int to = inputScanner.nextInt();
				System.out.println("EDGE : " + edgeCount + " | FROM : " + from + " | to : " + to);
				edges.add(new Edge(from - 1, to - 1));
			}

			testRun(edges, numberOfVertices);

			inputScanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of Test from file source
	
}// End of Class
