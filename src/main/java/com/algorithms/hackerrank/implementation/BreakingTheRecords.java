package com.algorithms.hackerrank.implementation;

public class BreakingTheRecords {

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {

		int max = scores[0];
		int min = scores[0];

		int maxCount = 0;
		int minCount = 0;

		for (int i = 1; i < scores.length; i++) {
			int currentValue = scores[i];
			if (currentValue > max) {
				maxCount++;
				max = currentValue;
			} else if (currentValue < min) {
				minCount++;
				min = currentValue;
			}
		}

		int[] result = { maxCount, minCount };

		return result;

	}

	public static void main(String[] args) {

		int[] scores1 = { 10, 5, 20, 20, 4, 5, 2, 25, 1 };
		printArr(breakingRecords(scores1));
		int[] scores2 = { 3, 4, 21, 36, 10, 28, 35, 5, 24, 42 };
		printArr(breakingRecords(scores2));
	}
	
	static void printArr(int[] array) {
		String output = "";
		for(int value : array) {
			output = output + " " + value;
		}
		
		System.out.println(output);
	}

}
