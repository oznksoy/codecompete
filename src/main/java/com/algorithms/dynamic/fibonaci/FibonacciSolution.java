package com.algorithms.dynamic.fibonaci;

import java.math.BigDecimal;

public class FibonacciSolution {

	/**
	 * Only recursive tecnique is used
	 * 
	 * @param n
	 * @return fibonacci value
	 */
	public BigDecimal calcFibonacciViaPureRecursion(int n) {
		if (n == 0) {
			return BigDecimal.ZERO;
		} else if (n == 1) {
			return BigDecimal.ONE;
		} else {
			return calcFibonacciViaPureRecursion(n - 2).add(calcFibonacciViaPureRecursion(n - 1));
		}
	}// End of Method

	/**
	 * Recursive Memoized(not memorized!) storage technique is used
	 * 
	 * @param n
	 * @return fibonacci value
	 */
	public BigDecimal calcFibonacciViaRecursiveMemoized(int n, BigDecimal[] memory) {
		if (memory != null && memory[n] != null) {
			return memory[n];
		}
		if (n == 0) {
			return BigDecimal.ZERO;
		} else if (n == 1) {
			return BigDecimal.ONE;
		} else {
			memory[n] = calcFibonacciViaRecursiveMemoized(n - 2, memory)
					.add(calcFibonacciViaRecursiveMemoized(n - 1, memory));
			return memory[n];
		}
	}// End of Method

	public BigDecimal calcFibonacciViaButtomUp(int n) {
		if (n == 0) {
			return BigDecimal.ZERO;
		} else if (n == 1) {
			return BigDecimal.ONE;
		} else {
			BigDecimal[] memory = new BigDecimal[n + 1];
			memory[0] = BigDecimal.ZERO;
			memory[1] = BigDecimal.ONE;
			for (int i = 2; i <= n; i++) {
				memory[i] = memory[i - 1].add(memory[i - 2]);
			}
			return memory[n];
		}
	}// End of Method

}// EOC
