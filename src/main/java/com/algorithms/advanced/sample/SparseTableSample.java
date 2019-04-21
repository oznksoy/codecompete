package com.algorithms.advanced.sample;

/**
 * Sample from <a href="https://www.geeksforgeeks.org/sparse-table/">simple
 * sparse table implementations</>
 * 
 * @author Ozan Aksoy
 *
 */
public class SparseTableSample {

	// lookup[i][j] is going to store minimum
	// value in arr[i..j]. Ideally lookup table
	// size should not be fixed and should be
	// determined using n Log n. It is kept
	// constant to keep code simple.
	static int[][] lookup;

	// Fills lookup array lookup[][] in bottom up manner.
	static void buildSparseTable(int arr[], int n) {

		lookup = new int[n][n];

		// Initialize M for the intervals with length 1
		for (int i = 0; i < n; i++)
			lookup[i][0] = arr[i];

		// Compute values from smaller to bigger intervals
		for (int pow = 1; (1 << pow) <= n; pow++) {

			// Compute minimum value for all intervals with
			// size 2^j
			for (int i = 0; (i + (1 << pow) - 1) < n; i++) {

				// For arr[2][10], we compare arr[lookup[0][7]]
				// and arr[lookup[3][10]]
				if (lookup[i][pow - 1] < lookup[i + (1 << (pow - 1))][pow - 1])
					lookup[i][pow] = lookup[i][pow - 1];
				else
					lookup[i][pow] = lookup[i + (1 << (pow - 1))][pow - 1];
			}
		}
	}

	// Returns minimum of arr[L..R]
	static int query(int L, int R) {

		// Find highest power of 2 that is smaller
		// than or equal to count of elements in given
		// range. For [2, 10], j = 3
		int j = (int) Math.log(R - L + 1);

		// Compute minimum of last 2^j elements with first
		// 2^j elements in range.
		// For [2, 10], we compare arr[lookup[0][3]] and
		// arr[lookup[3][3]],
		if (lookup[L][j] <= lookup[R - (1 << j) + 1][j])
			return lookup[L][j];

		else
			return lookup[R - (1 << j) + 1][j];
	}

	// Driver program
	public static void main(String[] args) {
		int a[] = { 7, 2, 3, 0, 5, 10, 3, 12, 18 };
		int n = a.length;

		buildSparseTable(a, n);

		System.out.println(query(0, 4));
		System.out.println(query(4, 7));
		System.out.println(query(7, 8));

	}

}// End of Class
