package com.algorithms.hackerrank.implementation.hard;

import java.util.ArrayList;
import java.util.List;

public class MatrixLayerRotationSolution {

	// Complete the matrixRotation function below.
	static void matrixRotation(List<List<Integer>> matrix, int r) {

	}// End of Method

	public static void main(String[] args) {

		// 3 4 8 12
		// 2 11 10 16
		// 1 7 6 15
		// 5 9 13 14
		testMatrixRotation(new ArrayList<List<Integer>>() {
			{
				add(new ArrayList<Integer>() {
					{
						add(1);
						add(2);
						add(3);
						add(4);
					}
				});
				add(new ArrayList<Integer>() {
					{
						add(5);
						add(6);
						add(7);
						add(8);
					}
				});
				add(new ArrayList<Integer>() {
					{
						add(9);
						add(10);
						add(11);
						add(12);
					}
				});
				add(new ArrayList<Integer>() {
					{
						add(13);
						add(14);
						add(15);
						add(16);
					}
				});
			}
		}, 2);
		
		

	}// End of Main

	static void testMatrixRotation(List<List<Integer>> matrix, int r) {

	}// End of Test

}// End of Class
