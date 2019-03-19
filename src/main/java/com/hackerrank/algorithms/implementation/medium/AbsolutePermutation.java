package com.hackerrank.algorithms.implementation.medium;

import java.io.File;
import java.util.Scanner;

public class AbsolutePermutation {

	/**
	 * <p>
	 * Complete the absolutePermutation function below.
	 * </p>
	 * <p>
	 * It should return an integer that represents the smallest lexicographically
	 * smallest permutation, or if there is none.
	 * </p>
	 * <p>
	 * Idea for the solution is to understand the numeric distribution. For
	 * |pos[i]-i|=k there are two possible outcomes.
	 * <li>pos[i] = i+k</li>
	 * <li>pos[i] = i-k</li>
	 * </p>
	 * <p>
	 * As such, a given k constant has to be such that, it must be possible to shift
	 * values in a mappable distribution. Any odd value of n would violate this
	 * condition. hence n%2==0. Any k value must be also evenly mapped to n. Thus n
	 * % k == 0. Finally, any value of k that is larger than n/2 would automatically
	 * shift values to far to match.
	 * </p>
	 * <p>
	 * For pos[i] == i+k or i-k where i < n; for n = 10; k = 2 <br>
	 * i | i+k | i-k <br>
	 * --------------------<br>
	 * 1 | 3 | -1<br>
	 * 2 | 4 | 0<br>
	 * 3 | 5 | 1<br>
	 * 4 | 6 | 2<br>
	 * 5 | 7 | 3<br>
	 * 6 | 8 | 4<br>
	 * 7 | 9 | 5<br>
	 * 8 | 10 | 6<br>
	 * 9 | 11 | 7<br>
	 * 10 | 12 | 8<br>
	 * </p>
	 * 
	 * <p>
	 * As at the above distribution shift, pos[1] can be mapped to i = 3 or i = -1.
	 * Since it is only possible to select within the range of permutation (1...n),
	 * for pos[1], it must be selected as 3. This is the same upto k values of
	 * <i>push</i> of i+k column, and it is repeated for any other k value.
	 * Similarly, for i-k, there is a <i>pull</i>, making initial value of P(n) to
	 * shift to index+k, thus making pos[3] = 1. Why not select 5 for pos[3]? This
	 * is in order to match the other shifting values on cycling values of
	 * <b>i+2*k</b>
	 * </p>
	 * 
	 * @param n : value to permute
	 * @param k : shifting constant
	 * @return possible absolute permutation series
	 */
	static int[] absolutePermutation(int n, int k) {

		if (k == 0) {
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				int v = i + 1;
				r[i] = v;
			}
			return r;
		}

		// !NOTE! : must combine
		// n % 2 == 0 && n % k == 0 && (n / 2) >= k
		if (n % (2 * k) == 0) {
			int[] r = new int[n];
			int i = 0;
			while (i < n) {
				// pull to k level
				int pull = i;
				for (int j = i + 1; j <= pull + k; j++, i++) {
					int v = j + k;
					r[i] = v;
				}
				// push to k level
				int push = i;
				for (int j = i + 1; j <= push + k; j++, i++) {
					int v = i + 1 - k;
					r[i] = v;
				}
			}
			return r;
		}

		return new int[] { -1 };

	}// End of Method

	public static void main(String[] args) {
		testAbsolutePermutation(2, 1, new int[] { 2, 1 });
		testAbsolutePermutation(3, 0, new int[] { 1, 2, 3 });
		testAbsolutePermutation(3, 2, new int[] { -1 });
		testAbsolutePermutation(10, 5, new int[] { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 });
		testAbsolutePermutation(7, 5, new int[] { -1 });
		testAbsolutePermutation(2, 0, new int[] { 1, 2 });
		testAbsolutePermutation(1, 0, new int[] { 1 });
		testAbsolutePermutation(1, 1, new int[] { -1 });
		testAbsolutePermutation(10, 0, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
		testAbsolutePermutation(6, 0, new int[] { 1, 2, 3, 4, 5, 6 });
		testAbsolutePermutation(6, 3, new int[] { 4, 5, 6, 1, 2, 3 });
		testAbsolutePermutation(12, 3, new int[] { 4, 5, 6, 1, 2, 3, 10, 11, 12, 7, 8, 9 });
		testAbsolutePermutation(8, 2, new int[] { 3, 4, 1, 2, 7, 8, 5, 6 });
		testAbsolutePermutation(8, 4, new int[] { 5, 6, 7, 8, 1, 2, 3, 4 });
		testAbsolutePermutation(9, 1, new int[] { -1 });
		testAbsolutePermutation(10, 1, new int[] { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9 });
		testAbsolutePermutation(16, 15, new int[] { -1 });
//
		testInput12();
		testInput13();

	}// End of Main

	static void testInput12() {

		String dir = "src/main/resources/algorithms/implementation/absolutepermutation/";
		File inputFile = new File(dir + "input12.txt");
		File outputFile = new File(dir + "output12.txt");

		try {

			Scanner inputScanner = new Scanner(inputFile);

			int totalNumOfLines = inputScanner.nextInt();

			inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			Scanner outputScanner = new Scanner(outputFile);

			outputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int lineNum = 0; lineNum < totalNumOfLines; lineNum++) {

				String[] nk = inputScanner.nextLine().split(" ");

				int n = Integer.parseInt(nk[0]);

				int k = Integer.parseInt(nk[1]);

				String[] output = outputScanner.nextLine().split(" ");

				int[] expected = new int[output.length];
				int i = 0;
				for (String val : output) {
					expected[i] = Integer.valueOf(val);
					i++;
				}

				testAbsolutePermutation(n, k, expected);

			}

			inputScanner.close();
			outputScanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of Test from file source

	static void testInput13() {

		String dir = "src/main/resources/algorithms/implementation/absolutepermutation/";
		File inputFile = new File(dir + "input13.txt");
		File outputFile = new File(dir + "output13.txt");

		try {

			Scanner inputScanner = new Scanner(inputFile);

			int totalNumOfLines = inputScanner.nextInt();

			inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			Scanner outputScanner = new Scanner(outputFile);

			outputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int lineNum = 0; lineNum < totalNumOfLines; lineNum++) {

				String[] nk = inputScanner.nextLine().split(" ");

				int n = Integer.parseInt(nk[0]);

				int k = Integer.parseInt(nk[1]);

				String[] output = outputScanner.nextLine().split(" ");

				int[] expected = new int[output.length];
				int i = 0;
				for (String val : output) {
					expected[i] = Integer.valueOf(val);
					i++;
				}

				testAbsolutePermutation(n, k, expected);

			}

			inputScanner.close();
			outputScanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of Test from file source

	static void testAbsolutePermutation(int n, int k, int[] expected) {
		int[] result = absolutePermutation(n, k);
		System.out.print("For n : " + n + " and k : " + k + " Result :");
//		for (int value : result) {
//			System.out.print(" " + value);
//		}
		System.out.println("");
		assert expected.length == result.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i] == result[i];
		}
	}// End of Test

}// End of Class
