package com.algorithms.advanced;

/**
 * <p>
 * Sparse Matrix is a technique to record a sparsely filled matrix with much
 * less space. The main idea is to only record the non-zero elements of the
 * matrix.
 * </p>
 * <p>
 * The implementation can vary, but general technique is as follows:
 * </p>
 * <p>
 * if n is the number of non-zero elements; create a matrix int[3][n]
 * (variations can be implemented too); where dimensions are representative of:
 * <li>rows</li>
 * <li>columns</li>
 * <li>values</li>
 * </p>
 * <p>
 * row index and column index of the non-zero value is stored to the 3 rows of
 * the int[3][n] matrix; therefore getting rid of unnecessary space used in
 * forming the full array.
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class SparseTableSolution {

	private static int[][] originalMatrix;// = new int[10][10];

	static {
		originalMatrix = new int[][] { //
				{ 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 }, // 0
				{ 0, 0, 0, 6, 0, 0, 2, 0, 0, 0 }, // 1
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }, // 2
				{ 0, 0, 3, 0, 0, 8, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 0, 0, 0, 7, 0, 0, 0 }, // 4
				{ 0, 0, 0, 0, 4, 0, 0, 0, 0, 0 }, // 5
				{ 11, 0, 0, 0, 0, 0, 10, 0, 0, 0 }, // 6
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 }, // 7
				{ 0, 12, 0, 0, 0, 0, 13, 0, 0, 14 }, // 8
				{ 0, 0, 0, 15, 0, 0, 0, 0, 16, 0 } // 9
		};
	}// End of Static Initialization

	public static void main(String[] args) {

		generateSparseMatrix();

	}// End of Main

	private static void generateSparseMatrix() {

		// Knowing non-zero element count will save O(n^2) time. But for now...
		int[][] sparseMatrix = fillSparseMatrix(countNonZeroElements());
		print(sparseMatrix);

		int orgSpace = originalMatrix.length * originalMatrix[0].length;
		int curSpace = sparseMatrix.length * sparseMatrix[0].length;

		System.out.println("Original Space Requirement : " + orgSpace);
		System.out.println("Sparse Matrix Space Requirement : " + curSpace);
		System.out.println("Saved Space : " + (orgSpace - curSpace));
	}// End of Method

	private static int countNonZeroElements() {
		int count = 0;
		for (int[] rowArray : originalMatrix) {
			for (int value : rowArray) {
				if (value != 0)
					count++;
			}
		}
		return count;
	}// End of Method

	private static int[][] fillSparseMatrix(int n) {
		int[][] sparseMatrix = new int[3][n];

		int idx = 0;
		for (int rowIndex = 0; rowIndex < originalMatrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < originalMatrix[0].length; columnIndex++) {
				int value = originalMatrix[rowIndex][columnIndex];
				if (0 != value) {
					sparseMatrix[0][idx] = rowIndex;
					sparseMatrix[1][idx] = columnIndex;
					sparseMatrix[2][idx] = value;
					idx++;
				}
			}
		}
		return sparseMatrix;
	}// End of Method

	private static void print(int[][] sparseMatrix) {
		for (int i = 0; i < sparseMatrix[0].length; i++) {
			int orgRowIndex = sparseMatrix[0][i];
			int orgColIndex = sparseMatrix[1][i];
			int orgValue = sparseMatrix[2][i];
			System.out.println(//
					"ROW : " + orgRowIndex //
							+ " COLUMN : " + orgColIndex //
							+ " VALUE : " + orgValue // ;
			);
		}

	}

}// End of Class
