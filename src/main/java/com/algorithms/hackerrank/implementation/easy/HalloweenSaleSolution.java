package com.algorithms.hackerrank.implementation.easy;

public class HalloweenSaleSolution {

	// Complete the howManyGames function below.
	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy
		int budget = s;
		int sale = p;
		int count = 0;

		if (s < p) {
			return count;
		}

		while (budget >= sale && sale >= m) {
			count++;
			budget -= sale;
			sale -= d;
		}

		if (budget >= sale) {
			int addition = (budget - (budget % m)) / m;
			count += addition;
		}

		return count;
	}// End of Method

	public static void main(String args[]) {
		testHowManyGames(20, 3, 6, 80, 6);
		testHowManyGames(20, 3, 6, 85, 7);
		testHowManyGames(100, 1, 1, 99, 0);
		testHowManyGames(100, 19, 1, 180, 1);
	}// End of Main

	static void testHowManyGames(int p, int d, int m, int s, int expected) {
		int result = howManyGames(p, d, m, s);
		System.out.println("Result : " + result);
		assert result == expected;
	}// End of Test

}// End of Class
