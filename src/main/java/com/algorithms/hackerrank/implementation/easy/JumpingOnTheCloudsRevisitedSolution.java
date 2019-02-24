package com.algorithms.hackerrank.implementation.easy;

public class JumpingOnTheCloudsRevisitedSolution {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c, int k) {

		int e = 100;
		// uses 1 energy to make a jump
		// Length of 1 jump : k
		// Configuration of the clouds to jump on : c

		int n = c.length;

		for (int i = 1;; i++) {
			int ind = ((i * k) % n);
			e -= 1;
			if (1 == c[ind]) {
				e -= 2;
			}
			if(i * k >= n) {
				break;
			}
		}
		
		return e;

	}// End of Method

	public static void main(String[] args) {

		testJumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 1, 0 }, 2, 92);

	}// End of Main

	static void testJumpingOnClouds(int[] c, int k, int expected) {
		int result = jumpingOnClouds(c, k);
		System.out.println(result);
		assert result == expected;
	}

}// End of Class
