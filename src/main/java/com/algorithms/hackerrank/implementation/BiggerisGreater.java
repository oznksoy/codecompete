package com.algorithms.hackerrank.implementation;

import java.io.File;
import java.util.Scanner;

public class BiggerisGreater {

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {

		char[] cArr = w.toCharArray();
		// Starting from the end, Which value to the left is lower?
		for (int i = cArr.length - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (cArr[i] > cArr[j]) {
					char temp = cArr[i];
					cArr[i] = cArr[j];
					cArr[j] = temp;
					sort(j, cArr);
					return String.copyValueOf(cArr);
				}
			}
		}

		return "no answer";

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

//		testBiggerIsGreater("ab", "ba");
//		testBiggerIsGreater("bb", "no answer");
//		testBiggerIsGreater("hefg", "hegf");
//		testBiggerIsGreater("dhck", "dhkc");
//		testBiggerIsGreater("dkhc", "hcdk");
//		testBiggerIsGreater("lmno", "lmon");
//		testBiggerIsGreater("dcba", "no answer");
//		testBiggerIsGreater("dcbb", "no answer");
//		testBiggerIsGreater("abdc", "acbd");
//		testBiggerIsGreater("abcd", "abdc");
//		testBiggerIsGreater("fedcbabcd", "fedcbabdc");
//		testBiggerIsGreater("fedchabcd", "fedchabdc");
//		testBiggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw",
//				"zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm");
//		testBiggerIsGreater("zyyxwwtrrnmlggfeb", "no answer");
//		testBiggerIsGreater("zzzzzzzyyyxxxvvuutttttsssrrrrrrqqqppppoooonnnmmlllkkkkjiiihggfffeeddccccaaaaa",
//				"no answer");
		testBiggerIsGreater("dmsym", "dmyms");

//		testInput01();

	}// End of Main

	static void testBiggerIsGreater(String w, String expected) {
		String result = biggerIsGreater(w);
		System.out.println(w + " -> " + result);
		assert result.equals(expected);
	}// End of Test

	static void testInput01() {
		
		String dir = "src/main/resources/algorithms/biggerisgreater/";
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
//		try {
//			for (int i = 0; i < 10; i++) {
//				int chInt = inputFileReader.read();
//				System.out.println(chInt + " : " + (char) chInt);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		File file = new File(dir);
//		File[] inputmatches = file.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String name) {
//				return name.startsWith("input") && name.endsWith("01.txt");
//			}
//		});
//		File[] outputmatches = file.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String name) {
//				return name.startsWith("output") && name.endsWith("01.txt");
//			}
//		});
//		
//		file.fi
//		for (final File match : inputmatches) {
//			try {
//				InputStream inputStream = new FileInputStream(match);
//				
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

}// End of Class
