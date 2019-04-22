package com.algorithms.advanced;

public class RangeMinimumQuerySolution {

	public static void main(String[] args) {
		RangeMinimumQuerySolution solution = new RangeMinimumQuerySolution();
		solution.test();
	}// End of Class

	public void test() {
		int[] array = generateTestCase();
		SqrtDecomposition decomposition = new SqrtDecomposition(array);
		int[] block = decomposition.getBlock();
		for (int i : block) {
			System.out.println(i);
		}
		return;
	}

	private int[] generateTestCase() {

		int[] array = new int[] //
		{ 12, 17, 2, 7, 5, 9, 13, 14, 10, 8, 1, 4, 3 };

		return array;

	}// End of Test Method

	private class SqrtDecomposition {

		private int[] array;
		private int blockSize;
		private int[] block;

		private int[] getBlock() {
			return block;
		}

		public SqrtDecomposition(int[] array) {
			this.array = array;
			this.blockSize = (int) Math.ceil(Math.sqrt(array.length));
			this.block = new int[blockSize];
			consume();
		}// End of Constructor

		private void consume() {

			for (int i = 0; i < array.length; i++) {
				int blockIndex = i / blockSize;
				if (i == blockIndex * blockSize) {
					block[blockIndex] = array[i];
				} else if (block[blockIndex] > array[i]) {
					block[blockIndex] = array[i];
				}
			}

		}// End of Method

		public int queryRMQ(int a, int b) {

			if (a > b) {
				int t = a;
				a = b;
				b = a;
			}

			return 0;
		}

	}// End of Method

}// End of Class
