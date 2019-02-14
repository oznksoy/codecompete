package com.algorithms.hackerrank.implementation;

import java.util.Arrays;
import java.util.List;

public class MigratoryBirdsSolution {

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {

		int[] counts = new int[5];
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == 1) {
				counts[0] += 1;
			} else if (arr.get(i) == 2) {
				counts[1] += 1;
			} else if (arr.get(i) == 3) {
				counts[2] += 1;
			} else if (arr.get(i) == 4) {
				counts[3] += 1;
			} else if (arr.get(i) == 5) {
				counts[4] += 1;
			}
		}

		int maxCount = 0;
		int type = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > maxCount) {
				maxCount = counts[i];
				type = i + 1;
			}
		}
		return type;

	}

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 4, 4, 4, 5, 3);
		int result1 = migratoryBirds(list1);
		System.out.println(result1);		
		assert result1 == 4;

		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
		int result2 = migratoryBirds(list2);
		System.out.println(result2);		
		assert result2 == 3;
		
	}

}
