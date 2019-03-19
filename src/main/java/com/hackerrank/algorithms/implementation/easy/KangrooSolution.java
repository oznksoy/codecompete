package com.hackerrank.algorithms.implementation.easy;

public class KangrooSolution {

	// Complete the kangaroo function below.
	static String kangaroo(int x1, int v1, int x2, int v2) {

		if (x1 < x2) {
			if (v1 <= v2) {
				return "NO";
			}
		} else if (x1 > x2) {
			if (v2 <= v1) {
				return "NO";
			}
		} else {// x1 == x2
			if (v1 != v2) {
				return "NO";
			}
		}

		int distance = Math.abs(x1 - x2);
		int catchUp = Math.abs(v1 - v2);

		if (distance % catchUp == 0) {
			return "YES";
		} else {
			return "NO";
		}

	}

	public static void main(String[] args) {
		System.out.println(kangaroo(0, 3, 4, 2));
		System.out.println(kangaroo(0, 2, 5, 3));
	}// End of Main

}// End of Class
