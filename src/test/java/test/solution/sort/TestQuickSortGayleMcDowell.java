package test.solution.sort;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.sorting.SortSolutionType;

public class TestQuickSortGayleMcDowell extends AbstSortSolutionTest {

	@Before
	public void setup() throws Exception {
		setSolutionTypeToTest();
	}

	@Override
	public void setSolutionTypeToTest() {
		solutionType = SortSolutionType.QUICK_GAYLE_MCDOWELL;
	}

	@Override
	@Test
	@Ignore
	public void testRandomizedTestCase() {
		testSupport.runRandomizedTestCase(100000, 200, 0, solutionType);
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
	public void testOneToFiveCase() {
		super.testOneToFiveCase();
	}

}
