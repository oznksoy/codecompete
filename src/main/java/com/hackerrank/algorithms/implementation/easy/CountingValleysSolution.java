package com.hackerrank.algorithms.implementation.easy;

/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close
 * attention to small details like topography. During his last hike he took
 * exactly steps. For every step he took, he noted if it was an uphill, , or a
 * downhill, step. Gary's hikes start and end at sea level and each step up or
 * down represents a unit change in altitude.
 * 
 * A mountain is a sequence of consecutive steps above sea level, starting with
 * a step up from sea level and ending with a step down to sea level. A valley
 * is a sequence of consecutive steps below sea level, starting with a step down
 * from sea level and ending with a step up to sea level.
 * 
 * Given Gary's sequence of up and down steps during his last hike, find and
 * print the number of valleys he walked through.
 * 
 * For example, if Gary's path is UDDDUDUU, he first enters a valley 2 units
 * deep. Then he climbs out an up onto a mountain 2 units high. Finally, he
 * returns to sea level and ends his hike.
 * 
 * @author Ozan Aksoy
 *
 */
public class CountingValleysSolution {

	// Complete the countingValleys function below.
	/**
	 * @param n : the number of steps Gary takes
	 * @param s : a string describing his path
	 * @return
	 */
	static int countingValleys(int n, String s) {

		char[] charArray = s.toCharArray();
		int count = 0;

		int level = 0;
		char up = 'U';

		int index = 0;

		while (index < charArray.length - 1) {
			boolean isDive = false;
			if (up == charArray[index]) {
				if (level == 0) {
					isDive = false;
				}
				level++;
			} else {
				if (level == 0) {
					isDive = true;
				}
				level--;
			}
			boolean isUp = false;
			while (level != 0 && index < charArray.length) {
				index++;
				if (up == charArray[index]) {
					level++;
					if (level == 0) {
						isUp = true;
					}
				} else {
					level--;
					if (level == 0) {
						isUp = false;
					}
				}
			}
			if (level == 0 && isDive && isUp) {
				count++;
			}
			index++;
		}

		return count;

	}
	
	static int countingValleys2(int n, String s) {

		char[] charArray = s.toCharArray();
		int count = 0;

		int level = 0;
		char up = 'U';

		int index = 0;

		while (index < charArray.length - 1) {
			if (up == charArray[index]) {
				level++;
			} else {
				level--;
			}
			boolean isUp = false;
			while (level != 0 && index < charArray.length) {
				index++;
				if (up == charArray[index]) {
					level++;
					if (level == 0) {
						isUp = true;
					}
				} else {
					level--;
				}
			}
			if (level == 0 && isUp) {
				count++;
			}
			index++;
		}

		return count;

	}

	public static void main(String[] args) {
		testCountingValleys(8, "UDDDUDUU", 1);
		testCountingValleys(10, "DDUUUUDDDU", 2);
	}

	static void testCountingValleys(int n, String s, int expected) {
		int result = countingValleys(n, s);
		System.out.println(result);
		assert expected == result;
	}

}
