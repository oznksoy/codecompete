package com.algorithms.hackerrank.implementation.medium;

/**
 * <p>
 * Given the time in numerals we may convert it into words, as shown below:
 * </p>
 * <p>
 * <li>At minutes = 0, use "o'clock"</li>
 * <li>For 1&lt= minutes &lt= 30, use "past"</li>
 * <li>and for 30 &lt minutes, use "to"</li>
 * </p>
 * <p>
 * Note the space between the apostrophe and clock in o' clock. Write a program
 * which prints the time in words for the input given in the format described.
 * </p>
 * <p>
 * <li>5:00 - five o' clock</li>
 * <li>5:01 - one minute past five</li>
 * <li>5:10 - ten minutes past five</li>
 * <li>5:15 - quarter past five</li>
 * <li>5:30 - half past five</li>
 * <li>5:40 - twenty minutes to six</li>
 * <li>5:45 - quarter to six</li>
 * <li>5:47 - thirteen minutes to six</li>
 * <li>5:28 - twenty eight minutes past five</li>
 * </p>
 * <p>
 * Note: h : hour -- 1 &lt= h &lt= 12 and m : minute -- 0 &lt= m & &lt= 59
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class TheTimeInWordsSolution {

	// Complete the timeInWords function below.
	/**
	 * 
	 * @param h : hour -- 1 &lt= h &lt= 12
	 * @param m : minute -- 0 &lt= m & &lt= 59
	 * @return
	 */
	static String timeInWords(int h, int m) {

		String[] texts = getNumberAsTextArray();

		boolean isUnderHalf = m / 30 < 1 ? true : false;
		int min = m % 30;

		String minute = "";
		String pronoun = "";
		String hour = "";

		if (isUnderHalf) {
			hour += texts[h];
			minute += texts[min];
			if (min == 15) {
				pronoun = "past";
			} else if (min == 1) {
				pronoun = "minute past";
			} else if (min != 0) {
				pronoun = "minutes past";
			}
		} else {
			min = 30 - min;
			minute += texts[min];
			if (min == 30) {
				hour += texts[h];
				pronoun = "past";
			} else {
				if ((h + 1) % 12 == 0) {
					hour += texts[12];
				} else {
					hour += texts[(h + 1) % 12];
				}
				if (min == 15) {
					pronoun = "to";
				} else if (min == 1) {
					pronoun = "minute to";
				} else if (min != 0) {
					pronoun = "minutes to";
				}
			}
		}

		String result = constructClause(hour, minute, pronoun);

		return result;

	}// End of Method

	static String constructClause(String hour, String minute, String pronoun) {
		if (pronoun.isEmpty()) {
			return hour + " " + minute;
		} else {
			return minute + " " + pronoun + " " + hour;
		}
	}// End of Method

	static String[] getNumberAsTextArray() {

		String[] arr = new String[31]; // 0 to 30

		arr[0] = "o' clock";
		arr[1] = "one";
		arr[2] = "two";
		arr[3] = "three";
		arr[4] = "four";
		arr[5] = "five";
		arr[6] = "six";
		arr[7] = "seven";
		arr[8] = "eight";
		arr[9] = "nine";
		arr[10] = "ten";
		arr[11] = "eleven";
		arr[12] = "twelve";
		arr[13] = "thirteen";
		arr[14] = "fourteen";
		arr[15] = "quarter";
		arr[16] = "sixteen";
		arr[17] = "seventeen";
		arr[18] = "eighteen";
		arr[19] = "nineteen";
		arr[20] = "twenty";
		arr[21] = "twenty one";
		arr[22] = "twenty two";
		arr[23] = "twenty three";
		arr[24] = "twenty four";
		arr[25] = "twenty five";
		arr[26] = "twenty six";
		arr[27] = "twenty seven";
		arr[28] = "twenty eight";
		arr[29] = "twenty nine";
		arr[30] = "half";

		return arr;
	}// End of Method

	public static void main(String[] args) {

		testTimeInWords(1, 0, "one o' clock");
		testTimeInWords(1, 1, "one minute past one");
		testTimeInWords(1, 2, "two minutes past one");
		testTimeInWords(1, 3, "three minutes past one");
		testTimeInWords(1, 4, "four minutes past one");
		testTimeInWords(1, 5, "five minutes past one");
		testTimeInWords(1, 6, "six minutes past one");
		testTimeInWords(1, 7, "seven minutes past one");
		testTimeInWords(1, 8, "eight minutes past one");
		testTimeInWords(1, 9, "nine minutes past one");
		testTimeInWords(1, 10, "ten minutes past one");
		testTimeInWords(1, 11, "eleven minutes past one");
		testTimeInWords(1, 12, "twelve minutes past one");
		testTimeInWords(1, 13, "thirteen minutes past one");
		testTimeInWords(1, 14, "fourteen minutes past one");
		testTimeInWords(1, 15, "quarter past one");
		testTimeInWords(1, 16, "sixteen minutes past one");
		testTimeInWords(1, 17, "seventeen minutes past one");
		testTimeInWords(1, 18, "eighteen minutes past one");
		testTimeInWords(1, 19, "nineteen minutes past one");
		testTimeInWords(1, 20, "twenty minutes past one");
		testTimeInWords(1, 21, "twenty one minutes past one");
		testTimeInWords(1, 22, "twenty two minutes past one");
		testTimeInWords(1, 23, "twenty three minutes past one");
		testTimeInWords(1, 24, "twenty four minutes past one");
		testTimeInWords(1, 25, "twenty five minutes past one");
		testTimeInWords(1, 26, "twenty six minutes past one");
		testTimeInWords(1, 27, "twenty seven minutes past one");
		testTimeInWords(1, 28, "twenty eight minutes past one");
		testTimeInWords(1, 29, "twenty nine minutes past one");
		testTimeInWords(1, 30, "half past one");
		testTimeInWords(1, 31, "twenty nine minutes to two");
		testTimeInWords(1, 32, "twenty eight minutes to two");
		testTimeInWords(1, 33, "twenty seven minutes to two");
		testTimeInWords(1, 34, "twenty six minutes to two");
		testTimeInWords(1, 35, "twenty five minutes to two");
		testTimeInWords(1, 36, "twenty four minutes to two");
		testTimeInWords(1, 37, "twenty three minutes to two");
		testTimeInWords(1, 38, "twenty two minutes to two");
		testTimeInWords(1, 39, "twenty one minutes to two");
		testTimeInWords(1, 40, "twenty minutes to two");
		testTimeInWords(1, 41, "nineteen minutes to two");
		testTimeInWords(1, 42, "eighteen minutes to two");
		testTimeInWords(1, 43, "seventeen minutes to two");
		testTimeInWords(1, 44, "sixteen minutes to two");
		testTimeInWords(1, 45, "quarter to two");
		testTimeInWords(1, 46, "fourteen minutes to two");
		testTimeInWords(1, 47, "thirteen minutes to two");
		testTimeInWords(1, 48, "twelve minutes to two");
		testTimeInWords(1, 49, "eleven minutes to two");
		testTimeInWords(1, 50, "ten minutes to two");
		testTimeInWords(1, 51, "nine minutes to two");
		testTimeInWords(1, 52, "eight minutes to two");
		testTimeInWords(1, 53, "seven minutes to two");
		testTimeInWords(1, 54, "six minutes to two");
		testTimeInWords(1, 55, "five minutes to two");
		testTimeInWords(1, 56, "four minutes to two");
		testTimeInWords(1, 57, "three minutes to two");
		testTimeInWords(1, 58, "two minutes to two");
		testTimeInWords(1, 59, "one minute to two");

		testTimeInWords(2, 0, "two o' clock");
		testTimeInWords(2, 1, "one minute past two");
		testTimeInWords(2, 2, "two minutes past two");
		testTimeInWords(2, 3, "three minutes past two");
		testTimeInWords(2, 4, "four minutes past two");
		testTimeInWords(2, 5, "five minutes past two");
		testTimeInWords(2, 6, "six minutes past two");
		testTimeInWords(2, 7, "seven minutes past two");
		testTimeInWords(2, 8, "eight minutes past two");
		testTimeInWords(2, 9, "nine minutes past two");
		testTimeInWords(2, 10, "ten minutes past two");
		testTimeInWords(2, 11, "eleven minutes past two");
		testTimeInWords(2, 12, "twelve minutes past two");
		testTimeInWords(2, 13, "thirteen minutes past two");
		testTimeInWords(2, 14, "fourteen minutes past two");
		testTimeInWords(2, 15, "quarter past two");
		testTimeInWords(2, 16, "sixteen minutes past two");
		testTimeInWords(2, 17, "seventeen minutes past two");
		testTimeInWords(2, 18, "eighteen minutes past two");
		testTimeInWords(2, 19, "nineteen minutes past two");
		testTimeInWords(2, 20, "twenty minutes past two");
		testTimeInWords(2, 21, "twenty one minutes past two");
		testTimeInWords(2, 22, "twenty two minutes past two");
		testTimeInWords(2, 23, "twenty three minutes past two");
		testTimeInWords(2, 24, "twenty four minutes past two");
		testTimeInWords(2, 25, "twenty five minutes past two");
		testTimeInWords(2, 26, "twenty six minutes past two");
		testTimeInWords(2, 27, "twenty seven minutes past two");
		testTimeInWords(2, 28, "twenty eight minutes past two");
		testTimeInWords(2, 29, "twenty nine minutes past two");
		testTimeInWords(2, 30, "half past two");
		testTimeInWords(2, 31, "twenty nine minutes to three");
		testTimeInWords(2, 32, "twenty eight minutes to three");
		testTimeInWords(2, 33, "twenty seven minutes to three");
		testTimeInWords(2, 34, "twenty six minutes to three");
		testTimeInWords(2, 35, "twenty five minutes to three");
		testTimeInWords(2, 36, "twenty four minutes to three");
		testTimeInWords(2, 37, "twenty three minutes to three");
		testTimeInWords(2, 38, "twenty two minutes to three");
		testTimeInWords(2, 39, "twenty one minutes to three");
		testTimeInWords(2, 40, "twenty minutes to three");
		testTimeInWords(2, 41, "nineteen minutes to three");
		testTimeInWords(2, 42, "eighteen minutes to three");
		testTimeInWords(2, 43, "seventeen minutes to three");
		testTimeInWords(2, 44, "sixteen minutes to three");
		testTimeInWords(2, 45, "quarter to three");
		testTimeInWords(2, 46, "fourteen minutes to three");
		testTimeInWords(2, 47, "thirteen minutes to three");
		testTimeInWords(2, 48, "twelve minutes to three");
		testTimeInWords(2, 49, "eleven minutes to three");
		testTimeInWords(2, 50, "ten minutes to three");
		testTimeInWords(2, 51, "nine minutes to three");
		testTimeInWords(2, 52, "eight minutes to three");
		testTimeInWords(2, 53, "seven minutes to three");
		testTimeInWords(2, 54, "six minutes to three");
		testTimeInWords(2, 55, "five minutes to three");
		testTimeInWords(2, 56, "four minutes to three");
		testTimeInWords(2, 57, "three minutes to three");
		testTimeInWords(2, 58, "two minutes to three");
		testTimeInWords(2, 59, "one minute to three");

		testTimeInWords(3, 0, "three o' clock");
		testTimeInWords(3, 1, "one minute past three");
		testTimeInWords(3, 2, "two minutes past three");
		testTimeInWords(3, 3, "three minutes past three");
		testTimeInWords(3, 4, "four minutes past three");
		testTimeInWords(3, 5, "five minutes past three");
		testTimeInWords(3, 6, "six minutes past three");
		testTimeInWords(3, 7, "seven minutes past three");
		testTimeInWords(3, 8, "eight minutes past three");
		testTimeInWords(3, 9, "nine minutes past three");
		testTimeInWords(3, 10, "ten minutes past three");
		testTimeInWords(3, 11, "eleven minutes past three");
		testTimeInWords(3, 12, "twelve minutes past three");
		testTimeInWords(3, 13, "thirteen minutes past three");
		testTimeInWords(3, 14, "fourteen minutes past three");
		testTimeInWords(3, 15, "quarter past three");
		testTimeInWords(3, 16, "sixteen minutes past three");
		testTimeInWords(3, 17, "seventeen minutes past three");
		testTimeInWords(3, 18, "eighteen minutes past three");
		testTimeInWords(3, 19, "nineteen minutes past three");
		testTimeInWords(3, 20, "twenty minutes past three");
		testTimeInWords(3, 21, "twenty one minutes past three");
		testTimeInWords(3, 22, "twenty two minutes past three");
		testTimeInWords(3, 23, "twenty three minutes past three");
		testTimeInWords(3, 24, "twenty four minutes past three");
		testTimeInWords(3, 25, "twenty five minutes past three");
		testTimeInWords(3, 26, "twenty six minutes past three");
		testTimeInWords(3, 27, "twenty seven minutes past three");
		testTimeInWords(3, 28, "twenty eight minutes past three");
		testTimeInWords(3, 29, "twenty nine minutes past three");
		testTimeInWords(3, 30, "half past three");
		testTimeInWords(3, 31, "twenty nine minutes to four");
		testTimeInWords(3, 32, "twenty eight minutes to four");
		testTimeInWords(3, 33, "twenty seven minutes to four");
		testTimeInWords(3, 34, "twenty six minutes to four");
		testTimeInWords(3, 35, "twenty five minutes to four");
		testTimeInWords(3, 36, "twenty four minutes to four");
		testTimeInWords(3, 37, "twenty three minutes to four");
		testTimeInWords(3, 38, "twenty two minutes to four");
		testTimeInWords(3, 39, "twenty one minutes to four");
		testTimeInWords(3, 40, "twenty minutes to four");
		testTimeInWords(3, 41, "nineteen minutes to four");
		testTimeInWords(3, 42, "eighteen minutes to four");
		testTimeInWords(3, 43, "seventeen minutes to four");
		testTimeInWords(3, 44, "sixteen minutes to four");
		testTimeInWords(3, 45, "quarter to four");
		testTimeInWords(3, 46, "fourteen minutes to four");
		testTimeInWords(3, 47, "thirteen minutes to four");
		testTimeInWords(3, 48, "twelve minutes to four");
		testTimeInWords(3, 49, "eleven minutes to four");
		testTimeInWords(3, 50, "ten minutes to four");
		testTimeInWords(3, 51, "nine minutes to four");
		testTimeInWords(3, 52, "eight minutes to four");
		testTimeInWords(3, 53, "seven minutes to four");
		testTimeInWords(3, 54, "six minutes to four");
		testTimeInWords(3, 55, "five minutes to four");
		testTimeInWords(3, 56, "four minutes to four");
		testTimeInWords(3, 57, "three minutes to four");
		testTimeInWords(3, 58, "two minutes to four");
		testTimeInWords(3, 59, "one minute to four");

		testTimeInWords(4, 0, "four o' clock");
		testTimeInWords(4, 1, "one minute past four");
		testTimeInWords(4, 2, "two minutes past four");
		testTimeInWords(4, 3, "three minutes past four");
		testTimeInWords(4, 4, "four minutes past four");
		testTimeInWords(4, 5, "five minutes past four");
		testTimeInWords(4, 6, "six minutes past four");
		testTimeInWords(4, 7, "seven minutes past four");
		testTimeInWords(4, 8, "eight minutes past four");
		testTimeInWords(4, 9, "nine minutes past four");
		testTimeInWords(4, 10, "ten minutes past four");
		testTimeInWords(4, 11, "eleven minutes past four");
		testTimeInWords(4, 12, "twelve minutes past four");
		testTimeInWords(4, 13, "thirteen minutes past four");
		testTimeInWords(4, 14, "fourteen minutes past four");
		testTimeInWords(4, 15, "quarter past four");
		testTimeInWords(4, 16, "sixteen minutes past four");
		testTimeInWords(4, 17, "seventeen minutes past four");
		testTimeInWords(4, 18, "eighteen minutes past four");
		testTimeInWords(4, 19, "nineteen minutes past four");
		testTimeInWords(4, 20, "twenty minutes past four");
		testTimeInWords(4, 21, "twenty one minutes past four");
		testTimeInWords(4, 22, "twenty two minutes past four");
		testTimeInWords(4, 23, "twenty three minutes past four");
		testTimeInWords(4, 24, "twenty four minutes past four");
		testTimeInWords(4, 25, "twenty five minutes past four");
		testTimeInWords(4, 26, "twenty six minutes past four");
		testTimeInWords(4, 27, "twenty seven minutes past four");
		testTimeInWords(4, 28, "twenty eight minutes past four");
		testTimeInWords(4, 29, "twenty nine minutes past four");
		testTimeInWords(4, 30, "half past four");
		testTimeInWords(4, 31, "twenty nine minutes to five");
		testTimeInWords(4, 32, "twenty eight minutes to five");
		testTimeInWords(4, 33, "twenty seven minutes to five");
		testTimeInWords(4, 34, "twenty six minutes to five");
		testTimeInWords(4, 35, "twenty five minutes to five");
		testTimeInWords(4, 36, "twenty four minutes to five");
		testTimeInWords(4, 37, "twenty three minutes to five");
		testTimeInWords(4, 38, "twenty two minutes to five");
		testTimeInWords(4, 39, "twenty one minutes to five");
		testTimeInWords(4, 40, "twenty minutes to five");
		testTimeInWords(4, 41, "nineteen minutes to five");
		testTimeInWords(4, 42, "eighteen minutes to five");
		testTimeInWords(4, 43, "seventeen minutes to five");
		testTimeInWords(4, 44, "sixteen minutes to five");
		testTimeInWords(4, 45, "quarter to five");
		testTimeInWords(4, 46, "fourteen minutes to five");
		testTimeInWords(4, 47, "thirteen minutes to five");
		testTimeInWords(4, 48, "twelve minutes to five");
		testTimeInWords(4, 49, "eleven minutes to five");
		testTimeInWords(4, 50, "ten minutes to five");
		testTimeInWords(4, 51, "nine minutes to five");
		testTimeInWords(4, 52, "eight minutes to five");
		testTimeInWords(4, 53, "seven minutes to five");
		testTimeInWords(4, 54, "six minutes to five");
		testTimeInWords(4, 55, "five minutes to five");
		testTimeInWords(4, 56, "four minutes to five");
		testTimeInWords(4, 57, "three minutes to five");
		testTimeInWords(4, 58, "two minutes to five");
		testTimeInWords(4, 59, "one minute to five");

		testTimeInWords(5, 0, "five o' clock");
		testTimeInWords(5, 1, "one minute past five");
		testTimeInWords(5, 2, "two minutes past five");
		testTimeInWords(5, 3, "three minutes past five");
		testTimeInWords(5, 4, "four minutes past five");
		testTimeInWords(5, 5, "five minutes past five");
		testTimeInWords(5, 6, "six minutes past five");
		testTimeInWords(5, 7, "seven minutes past five");
		testTimeInWords(5, 8, "eight minutes past five");
		testTimeInWords(5, 9, "nine minutes past five");
		testTimeInWords(5, 10, "ten minutes past five");
		testTimeInWords(5, 11, "eleven minutes past five");
		testTimeInWords(5, 12, "twelve minutes past five");
		testTimeInWords(5, 13, "thirteen minutes past five");
		testTimeInWords(5, 14, "fourteen minutes past five");
		testTimeInWords(5, 15, "quarter past five");
		testTimeInWords(5, 16, "sixteen minutes past five");
		testTimeInWords(5, 17, "seventeen minutes past five");
		testTimeInWords(5, 18, "eighteen minutes past five");
		testTimeInWords(5, 19, "nineteen minutes past five");
		testTimeInWords(5, 20, "twenty minutes past five");
		testTimeInWords(5, 21, "twenty one minutes past five");
		testTimeInWords(5, 22, "twenty two minutes past five");
		testTimeInWords(5, 23, "twenty three minutes past five");
		testTimeInWords(5, 24, "twenty four minutes past five");
		testTimeInWords(5, 25, "twenty five minutes past five");
		testTimeInWords(5, 26, "twenty six minutes past five");
		testTimeInWords(5, 27, "twenty seven minutes past five");
		testTimeInWords(5, 28, "twenty eight minutes past five");
		testTimeInWords(5, 29, "twenty nine minutes past five");
		testTimeInWords(5, 30, "half past five");
		testTimeInWords(5, 31, "twenty nine minutes to six");
		testTimeInWords(5, 32, "twenty eight minutes to six");
		testTimeInWords(5, 33, "twenty seven minutes to six");
		testTimeInWords(5, 34, "twenty six minutes to six");
		testTimeInWords(5, 35, "twenty five minutes to six");
		testTimeInWords(5, 36, "twenty four minutes to six");
		testTimeInWords(5, 37, "twenty three minutes to six");
		testTimeInWords(5, 38, "twenty two minutes to six");
		testTimeInWords(5, 39, "twenty one minutes to six");
		testTimeInWords(5, 40, "twenty minutes to six");
		testTimeInWords(5, 41, "nineteen minutes to six");
		testTimeInWords(5, 42, "eighteen minutes to six");
		testTimeInWords(5, 43, "seventeen minutes to six");
		testTimeInWords(5, 44, "sixteen minutes to six");
		testTimeInWords(5, 45, "quarter to six");
		testTimeInWords(5, 46, "fourteen minutes to six");
		testTimeInWords(5, 47, "thirteen minutes to six");
		testTimeInWords(5, 48, "twelve minutes to six");
		testTimeInWords(5, 49, "eleven minutes to six");
		testTimeInWords(5, 50, "ten minutes to six");
		testTimeInWords(5, 51, "nine minutes to six");
		testTimeInWords(5, 52, "eight minutes to six");
		testTimeInWords(5, 53, "seven minutes to six");
		testTimeInWords(5, 54, "six minutes to six");
		testTimeInWords(5, 55, "five minutes to six");
		testTimeInWords(5, 56, "four minutes to six");
		testTimeInWords(5, 57, "three minutes to six");
		testTimeInWords(5, 58, "two minutes to six");
		testTimeInWords(5, 59, "one minute to six");

		testTimeInWords(6, 0, "six o' clock");
		testTimeInWords(6, 1, "one minute past six");
		testTimeInWords(6, 2, "two minutes past six");
		testTimeInWords(6, 3, "three minutes past six");
		testTimeInWords(6, 4, "four minutes past six");
		testTimeInWords(6, 5, "five minutes past six");
		testTimeInWords(6, 6, "six minutes past six");
		testTimeInWords(6, 7, "seven minutes past six");
		testTimeInWords(6, 8, "eight minutes past six");
		testTimeInWords(6, 9, "nine minutes past six");
		testTimeInWords(6, 10, "ten minutes past six");
		testTimeInWords(6, 11, "eleven minutes past six");
		testTimeInWords(6, 12, "twelve minutes past six");
		testTimeInWords(6, 13, "thirteen minutes past six");
		testTimeInWords(6, 14, "fourteen minutes past six");
		testTimeInWords(6, 15, "quarter past six");
		testTimeInWords(6, 16, "sixteen minutes past six");
		testTimeInWords(6, 17, "seventeen minutes past six");
		testTimeInWords(6, 18, "eighteen minutes past six");
		testTimeInWords(6, 19, "nineteen minutes past six");
		testTimeInWords(6, 20, "twenty minutes past six");
		testTimeInWords(6, 21, "twenty one minutes past six");
		testTimeInWords(6, 22, "twenty two minutes past six");
		testTimeInWords(6, 23, "twenty three minutes past six");
		testTimeInWords(6, 24, "twenty four minutes past six");
		testTimeInWords(6, 25, "twenty five minutes past six");
		testTimeInWords(6, 26, "twenty six minutes past six");
		testTimeInWords(6, 27, "twenty seven minutes past six");
		testTimeInWords(6, 28, "twenty eight minutes past six");
		testTimeInWords(6, 29, "twenty nine minutes past six");
		testTimeInWords(6, 30, "half past six");
		testTimeInWords(6, 31, "twenty nine minutes to seven");
		testTimeInWords(6, 32, "twenty eight minutes to seven");
		testTimeInWords(6, 33, "twenty seven minutes to seven");
		testTimeInWords(6, 34, "twenty six minutes to seven");
		testTimeInWords(6, 35, "twenty five minutes to seven");
		testTimeInWords(6, 36, "twenty four minutes to seven");
		testTimeInWords(6, 37, "twenty three minutes to seven");
		testTimeInWords(6, 38, "twenty two minutes to seven");
		testTimeInWords(6, 39, "twenty one minutes to seven");
		testTimeInWords(6, 40, "twenty minutes to seven");
		testTimeInWords(6, 41, "nineteen minutes to seven");
		testTimeInWords(6, 42, "eighteen minutes to seven");
		testTimeInWords(6, 43, "seventeen minutes to seven");
		testTimeInWords(6, 44, "sixteen minutes to seven");
		testTimeInWords(6, 45, "quarter to seven");
		testTimeInWords(6, 46, "fourteen minutes to seven");
		testTimeInWords(6, 47, "thirteen minutes to seven");
		testTimeInWords(6, 48, "twelve minutes to seven");
		testTimeInWords(6, 49, "eleven minutes to seven");
		testTimeInWords(6, 50, "ten minutes to seven");
		testTimeInWords(6, 51, "nine minutes to seven");
		testTimeInWords(6, 52, "eight minutes to seven");
		testTimeInWords(6, 53, "seven minutes to seven");
		testTimeInWords(6, 54, "six minutes to seven");
		testTimeInWords(6, 55, "five minutes to seven");
		testTimeInWords(6, 56, "four minutes to seven");
		testTimeInWords(6, 57, "three minutes to seven");
		testTimeInWords(6, 58, "two minutes to seven");
		testTimeInWords(6, 59, "one minute to seven");

		testTimeInWords(7, 0, "seven o' clock");
		testTimeInWords(7, 1, "one minute past seven");
		testTimeInWords(7, 2, "two minutes past seven");
		testTimeInWords(7, 3, "three minutes past seven");
		testTimeInWords(7, 4, "four minutes past seven");
		testTimeInWords(7, 5, "five minutes past seven");
		testTimeInWords(7, 6, "six minutes past seven");
		testTimeInWords(7, 7, "seven minutes past seven");
		testTimeInWords(7, 8, "eight minutes past seven");
		testTimeInWords(7, 9, "nine minutes past seven");
		testTimeInWords(7, 10, "ten minutes past seven");
		testTimeInWords(7, 11, "eleven minutes past seven");
		testTimeInWords(7, 12, "twelve minutes past seven");
		testTimeInWords(7, 13, "thirteen minutes past seven");
		testTimeInWords(7, 14, "fourteen minutes past seven");
		testTimeInWords(7, 15, "quarter past seven");
		testTimeInWords(7, 16, "sixteen minutes past seven");
		testTimeInWords(7, 17, "seventeen minutes past seven");
		testTimeInWords(7, 18, "eighteen minutes past seven");
		testTimeInWords(7, 19, "nineteen minutes past seven");
		testTimeInWords(7, 20, "twenty minutes past seven");
		testTimeInWords(7, 21, "twenty one minutes past seven");
		testTimeInWords(7, 22, "twenty two minutes past seven");
		testTimeInWords(7, 23, "twenty three minutes past seven");
		testTimeInWords(7, 24, "twenty four minutes past seven");
		testTimeInWords(7, 25, "twenty five minutes past seven");
		testTimeInWords(7, 26, "twenty six minutes past seven");
		testTimeInWords(7, 27, "twenty seven minutes past seven");
		testTimeInWords(7, 28, "twenty eight minutes past seven");
		testTimeInWords(7, 29, "twenty nine minutes past seven");
		testTimeInWords(7, 30, "half past seven");
		testTimeInWords(7, 31, "twenty nine minutes to eight");
		testTimeInWords(7, 32, "twenty eight minutes to eight");
		testTimeInWords(7, 33, "twenty seven minutes to eight");
		testTimeInWords(7, 34, "twenty six minutes to eight");
		testTimeInWords(7, 35, "twenty five minutes to eight");
		testTimeInWords(7, 36, "twenty four minutes to eight");
		testTimeInWords(7, 37, "twenty three minutes to eight");
		testTimeInWords(7, 38, "twenty two minutes to eight");
		testTimeInWords(7, 39, "twenty one minutes to eight");
		testTimeInWords(7, 40, "twenty minutes to eight");
		testTimeInWords(7, 41, "nineteen minutes to eight");
		testTimeInWords(7, 42, "eighteen minutes to eight");
		testTimeInWords(7, 43, "seventeen minutes to eight");
		testTimeInWords(7, 44, "sixteen minutes to eight");
		testTimeInWords(7, 45, "quarter to eight");
		testTimeInWords(7, 46, "fourteen minutes to eight");
		testTimeInWords(7, 47, "thirteen minutes to eight");
		testTimeInWords(7, 48, "twelve minutes to eight");
		testTimeInWords(7, 49, "eleven minutes to eight");
		testTimeInWords(7, 50, "ten minutes to eight");
		testTimeInWords(7, 51, "nine minutes to eight");
		testTimeInWords(7, 52, "eight minutes to eight");
		testTimeInWords(7, 53, "seven minutes to eight");
		testTimeInWords(7, 54, "six minutes to eight");
		testTimeInWords(7, 55, "five minutes to eight");
		testTimeInWords(7, 56, "four minutes to eight");
		testTimeInWords(7, 57, "three minutes to eight");
		testTimeInWords(7, 58, "two minutes to eight");
		testTimeInWords(7, 59, "one minute to eight");

		testTimeInWords(8, 0, "eight o' clock");
		testTimeInWords(8, 1, "one minute past eight");
		testTimeInWords(8, 2, "two minutes past eight");
		testTimeInWords(8, 3, "three minutes past eight");
		testTimeInWords(8, 4, "four minutes past eight");
		testTimeInWords(8, 5, "five minutes past eight");
		testTimeInWords(8, 6, "six minutes past eight");
		testTimeInWords(8, 7, "seven minutes past eight");
		testTimeInWords(8, 8, "eight minutes past eight");
		testTimeInWords(8, 9, "nine minutes past eight");
		testTimeInWords(8, 10, "ten minutes past eight");
		testTimeInWords(8, 11, "eleven minutes past eight");
		testTimeInWords(8, 12, "twelve minutes past eight");
		testTimeInWords(8, 13, "thirteen minutes past eight");
		testTimeInWords(8, 14, "fourteen minutes past eight");
		testTimeInWords(8, 15, "quarter past eight");
		testTimeInWords(8, 16, "sixteen minutes past eight");
		testTimeInWords(8, 17, "seventeen minutes past eight");
		testTimeInWords(8, 18, "eighteen minutes past eight");
		testTimeInWords(8, 19, "nineteen minutes past eight");
		testTimeInWords(8, 20, "twenty minutes past eight");
		testTimeInWords(8, 21, "twenty one minutes past eight");
		testTimeInWords(8, 22, "twenty two minutes past eight");
		testTimeInWords(8, 23, "twenty three minutes past eight");
		testTimeInWords(8, 24, "twenty four minutes past eight");
		testTimeInWords(8, 25, "twenty five minutes past eight");
		testTimeInWords(8, 26, "twenty six minutes past eight");
		testTimeInWords(8, 27, "twenty seven minutes past eight");
		testTimeInWords(8, 28, "twenty eight minutes past eight");
		testTimeInWords(8, 29, "twenty nine minutes past eight");
		testTimeInWords(8, 30, "half past eight");
		testTimeInWords(8, 31, "twenty nine minutes to nine");
		testTimeInWords(8, 32, "twenty eight minutes to nine");
		testTimeInWords(8, 33, "twenty seven minutes to nine");
		testTimeInWords(8, 34, "twenty six minutes to nine");
		testTimeInWords(8, 35, "twenty five minutes to nine");
		testTimeInWords(8, 36, "twenty four minutes to nine");
		testTimeInWords(8, 37, "twenty three minutes to nine");
		testTimeInWords(8, 38, "twenty two minutes to nine");
		testTimeInWords(8, 39, "twenty one minutes to nine");
		testTimeInWords(8, 40, "twenty minutes to nine");
		testTimeInWords(8, 41, "nineteen minutes to nine");
		testTimeInWords(8, 42, "eighteen minutes to nine");
		testTimeInWords(8, 43, "seventeen minutes to nine");
		testTimeInWords(8, 44, "sixteen minutes to nine");
		testTimeInWords(8, 45, "quarter to nine");
		testTimeInWords(8, 46, "fourteen minutes to nine");
		testTimeInWords(8, 47, "thirteen minutes to nine");
		testTimeInWords(8, 48, "twelve minutes to nine");
		testTimeInWords(8, 49, "eleven minutes to nine");
		testTimeInWords(8, 50, "ten minutes to nine");
		testTimeInWords(8, 51, "nine minutes to nine");
		testTimeInWords(8, 52, "eight minutes to nine");
		testTimeInWords(8, 53, "seven minutes to nine");
		testTimeInWords(8, 54, "six minutes to nine");
		testTimeInWords(8, 55, "five minutes to nine");
		testTimeInWords(8, 56, "four minutes to nine");
		testTimeInWords(8, 57, "three minutes to nine");
		testTimeInWords(8, 58, "two minutes to nine");
		testTimeInWords(8, 59, "one minute to nine");

		testTimeInWords(9, 0, "nine o' clock");
		testTimeInWords(9, 1, "one minute past nine");
		testTimeInWords(9, 2, "two minutes past nine");
		testTimeInWords(9, 3, "three minutes past nine");
		testTimeInWords(9, 4, "four minutes past nine");
		testTimeInWords(9, 5, "five minutes past nine");
		testTimeInWords(9, 6, "six minutes past nine");
		testTimeInWords(9, 7, "seven minutes past nine");
		testTimeInWords(9, 8, "eight minutes past nine");
		testTimeInWords(9, 9, "nine minutes past nine");
		testTimeInWords(9, 10, "ten minutes past nine");
		testTimeInWords(9, 11, "eleven minutes past nine");
		testTimeInWords(9, 12, "twelve minutes past nine");
		testTimeInWords(9, 13, "thirteen minutes past nine");
		testTimeInWords(9, 14, "fourteen minutes past nine");
		testTimeInWords(9, 15, "quarter past nine");
		testTimeInWords(9, 16, "sixteen minutes past nine");
		testTimeInWords(9, 17, "seventeen minutes past nine");
		testTimeInWords(9, 18, "eighteen minutes past nine");
		testTimeInWords(9, 19, "nineteen minutes past nine");
		testTimeInWords(9, 20, "twenty minutes past nine");
		testTimeInWords(9, 21, "twenty one minutes past nine");
		testTimeInWords(9, 22, "twenty two minutes past nine");
		testTimeInWords(9, 23, "twenty three minutes past nine");
		testTimeInWords(9, 24, "twenty four minutes past nine");
		testTimeInWords(9, 25, "twenty five minutes past nine");
		testTimeInWords(9, 26, "twenty six minutes past nine");
		testTimeInWords(9, 27, "twenty seven minutes past nine");
		testTimeInWords(9, 28, "twenty eight minutes past nine");
		testTimeInWords(9, 29, "twenty nine minutes past nine");
		testTimeInWords(9, 30, "half past nine");
		testTimeInWords(9, 31, "twenty nine minutes to ten");
		testTimeInWords(9, 32, "twenty eight minutes to ten");
		testTimeInWords(9, 33, "twenty seven minutes to ten");
		testTimeInWords(9, 34, "twenty six minutes to ten");
		testTimeInWords(9, 35, "twenty five minutes to ten");
		testTimeInWords(9, 36, "twenty four minutes to ten");
		testTimeInWords(9, 37, "twenty three minutes to ten");
		testTimeInWords(9, 38, "twenty two minutes to ten");
		testTimeInWords(9, 39, "twenty one minutes to ten");
		testTimeInWords(9, 40, "twenty minutes to ten");
		testTimeInWords(9, 41, "nineteen minutes to ten");
		testTimeInWords(9, 42, "eighteen minutes to ten");
		testTimeInWords(9, 43, "seventeen minutes to ten");
		testTimeInWords(9, 44, "sixteen minutes to ten");
		testTimeInWords(9, 45, "quarter to ten");
		testTimeInWords(9, 46, "fourteen minutes to ten");
		testTimeInWords(9, 47, "thirteen minutes to ten");
		testTimeInWords(9, 48, "twelve minutes to ten");
		testTimeInWords(9, 49, "eleven minutes to ten");
		testTimeInWords(9, 50, "ten minutes to ten");
		testTimeInWords(9, 51, "nine minutes to ten");
		testTimeInWords(9, 52, "eight minutes to ten");
		testTimeInWords(9, 53, "seven minutes to ten");
		testTimeInWords(9, 54, "six minutes to ten");
		testTimeInWords(9, 55, "five minutes to ten");
		testTimeInWords(9, 56, "four minutes to ten");
		testTimeInWords(9, 57, "three minutes to ten");
		testTimeInWords(9, 58, "two minutes to ten");
		testTimeInWords(9, 59, "one minute to ten");

		testTimeInWords(10, 0, "ten o' clock");
		testTimeInWords(10, 1, "one minute past ten");
		testTimeInWords(10, 2, "two minutes past ten");
		testTimeInWords(10, 3, "three minutes past ten");
		testTimeInWords(10, 4, "four minutes past ten");
		testTimeInWords(10, 5, "five minutes past ten");
		testTimeInWords(10, 6, "six minutes past ten");
		testTimeInWords(10, 7, "seven minutes past ten");
		testTimeInWords(10, 8, "eight minutes past ten");
		testTimeInWords(10, 9, "nine minutes past ten");
		testTimeInWords(10, 10, "ten minutes past ten");
		testTimeInWords(10, 11, "eleven minutes past ten");
		testTimeInWords(10, 12, "twelve minutes past ten");
		testTimeInWords(10, 13, "thirteen minutes past ten");
		testTimeInWords(10, 14, "fourteen minutes past ten");
		testTimeInWords(10, 15, "quarter past ten");
		testTimeInWords(10, 16, "sixteen minutes past ten");
		testTimeInWords(10, 17, "seventeen minutes past ten");
		testTimeInWords(10, 18, "eighteen minutes past ten");
		testTimeInWords(10, 19, "nineteen minutes past ten");
		testTimeInWords(10, 20, "twenty minutes past ten");
		testTimeInWords(10, 21, "twenty one minutes past ten");
		testTimeInWords(10, 22, "twenty two minutes past ten");
		testTimeInWords(10, 23, "twenty three minutes past ten");
		testTimeInWords(10, 24, "twenty four minutes past ten");
		testTimeInWords(10, 25, "twenty five minutes past ten");
		testTimeInWords(10, 26, "twenty six minutes past ten");
		testTimeInWords(10, 27, "twenty seven minutes past ten");
		testTimeInWords(10, 28, "twenty eight minutes past ten");
		testTimeInWords(10, 29, "twenty nine minutes past ten");
		testTimeInWords(10, 30, "half past ten");
		testTimeInWords(10, 31, "twenty nine minutes to eleven");
		testTimeInWords(10, 32, "twenty eight minutes to eleven");
		testTimeInWords(10, 33, "twenty seven minutes to eleven");
		testTimeInWords(10, 34, "twenty six minutes to eleven");
		testTimeInWords(10, 35, "twenty five minutes to eleven");
		testTimeInWords(10, 36, "twenty four minutes to eleven");
		testTimeInWords(10, 37, "twenty three minutes to eleven");
		testTimeInWords(10, 38, "twenty two minutes to eleven");
		testTimeInWords(10, 39, "twenty one minutes to eleven");
		testTimeInWords(10, 40, "twenty minutes to eleven");
		testTimeInWords(10, 41, "nineteen minutes to eleven");
		testTimeInWords(10, 42, "eighteen minutes to eleven");
		testTimeInWords(10, 43, "seventeen minutes to eleven");
		testTimeInWords(10, 44, "sixteen minutes to eleven");
		testTimeInWords(10, 45, "quarter to eleven");
		testTimeInWords(10, 46, "fourteen minutes to eleven");
		testTimeInWords(10, 47, "thirteen minutes to eleven");
		testTimeInWords(10, 48, "twelve minutes to eleven");
		testTimeInWords(10, 49, "eleven minutes to eleven");
		testTimeInWords(10, 50, "ten minutes to eleven");
		testTimeInWords(10, 51, "nine minutes to eleven");
		testTimeInWords(10, 52, "eight minutes to eleven");
		testTimeInWords(10, 53, "seven minutes to eleven");
		testTimeInWords(10, 54, "six minutes to eleven");
		testTimeInWords(10, 55, "five minutes to eleven");
		testTimeInWords(10, 56, "four minutes to eleven");
		testTimeInWords(10, 57, "three minutes to eleven");
		testTimeInWords(10, 58, "two minutes to eleven");
		testTimeInWords(10, 59, "one minute to eleven");

		testTimeInWords(11, 0, "eleven o' clock");
		testTimeInWords(11, 1, "one minute past eleven");
		testTimeInWords(11, 2, "two minutes past eleven");
		testTimeInWords(11, 3, "three minutes past eleven");
		testTimeInWords(11, 4, "four minutes past eleven");
		testTimeInWords(11, 5, "five minutes past eleven");
		testTimeInWords(11, 6, "six minutes past eleven");
		testTimeInWords(11, 7, "seven minutes past eleven");
		testTimeInWords(11, 8, "eight minutes past eleven");
		testTimeInWords(11, 9, "nine minutes past eleven");
		testTimeInWords(11, 10, "ten minutes past eleven");
		testTimeInWords(11, 11, "eleven minutes past eleven");
		testTimeInWords(11, 12, "twelve minutes past eleven");
		testTimeInWords(11, 13, "thirteen minutes past eleven");
		testTimeInWords(11, 14, "fourteen minutes past eleven");
		testTimeInWords(11, 15, "quarter past eleven");
		testTimeInWords(11, 16, "sixteen minutes past eleven");
		testTimeInWords(11, 17, "seventeen minutes past eleven");
		testTimeInWords(11, 18, "eighteen minutes past eleven");
		testTimeInWords(11, 19, "nineteen minutes past eleven");
		testTimeInWords(11, 20, "twenty minutes past eleven");
		testTimeInWords(11, 21, "twenty one minutes past eleven");
		testTimeInWords(11, 22, "twenty two minutes past eleven");
		testTimeInWords(11, 23, "twenty three minutes past eleven");
		testTimeInWords(11, 24, "twenty four minutes past eleven");
		testTimeInWords(11, 25, "twenty five minutes past eleven");
		testTimeInWords(11, 26, "twenty six minutes past eleven");
		testTimeInWords(11, 27, "twenty seven minutes past eleven");
		testTimeInWords(11, 28, "twenty eight minutes past eleven");
		testTimeInWords(11, 29, "twenty nine minutes past eleven");
		testTimeInWords(11, 30, "half past eleven");
		testTimeInWords(11, 31, "twenty nine minutes to twelve");
		testTimeInWords(11, 32, "twenty eight minutes to twelve");
		testTimeInWords(11, 33, "twenty seven minutes to twelve");
		testTimeInWords(11, 34, "twenty six minutes to twelve");
		testTimeInWords(11, 35, "twenty five minutes to twelve");
		testTimeInWords(11, 36, "twenty four minutes to twelve");
		testTimeInWords(11, 37, "twenty three minutes to twelve");
		testTimeInWords(11, 38, "twenty two minutes to twelve");
		testTimeInWords(11, 39, "twenty one minutes to twelve");
		testTimeInWords(11, 40, "twenty minutes to twelve");
		testTimeInWords(11, 41, "nineteen minutes to twelve");
		testTimeInWords(11, 42, "eighteen minutes to twelve");
		testTimeInWords(11, 43, "seventeen minutes to twelve");
		testTimeInWords(11, 44, "sixteen minutes to twelve");
		testTimeInWords(11, 45, "quarter to twelve");
		testTimeInWords(11, 46, "fourteen minutes to twelve");
		testTimeInWords(11, 47, "thirteen minutes to twelve");
		testTimeInWords(11, 48, "twelve minutes to twelve");
		testTimeInWords(11, 49, "eleven minutes to twelve");
		testTimeInWords(11, 50, "ten minutes to twelve");
		testTimeInWords(11, 51, "nine minutes to twelve");
		testTimeInWords(11, 52, "eight minutes to twelve");
		testTimeInWords(11, 53, "seven minutes to twelve");
		testTimeInWords(11, 54, "six minutes to twelve");
		testTimeInWords(11, 55, "five minutes to twelve");
		testTimeInWords(11, 56, "four minutes to twelve");
		testTimeInWords(11, 57, "three minutes to twelve");
		testTimeInWords(11, 58, "two minutes to twelve");
		testTimeInWords(11, 59, "one minute to twelve");
		
	}// End of Main

	static void testTimeInWords(int h, int m, String expected) {
		String result = timeInWords(h, m);
		System.out.println("Result : " + result);
		assert expected.equals(result);
	}// End of Test

}// End of Class
