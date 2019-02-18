package com.algorithms.hackerrank.implementation;

public class SequenceEquationSolution {

	// Complete the permutationEquation function below.
	static int[] permutationEquation(int[] p) {
		int[] results = new int[p.length];

		for (int i = 0; i < p.length; i++) {
			int x = p[i];
			int v = i + 1;
			int y = findValRef(v, p);
			results[x - 1] = y;
		}

		return results;
	}// End of Method

	static int findValRef(int v, int[] p) {

		int ind = 0;
		for (int i = 0; i < p.length; i++) {
			if (v == p[i]) {
				ind = i + 1;
			}
		}
		return ind;
	}

	public static void main(String[] args) {
		testPermutationEquation(new int[] { 2, 3, 1 }, new int[] { 2, 3, 1 });
		testPermutationEquation(new int[] { 4, 3, 5, 1, 2 }, new int[] { 1, 3, 5, 4, 2 });
		// 2 });
	}// End of Method

	static void testPermutationEquation(int[] p, int[] expected) {
		int[] result = permutationEquation(p);
		for (int value : result) {
			System.out.println(value);
		}
		System.out.println("------------");
		if (expected.length != result.length) {
			assert false;

		} else {
			for (int i = 0; i < result.length; i++) {
				assert result[i] == expected[i];
			}
		}
	}

}// End of Class
