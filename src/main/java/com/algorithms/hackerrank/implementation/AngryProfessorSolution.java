package com.algorithms.hackerrank.implementation;

/**
 * Discrete Mathematics professor has a class of students. Frustrated with their
 * lack of discipline, he decides to cancel class if fewer than some number of
 * students are present when class starts. Arrival times go from on time
 * (arrivalTime <= 0) to arrived late ( arrivalTime > 0).
 * 
 * Given the arrival time of each student and a threshhold number of attendees,
 * determine if the class is canceled.
 * 
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/angry-professor/problem">angry-professor</a>
 */
public class AngryProfessorSolution {

	// Complete the angryProfessor function below.
	// Is class cancelled?
	static String angryProfessor(int k, int[] a) {

		int lateCount = 0;
		for (int v : a) {
			if (v > 0) {
				lateCount++;
			}
			if ((a.length - lateCount) < k) {
				return "YES";
			}
		}
		return "NO";

	}// End of Method

	public static void main(String args[]) {

		testAngryProfessor(3, new int[] { -1, -3, 4, 2 }, "YES");
		testAngryProfessor(2, new int[] { 0, -1, 2, 1 }, "NO");

	}// End of Main

	static void testAngryProfessor(int k, int[] a, String expected) {
		String result = angryProfessor(k, a);
		System.out.println(result);
		assert expected.equals(result);
	}// End of Test

}// End of Class
