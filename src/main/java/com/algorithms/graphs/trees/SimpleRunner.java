package com.algorithms.graphs.trees;

class SimpleRunner {

	public static void main(String[] args) {
		testCase01();
		testCase02();
		return;
	}// End of Main

	private static void testCase01() {

		UndirectedGraph graph = new UndirectedGraph(9);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		graph.addEdge(4, 8);
		graph.addEdge(4, 9);

	}// End of Test Case

	private static void testCase02() {

		TreeArray treeArray = new TreeArray(9);
		try {
			treeArray.setRoot(1);
			treeArray.addNode(1, 2);
			treeArray.addNode(1, 3);
			treeArray.addNode(2, 4);
			treeArray.addNode(2, 5);
			treeArray.addNode(3, 6);
			treeArray.addNode(3, 7);
			treeArray.addNode(4, 8);
			treeArray.addNode(4, 9);
		} catch (Exception e) {
			e.printStackTrace();
		}

		treeArray.printTree();

	}// End of Test Case

}// End of Method
