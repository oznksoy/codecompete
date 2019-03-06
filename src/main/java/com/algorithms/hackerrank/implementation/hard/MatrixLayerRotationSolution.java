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

		// 28 27 26 25
		// 22 9 15 19
		// 16 8 21 13
		// 10 14 20 7
		// 4 3 2 1
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
						add(7);
						add(8);
						add(9);
						add(10);
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
				add(new ArrayList<Integer>() {
					{
						add(19);
						add(20);
						add(21);
						add(22);
					}
				});
				add(new ArrayList<Integer>() {
					{
						add(25);
						add(26);
						add(27);
						add(28);
					}
				});
			}
		}, 7);

	}// End of Main

	static void testMatrixRotation(List<List<Integer>> matrix, int r) {

	}// End of Test

}// End of Class
