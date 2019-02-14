package com.algorithms.hackerrank.implementation;

public class DayOfTheProgrammerSolution {

	// Complete the dayOfProgrammer function below.
	static String dayOfProgrammer(int year) {

		if (year < 1918) { //Julian
			if (year % 4 == 0) {
				return "12.09." + year;
			}
			return "13.09." + year;
		} else if (year > 1918) { //Gregorian
			if (year % 4 == 0 && year %100 != 0|| year % 400 == 0) {
				return "12.09." + year;
			}
			return "13.09." + year;
		} else { // year == 1918
			return "26.09." + year;
		}

	}

	public static void main(String[] args) {
		String result1 = dayOfProgrammer(2017);
		System.out.println(result1);
		assert result1.equals("13.09.2017");

		String result2 = dayOfProgrammer(1800);
		System.out.println(result2);
		assert result2.equals("12.09.1800");

	}

}
