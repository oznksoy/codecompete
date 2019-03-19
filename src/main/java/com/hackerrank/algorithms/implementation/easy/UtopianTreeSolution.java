package com.hackerrank.algorithms.implementation.easy;

public class UtopianTreeSolution {

	// Complete the utopianTree function below.
	static int utopianTree(int n) {

		int height = 0;

		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0) {
				height += 1;
			} else {
				height *= 2;
			}
		}

		return height;
		
	}// End of Method

	public static void main(String[] args) {
		testUtopianTree(0, 1);
		testUtopianTree(1, 2);
		testUtopianTree(4, 7);
	}// End of Main

	static void testUtopianTree(int n, int expected) {
		int result = utopianTree(n);
		System.out.println(result);
		System.out.println("---------");
		assert expected == result;
	}
}// End of Class
