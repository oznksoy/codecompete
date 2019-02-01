package test.solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.dynamic.fibonaci.FibonacciSolution;

public class TestFibonacci {

	public FibonacciSolution solution;

	@Before
	public void getReady() {
		solution = new FibonacciSolution();
	}

	@Test
	@Ignore
	public void testPerformanceofPureRecursion() {
		for (int i = 50; i >= 0; i--) {
			try {
				System.out.println("calc(" + i + ") : " + solution.calcFibonacciViaPureRecursion(i).toString());
			} catch (Throwable t) {
				System.out.println("final value : " + i);
			}
		}
	}

	@Test
	public void testPerformanceofStoredRecursion() {
		for (int i = 20000; i >= 0; i--) {
			try {
				System.out.println("calc(" + i + ") : "
						+ solution.calcFibonacciViaRecursiveMemoized(i, new BigDecimal[i + 1]).toString());
			} catch (Throwable t) {
				System.out.println("final value : " + i);
			}

		}
	}

	@Test
	public void testPerformanceofButtomUp() {
		for (int i = 20000; i >= 0; i--) {
			try {
				System.out.println("calc(" + i + ") : " + solution.calcFibonacciViaButtomUp(i).toString());
			} catch (Throwable t) {
				System.out.println("final value : " + i);
			}
		}
	}

	@Test
	@Ignore
	public void testPureRecursion() {
		assertTrue(BigDecimal.valueOf(2).equals(solution.calcFibonacciViaPureRecursion(3)));
		assertTrue(BigDecimal.valueOf(55).equals(solution.calcFibonacciViaPureRecursion(10)));
		assertTrue(BigDecimal.valueOf(6765).equals(solution.calcFibonacciViaPureRecursion(20)));
		assertTrue(BigDecimal.valueOf(1836311903).equals(solution.calcFibonacciViaPureRecursion(46)));

		assertFalse(BigDecimal.valueOf(13).equals(solution.calcFibonacciViaPureRecursion(3)));
		assertFalse(BigDecimal.valueOf(22).equals(solution.calcFibonacciViaPureRecursion(10)));
		assertFalse(BigDecimal.valueOf(6314123).equals(solution.calcFibonacciViaPureRecursion(20)));
	}

	@Test
	@Ignore
	public void testStoredRecursion() {
		assertTrue(BigDecimal.valueOf(2).equals(solution.calcFibonacciViaRecursiveMemoized(3, new BigDecimal[4])));
		assertTrue(BigDecimal.valueOf(55).equals(solution.calcFibonacciViaRecursiveMemoized(10, new BigDecimal[11])));
		assertTrue(BigDecimal.valueOf(6765).equals(solution.calcFibonacciViaRecursiveMemoized(20, new BigDecimal[21])));
		assertTrue(BigDecimal.valueOf(1836311903)
				.equals(solution.calcFibonacciViaRecursiveMemoized(46, new BigDecimal[47])));

		assertFalse(BigDecimal.valueOf(13).equals(solution.calcFibonacciViaRecursiveMemoized(3, new BigDecimal[4])));
		assertFalse(BigDecimal.valueOf(22).equals(solution.calcFibonacciViaRecursiveMemoized(10, new BigDecimal[11])));
		assertFalse(
				BigDecimal.valueOf(6314123).equals(solution.calcFibonacciViaRecursiveMemoized(20, new BigDecimal[21])));
	}

	@Test@Ignore
	public void testButtomUp() {
		assertTrue(BigDecimal.valueOf(2).equals(solution.calcFibonacciViaButtomUp(3)));
		assertTrue(BigDecimal.valueOf(55).equals(solution.calcFibonacciViaButtomUp(10)));
		assertTrue(BigDecimal.valueOf(6765).equals(solution.calcFibonacciViaButtomUp(20)));
		assertTrue(BigDecimal.valueOf(1836311903).equals(solution.calcFibonacciViaButtomUp(46)));

		assertFalse(BigDecimal.valueOf(13).equals(solution.calcFibonacciViaButtomUp(3)));
		assertFalse(BigDecimal.valueOf(22).equals(solution.calcFibonacciViaButtomUp(10)));
		assertFalse(BigDecimal.valueOf(6314123).equals(solution.calcFibonacciViaButtomUp(20)));
	}

}
