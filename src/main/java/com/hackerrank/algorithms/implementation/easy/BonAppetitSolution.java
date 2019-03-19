package com.hackerrank.algorithms.implementation.easy;

import java.util.Arrays;
import java.util.List;

public class BonAppetitSolution {

	// Complete the bonAppetit function below.
	static void bonAppetit(List<Integer> bill, int k, int b) {
		
		int total = 0;
		for(int i = 0; i < bill.size() ; i++) {
			if(i != k) {
				total += bill.get(i);
			}
		}
		
		int invoice = total/2;
		if(invoice == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(Math.abs(b - invoice));
		}
		
	}

	public static void main(String[] args) {

		bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 12); // expected "5"
		bonAppetit(Arrays.asList(3, 10, 2, 9), 1, 7); // expected "Bon Appetit"

	}
}
