package algorithms.warmup.plusminus;

import java.util.Scanner;

public class Solution {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		plusMinus(arr);

		scanner.close();
	}

//	public static void run() {
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] arr = new int[n];
//
//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}
//
//		plusMinus(arr);
//
//		scanner.close();
//	
//	}

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int positives = 0;
		int negatives = 0;
		int zeros = 0;

		for (int i : arr) {
			if (i == 0) { // zero
				zeros++;
			} else if (i < 0) { // negative
				negatives++;
			} else { // positive
				positives++;
			}
		}

		float n = arr.length;
		// Notice that, to generate a floating number variable, divisor must be from the
		// desired conversion type.
		// float = int / float is correct; but float / int is wrong.

		float compPositives = positives / n;
		float compNegatives = negatives / n;
		float compZeros = zeros / n;

		System.out.printf("%.6f%n", compPositives);
		System.out.printf("%.6f%n", compNegatives);
		System.out.printf("%.6f%n", compZeros);
	}

}// End of Class
