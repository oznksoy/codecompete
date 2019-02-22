package com.algorithms.hackerrank.implementation;

public class OrganizingContainersoOfBallsSolution {

	// Complete the organizingContainers function below.
	static String organizingContainers(int[][] container) {
		
		String impossible = "Impossible";
		String possible = "Possible";
		
		
		return null;
	} // End of Method

	public static void main(String[] args) {

		String impossible = "Impossible";
		String possible = "Possible";
		testOrganizingContainers(new int[][] { { 1, 3, 1 }, { 2, 1, 2 }, { 3, 3, 3 } }, impossible);
		testOrganizingContainers(new int[][] { { 0, 2, 1 }, { 1, 1, 1 }, { 2, 0, 0 } }, possible);

	} // End of Main

	static void testOrganizingContainers(int[][] container, String expected) {
		String result = organizingContainers(container);
		System.out.println(result);
		assert result.contentEquals(result);
	}// End of Test

}// End of Class
