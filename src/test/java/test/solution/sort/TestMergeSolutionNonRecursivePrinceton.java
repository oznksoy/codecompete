package test.solution.sort;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.sorting.SortSolutionType;

public class TestMergeSolutionNonRecursivePrinceton extends AbstSortSolutionTest {

	@Before
	public void setup() throws Exception {
		setSolutionTypeToTest();
	}

	@Override
	public void setSolutionTypeToTest() {
		solutionType = SortSolutionType.MERGE_NON_RECURSIVE_PRINCETON;
	}

	@Override
	@Test
	public void testRandomizedTestCase() {
		testSupport.runRandomizedTestCase(500000, 200, 0, solutionType);
	}

	@Override
	@Test
	@Ignore
	public void testBestCase() {
		super.testBestCase();
	}

	@Override
	@Test
	@Ignore
	public void testWorstCase() {
		super.testWorstCase();
	}

	@Override
	@Test
	@Ignore
	public void testHalfInOrderatRandom() {
		super.testHalfInOrderatRandom();
	}

	@Override
	@Test
	@Ignore
	public void testHalfInOrderOnMedian() {
		super.testHalfInOrderOnMedian();
	}

	@Override
	@Test
	@Ignore
	public void testHalfInOrderOnMedianInReverse() {
		super.testHalfInOrderOnMedianInReverse();
	}

	@Override
	@Test
	@Ignore
	public void testOneToFiveCase() {
		super.testOneToFiveCase();
	}

}// End of Test Case
