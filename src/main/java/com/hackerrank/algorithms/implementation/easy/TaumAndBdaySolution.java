package com.hackerrank.algorithms.implementation.easy;

public class TaumAndBdaySolution {

	// Complete the taumBday function below.
	/**
	 * <p>
	 * Help Taum by deducing the minimum amount he needs to spend on Diksha's gifts.
	 * </p>
	 * 
	 * @param b  : the number of black gifts
	 * @param w  : the number of white gifts
	 * @param bc : the cost of a black gift
	 * @param wc : the cost of a white gift
	 * @param z  : the cost to convert one color gift to the other color
	 * @return the minimal cost of obtaining the desired gifts
	 */
	static long taumBday(int b, int w, int bc, int wc, int z) {

		long bl = b;
		long wl = w;
		long bcl = bc;
		long wcl = wc;
		long zl = z;

		if (bcl > zl + wcl) {
			bcl = zl + wcl;
		} else if (wcl > zl + bcl) {
			wcl = zl + bcl;
		}

		long result = (bl * bcl) + (wl * wcl);

		return result;

	}// End of Method

	public static void main(String[] args) {

		testTaumBday(10, 10, 1, 1, 1, 20);
		testTaumBday(5, 9, 2, 3, 4, 37);
		testTaumBday(3, 6, 9, 1, 1, 12);
		testTaumBday(7, 7, 4, 2, 1, 35);
		testTaumBday(3, 3, 1, 9, 2, 12);

		testTaumBday(27984, 1402, 619246, 615589, 247954, 18192035842l);
		testTaumBday(95677, 39394, 86983, 311224, 588538, 20582630747l);
		testTaumBday(68406, 12718, 532909, 315341, 201009, 39331944938l);
		testTaumBday(15242, 95521, 712721, 628729, 396706, 70920116291l);
		testTaumBday(21988, 67781, 645748, 353796, 333199, 38179353700l);
		testTaumBday(22952, 80129, 502975, 175136, 340236, 25577754744l);
		testTaumBday(38577, 3120, 541637, 657823, 735060, 22947138309l);
		testTaumBday(5943, 69851, 674453, 392925, 381074, 31454478354l);
		testTaumBday(62990, 61330, 310144, 312251, 93023, 38686324390l);
		testTaumBday(11152, 43844, 788543, 223872, 972572, 18609275504l);

	}

	static void testTaumBday(int b, int w, int bc, int wc, int z, long expected) {
		long result = taumBday(b, w, bc, wc, z);
		System.out.println("Result : " + result);
		assert expected == result;
	}

}
