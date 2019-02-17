package com.algorithms.hackerrank.implementation;

public class DesignerPDFViewerSolution {

	// Complete the designerPdfViewer function below.
	static int designerPdfViewer(int[] h, String word) {
		
		int asciiBase = 97;
		char[] chArr = word.toCharArray();
		int length = chArr.length;
		
		int heighest = 0;
		for(char ch : chArr) {
			int value = ch;
			int thisHeight = h[value - asciiBase];
			if(heighest < thisHeight) {
				heighest = thisHeight;
			}
		}
		
		return heighest*length;
		
	}

	public static void main(String[] args) {
		testDesignPdfViewer(//
				new int[] { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 }, //
				"abc", 9);
		testDesignPdfViewer(//
				new int[] { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7 }, //
				"zaba", 28);
	}// End of Method

	static void testDesignPdfViewer(int[] h, String word, int expected) {
		int result = designerPdfViewer(h, word);
		System.out.println(result);
		System.out.println("---------");
		assert expected == result;
	}

}// End of Class
