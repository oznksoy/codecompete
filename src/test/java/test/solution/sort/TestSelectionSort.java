package test.solution.sort;

import org.junit.Before;
import org.junit.Test;

import com.algorithms.sorting.SortSolutionType;

public class TestSelectionSort extends AbstSortSolutionTest {

	@Before
	public void setup() throws Exception {
		setSolutionTypeToTest();
	}

	@Override
	public void setSolutionTypeToTest() {
		solutionType = SortSolutionType.SELECTION;
	}

	@Override
	@Test
	public void testRandomizedTestCase() {
		testSupport.runRandomizedTestCase(100000, 200, 0, solutionType);
	}

	@Override
	@Test
	public void testBestCase() {
		super.testBestCase();
	}

	@Override
	@Test
	public void testWorstCase() {
		super.testWorstCase();
	}

	@Override
	@Test
	public void testHalfInOrderatRandom() {
		super.testHalfInOrderatRandom();
	}

	@Override
	@Test
	public void testHalfInOrderOnMedian() {
		super.testHalfInOrderOnMedian();
	}

	@Override
	@Test
	public void testHalfInOrderOnMedianInReverse() {
		super.testHalfInOrderOnMedianInReverse();
	}

	@Override
	@Test
	public void testOneToFiveCase() {
		super.testOneToFiveCase();
	}

}// End of Test Case
