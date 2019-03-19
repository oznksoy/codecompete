package com.hackerrank.datastructures.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class SparseArraysSolution {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {

		Map<String, Integer> inputMap = new HashMap<>();

		for (String key : strings) {
			inputMap.put(key, inputMap.get(key) == null ? 1 : inputMap.get(key) + 1);
		}

		int[] values = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			values[i] = inputMap.get(queries[i]) == null ? 0 : inputMap.get(queries[i]);
		}

		return values;

	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}// End of Main

	static void testCase1() {
		testMatchingStrings(//
				new String[] { //
						"aba", //
						"baba", //
						"aba", //
						"xzxb"//
				}, //
				new String[] { //
						"aba", //
						"xzxb", //
						"ab" //
				}, //
				new int[] { 2, 1, 0 }//
		);
	}// End of Test Case

	static void testCase2() {
		testMatchingStrings(//
				new String[] { //
						"def", //
						"de", //
						"fgh" //
				}, //
				new String[] { //
						"de", //
						"lmn", //
						"fgh" //
				}, //
				new int[] { 1, 0, 1 }//
		);
	}// End of Test Case

	static void testMatchingStrings(String[] strings, String[] queries, int[] expected) {
		int[] result = matchingStrings(strings, queries);
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert result[i] == expected[i];
		}
	}// End of Test

}// End of Class
