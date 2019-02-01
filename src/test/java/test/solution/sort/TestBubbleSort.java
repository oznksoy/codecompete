package test.solution.sort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.sorting.BubbleSortSolution;
import com.algorithms.sorting.SortSolution;

import test.support.generator.IRandomInputGenerator;
import test.support.generator.RandomInputGenerator;

public class TestBubbleSort {

	@Test
	@Ignore
	public void test() {

		SortingTestRequest testRequest = new SortingTestRequest();
		testRequest.setLenght(100000);
		testRequest.setLowerbound(0);
		testRequest.setUpperbound(200);
		SortingTestResponse testResponse = prepareTest(testRequest);
		controlProtocol(testResponse, new BubbleSortSolution());

	}

	@Test
	@Ignore
	public void testBestCase() {

		SortingTestResponse testResponse = new SortingTestResponse();
		int[] randomInput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testResponse.setExpectedOutput(expectedOutput);

		controlProtocol(testResponse, new BubbleSortSolution());

	}

	@Test
	@Ignore
	public void testWorstCase() {

		SortingTestResponse testResponse = new SortingTestResponse();
		int[] randomInput = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testResponse.setExpectedOutput(expectedOutput);

		controlProtocol(testResponse, new BubbleSortSolution());

	}

	@Test
	@Ignore
	public void testHalfInOrderOnMedianInReverse() {

		SortingTestResponse testResponse = new SortingTestResponse();
		int[] randomInput = { 9, 8, 7, 6, 5, 0, 1, 2, 3, 4 };
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testResponse.setExpectedOutput(expectedOutput);

		controlProtocol(testResponse, new BubbleSortSolution());

	}

	@Test
	@Ignore
	public void testHalfInOrderOnMedian() {

		SortingTestResponse testResponse = new SortingTestResponse();
		int[] randomInput = { 0, 1, 2, 3, 4, 9, 8, 7, 6, 5 };
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testResponse.setExpectedOutput(expectedOutput);

		controlProtocol(testResponse, new BubbleSortSolution());

	}

	@Test
	public void testHalfInOrderatRandom() {

		SortingTestResponse testResponse = new SortingTestResponse();
		int[] randomInput = { 1, 2, 8, 9, 7, 7, 7, 2, 2, 1, 9, 6, 4, 7, 3, 4 };
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = randomInput.clone();
		Arrays.sort(expectedOutput);
		testResponse.setExpectedOutput(expectedOutput);

		controlProtocol(testResponse, new BubbleSortSolution());

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

	private void controlProtocol(SortingTestResponse testResponse, SortSolution solution) {
		int[] realOutput = solution.sort(testResponse.getRandomInput());
		int[] expectedOutput = testResponse.getExpectedOutput();
		for (int i = 0; i < realOutput.length; i++) {
			assertEquals(expectedOutput[i], realOutput[i]);
		}
	}

}
