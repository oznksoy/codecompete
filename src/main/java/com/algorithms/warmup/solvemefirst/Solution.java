package com.algorithms.warmup.solvemefirst;

import java.util.Scanner;

public class Solution {

	private Scanner scanner;

	private Solution(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void main(String[] args) {
		new Solution(new Scanner(System.in)).solve();
	}

	private void solve() {
		int a = readNewValue();
		a = writeValue(a);
		int b = readNewValue();
		b = writeValue(b);
		System.out.println(solveMe(a, b));
	}// End of Method

	private Integer tryParseInt(String text) {
		Integer i = null;
		try {
			i = Integer.valueOf(text);
			return i;
		} catch (NumberFormatException e) {
			i = null;
		} finally {
			if (i == null) {
				Integer scannedValue = tryParseInt(scanner.next());
				i = scannedValue;
			}
		}
		return i;
	}// End of Method

	private int readNewValue() {
		Integer scannedValue = tryParseInt(scanner.next());
		return scannedValue.intValue();
	}// End of Method

	private int writeValue(int nValue) {
		int rValue = 0;
		if (nValue >= 1 && nValue <= 1000) {
			rValue = nValue;
		} else {
			rValue = writeValue(readNewValue());
		}
		return rValue;
	}// End of Method

	private int solveMe(int a, int b) {
		int solution = a + b;
		return solution;
	}// End of Method

}// End of Class