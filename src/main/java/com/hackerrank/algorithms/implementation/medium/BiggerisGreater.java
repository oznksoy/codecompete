package com.hackerrank.algorithms.implementation.medium;

import java.io.File;
import java.util.Scanner;

public class BiggerisGreater {

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {

		char[] cArr = w.toCharArray();
		int[] toSwap = checkCharToSwap(cArr);
		int source = toSwap[0];
		int target = toSwap[1];

		if (source == target) {
			return "no answer";
		} else {
			char temp = cArr[source];
			cArr[source] = cArr[target];
			cArr[target] = temp;
			sort(target, cArr);
			return String.copyValueOf(cArr);

		}

	}// End of Method

	static int[] checkCharToSwap(char[] cArr) {
		// Starting from the end, Which value to the left is lower?
		int start = cArr.length - 1;
		int end = 0;
		int[] toSwap = new int[2];
		int i = start;
		int j = start;
		for (i = start; i >= end;) {
			for (j = i - 1; j >= end;) {
				if (cArr[i] > cArr[j]) {
					toSwap[0] = i;
					toSwap[1] = j;
					start = i - 1;
					end = j + 1;
					i = start;
					j = start - 1;
				} else {
					j--;
				}
			}
			i--;
		}
		return toSwap;
	}// End of Method

	static void sort(int start, char[] array) {
		int n = array.length;
		int indexStart = start + 1;
		for (int i = indexStart + 1; i < n; ++i) {
			int valueToInsert = array[i];
			int sortedBelow = i - 1;
			while (sortedBelow > start && array[sortedBelow] > valueToInsert) {
				array[sortedBelow + 1] = array[sortedBelow];
				sortedBelow = sortedBelow - 1;
			}
			array[sortedBelow + 1] = (char) valueToInsert;
		}
	}// End of Method

	public static void main(String[] args) {

		testBiggerIsGreater("ab", "ba");
		testBiggerIsGreater("bb", "no answer");
		testBiggerIsGreater("hefg", "hegf");
		testBiggerIsGreater("dhck", "dhkc");
		testBiggerIsGreater("dkhc", "hcdk");
		testBiggerIsGreater("lmno", "lmon");
		testBiggerIsGreater("dcba", "no answer");
		testBiggerIsGreater("dcbb", "no answer");
		testBiggerIsGreater("abdc", "acbd");
		testBiggerIsGreater("abcd", "abdc");
		testBiggerIsGreater("fedcbabcd", "fedcbabdc");
		testBiggerIsGreater("fedchabcd", "fedchabdc");
		testBiggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw",
				"zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm");
		testBiggerIsGreater("zyyxwwtrrnmlggfeb", "no answer");
		testBiggerIsGreater("zzzzzzzyyyxxxvvuutttttsssrrrrrrqqqppppoooonnnmmlllkkkkjiiihggfffeeddccccaaaaa",
				"no answer");
		testBiggerIsGreater("dmsym", "dmyms");

//		testInput01();

	}// End of Main

	static void testBiggerIsGreater(String w, String expected) {
		String result = biggerIsGreater(w);
		System.out.println(w + " -> " + result);
		assert result.equals(expected);
	}// End of Test

	static void testInput01() {

		String dir = "src/main/resources/algorithms/implementaion/biggerisgreater/";
		File inputFile = new File(dir + "input01.txt");
		File outputFile = new File(dir + "output01.txt");

		try {

			Scanner inputScanner = new Scanner(inputFile);

			int totalNumOfLines = inputScanner.nextInt();

			inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			Scanner outputScanner = new Scanner(outputFile);

			outputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int lineNum = 0; lineNum < totalNumOfLines; lineNum++) {

				String input = inputScanner.nextLine();
				String output = outputScanner.nextLine();
				testBiggerIsGreater(input, output);

			}

			inputScanner.close();
			outputScanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of Test from file source
	
}// End of Class
