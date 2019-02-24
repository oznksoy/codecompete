package com.algorithms.hackerrank.implementation.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Given a set of distinct integers, print the size of a maximal subset of S
 * where the sum of any 2 numbers in S' is not evenly divisible by k. S is a set
 * of unique values.
 * </p>
 * <p>
 * <li>1 <= n <= 10^5 where n is size of S</li>
 * <li>1 <= k <= 100</li>
 * <li>1 <= S[i] <= 10^9</li>
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class NonDivisibleSubsetSolution {

	// Complete the nonDivisibleSubset function below.
	static int nonDivisibleSubset(int k, int[] s) {

		int[] distribution = new int[k];
		for (int i = 0; i < s.length; i++) {
			int loc = s[i] % k;
			distribution[loc] = distribution[loc] + 1;
		}

		if (k % 2 == 0) {
			return calcualteEvenValuedDivisor(distribution, k);
		} else {
			return calculateOddValuedDivisor(distribution, k);
		}

	}// End of Method

	static int calculateOddValuedDivisor(int[] distribution, int k) {

		int count = 0;
		int median = (k + 1) / 2;
		for (int i = 1; i < median; i++) {
			int countDir = distribution[i];
			int opposite = k - i;
			int countOpp = distribution[opposite];
			if (countDir > countOpp) {
				count += countDir;
			} else {
				count += countOpp;
			}
		}

		if (distribution[0] != 0) {
			count++;
		}

		return count;

	}// End of Method

	static int calcualteEvenValuedDivisor(int[] distribution, int k) {
		int count = 0;

		int median = k / 2;

		for (int i = 1; i < median; i++) {
			int countDir = distribution[i];
			int countOpp = distribution[k - i];
			if (countDir > countOpp) {
				count += countDir;
			} else {
				count += countOpp;
			}
		}

		if (distribution[median] != 0) {
			count++;
		}

		if (distribution[0] != 0) {
			count++;
		}

		return count;
	}// End of Method

	public static void main(String[] args) {
		testNonDivisibleSubset(3, new int[] { 1, 7, 2, 4 }, 3);
		testNonDivisibleSubset(4, new int[] { 19, 10, 12, 24, 25, 22 }, 3);
		testNonDivisibleSubset(4, new int[] { 19, 10, 12, 10, 24, 25, 22 }, 3);
		testNonDivisibleSubset(7,
				new int[] { 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436 }, 11);
	}

	static void testNonDivisibleSubset(int k, int[] s, int expected) {
		int result = nonDivisibleSubset(k, s);
		System.out.println("Result : " + result);
		assert result == expected;
	}

	@SuppressWarnings(value = { "unused" })
	private static class SolutionAttempt2 {

		static int nonDivisibleSubset(int k, int[] s) {

			int highestCount = 0;

			int[][] distribution = new int[k][1];
			for (int i = 0; i < s.length; i++) {
				s[i] = s[i] % k;
			}
			boolean isZeroDivisorIncluded = false;
			boolean isMedianIncluded = false;
			int median = (k % 2) == 0 ? (k / 2) : ((k + 1) / 2);
			System.out.println("Median : " + median);
			int countLowerMedian = 0;
			int countUpperMedian = 0;
			for (int i = 0; i < s.length; i++) {
				System.out.println(s[i]);
				if (k % 2 != 0) {
					if (s[i] < median) {
						if (!isZeroDivisorIncluded && s[i] == 0) {
							countUpperMedian++;
							countLowerMedian++;
							isZeroDivisorIncluded = true;
						} else if (s[i] != 0) {
							countLowerMedian++;
						}
					} else {
						countUpperMedian++;
					}
				} else {
					if (s[i] < median) {
						if (!isZeroDivisorIncluded && s[i] == 0) {
							countUpperMedian++;
							countLowerMedian++;
							isZeroDivisorIncluded = true;
						} else if (s[i] != 0) {
							countLowerMedian++;
						}
					} else if (s[i] > median) {
						countUpperMedian++;
					} else if (!isMedianIncluded && s[i] == median) {
						countLowerMedian++;
						countUpperMedian++;
						isMedianIncluded = true;
					}
				}
			}

			if (countLowerMedian < countUpperMedian) {
				highestCount = countUpperMedian;
			} else {
				highestCount = countLowerMedian;
			}

			return highestCount;

		}// End of Method

	}

	@SuppressWarnings(value = { "unused" })
	private static class SolutionAttept1 {
		// Complete the nonDivisibleSubset function below.
		static int nonDivisibleSubset(int k, int[] s) {

			int highestCount = 0;

			for (int start = 1; start < s.length; start++) {
				Set<Integer> memo = new HashSet<Integer>();
				memo.add(s[start - 1]);
				nonDivSet(memo, k, s, start);
				int length = memo.size();
				if (length > highestCount) {
					highestCount = length;
				}
			}

			return highestCount;

		}// End of Method

		static void nonDivSet(Set<Integer> memory, int k, int[] s, int start) {

			if (start >= s.length) {
				return;
			}
			nonDivSetOnReverse(memory, k, s[start]);
			nonDivSet(memory, k, s, start + 1);

		}// End of Method

		static void nonDivSetOnReverse(Set<Integer> memo, int k, int current) {

			boolean isNonDivisible = true;
			for (Integer value : memo) {
				if (((current + value) % k) == 0) {
					isNonDivisible = false;
					break;
				}
			}

			if (isNonDivisible) {
				memo.add(current);
			}

		}// End of Method
	}

}
