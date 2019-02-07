package test.solution.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.algorithms.sorting.SortSolution;
import com.algorithms.sorting.SortSolutionFactory;
import com.algorithms.sorting.SortSolutionType;
import com.algorithms.sorting.exception.BubbleSortSolutionSelectionException;
import com.algorithms.sorting.exception.SortSolutionSelectionException;

import test.support.generator.IRandomInputGenerator;
import test.support.generator.RandomInputGenerator;

public class TestBubbleSort {

	@Test
	public void testBubbleSortPureImplementation() {

		runRandomizedTestCase(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testBubbleSortOptimizedWithSwapCheck() {

		runRandomizedTestCase(SortSolutionType.BUBBLE_V2);

	}

	@Test
	public void testBubbleSortOptimizedWithLastSwapIndex() {

		runRandomizedTestCase(SortSolutionType.BUBBLE_V3);

	}

	private void runRandomizedTestCase(SortSolutionType solutionType) {
		try {
			SortingTestRequest testRequest = new SortingTestRequest();
			testRequest.setLenght(10000);
			testRequest.setLowerbound(0);
			testRequest.setUpperbound(200);
			SortingTestResponse testResponse = prepareTest(testRequest);
			controlProtocol(testResponse, SortSolutionFactory.getInstance().getSolution(solutionType));
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private SortingTestResponse prepareTest(SortingTestRequest testRequest) {
		SortingTestResponse testResponse = new SortingTestResponse();
		// Prepare and set generated random output for test
		IRandomInputGenerator randomInputGenerator = new RandomInputGenerator();
		int[] randomInput = randomInputGenerator.generateIntegers(testRequest.getLenght(), testRequest.getUpperbound(),
				testRequest.getLowerbound());
		testResponse.setRandomInput(randomInput);
		// Prepare and set expected output via Java utilities
		int[] expectedOutput = randomInput.clone();
		Arrays.sort(expectedOutput);
		testResponse.setExpectedOutput(expectedOutput);
		return testResponse;
	}
	
	@Test
	public void testBestCaseV1() {

		testBestCase(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testBestCaseV2() {

		testBestCase(SortSolutionType.BUBBLE_V2);

	}

	@Test
	public void testBestCaseV3() {

		testBestCase(SortSolutionType.BUBBLE_V3);

	}

	private void testBestCase(SortSolutionType solutionType) {

		try {
			SortingTestResponse testResponse = new SortingTestResponse();
			int[] randomInput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			testResponse.setExpectedOutput(expectedOutput);
			controlProtocol(testResponse, SortSolutionFactory.getInstance().getSolution(solutionType));
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testWorstCaseV1() {

		testWorstCase(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testWorstCaseV2() {

		testWorstCase(SortSolutionType.BUBBLE_V2);

	}

	@Test
	public void testWorstCaseV3() {

		testWorstCase(SortSolutionType.BUBBLE_V3);

	}

	private void testWorstCase(SortSolutionType solutionType) {

		try {
			SortingTestResponse testResponse = new SortingTestResponse();
			int[] randomInput = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			testResponse.setExpectedOutput(expectedOutput);
			SortSolution sortSolution = SortSolutionFactory.getInstance().getSolution(solutionType);
			controlProtocol(testResponse, sortSolution);
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testHalfInOrderOnMedianInReverseV1() {

		testHalfInOrderOnMedianInReverse(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testHalfInOrderOnMedianInReverseV2() {

		testHalfInOrderOnMedianInReverse(SortSolutionType.BUBBLE_V2);
	}

	@Test
	public void testHalfInOrderOnMedianInReverseV3() {

		testHalfInOrderOnMedianInReverse(SortSolutionType.BUBBLE_V3);

	}

	private void testHalfInOrderOnMedianInReverse(SortSolutionType solutionType) {

		try {
			SortSolution sortSolution = SortSolutionFactory.getInstance().getSolution(solutionType);
			SortingTestResponse testResponse = new SortingTestResponse();
			int[] randomInput = { 9, 8, 7, 6, 5, 0, 1, 2, 3, 4 };
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			testResponse.setExpectedOutput(expectedOutput);
			controlProtocol(testResponse, sortSolution);
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void testHalfInOrderOnMedianV1() {

		testHalfInOrderOnMedian(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testHalfInOrderOnMedianV2() {

		testHalfInOrderOnMedian(SortSolutionType.BUBBLE_V2);

	}

	@Test
	public void testHalfInOrderOnMedianV3() {

		testHalfInOrderOnMedian(SortSolutionType.BUBBLE_V3);

	}

	private void testHalfInOrderOnMedian(SortSolutionType solutionType) {

		try {
			SortSolution sortSolution = SortSolutionFactory.getInstance().getSolution(solutionType);
			SortingTestResponse testResponse = new SortingTestResponse();
			int[] randomInput = { 0, 1, 2, 3, 4, 9, 8, 7, 6, 5 };
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			testResponse.setExpectedOutput(expectedOutput);
			controlProtocol(testResponse, sortSolution);
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testHalfInOrderatRandomV1() {

		testHalfInOrderatRandom(SortSolutionType.BUBBLE_V1);

	}

	@Test
	public void testHalfInOrderatRandomV2() {

		testHalfInOrderatRandom(SortSolutionType.BUBBLE_V2);

	}

	@Test
	public void testHalfInOrderatRandomV3() {

		testHalfInOrderatRandom(SortSolutionType.BUBBLE_V3);

	}

	private void testHalfInOrderatRandom(SortSolutionType solutionType) {

		try {
			SortSolution sortSolution = SortSolutionFactory.getInstance().getSolution(solutionType);
			SortingTestResponse testResponse = new SortingTestResponse();
			int[] randomInput = { 1, 2, 8, 9, 7, 7, 7, 2, 2, 1, 9, 6, 4, 7, 3, 4 };
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = randomInput.clone();
			Arrays.sort(expectedOutput);
			testResponse.setExpectedOutput(expectedOutput);
			controlProtocol(testResponse, sortSolution);
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void controlProtocol(SortingTestResponse testResponse, SortSolution solution) {
		int[] realOutput = solution.sort(testResponse.getRandomInput());
		int[] expectedOutput = testResponse.getExpectedOutput();
		for (int i = 0; i < realOutput.length; i++) {
			assertEquals(expectedOutput[i], realOutput[i]);
		}
	}

}
