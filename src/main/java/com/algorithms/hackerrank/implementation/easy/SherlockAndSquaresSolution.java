package com.algorithms.hackerrank.implementation.easy;

public class SherlockAndSquaresSolution {

	// Complete the squares function below.
	static int squares(int a, int b) {
		
		double sqrta = Math.sqrt(a);
		double sqrtb = Math.sqrt(b);
		int floor = (int) Math.ceil(sqrta);
		int ceil = (int) Math.floor(sqrtb);

		int count = ceil - floor + 1;
		count = count < 0 ? 0 : count;
		return count;
		
	}// End of Method

	public static void main(String[] args) {
		testSquares(3, 9, 2);
		testSquares(17, 24, 0);
	}// End of Main

	static void testSquares(int a, int b, int expected) {
		int result = squares(a, b);
		System.out.println(result);
		assert expected == result;
	}// End of Test

}// End of Class
