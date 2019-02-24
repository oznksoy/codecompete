package com.algorithms.hackerrank.implementation.easy;

public class ModifiedKaprekarNumbersSolution {

	static void kaprekarNumbers(int p, int q) {

        long n = p; // This is a critical point.
        //If n is set as int, the multiplication will overflow.
		String output = "";

		while (n <= q) {
			int lenOfN = findLength(n);
			long pow = n * n;
			int length = findLength(pow);
			if (length == 1) {
				int val = createValue(pow, 0, 0);
				output += printKaprekarNumbers(n, val);
			} else {
				int index = lenOfN - 1;
				int val1 = createValue(pow, 0, index);
				int val2 = createValue(pow, index + 1, length - 1);
				output += printKaprekarNumbers(n, val1, val2);
			}
			n++;
		}
		if (output.isEmpty()) {
			System.out.println("INVALID RANGE");
		} else {
			System.out.println(output.trim());
		}
	}// End of Method

	static String printKaprekarNumbers(long n, int val) {
		if (val != 0 && val == n) {
			return " " + n;
		}
		return "";
	}// End of Method

	static String printKaprekarNumbers(long n, int val1, int val2) {
		if (val1 != 0 && val2 != 0 && (val1 + val2) == n) {
			return " " + n;
		}
		return "";
	}// End of Method

	static int createValue(long v, int start, int end) {
		int value = 0;
		int mul = 1;
		for (int i = start; i <= end; i++) {
			int subval = findDigit(v, i);
			value += subval * mul;
			mul *= 10;
		}
		return value;
	}// End of Method

	static int findLength(long v) {
		long t = v;
		long div = 1;
		int len = 0;
		while (t >= 1) {
			len++;
			div *= 10;
			long d = t % (div);
			t = t - d;
		}
		return len;
	}// End of Method

	static int findDigit(long v, int i) {
		long t = v;
		long div = 1;
		for (int r = 0; r < i; r++) {
			div = div * 10;
		}
		t = (t - (t % (div))) / div;
		t = t % 10;
		return (int) t;
	} // End of Method

	public static void main(String[] args) {
//		testKaprekarNumbers(1, 1000); // Expected -> "1 9 45 55 99"
//		testKaprekarNumbers(400, 700); // Expected -> "INVALID RANGE"
//		testKaprekarNumbers(1, 99999);// Expected -> 1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
		testKaprekarNumbers(77778, 99999);
//		testKaprekarNumbers(82656 , 99999);
	}// End of Main

	static void testKaprekarNumbers(int p, int q) {
		kaprekarNumbers(p, q);
	}

}// End of Class
