package com.hackerrank.algorithms.implementation.easy;

/**
 * <p>
 * You are the benevolent ruler of Rankhacker Castle, and today you're
 * distributing bread. Your subjects are in a line, and some of them already
 * have some loaves. Times are hard and your castle's food stocks are dwindling,
 * so you must distribute as few loaves as possible according to the following
 * rules:
 * </p>
 * <li>Every time you give a loaf of bread to some person i, you must also give
 * a loaf of bread to the person immediately in front of or behind them in the
 * line (i.e., persons i+1 or i-1).</li>
 * <li>After all the bread is distributed, each person must have an even number
 * of loaves.</li>
 * <p>
 * Given the number of loaves already held by each citizen, find and print the
 * minimum number of loaves you must distribute to satisfy the two rules above.
 * If this is not possible, print NO.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class FairRationsSolution {

	/**
	 * <p>
	 * Complete the fairRations function in the editor below. It should return an
	 * integer that represents the minimum number of loaves required.
	 * </p>
	 * 
	 * @param b : an array of integers that represent the number of loaves each
	 *          persons starts with.
	 * @return the minimum number of loaves required
	 */
	static String fairRations(int[] b) {
		// The trick is hidden in finding the way of possible distribution calculation
		// How many odd numbers are in the distribution?
		int count = 0;
		int indexToCheck = -1;
		int reqSteps = 0;
		for (int i = 0; i < b.length; i++) {
			int v = b[i];
			if ((v % 2) != 0) {
				count++;
				if (indexToCheck == -1) {
					indexToCheck = i;
				} else {
					reqSteps += i - indexToCheck;
					indexToCheck = -1;
				}
			}
		}

		if (count % 2 != 0) {
			return "NO";
		} else {// Each step has 2 loafs that is distributed
			return String.valueOf(reqSteps * 2);
		}
	}// End of Method

	public static void main(String[] args) {
		testFairRations(new int[] { 2, 3, 4, 5, 6 }, "4");
		testFairRations(new int[] { 1, 2 }, "NO"); // Will print no as a result
	}// End of Main

	static void testFairRations(int[] b, String expected) {
		String result = fairRations(b);
		System.out.println(result);
		assert expected.contains(result);
	}// End of Test

}// End of Class
