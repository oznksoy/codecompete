package com.hackerrank.datastructures.linkedlist.hints;

public class BitwiseOperatorTrick {

	/**
	 * Very fast division and multiplications
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 100;
		System.out.println(value << 2); // Quadruple in value
		System.out.println(value << 1); // Doubles in value
		System.out.println(value >> 1); // Half of value
		System.out.println(value >> 2); // Quarter of value
	}

}
