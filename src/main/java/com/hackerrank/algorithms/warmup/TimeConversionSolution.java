package com.hackerrank.algorithms.warmup;

import java.io.IOException;

public class TimeConversionSolution {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {

		String ampm = s.substring(s.length() - 2, s.length());
		String hours = s.split(":", 2)[0];
		int addHr = 0;
		if (ampm.equals("PM") && !hours.equals("12")) {
			addHr = 12;
		} else if (ampm.equals("AM") && hours.equals("12")) {
			addHr = 12;
		}
		Integer newHour = Integer.valueOf(hours) + addHr;
		if (newHour >= 24) {
			newHour = newHour - 24;
		}
		String toReplace = newHour.toString();
		if (toReplace.length() == 1) {
			toReplace = "0" + toReplace;
		}
		String result = s.replaceFirst(hours, toReplace);
		result = result.substring(0, s.length() - 2);
		return result;


	}

	public static void main(String[] args) throws IOException {
		System.out.println(timeConversion("12:00:00AM"));
		System.out.println(timeConversion("07:05:45PM"));
		System.out.println(timeConversion("01:59:59PM"));
		System.out.println(timeConversion("12:05:45AM"));
		System.out.println(timeConversion("12:14:45PM"));
	}

}