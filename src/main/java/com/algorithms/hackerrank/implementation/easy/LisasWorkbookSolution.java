package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Lisa just got a new math workbook. A workbook contains exercise problems,
 * grouped into chapters. Lisa believes a problem to be special if its index
 * (within a chapter) is the same as the page number where it's located.
 * </p>
 * 
 * 
 * @author Ozan Aksoy
 *
 */
public class LisasWorkbookSolution {

	/**
	 * <p>
	 * Complete the workbook function in the editor below. It should return an
	 * integer that represents the number of special problems in the workbook.
	 * </p>
	 * 
	 * @param n   : an integer that denotes the number of chapters
	 * @param k   : an integer that denotes the maximum number of problems per page
	 * @param arr : an array of integers that denote the number of problems in each
	 *            chapter
	 * @return number of "special" problems in the workbook
	 */
	static int workbook(int n, int k, int[] arr) {

		int index = 0;
		int totalPageCount = 0;
		int result = 0;
		while (index < arr.length) {
			int problemCount = arr[index];
			int lastPageProblemCount = problemCount % k;
			int pageCount = (problemCount - lastPageProblemCount) / k;
			int page = totalPageCount + 1;
			int p = 1;
			for (; page <= totalPageCount + pageCount; page++) {
				int problemsUpTo = k * p;
				int problemFrom = k * (p - 1);
				if (problemsUpTo >= page && page > problemFrom) {
					result++;
				}
				p++;
			}
			if (lastPageProblemCount != 0) {
				p--;
				int problemsUpTo = lastPageProblemCount + (k * p);
				int problemFrom = k * p;
				if (problemsUpTo >= page && page > problemFrom) {
					result++;
				}
				pageCount++;
			}
			totalPageCount += pageCount;
			index++;
		}

		return result;
	}// End of Method

	public static void main(String[] args) {
		testWorkBook(5, 3, new int[] { 4, 2, 6, 1, 10 }, 4);
		testWorkBook(10, 5, new int[] { 3, 8, 15, 11, 14, 1, 9, 2, 24, 31 }, 8);
	}// End of Main

	static void testWorkBook(int n, int k, int[] arr, int expected) {
		int result = workbook(n, k, arr);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
