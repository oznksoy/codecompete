package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * s is a string of lower case English letters that is repeated infinitely.
 * Given an integer, n, find and print the number of letter a's in the first n
 * letters of the infinite string.
 * </p>
 * <li>n : number of characters to consider. 1 <= s <= 100</li>
 * <li>s : a single string. 1 <= n <= 10^12</li>
 * 
 * @author Ozan Aksoy
 *
 */
public class RepeatedStringSolution {

	// Complete the repeatedString function below.
	// Repeat s upto n length. Count the 'a' letters and return.
	static long repeatedString(String s, long n) {
		long length = s.length();

		long count = 0;
		if (length < n) {
			long rem = n % length;
			for (int i = 0; i < s.length(); i++) {
				if ('a' == s.charAt(i)) {
					count++;
				}
			}
			count = count * ((n - rem) / length);

			for (int i = 0; i < rem; i++) {
				if ('a' == s.charAt(i)) {
					count++;
				}
			}
		} else {
			String subString = s.substring(0, (int) n);
			for (int i = 0; i < subString.length(); i++) {
				if ('a' == s.charAt(i)) {
					count++;
				}
			}
		}

		return count;
	}// End of Method

	public static void main(String[] args) {
		testRepeatedString("aba", 10, 7);
		testRepeatedString("a", 1000000000000l, 1000000000000l);
	}// End of Main

	static void testRepeatedString(String s, long n, long expected) {
		long result = repeatedString(s, n);
		System.out.println(result);
		assert expected == result;
	}// End of Main

}// End of Class
