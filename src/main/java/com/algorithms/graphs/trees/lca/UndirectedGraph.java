package com.algorithms.graphs.trees.lca;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple Graph representation for tests. Based on integer valued vertices.
 * Every vertex is undirected and unweighted. No self-direction or parallel
 * edges are allowed.
 * 
 * @author Ozan Aksoy
 *
 */
class UndirectedGraph {

	private LinkedList<Integer>[] adjacentList;
	private int size;

	/**
	 * Size must be above 0;
	 * 
	 * @param size
	 */
	public UndirectedGraph(int size) {
		if (size < 1) {
			throw new IndexOutOfBoundsException();
		}
		this.size = size;
		this.adjacentList = new LinkedList[size];
	}// End of Constructor

	public List<Integer>[] getAdjacentList() {
		return this.adjacentList;
	}// End of Method

	public void addEdge(int source, int destination) {
		if (source == destination) {
			return;
		}
		if (source > size || source < 1 || destination > size || destination < 1) {
			throw new IndexOutOfBoundsException();
		}
		updateAdjList(source, destination);
		updateAdjList(destination, source);
	}// End of Method

	/**
	 * Source and Destination must be below size
	 * 
	 * @param size
	 */
	public void updateAdjList(int source, int destination) {
		Integer from = source - 1;
		Integer to = destination - 1;

		LinkedList<Integer> connections = adjacentList[from];
		if (connections == null) {
			connections = new LinkedList<Integer>();
			adjacentList[from] = connections;
		}
		connections.add(to);

	}// End of Method

}// End of Class
