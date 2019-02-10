package test.solution.sort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import com.algorithms.sorting.SortSolution;
import com.algorithms.sorting.SortSolutionFactory;
import com.algorithms.sorting.SortSolutionType;
import com.algorithms.sorting.exception.BubbleSortSolutionSelectionException;
import com.algorithms.sorting.exception.SortSolutionSelectionException;

import test.support.generator.IRandomInputGenerator;
import test.support.generator.RandomInputGenerator;

class SortingTestSupport {

	public void testInput(int[] randomInput, SortSolutionType solutionType) {
		try {
			SortSolution sortSolution = SortSolutionFactory.getInstance().getSolution(solutionType);
			SortingTestResponse testResponse = new SortingTestResponse();
			testResponse.setRandomInput(randomInput);
			int[] expectedOutput = randomInput.clone();
			Arrays.sort(expectedOutput);
			testResponse.setExpectedOutput(expectedOutput);
			controlProtocol(testResponse, sortSolution);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed by Exception!");
		}
	}

	public void testBestCase(SortSolutionType solutionType) {

		int[] bestCase = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		testInput(bestCase, solutionType);

	}

	public void testWorstCase(SortSolutionType solutionType) {

		int[] worstCase = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		testInput(worstCase, solutionType);

	}

	public void testHalfInOrderOnMedian(SortSolutionType solutionType) {
		int[] halsfInOrderOnMedian = { 0, 1, 2, 3, 4, 9, 8, 7, 6, 5 };
		testInput(halsfInOrderOnMedian, solutionType);
	}

	public void testHalfInOrderOnMedianInReverse(SortSolutionType solutionType) {
		int[] halfInOrderOnMedianInReverse = { 9, 8, 7, 6, 5, 0, 1, 2, 3, 4 };
		testInput(halfInOrderOnMedianInReverse, solutionType);
	}

	public void testOneToFiveCase(SortSolutionType solutionType) {

		int[] maxRandomOneToFiveCase = { 5, 2, 1, 3, 4 };
		testInput(maxRandomOneToFiveCase, solutionType);

	}

	public void testHalfInOrderatRandom(SortSolutionType solutionType) {

		int[] halfInOrderatRandom = { 1, 2, 8, 9, 7, 7, 7, 2, 2, 1, 9, 6, 4, 7, 3, 4 };
		testInput(halfInOrderatRandom, solutionType);

	}

	public SortingTestRequest createTestRequest(int lenght, int upperbound, int lowerbound) {
		SortingTestRequest testRequest = new SortingTestRequest();
		testRequest.setLenght(lenght);
		testRequest.setUpperbound(upperbound);
		testRequest.setLowerbound(lowerbound);
		return testRequest;
	}

	public void runRandomizedTestCase(int lenght, int upperbound, int lowerbound, SortSolutionType solutionType) {
		SortingTestRequest testRequest = new SortingTestRequest();
		testRequest.setLenght(lenght);
		testRequest.setUpperbound(upperbound);
		testRequest.setLowerbound(lowerbound);
		runTestCase(testRequest, solutionType);
	}

	public void runTestCase(SortingTestRequest testRequest, SortSolutionType solutionType) {
		try {
			controlProtocol(prepareTest(testRequest), SortSolutionFactory.getInstance().getSolution(solutionType));
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void runTestCase(SortingTestResponse testResponse, SortSolutionType solutionType) {
		try {
			controlProtocol(testResponse, SortSolutionFactory.getInstance().getSolution(solutionType));
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SortingTestResponse prepareTest(SortingTestRequest testRequest) {
		SortingTestResponse testResponse = new SortingTestResponse();
		IRandomInputGenerator randomInputGenerator = new RandomInputGenerator();
		int[] randomInput = randomInputGenerator.generateIntegers(testRequest.getLenght(), testRequest.getUpperbound(),
				testRequest.getLowerbound());
		testResponse.setRandomInput(randomInput);
		int[] expectedOutput = randomInput.clone();
		Arrays.sort(expectedOutput);
		testResponse.setExpectedOutput(expectedOutput);
		return testResponse;
	}

	public void controlProtocol(SortingTestResponse testResponse, SortSolution solution) {
		int[] realOutput = solution.sort(testResponse.getRandomInput());
		int[] expectedOutput = testResponse.getExpectedOutput();
		for (int i = 0; i < realOutput.length; i++) {
			assertEquals(expectedOutput[i], realOutput[i]);
		}
	}

}
