package com.datastructures.hackerrank.arrays.easy;

import java.util.List;

public class DynamicArraySolution {

	// Complete the dynamicArray function below.
	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		return null;
	}

	public static void main(String[] args) {

	}// End of Main

	static void testDynamicArray(int n, List<List<Integer>> queries, List<Integer> expected) {
		List<Integer> result = dynamicArray(n, queries);
		assert result.size() == expected.size();
		for (int i = 0; i < expected.size(); i++) {
			assert result.get(i).compareTo(expected.get(i)) == 0;
		}
	}// End of Test

}// End of Class
