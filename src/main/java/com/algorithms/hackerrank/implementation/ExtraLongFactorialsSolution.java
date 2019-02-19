package com.algorithms.hackerrank.implementation;

import java.math.BigInteger;

public class ExtraLongFactorialsSolution {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {

		BigInteger value = BigInteger.ONE;

		for(int i = 1; i <= n; i++) {
			BigInteger factor = BigInteger.valueOf(i);
			value = value.multiply(factor);
		}
		
		System.out.println(value);

	}// End of Method

	public static void main(String[] args) {
		extraLongFactorials(10);
	}

}// End of Class
