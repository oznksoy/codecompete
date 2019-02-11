package test.solution.sort;

import org.junit.Before;
import org.junit.Test;

import com.algorithms.sorting.SortSolutionType;

public class TestSortSolutionPerformance {

	SortingTestRequest testRequest;
	SortingTestResponse testResponse;
	SortingTestSupport testSupport;

	@Before
	public void setup() {

		this.testSupport = new SortingTestSupport();
		this.testRequest = testSupport.createTestRequest(100000, 100000, 0);
		this.testResponse = this.testSupport.prepareTest(testRequest);
	}

	@Test
	public void testBruteSort() {
		testSupport.runTestCase(testResponse, SortSolutionType.BRUTE);
	}

	@Test
	public void testBubbleSortUncheckedSwaps() {
		testSupport.runTestCase(testResponse, SortSolutionType.BUBBLE_UNCHECKED_SWAPS);
	}

	@Test
	public void testBubbleSortIsSwapChecked() {
		testSupport.runTestCase(testResponse, SortSolutionType.BUBBLE_IS_SWAP_CHECKED);
	}

	@Test
	public void testBubbleSortLastSwapIndexCheck() {
		testSupport.runTestCase(testResponse, SortSolutionType.BUBBLE_LAST_SWAP_INDEX_CHECK);
	}

	@Test
	public void testSelectionSort() {
		testSupport.runTestCase(testResponse, SortSolutionType.SELECTION);
	}

	@Test
	public void testInsersionSort() {
		testSupport.runTestCase(testResponse, SortSolutionType.INSERTION);
	}

	@Test
	public void testMergeSortRecursiveSortedByInsertion() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_SORTED_BY_INSERTION);
	}

	@Test
	public void testMergeSortRecursiveArrayCopy() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_ARRAY_COPY);
	}

	@Test
	public void testMergeSortRecursiveNaiveNLogNSpace() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_NLOGN_SPACE);
	}

	@Test
	public void testMergeSortRecursiveNaiveNSpace() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_N_SPACE);
	}

	@Test
	public void testMergeSortRecursiveNaiveOneSpace() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_ONE_SPACE);
	}

	@Test
	public void testMergeSortRecursivePolished() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_RECURSIVE_NLOGN_SPACE_DIVISION_ON_MERGE);
	}
	
	@Test
	public void testMergeSortNonrecursive() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_NON_RECURSIVE);
	}
	
	@Test
	public void testMergeSortNonrecursivePrinceton() {
		testSupport.runTestCase(testResponse, SortSolutionType.MERGE_NON_RECURSIVE_PRINCETON);
	}

}// End of Test Case
