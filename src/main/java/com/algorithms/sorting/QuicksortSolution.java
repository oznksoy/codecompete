package com.algorithms.sorting;

import com.algorithms.sorting.exception.QuickSortSortSolutionSelectionException;

class QuicksortSolution {

	private SortSolution activeSolution;
	private SortSolutionUtil util;

	public QuicksortSolution(QuickSortVersion version) throws QuickSortSortSolutionSelectionException {
		util = SortSolutionUtil.getInstance();
		activeSolution = setQuickSortSolutions(version);
	}

	public SortSolution getActiveSolution() {
		return this.activeSolution;
	}

	public SortSolution setQuickSortSolutions(QuickSortVersion version) throws QuickSortSortSolutionSelectionException {
		switch (version) {
		case INITIAL_PIVOT:
			return new QuickSortInitialPivot();
		case MIDDLE_PIVOT:
			return new QuickSortMiddleIndexPivot();
		case RANDOM_PIVOT:
			return new QuickSortRandomIndexPivot();
		case DUAL_PIVOT:
			return new QuickSortDualPivot();
		default:
			throw new QuickSortSortSolutionSelectionException();
		}
	}

	private class QuickSortInitialPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

	private class QuickSortMiddleIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

	private class QuickSortRandomIndexPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

	private class QuickSortDualPivot implements SortSolution {

		@Override
		public int[] sort(int[] inputArray) {
			return null;
		}

	}

}
