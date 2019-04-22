package com.algorithms.advanced;

/**
 * <p>
 * Square Root Decomposition is a technique to decompose an array into
 * manageable partitions of sqrt(array.length) long. This method will decrease
 * the time complexity of processed array operations to sqrt(n) time; where n is
 * array length.
 * </p>
 * <p>
 * <i>For Array : {1,2,3,4,5,6,7,8,9} -> Decomposition :
 * {1,2,3}{4,5,6}(7,8,9}</i> since sqrt(array.length) = 3;
 * </p>
 * <p>
 * While using the sub arrays, the sub arrays must be preprocessed to answer a
 * certain query. This means you need to answer the query or queries in range of
 * i to j, where i and j are starting and ending indices of the array.
 * </p>
 * <p>
 * For example, let's say that we are trying to find the sum of all elements in
 * the queried range. In the worst case, the indices for the query would be the
 * initial and final index of the query. For this worst case, we would have to
 * calculate the sum of all sub array sums, which we already calculated. This
 * will give us a O(sqrt(n)) time.
 * </p>
 * <p>
 * It can be said that the worst case is where queried indices are within the
 * first and last subarray. However this case would require a worst case
 * 2*(sqrt(n)/2) => sqrt(n) time, where 2*O(sqrt(n)) = ~ O(sqrt(n)) asymptotic
 * complexity
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class SquareRootDecompositionSolution {

	/**
	 * For this example, lets say that the <i>range query</i> would require us to
	 * return the sum of the range(inclusive).
	 */
	public static void main(String[] args) {
		for (int i = 2; i <= 100; i++) {
			completeCheck(generateSampleArray(i, 1));
		}
		return;
	}// End of Main

	private static int[] generateSampleArray(int length, int spread) {
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = i + spread;
		}
		return array;
	}

	private static void completeCheck(int[] array) {
		for (int a = 0; a < array.length - 1; a++) {
			for (int b = a + 1; b < array.length; b++) {
				assertQueryAsWhileLoop(a, b, array);
				assertQueryWithBlockJump(a, b, array);
			}
		}
	}

	private static void assertQueryAsWhileLoop(int a, int b, int[] array) {
		int expectedSum = naiveSum(a, b, array);
		int actualSum = new SquareRootDecompositor(array).queryAsWhileLoop(a, b);
		if (expectedSum != actualSum) {
			System.err.println("Fail!");
			System.err.println("expectedSum : " + expectedSum);
			System.err.println("actualSum : " + actualSum + "\n");
		}
	}// End of Method

	private static void assertQueryWithBlockJump(int a, int b, int[] array) {
		int expectedSum = naiveSum(a, b, array);
		int actualSum = new SquareRootDecompositor(array).queryWithBlockJump(a, b);
		if (expectedSum != actualSum) {
			System.err.println("Fail!");
			System.err.println("expectedSum : " + expectedSum);
			System.err.println("actualSum : " + actualSum + "\n");
		}
	}// End of Method

	private static class SquareRootDecompositor {

		private int[] array;
		private int block[];
		private int blockLength;

		public SquareRootDecompositor(int[] array) {
			consume(array);
		}

		private void consume(int[] array) {
			this.array = array;
			int len = array.length;
			// for values that are not modular to their root, take the ceil value as
			// sublength
			int subLen = (int) Math.ceil(Math.sqrt(len));
			this.blockLength = subLen;
			block = new int[subLen];// note that sublen*sublen >= array.len

			// preprocess
			int blockIndex = 0;
			for (int i = 0; i < array.length;) {
				int j = 0;
				int blocksum = 0;
				while (j < subLen && i < array.length) {
					blocksum += array[i];
					j++;
					i++;
				}
				this.block[blockIndex] = blocksum;
				blockIndex++;
			}

		}// End of Method

		public void update(int idx, int value) {
			int blockSum = block[idx / blockLength];
			blockSum -= array[idx];
			array[idx] = value;
			blockSum += array[idx];
			block[idx / blockLength] = blockSum;
		}// End of Method

		public int queryAsWhileLoop(int a, int b) {

			int aIdx = a;
			int bIdx = b;
			if (aIdx > bIdx) {
				bIdx = aIdx + bIdx;
				aIdx = bIdx - aIdx;
				bIdx -= aIdx;
			}

			int sum = 0;
			while (aIdx < b && aIdx % blockLength != 0 && aIdx != 0) {
				sum += array[aIdx];
				aIdx++;
			}

			while (aIdx + blockLength <= bIdx) {
				sum += block[aIdx / blockLength];
				aIdx += blockLength;
			}

			while (aIdx <= bIdx) {
				sum += array[aIdx];
				aIdx++;
			}

			return sum;

		}// End of Method

		public int queryWithBlockJump(int a, int b) {

			int aIdx = a;
			int bIdx = b;
			if (aIdx > bIdx) {
				bIdx = aIdx + bIdx;
				aIdx = bIdx;
				bIdx -= aIdx;
			}

			if (bIdx - aIdx < blockLength) {
				return naiveSum(aIdx, bIdx);
			}

			int sum = 0;

			for (int i = (aIdx / blockLength) + 1; i < bIdx / blockLength; i++) { // sum of blocks in between
				sum += block[i];
			}

			int modA = aIdx % blockLength;

			if (modA != 0) {
				if (modA < blockLength / 2) { // closer to initial index of block
					int init = (aIdx - modA);
					int blockA = block[aIdx / blockLength];
					for (int i = init; i < aIdx; i++) {
						blockA -= array[i];
					}
					sum += blockA;
				} else { // closer to final index of the block
					int fin = ensureMaxLen(aIdx - modA + blockLength);
					for (int i = aIdx; i < fin; i++) {
						sum += array[i];
					}
				}
			} else {
				sum += block[(aIdx / blockLength)];
			}

			int modB = (bIdx + 1) % blockLength;
			if (modB != 0) {
				if (modB < blockLength / 2) { // closer to initial block
					int init = bIdx - modB;
					for (int i = bIdx; i > init; i--) {
						sum += array[i];
					}
				} else { // closer to final index of the block
					int fin = ensureMaxLen(bIdx - modB + blockLength + 1) - 1;
					int blockB = block[bIdx / blockLength];
					for (int i = bIdx + 1; i <= fin; i++) {
						blockB -= array[i];
					}
					sum += blockB;
				}
			} else {
				sum += block[(bIdx / blockLength)];
			}

			return sum;

		}// End of Method

		private int ensureMaxLen(int val) {
			return val > array.length ? array.length : val;
		}// End of Method

		private int naiveSum(int a, int b) {
			int sum = 0;
			for (int i = a; i <= b; i++) {
				sum += array[i];
			}
			return sum;
		}// End of Method

	}// End of Inner Class

	private static int naiveSum(int a, int b, int[] array) {
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += array[i];
		}
		return sum;
	}

}// End of Class
