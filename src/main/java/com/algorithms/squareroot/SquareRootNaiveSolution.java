package com.algorithms.squareroot;

public class SquareRootNaiveSolution {

	public static void main(String[] args) {
		test(5);
		test(6);
		test(9);
		test(64);
	}// End of Main

	private static void test(int value) {
		double expected = Math.sqrt(value);
		double actual = squareRootNaiveCalculation(value);
		System.out.println("Expected : " + expected);
		System.out.println("Actual : " + actual);
	}// End of Test Method

	private static double squareRootNaiveCalculation(int value) {

		double v = value;
		double half = v / 2;
		double inc = 0.0001;

		double sqrt = inc;
		while (sqrt < half && sqrt * sqrt < v) {
			sqrt += inc;
		}
		sqrt -= inc;
		Math.round(sqrt);
		return sqrt;

	}// End of Method

}
