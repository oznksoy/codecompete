package com.hackerrank.algorithms.implementation.easy;

public class LibraryFineSolution {

	// Complete the libraryFine function below.
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

		if (y1 > y2) {
			return 10000;
		} else if (y1 == y2) {
			if (m1 > m2) {
				return 500 * (m1 - m2);
			} else if (m1 == m2) {
				if (d1 > d2) {
					return 15 * (d1 - d2);
				}
			}
		}
		
		return 0;
		
	}// End of Method

	public static void main(String[] args) {
		testLibraryFine(9, 6, 2015, 6, 6, 2015, 45);
	}// End of Main

	static void testLibraryFine(int d1, int m1, int y1, int d2, int m2, int y2, int excepted) {
		int result = libraryFine(d1, m1, y1, d2, m2, y2);
		System.out.println(result);
		assert result == excepted;
	}// End of Test

}// End of Class
