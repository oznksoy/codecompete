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
		case PLAIN:
			return new PlainSortSolution();
		case BUBBLE_V1:
			return new BubbleSortSolution(BubbleSortVersion.V1).getActiveSolution();
		case BUBBLE_V2:
			return new BubbleSortSolution(BubbleSortVersion.V2).getActiveSolution();
		case BUBBLE_V3:
			return new BubbleSortSolution(BubbleSortVersion.V3).getActiveSolution();
		case INSERTION:
			return new InsertionSortSolution();
		case SELECTION:
			return new SelectionSortSolution();
		case MERGE_RECURSIVE_NAIVE:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_NAIVE).getActiveSolution();
		case MERGE_RECURSIVE_POLISHED:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_POLISHED).getActiveSolution();
		case MERGE_RECURSIVE_ARRAY_COPY:
			return new MergeSortSolution(MergeSortVersion.RECURSIVE_ARRAY_COPY).getActiveSolution();
		case MERGE_NON_RECURSIVE:
			return new MergeSortSolution(MergeSortVersion.NON_RECURSIVE).getActiveSolution();
		default:
			throw new SortSolutionSelectionException();
		}
	}

}
