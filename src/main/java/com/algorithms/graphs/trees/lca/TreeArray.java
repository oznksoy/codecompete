package com.algorithms.graphs.trees.lca;

import java.util.Arrays;

class TreeArray {

	private final int inf = -1;
	private int[] treeArray;

	public TreeArray(int size) {

		this.treeArray = new int[size];
		Arrays.fill(treeArray, -1);
	}// End of Method

	public void setRoot(int root) {
		this.treeArray[0] = root;
	}

	public void addNode(int addTo, int data) throws Exception {

		int parentIndex = findIndex(addTo);
		if (inf == parentIndex) {
			setRoot(data);
		} else if (inf == treeArray[parentIndex]) {
			setRoot(data);
		} else if (inf == getLeft(parentIndex)) {
			setLeft(parentIndex, data);
		} else if (inf == getRight(parentIndex)) {
			setRight(parentIndex, data);
		} else {
			throw new Exception("Node is full");
		}

	}// End of Method

	public int findIndex(int value) {
		int i;
		for (i = 0; i < treeArray.length; i++) {
			if (treeArray[i] == value) {
				return i;
			}
		}
		return inf;
	}// End of Method

	private int getLeftIndex(int index) {
		return 2 * index + 1;
	}

	private int getRightIndex(int index) {
		return 2 * index + 2;
	}

	private int getLeft(int parentIndex) {
		return this.treeArray[getLeftIndex(parentIndex)];
	}

	private void setLeft(int parentIndex, int data) {
		this.treeArray[getLeftIndex(parentIndex)] = data;
	}

	private int getRight(int parentIndex) {
		return this.treeArray[getRightIndex(parentIndex)];
	}

	private void setRight(int parentIndex, int data) {
		this.treeArray[getRightIndex(parentIndex)] = data;
	}

	public void printTree() {
		System.out.println("Root : " + treeArray[0]);
		for (int i = 0; i < treeArray.length; i++) {

			System.out.print(//
					"Node : " + treeArray[i]); //
			int leftIdx = getLeftIndex(i);
			int rightIdx = getRightIndex(i);
			if (leftIdx < treeArray.length) {
				System.out.print(//
						" -> left : " + treeArray[getLeftIndex(i)]); //
			}
			if (rightIdx < treeArray.length) {
				System.out.print(//
						" -> right : " + treeArray[getRightIndex(i)]);
			}
			System.out.print("\n");
		}

	}// End of Method

}// End of Class
