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
 * 
 * 
 * @author Ozan Aksoy
 *
 */
public class EulerTourSolution {

	public static void main(String[] args) {

	}// End of Main

	public static List<Integer>[] generateTree() {

		List<Integer> adjList[] = new ArrayList[23];

		// value = index + 1;

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
