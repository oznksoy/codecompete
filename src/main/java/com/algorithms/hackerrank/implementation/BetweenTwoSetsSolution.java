package com.algorithms.hackerrank.implementation;

public class BetweenTwoSetsSolution {

	/*
	 * Complete the getTotalX function below.
	 */
	static int getTotalX(int[] a, int[] b) {

		int total = 0;
		int lcmOfA = calculateLowestCommonMultiple(a);
		int gcdOfB = calculateGreatestCommonDivisor(b);

		for (int value = lcmOfA; value <= gcdOfB; value += lcmOfA) {
			if (gcdOfB % value == 0) {
				total++;
			}
		}

		return total;

	}

	static int calculateLowestCommonMultiple(int[] array) {
		int gcd = calculateGreatestCommonDivisor(array);
		int difference = array[0] / gcd;
		for (int i = 1; i < array.length; i++) {
			int x = difference;
			int y = array[i] / gcd;
			int commonDivisor = calculateGreatestCommonDivisor(x, y);
			difference = x * y / commonDivisor;
		}
		return difference * gcd;
	}

	static int calculateGreatestCommonDivisor(int[] array) {
		int gcd = array[0];
		for (int i = 1; i < array.length; i++) {
			gcd = calculateGreatestCommonDivisor(array[i], gcd);
		}
		return gcd;
	}

	static int calculateGreatestCommonDivisor(int x, int y) {

		if (x == 1 || y == 1) {
			return 1;
		} else if (x == y) {
			return x;
		}

		int larger = 0;
		int lower = 0;
		if (x < y) {
			larger = y;
			lower = x;
		} else if (x > y) {
			larger = x;
			lower = y;
		}

		for (int div = lower; div > 1; div--) {
			if (larger % div == 0 && lower % div == 0) {
				return div;
			}
		}

		return 1;

	}

	public static void main(String[] args) {
		int[] a1 = { 2, 4 };
		int[] b1 = { 16, 32, 96 };
		System.out.println(getTotalX(a1, b1));

		int[] a2 = { 3, 4 };
		int[] b2 = { 24, 48 };
		System.out.println(getTotalX(a2, b2));

		int[] a3 = { 2, 8, 3, 5, 7 };
		int[] b3 = { 16, 35, 60, 120, 30, 50, 240, 840 };
		System.out.println(getTotalX(a3, b3));

	}
}
