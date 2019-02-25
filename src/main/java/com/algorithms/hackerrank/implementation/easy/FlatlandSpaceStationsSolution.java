package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Flatland is a country with a number of cities, some of which have space
 * stations. Cities are numbered consecutively and each has a road of 1 km
 * length connecting it to the next city. It is not a circular route, so the
 * first city doesn't connect with the last city. Determine the maximum distance
 * from any city to it's nearest space station.
 * </p>
 * <p>
 * For example, there are n = 3 cities and m = 1 of them has a space station,
 * city 1. They occur consecutively along a route. City 2 is 2-1 = 1 units away
 * and city 3 is 3-1=2 units away. City 1 is 0 units from its nearest space
 * station as one is located there. The maximum distance is 2.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class FlatlandSpaceStationsSolution {

	/**
	 * Complete the flatlandSpaceStations function below.
	 * 
	 * @param n : the number of cities
	 * @param c : an integer array that contains the indices of cities with a space
	 *          station, 1-based indexing
	 * @return the maximum distance any city is from a space station
	 */
	static int flatlandSpaceStations(int n, int[] c) {
		// How to find the maximum distance?
		sort(c);
		int startingDistance = c[0];
		int maxDistance = (n - 1) - c[c.length - 1];
		if (startingDistance > maxDistance) {
			maxDistance = startingDistance;
		}
		for (int i = 0; i < c.length - 1; i++) {
			int distance = (c[i + 1] - c[i]);
			int midway = (distance - (distance % 2)) / 2;
			if (midway > maxDistance) {
				maxDistance = midway;
			}
		}

		return maxDistance;
	}// End of Method

	static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int sel = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[sel]) {
					sel = j;
				}
			}
			int temp = arr[sel];
			arr[sel] = arr[i];
			arr[i] = temp;
		}
	}// End of Method

	public static void main(String[] args) {
		testFlatlandSpaceStations(5, new int[] { 0, 4 }, 2);
		testFlatlandSpaceStations(6, new int[] { 0, 4, 2, 1, 3, 5 }, 0);
	}// End of Main

	static void testFlatlandSpaceStations(int n, int[] c, int expected) {
		int result = flatlandSpaceStations(n, c);
		System.out.println("Result : " + result);
		assert expected == result;
	}// End of Test

}// End of Class
