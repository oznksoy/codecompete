package com.datastructures.hackerrank.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class DynamicArraySolution {

	// Complete the dynamicArray function below.
	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<List<Integer>> seqList = new ArrayList<List<Integer>>();
		Integer lastAnswer = 0;
		for (int i = 0; i < n; i++) {
			seqList.add(new ArrayList<Integer>());
		}
		List<Integer> results = new ArrayList<Integer>();
		for (List<Integer> query : queries) {
			Integer qtype = query.get(0);
			if (qtype == 1) {
				queryTypeOne(n, lastAnswer, seqList, query);
			} else if (qtype == 2) {
				lastAnswer = queryTypeTwo(n, lastAnswer, seqList, query, results);
			}
		}
		return results;
	}// End of Method

	static void queryTypeOne(int n, Integer lastAnswer, List<List<Integer>> seqList, List<Integer> query) {
		int x = query.get(1);
		int seq = (x ^ lastAnswer.intValue()) % n;
		seqList.get(seq).add(query.get(2));
	}// End of Method

	static Integer queryTypeTwo(int n, Integer lastAnswer, List<List<Integer>> seqList, List<Integer> query,
			List<Integer> results) {
		int x = query.get(1);
		int seq = (x ^ lastAnswer.intValue()) % n;
		lastAnswer = seqList.get(seq).get(query.get(2) % seqList.get(seq).size());
		results.add(lastAnswer.intValue());
		return lastAnswer;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static List<List<Integer>> createInput(String... strings) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (String val : strings) {
			List<Integer> row = new ArrayList<Integer>();
			String[] vs = val.split(" ");
			for (String v : vs) {
				row.add(Integer.valueOf(v));
			}
			list.add(row);
		}
		return list;
	}// End of Method for Tests

	static List<Integer> createExpected(String string) {
		List<Integer> list = new ArrayList<Integer>();
		String[] vs = string.split(" ");
		for (String v : vs) {
			list.add(Integer.valueOf(v));
		}
		return list;
	}// End of Method for Tests

	static void testCase1() {
		testDynamicArray(2, //
				createInput(//
						"1 0 5", //
						"1 1 7", //
						"1 0 3", //
						"2 1 0", //
						"2 1 1" //
				), //
				createExpected("7 3") //
		);

	}// End of Method

	static void testDynamicArray(int n, List<List<Integer>> queries, List<Integer> expected) {
		List<Integer> result = dynamicArray(n, queries);
		assert result.size() == expected.size();
		for (int i = 0; i < expected.size(); i++) {
			assert result.get(i).compareTo(expected.get(i)) == 0;
		}
	}// End of Test

}// End of Class
