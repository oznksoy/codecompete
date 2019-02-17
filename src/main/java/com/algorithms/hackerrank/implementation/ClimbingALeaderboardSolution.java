package com.algorithms.hackerrank.implementation;

public class ClimbingALeaderboardSolution {

	// Complete the climbingLeaderboard function below.

	/**
	 * <p>
	 * What is alice's score sequence in cross-reference to scores in dense ranking
	 * fashion?
	 * </p>
	 * <li>scores[] < 10^9;</li>
	 * <li>alice[] < 10^9;</li>
	 * <li>scores[].length <= 2*10^5</li>
	 * <li>alice[].length <= 2*10^5</li>
	 * 
	 * @param scores : is in descending order
	 * @param        alice: is in ascending order
	 * @return
	 */
	static int[] climbingLeaderboard(int[] scores, int[] alice) {

		int[] aliceRanks = new int[alice.length];

		int rank = 0;
		for (int a = alice.length - 1; a >= 0;) {
			for (int s = 0; s < scores.length;) {
				while (s < scores.length - 1 && scores[s] == scores[s + 1]) {
					s++;
				}
				rank++;
				while (a >= 0 && scores[s] <= alice[a]) {
					aliceRanks[a] = rank;
					a--;
				}
				s++;
				if (a < 0) {
					break;
				}
			}
			rank += 1;
			while (a >= 0) {
				aliceRanks[a] = rank;
				a--;
			}
		}

		return aliceRanks;

	}// End of Method

	public static void main(String[] args) {
		testClimbingLeaderboard(//
				new int[] { 100, 100, 50, 40, 40, 20, 10 }, //
				new int[] { 5, 25, 50, 120 }, //
				new int[] { 6, 4, 2, 1 });
		testClimbingLeaderboard(//
				new int[] { 100, 90, 90, 80, 75, 60 }, //
				new int[] { 50, 65, 77, 90, 102 }, //
				new int[] { 6, 5, 4, 2, 1 });
		testClimbingLeaderboard(//
				new int[] { 100, 100, 50, 40, 40, 20, 10 }, //
				new int[] { 3, 3, 3, 4, 4, 4, 5, 25, 50, 120 }, //
				new int[] { 6, 6, 6, 6, 6, 6, 6, 4, 2, 1 });
		testClimbingLeaderboard(//
				new int[] { 100, 100, 50, 40, 40, 20, 10, 10, 10, 10 }, //
				new int[] { 5, 25, 50, 90, 90, 95 }, //
				new int[] { 6, 4, 2, 2 });
	}

	static void testClimbingLeaderboard(int[] scores, int[] alice, int[] expected) {
		int[] result = climbingLeaderboard(scores, alice);
		for (int i : result) {
			System.out.println(i);
		}
		System.out.println("--------------");
		if (expected.length == result.length) {
			for (int i = 0; i < expected.length; i++) {
				assert expected[i] == result[i];
			}
		}
	}// End of Test

}// End of Class
