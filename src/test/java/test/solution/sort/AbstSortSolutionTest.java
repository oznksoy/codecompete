package test.solution.sort;

import com.algorithms.sorting.SortSolutionType;

abstract class AbstSortSolutionTest implements ISortSolutionTest {

	SortingTestSupport testSupport = new SortingTestSupport();
	SortSolutionType solutionType;

	public abstract void setSolutionTypeToTest();

	@Override
	public abstract void testRandomizedTestCase();

	@Override
	public void testBestCase() {
		testSupport.testBestCase(solutionType);
	}

	@Override
	public void testWorstCase() {
		testSupport.testWorstCase(solutionType);
	}

	@Override
	public void testHalfInOrderOnMedian() {
		testSupport.testHalfInOrderOnMedian(solutionType);
	}

	@Override
	public void testHalfInOrderOnMedianInReverse() {
		testSupport.testHalfInOrderOnMedianInReverse(solutionType);

	}

	@Override
	public void testHalfInOrderatRandom() {
		testSupport.testHalfInOrderatRandom(solutionType);
	}

	@Override
	public void testOneToFiveCase() {
		testSupport.testOneToFiveCase(solutionType);
	}

}
