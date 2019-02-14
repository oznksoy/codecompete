package com.algorithms.hackerrank.implementation;

import java.util.Arrays;
import java.util.List;

public class BirthdayCakeSolution {

	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {

		if (s.size() < m) {
			return 0;
		}
		int index = s.size() - 1;
		int fitCount = 0;
		int total = 0;
		for (int i = index; i > index - m; i--) {
			total += s.get(i);
		}

		if (total == d) {
			fitCount++;
		}

		for (int i = index - m; i >= 0; i--) {
			total = total - s.get(i + m);
			total = total + s.get(i);
			if (total == d) {
				fitCount++;
			}
		}

		return fitCount;
	}

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 1, 3, 2);
		System.out.println(birthday(list1, 3, 2));

		List<Integer> list2 = Arrays.asList(1, 1, 1, 1, 1, 1);
		System.out.println(birthday(list2, 3, 2));

		List<Integer> list3 = Arrays.asList(4);
		System.out.println(birthday(list3, 4, 1));

	}

}
