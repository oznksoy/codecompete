package com.algorithms.hackerrank.implementation.medium;

public class EncryptionSolution {

	// Complete the encryption function below.
	static String encryption(String s) {

		int length = s.length();

		// What is the floor value, what is the correct ceil value?
		double sqVal = Math.sqrt(length);
		int rowLength = (int) Math.floor(sqVal);
		int colLength = (int) Math.ceil(sqVal);

		String result = "";
		for (int i = 0; i < colLength; i++) {
			for (int j = i; j < length; j += colLength) {
				result += s.charAt(j);
			}
			if (i != rowLength) {
				result += " ";
			}

		}

		return result;

	}// End of Method

	public static void main(String[] args) {
		testEncryption("haveaniceday", "hae and via ecy");
		testEncryption("feedthedog", "fto ehg ee dd");
		testEncryption("chillout", "clu hlt io");
	}

	static void testEncryption(String s, String expected) {
		String result = encryption(s);
		System.out.println("Result : " + result);
		assert expected.equals(result);
	}

}
