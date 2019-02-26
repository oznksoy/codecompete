package com.algorithms.hackerrank.implementation.medium;

public class GridSearchSolution {

	// Complete the gridSearch function below.
	static String gridSearch(String[] grid, String[] pattern) {

		int gridRowCount = grid.length;
		int gridColumnCount = grid[0].length();

		int patternRowCount = pattern.length;
		int patternColumnCount = pattern[0].length();

		for (int v = 0; v <= gridRowCount - patternRowCount; v++) {
			for (int h = 0; h <= gridColumnCount - patternColumnCount; h++) {
				boolean isMatch = false;
				for (int pv = 0; pv < patternRowCount; pv++) {
					String toCheck = grid[v + pv].substring(h, h + patternColumnCount);
					if (toCheck.equals(pattern[pv])) {
						isMatch = true;
					} else {
						isMatch = false;
						break;
					}
				}
				if (isMatch) {
					return "YES";
				}
			}
		}

		return "NO";

	}// End of Method

	public static void main(String[] args) {

		testGridSearch(//
				new String[] { //
						"1234567890", //
						"0987654321", //
						"1111111111", //
						"1111111111", //
						"2222222222" //
				}, //
				new String[] { //
						"876543", //
						"111111", //
						"111111"//
				}, //
				"YES");

		testGridSearch(//
				new String[] { //
						"7283455864", //
						"6731158619", //
						"8988242643", //
						"3830589324", //
						"2229505813", //
						"5633845374", //
						"6473530293", //
						"7053106601", //
						"0834282956", //
						"4607924137"//
				}, //
				new String[] { //
						"9505", //
						"3845", //
						"3530"//
				}, //
				"YES");

		testGridSearch(//
				new String[] { //
						"400453592126560", //
						"114213133098692", //
						"474386082879648", //
						"522356951189169", //
						"887109450487496", //
						"252802633388782", //
						"502771484966748", //
						"075975207693780", //
						"511799789562806", //
						"404007454272504", //
						"549043809916080", //
						"962410809534811", //
						"445893523733475", //
						"768705303214174", //
						"650629270887160"//
				}, //
				new String[] { //
						"99", //
						"99" //
				}, //
				"NO");

		testGridSearch(//
				new String[] { //
						"400453592126560", //
						"114213133098692", //
						"474386082879648", //
						"522356951189169", //
						"887109450487496", //
						"252802633388782", //
						"502771484966748", //
						"075975207693780", //
						"511799789562806", //
						"404007454272504", //
						"549043809916080", //
						"962410809534811", //
						"445893523733475", //
						"768705303214174", //
						"650629270887160"//
				}, //
				new String[] { //
						"33475", //
						"14174", //
						"87160" //
				}, //
				"YES");

		testGridSearch(//
				new String[] { //
						"400453592126560", //
						"114213133098692", //
						"474386082879648", //
						"522356951189169", //
						"887109450487496", //
						"252802633388782", //
						"502771484966748", //
						"075975207693780", //
						"511799789562806", //
						"404007454272504", //
						"549043809916080", //
						"962410809534811", //
						"445893523733475", //
						"768705303214174", //
						"650629270887160"//
				}, //
				new String[] { //
						"87160", //
						"14174", //
						"33475", //
				}, //
				"NO");

		testGridSearch(//
				new String[] { //
						"400453592126560", //
						"114213133098692", //
						"474386082879648", //
						"522356951189169", //
						"887109450487496", //
						"252802633388782", //
						"502771484966748", //
						"075975207693780", //
						"511799789562806", //
						"404007454272504", //
						"549043809916080", //
						"962410809534811", //
						"445893523733475", //
						"768705303214174", //
						"650629270887160"//
				}, //
				new String[] { //
						"40400", //
						"54904", //
						"44589", //
				}, //
				"NO");

	}// End of Main

	static void testGridSearch(String[] grid, String[] pattern, String expected) {
		String result = gridSearch(grid, pattern);
		System.out.println("Result : " + result);
		assert expected.equals(result);
	}// End of Test

}// End of Class
