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

public class TestPlainSort {

	@Test
	public void test() {

		SortingTestRequest testRequest = new SortingTestRequest();
		testRequest.setLenght(10000);
		testRequest.setLowerbound(0);
		testRequest.setUpperbound(50);
		SortingTestResponse testResponse = prepareTest(testRequest);
		try {
			controlProtocol(testResponse, SortSolutionFactory.getInstance().getSolution(SortSolutionType.PLAIN));
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

	private void controlProtocol(SortingTestResponse testResponse, SortSolution solution) {
		int[] realOutput = solution.sort(testResponse.getRandomInput());
		int[] expectedOutput = testResponse.getExpectedOutput();
		for (int i = 0; i < realOutput.length; i++) {
			assertEquals(expectedOutput[i], realOutput[i]);
		}
	}

}
