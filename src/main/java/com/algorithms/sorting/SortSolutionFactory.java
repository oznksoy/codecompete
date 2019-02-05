package com.algorithms.sorting;

import com.algorithms.sorting.exception.SortSolutionBubbleSelectionException;
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

	public SortSolution getSolution(SortSolutionType type) throws SortSolutionSelectionException, SortSolutionBubbleSelectionException {
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
			return null;
		default:
			throw new SortSolutionSelectionException();
		}
	}

}
