package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Manasa is out on a hike with friends. She finds a trail of stones with
 * numbers on them. She starts following the trail and notices that any two
 * consecutive stones' numbers differ by one of two values. Legend has it that
 * there is a treasure trove at the end of the trail. If Manasa can guess the
 * value of the last stone, the treasure will be hers.
 * </p>
 * <p>
 * We know she starts with a 0 stone not included in her count. She finds 2
 * stones and their differences are a=2 or b=3. The permutations of differences
 * for the two stones would be [2,2],[2,3],[3,2] or [3,3]. Looking at each
 * scenario, stones might have [2,4][2,5][3,5] or [3,6] on them. The last stone
 * might have any of 4,5 or 6 on its face. Compute all possible numbers that
 * might occur on the last stone given a starting stone with a 0 on it, a number
 * of additional stones found, and the possible differences between consecutive
 * stones. Order the list ascending.
 * </p>
 * 
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/manasa-and-stones/problem">Manasa
 *      and Stones</a>
 * @author Ozan Aksoy
 *
 */
public class ManasaAndStonesSolution {

	/**
	 * <p>
	 * Complete the stones function in the editor below. It should return an array
	 * of integers representing all possible values of the last stone, sorted
	 * ascending.
	 * </p>
	 * <li>1 &lt= n,a,b &lt= 10^3</li>
	 * 
	 * @param n : an integer, the number of non-zero stones
	 * @param a : one possible integer difference
	 * @param b : another possible integer difference
	 * @return an array of integers representing all possible values of the last
	 *         stone, sorted ascending.
	 */
	static int[] stones(int n, int a, int b) {

		// To my understanding, the question is -> with n given placements, what are the
		// final distances that can be reached
		// Thus, it becomes a question of range possibilities.

		int diff = max(a, b) - min(a, b); // absolute difference
		int steps = n - 1; // times of distance increases;
		int shortestDistance = steps * min(a, b);

		if (diff == 0) {
			return new int[] { shortestDistance };
		}

		int longestDistance = steps * max(a, b);

		int count = (longestDistance - shortestDistance) / diff;

		int[] results = new int[count + 1]; // inclusive of shortest distance

		for (int inc = 0; inc <= count; inc++) {
			results[inc] = shortestDistance + inc * diff;
		}

		return results;

	}// End of Method

	static int min(int a, int b) {
		return a < b ? a : b;
	}// End of Method

	static int max(int a, int b) {
		return a > b ? a : b;
	}// End of Method

	public static void main(String[] args) {
		testStones(3, 1, 2, new int[] { 2, 3, 4 });
		testStones(4, 10, 100, new int[] { 30, 120, 210, 300 });
		testStones(5, 3, 23, new int[] { 12, 32, 52, 72, 92 });
		testStones(58, 69, 24,
				new int[] { 1368, 1413, 1458, 1503, 1548, 1593, 1638, 1683, 1728, 1773, 1818, 1863, 1908, 1953, 1998,
						2043, 2088, 2133, 2178, 2223, 2268, 2313, 2358, 2403, 2448, 2493, 2538, 2583, 2628, 2673, 2718,
						2763, 2808, 2853, 2898, 2943, 2988, 3033, 3078, 3123, 3168, 3213, 3258, 3303, 3348, 3393, 3438,
						3483, 3528, 3573, 3618, 3663, 3708, 3753, 3798, 3843, 3888, 3933 });
		testStones(83, 86, 81,
				new int[] { 6642, 6647, 6652, 6657, 6662, 6667, 6672, 6677, 6682, 6687, 6692, 6697, 6702, 6707, 6712,
						6717, 6722, 6727, 6732, 6737, 6742, 6747, 6752, 6757, 6762, 6767, 6772, 6777, 6782, 6787, 6792,
						6797, 6802, 6807, 6812, 6817, 6822, 6827, 6832, 6837, 6842, 6847, 6852, 6857, 6862, 6867, 6872,
						6877, 6882, 6887, 6892, 6897, 6902, 6907, 6912, 6917, 6922, 6927, 6932, 6937, 6942, 6947, 6952,
						6957, 6962, 6967, 6972, 6977, 6982, 6987, 6992, 6997, 7002, 7007, 7012, 7017, 7022, 7027, 7032,
						7037, 7042, 7047, 7052 });
		testStones(73, 25, 25, new int[] { 1800 });
		testStones(1000, 1000, 1000, new int[] { 999000 });
		testStones(12, 73, 82, new int[] { 803, 812, 821, 830, 839, 848, 857, 866, 875, 884, 893, 902 });

	}// End of Main

	static void testStones(int n, int a, int b, int[] expected) {
		int[] result = stones(n, a, b);
		System.out.print("Result : ");
		for (int value : result) {
			System.out.print(value + " ");
		}
		System.out.print("\n");
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert result[i] == expected[i];
		}
	}// End of Test

}// End of Class
