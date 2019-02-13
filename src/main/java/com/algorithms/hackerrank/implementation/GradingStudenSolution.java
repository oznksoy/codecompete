package com.algorithms.hackerrank.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradingStudenSolution {

	/*
	 * Complete the gradingStudents function below.
	 */
	static int[] gradingStudents(int[] grades) {

		int limitValue = 38;
		int[] validGrades = new int[grades.length];
		int index = 0;
		for (int i = 0; i < grades.length; i++) {
			int addition = 0;
			int grade = grades[i];
			if (grade >= limitValue) {
				int remainder = grade % 5;
				if (remainder > 2) {
					addition = 5 - remainder;
				}
			}
			validGrades[index] = grade + addition;
			index++;
		}

		return validGrades;

	}

	public static void main(String[] args) {
		int[] input = { 73, 67, 38, 33 };
		int[] output = gradingStudents(input);

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}// End of Main

	private static final Scanner scan = new Scanner(System.in);

	public static void operateConsoleInput(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scan.nextLine().trim());

		int[] grades = new int[n];

		for (int gradesItr = 0; gradesItr < n; gradesItr++) {
			int gradesItem = Integer.parseInt(scan.nextLine().trim());
			grades[gradesItr] = gradesItem;
		}

		int[] result = gradingStudents(grades);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bw.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bw.write("\n");
			}
		}

		bw.newLine();

		bw.close();
	}// End of Method

}// End of Class