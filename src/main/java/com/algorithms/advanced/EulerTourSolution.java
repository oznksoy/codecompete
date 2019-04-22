package com.algorithms.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Euler Tour is technique to find an
 * <q>Euler Trail</q>
 * </p>
 * <p>
 * On a graph:
 * <li>Walk: is a closed traverse on a graph, where u -->* v and u = v.</li>
 * <li>Trail: is to traverse on a graph with no repeated edges.*</li>
 * <li>Euler Trail: a trail taht visits every edge only once.*</li> <i>*vertices
 * can be visited multiple times.</i>
 * </p>
 * <p>
 * Euler Tour is an Euler Trail that is closed. If a graph has an Euler Tour
 * Specialty, it is called Eulerian.
 * </p>
 * <p>
 * For graph with n nodes, 2n-1 visits are required to complete an Euler Tour.
 * </p>
 * <p>
 * <a href="https://www.cs.sfu.ca/~ggbaker/zju/math/euler-ham.html#euler"> To
 * learn more about euler tour in detail, click</a>
 * <p>
 * <p>
 * Here are the important points to remember while designing a Euler Path
 * solution
 * </p>
 * <p>
 * <ul>
 * <li>It is important to index node values separately as a map. This method
 * will help to index all parent nodes with a lowered valued index while mapping
 * the closed trail.</li>
 * <li>Specially for Range Queries to function correctly, it is important to
 * ensure that index(parent) > index(child)</li>
 * </ul>
 * </p>
 * 
 * @author Ozan Aksoy
 */
public class EulerTourSolution {

	public static void main(String[] args) {
		EulerTourSolution eulerTourSolution = new EulerTourSolution();
		eulerTourSolution.test();
	}// End of Main

	private class EulerTourBuilder {

		private List<Integer>[] tree;
		private Integer root;
		private int[] eulerIndexList;
		private ArrayList<Integer> eulerPath;

		public EulerTourBuilder(List<Integer>[] tree, Integer root) {
			this.tree = tree;
			this.root = root;
			this.build();
		}

		public int[] getEulerIndexList() {
			return eulerIndexList;
		}

		public ArrayList<Integer> getEulerPath() {
			return eulerPath;
		}

		private void build() {
			eulerIndexList = new int[tree.length];
			eulerPath = new ArrayList<Integer>((tree.length * 2) - 1);
			eulerTour(root, -1, -1, eulerPath, eulerIndexList);
		}// End of Method

		private Integer eulerTour(Integer node, Integer parent, Integer previousEulerIndex,
				ArrayList<Integer> eulerPath, int[] eulerIndexList) {

			Integer currentEulerIndex = previousEulerIndex + 1;
			eulerPath.add(currentEulerIndex);
			eulerIndexList[currentEulerIndex] = node;
			List<Integer> adjacents = tree[node - 1];
			Integer maxVal = currentEulerIndex;
			for (Integer adjacent : adjacents) {
				if (!adjacent.equals(parent) && !adjacent.equals(node)) {
					Integer val = eulerTour(adjacent, node, maxVal, eulerPath, eulerIndexList);
					eulerPath.add(currentEulerIndex);
					if (val > maxVal) {
						maxVal = val;
					}
				}
			}

			return maxVal;

		}// End of Method

	}// End of Class

	public void test() {
		List<Integer>[] tree = generateTree();
		Integer root = 1;

		EulerTourBuilder eulerTourBuilder = new EulerTourBuilder(tree, root);

		int[] expectedIndexList = getExpectedIndexMapping(tree.length);
		int[] actualIndexList = eulerTourBuilder.getEulerIndexList();

		for (int i = 0; i < expectedIndexList.length; i++) {
			if (expectedIndexList[i] != actualIndexList[i]) {
				System.err.println("Fail");
				System.err.println("Expected Value: " + expectedIndexList[i] + " at Index : " + i);
				System.err.println("Actual Value: " + actualIndexList[i] + " at Index : " + i);
			}
		}

		ArrayList<Integer> expectedEulerTour = getExpectedEulerTour(tree.length);
		ArrayList<Integer> actualEulerTour = eulerTourBuilder.getEulerPath();

		for (int i = 0; i < expectedEulerTour.size(); i++) {
			if (expectedEulerTour.get(i) != actualEulerTour.get(i)) {
				System.err.println("Fail");
				System.err.println("Expected Value: " + expectedEulerTour.get(i) + " at Index : " + i);
				System.err.println("Actual Value: " + actualEulerTour.get(i) + " at Index : " + i);
			}
		}

	}// End of Test Method

	private int[] getExpectedIndexMapping(int length) {

		int[] expected = new int[length];

		expected[0] = 1;
		expected[1] = 2;
		expected[2] = 4;
		expected[3] = 8;
		expected[4] = 9;
		expected[5] = 5;
		expected[6] = 10;
		expected[7] = 16;
		expected[8] = 17;
		expected[9] = 21;
		expected[10] = 22;
		expected[11] = 23;
		expected[12] = 11;
		expected[13] = 3;
		expected[14] = 6;
		expected[15] = 12;
		expected[16] = 13;
		expected[17] = 18;
		expected[18] = 19;
		expected[19] = 7;
		expected[20] = 14;
		expected[21] = 20;
		expected[22] = 15;

		return expected;

	}// End of Method

