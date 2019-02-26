package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Basic idea is that there is a malfunctioning counter and it is set to
 * descending time count. Starting time is 3 sec and everytiem the counter is to
 * hit zero, it rewinds to double value of the last initial time. However the
 * cycle is fixed to 3 and its multiplications, meaning that t = 4 is the
 * begining of the second cycle, but the countdown is from 6 to 0 in this cycle.
 * </p>
 * <p>
 * Task is to find the displayed count for the input time value.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class StrangeCounterSolution {

	/**
	 * Complete the strangeCounter function below.
	 * 
	 * @param t : time
	 * @return displayed counter value
	 */
	static long strangeCounter(long t) {

		long time = t;
		long cycleRange = 3;

		// What cycle is t time?
		while (true) {
			if ((time - cycleRange) > 0) {
				time -= cycleRange;
				cycleRange = 2 * cycleRange;
			} else {
				break;
			}
		}

		long result = cycleRange - time + 1;

		return result;

	}// End of Method

	public static void main(String[] args) {
		testStrangeCounter(4, 6);
		testStrangeCounter(17, 5);
		testStrangeCounter(1, 3);
		testStrangeCounter(2, 2);
		testStrangeCounter(3, 1);
		testStrangeCounter(5, 5);
		testStrangeCounter(9, 1);
	}// End of Main

	static void testStrangeCounter(long t, long expected) {
		long result = strangeCounter(t);
		System.out.println("Result : " + result);
		assert result == expected;
	}// End of Test

}// End of Class
