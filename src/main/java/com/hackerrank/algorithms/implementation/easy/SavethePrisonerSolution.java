package com.hackerrank.algorithms.implementation.easy;

public class SavethePrisonerSolution {

	// Complete the saveThePrisoner function below.
	/**
	 * Note: All sequences starts from 1;
	 * 
	 * @param n : an integer, the number of prisoners
	 * @param m : an integer, the number of sweets
	 * @param s : an integer, the chair number to begin passing out sweets from
	 * @return
	 */
	static int saveThePrisoner(int n, int m, int s) {
		int rem = (m % n); // remaining candies to share
		int act = (rem + s - 1) % n; // rounds to go with the remaining candies
		act = act <= 0 ? n - act : act; // if there are no remaining candies, then iterate backwards
		return act;
	}

	public static void main(String[] args) {
		testSaveThePrisoner(5, 2, 1, 2);
		testSaveThePrisoner(5, 2, 2, 3);
		testSaveThePrisoner(7, 19, 2, 6);
		testSaveThePrisoner(3, 7, 3, 3);
	}// End of Main

	static void testSaveThePrisoner(int n, int m, int s, int expected) {
		int result = saveThePrisoner(n, m, s);
		System.out.println(result);
		assert expected == result;
	}// End of Test

}