	private ArrayList<Integer> getExpectedEulerTour(int length) {

		ArrayList<Integer> expectedEulerTour = new ArrayList<Integer>(length * 2 - 1);
		expectedEulerTour.add(0);
		expectedEulerTour.add(1);
		expectedEulerTour.add(2);
		expectedEulerTour.add(3);
		expectedEulerTour.add(2);
		expectedEulerTour.add(4);
		expectedEulerTour.add(2);
		expectedEulerTour.add(1);
		expectedEulerTour.add(5);
		expectedEulerTour.add(6);
		expectedEulerTour.add(7);
		expectedEulerTour.add(6);
		expectedEulerTour.add(8);
		expectedEulerTour.add(9);
		expectedEulerTour.add(8);
		expectedEulerTour.add(10);
		expectedEulerTour.add(11);
		expectedEulerTour.add(10);
		expectedEulerTour.add(8);
		expectedEulerTour.add(6);
		expectedEulerTour.add(5);
		expectedEulerTour.add(12);
		expectedEulerTour.add(5);
		expectedEulerTour.add(1);
		expectedEulerTour.add(0);
		expectedEulerTour.add(13);
		expectedEulerTour.add(14);
		expectedEulerTour.add(15);
		expectedEulerTour.add(14);
		expectedEulerTour.add(16);
		expectedEulerTour.add(17);
		expectedEulerTour.add(16);
		expectedEulerTour.add(18);
		expectedEulerTour.add(16);
		expectedEulerTour.add(14);
		expectedEulerTour.add(13);
		expectedEulerTour.add(19);
		expectedEulerTour.add(20);
		expectedEulerTour.add(21);
		expectedEulerTour.add(20);
		expectedEulerTour.add(19);
		expectedEulerTour.add(22);
		expectedEulerTour.add(19);
		expectedEulerTour.add(13);
		expectedEulerTour.add(0);

		return expectedEulerTour;

	}// End of Method

	public List<Integer>[] generateTree() {

		List<Integer> adjList[] = new ArrayList[23];

		// value = index + 1;
		// root = 1 -> (index->0)

		adjList[0] = new ArrayList<Integer>();
		adjList[0].add(2);
		adjList[0].add(3);

		adjList[1] = new ArrayList<Integer>();
		adjList[1].add(1);
		adjList[1].add(4);
		adjList[1].add(5);

		adjList[2] = new ArrayList<Integer>();
		adjList[2].add(1);
		adjList[2].add(6);
		adjList[2].add(7);

		adjList[3] = new ArrayList<Integer>();
		adjList[3].add(2);
		adjList[3].add(8);
		adjList[3].add(9);

		adjList[4] = new ArrayList<Integer>();
		adjList[4].add(2);
		adjList[4].add(10);
		adjList[4].add(11);

		adjList[5] = new ArrayList<Integer>();
		adjList[5].add(3);
		adjList[5].add(12);
		adjList[5].add(13);

		adjList[6] = new ArrayList<Integer>();
		adjList[6].add(3);
		adjList[6].add(14);
		adjList[6].add(15);

		adjList[7] = new ArrayList<Integer>();
		adjList[7].add(4);

		adjList[8] = new ArrayList<Integer>();
		adjList[8].add(4);

		adjList[9] = new ArrayList<Integer>();
		adjList[9].add(5);
		adjList[9].add(16);
		adjList[9].add(17);

		adjList[10] = new ArrayList<Integer>();
		adjList[10].add(5);

		adjList[11] = new ArrayList<Integer>();
		adjList[11].add(6);

		adjList[12] = new ArrayList<Integer>();
		adjList[12].add(6);
		adjList[12].add(18);
		adjList[12].add(19);

		adjList[13] = new ArrayList<Integer>();
		adjList[13].add(7);
		adjList[13].add(20);

		adjList[14] = new ArrayList<Integer>();
		adjList[14].add(7);

		adjList[15] = new ArrayList<Integer>();
		adjList[15].add(10);

		adjList[16] = new ArrayList<Integer>();
		adjList[16].add(10);
		adjList[16].add(21);
		adjList[16].add(22);

		adjList[17] = new ArrayList<Integer>();
		adjList[17].add(13);

		adjList[18] = new ArrayList<Integer>();
		adjList[18].add(13);

		adjList[19] = new ArrayList<Integer>();
		adjList[19].add(14);

		adjList[20] = new ArrayList<Integer>();
		adjList[20].add(17);

		adjList[21] = new ArrayList<Integer>();
		adjList[21].add(17);
		adjList[21].add(23);

		adjList[22] = new ArrayList<Integer>();
		adjList[22].add(22);

		return adjList;

	}// End of Method

}// End of Class
