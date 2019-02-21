package com.algorithms.hackerrank.implementation;

public class JumpingOnTheCloudsSolution {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {

		int length = c.length;
		int index = 0;
		int steps = 0;
		while (length - 2 > index) {
			int jump = 0;
			if (c[index + 2] == 0) {
				jump += 2;
			} else if (c[index + 1] == 0) {
				jump += 1;
			}
			index += jump;
			steps++;
		}

		if (length - 1 != index) {
			steps++;
		}

		return steps;

	}// End of Method

	public static void main(String[] args) {
		testJumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }, 3);
		testJumpingOnClouds(new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 1 }, 5);
		testJumpingOnClouds(new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, 6);
		testJumpingOnClouds(new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, 6);
		testJumpingOnClouds(new int[] { 0, 0, 1, 0 }, 2);
		testJumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 }, 6);
	}// End of Main

	static void testJumpingOnClouds(int[] c, int expected) {
		int result = jumpingOnClouds(c);
		System.out.println(result);
		assert expected == result;
	}// End of Test

}// End of Class
