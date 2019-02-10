package com.algorithms.sorting;

import com.algorithms.sorting.exception.BubbleSortSolutionSelectionException;
import com.algorithms.sorting.exception.MergeSortSolutionSelectionException;
import com.algorithms.sorting.exception.SortSolutionSelectionException;

public class SortSolutionFactory {

	private static SortSolutionFactory instance;

	private SortSolutionFactory() {
	}

	public static SortSolutionFactory getInstance() {
		if (instance == null) {
			instance = new SortSolutionFactory();
		}
		return instance;
	}

	public SortSolution getSolution(SortSolutionType type) throws SortSolutionSelectionException,
			BubbleSortSolutionSelectionException, MergeSortSolutionSelectionException {
		switch (type) {
		case BRUTE:
			return new PlainSortSolution();
		case BUBBLE_UNCHECKED_SWAPS:
			return new BubbleSortSolution(BubbleSortVersion.UNCHECKED_SWAPS).getActiveSolution();
		case BUBBLE_IS_SWAP_CHECKED:
			return new BubbleSortSolution(BubbleSortVersion.IS_SWAP_CHECKED).getActiveSolution();
		case BUBBLE_LAST_SWAP_INDEX_CHECK:
			return new BubbleSortSolution(BubbleSortVersion.LAST_SWAP_INDEX_CHECK).getActiveSolution();
		case INSERTION:
			return new InsertionSortSolution();
		case SELECTION:
			return new SelectionSortSolution();
		case MERGE_RECURSIVE_SORTED_BY_INSERTION:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_SORTED_BY_INSERTION).getActiveSolution();
		case MERGE_RECURSIVE_NLOGN_SPACE:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_NLOGN_SPACE).getActiveSolution();
		case MERGE_RECURSIVE_N_SPACE:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_N_SPACE).getActiveSolution();
		case MERGE_RECURSIVE_ONE_SPACE:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_ONE_SPACE).getActiveSolution();
		case MERGE_RECURSIVE_NLOGN_SPACE_DIVISION_ON_MERGE:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_NLOGN_SPACE_DIVISION_ON_MERGE).getActiveSolution();
		case MERGE_RECURSIVE_ARRAY_COPY:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_ARRAY_COPY).getActiveSolution();
		case MERGE_NON_RECURSIVE:
			return new MergeSortSolution(MergeSortVersion.NON_RECURSIVE).getActiveSolution();
		default:
			throw new SortSolutionSelectionException();
		}
	}

}
