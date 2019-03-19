package com.hackerrank.algorithms.implementation.easy;

public class DrawingBookSolution {

	/*
	 * Complete the pageCount function below.
	 */
	/**
	 * I really over-thought this one. My solution works but it is over-engineered.
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	static int pageCount(int n, int p) {

		int pagePairCount = ((n + 1) + ((n + 1) % 2)) / 2;
		double turns;
		if (p >= pagePairCount) {
			turns = (pagePairCount * 2 - p - 1) / 2;
		} else { // closer to the start
			turns = p / 2;
		}

		return (int) Math.floor(turns);
	}

	/**
	 * Got this one from the discussion. Way simple.
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	static int solve(int n, int p) {
		// Complete this function
		int total = n / 2;
		int right = p / 2;
		int left = total - right;
		if (right < left) {
			return right;
		} else {
			return left;
		}
	}

	/**
	 * An even better and simpler solution.
	 * 
	 * @param n
	 * @param p
	 * @return
	 */
	static int solveByMin(int n, int p) {
		return Math.min(p / 2, n / 2 - p / 2);
	}

	public static void main(String[] args) {
		testPageCount(7, 4, 1);
		testPageCount(6, 3, 1);
		testPageCount(6, 4, 1);
		testPageCount(5, 4, 0);
		testPageCount(25, 13, 6);
		testPageCount(24, 20, 2);
		testPageCount(5, 5, 0);
		testPageCount(13, 7, 3);
	}

	public static void testPageCount(int n, int p, int expected) {
		int pagecount = solveByMin(n, p);
		System.out.println(pagecount);
		assert pagecount == expected;
	}

}
