package com.algorithms.hackerrank.implementation.easy;

public class ChocolateFeastSolution {

	// Complete the chocolateFeast function below.
	/**
	 * <p>
	 * Idea is to spend money on chocolate bars and for every 2 chocolate that was
	 * bought, one receives a another bar. Promotion chocolates can be used for
	 * other free bars too.
	 * </p>
	 * 
	 * @param n : money to spend on chocolate bars
	 * @param c : cost
	 * @param m : wrappers to return to receive another chocolate bar
	 * @return
	 */
	static int chocolateFeast(int n, int c, int m) {

		int div = (n - (n % c)) / c;
		int count = div;

		int remainder = (div % m);
		int received = (div - remainder) / m;
		count += received;

		while (remainder + received >= m) {
			received = received + remainder;
			remainder = received % m;
			received = (received - remainder) / m;
			count += received;
		}

		return count;

	}// End of Method

	public static void main(String[] args) {
		testChocolateFeast(10, 2, 5, 6);
		testChocolateFeast(12, 4, 4, 3);
		testChocolateFeast(6, 2, 2, 5);
	}// End of Main

	static void testChocolateFeast(int n, int c, int m, int expected) {
		int result = chocolateFeast(n, c, m);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
