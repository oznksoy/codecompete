package com.hackerrank.algorithms.implementation.easy;

import java.util.Arrays;
import java.util.List;

public class PickingNumbersSolution {

	/*
	 * Complete the 'pickingNumbers' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY a as parameter.
	 */

	static int pickingNumbers(List<Integer> a) {

		for (int i = 0; i < a.size() - 1; i++) {
			boolean isSwapped = false;
			for (int j = 1; j < a.size() - i; j++) {
				if (a.get(j) < a.get(j - 1)) {
					int temp = a.get(j);
					a.set(j, a.get(j - 1));
					a.set(j - 1, temp);
					isSwapped = true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}

		int highestCount = 0;

		int index = 0;
		while (index < a.size() - 1) {
			int subindex = index;
			int count = 1; // shortest array would be length of 1
			while (subindex < a.size() - 1) {
				subindex++;
				if (abs(a.get(index) - a.get(subindex)) <= 1) {
					count++;
				} else {
					break;
				}
			}
			index = subindex;
			if (highestCount < count) {
				highestCount = count;
			}

		}

		return highestCount;
	}

	static int abs(int value) {
		return value < 0 ? -value : value;
	}

	public static void main(String[] args) {
		testPickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1), 3);
		testPickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2), 5);

	}// End of Main

	static void testPickingNumbers(List<Integer> a, int expected) {
		int result = pickingNumbers(a);
		System.out.println(result);
		assert result == expected;
	}

}
