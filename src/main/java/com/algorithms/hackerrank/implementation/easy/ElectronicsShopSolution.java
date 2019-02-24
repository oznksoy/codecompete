package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Monica wants to buy a keyboard and a USB drive from her favorite electronics
 * store. The store has several models of each. Monica wants to spend as much as
 * possible for the 2 items, given her budget.
 * </p>
 * <p>
 * Given the price lists for the store's keyboards and USB drives, and Monica's
 * budget, find and print the amount of money Monica will spend. If she doesn't
 * have enough money to both a keyboard and a USB drive, print -1 instead. She
 * will buy only the two required items.
 * </p>
 * <p>
 * For example, suppose she has b = 60 to spend. Three types of keyboards cost
 * keyboards = [40, 50,60]. Two USB drives cost 5,8,12. She could purchase a 40
 * keyboard + 12 USB drives for 52 or a 50 keyboard + 8 USB drives = 58.
 * </p>
 * <p>
 * She chooses the latter. She can't buy more than 2 items so she can't spend
 * exactly 60.
 * </p>
 * <p>
 * Function Description:
 * </p>
 * <p>
 * Complete the getMoneySpent function in the editor below. It should return the
 * maximum total price for the two items within Monica's budget, or -1 if she
 * cannot afford both items.
 * </p>
 * <p>
 * getMoneySpent has the following parameter(s):
 * 
 * <li>keyboards: an array of integers representing keyboard prices</li>
 * <li>drives: an array of integers representing drive prices</li>
 * <li>b: the units of currency in Monica's budget</li>
 * </p>
 * <p>
 * 
 * @author Ozan Aksoy
 *
 */
public class ElectronicsShopSolution {

	/*
	 * Complete the getMoneySpent function below.
	 */
	/**
	 * This is O(n*m) solution. It is possible to generate a solution with better
	 * time complexity with counter sorting the arrays and cross referencing to each
	 * other
	 * 
	 * @param keyboards
	 * @param drives
	 * @param b
	 * @return
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		/*
		 * Write your code here.
		 */
		// Only two items. One from each.
		// highest possible combination that is lower or equal to b.
		int spending = -1;
		for (int kbIndex = 0; kbIndex < keyboards.length; kbIndex++) {
			for (int sbIndex = 0; sbIndex < drives.length; sbIndex++) {
				int total = keyboards[kbIndex] + drives[sbIndex];
				if (b >= total && spending < total) {
					spending = total;
				}
			}
		}

		return spending;
	}

	public static void main(String[] args) {

		testElectronicsShop(new int[] { 3, 1 }, new int[] { 5, 2, 8 }, 10, 9);
		testElectronicsShop(new int[] { 4 }, new int[] { 5 }, 5, -1);

	}

	public static void testElectronicsShop(int[] keyboards, int[] drives, int b, int expected) {
		int result = getMoneySpent(keyboards, drives, b);
		System.out.println(result);
		assert result == expected;
	}

}
