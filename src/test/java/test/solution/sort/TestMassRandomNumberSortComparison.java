package test.solution.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.sorting.SortSolution;
import com.algorithms.sorting.SortSolutionFactory;
import com.algorithms.sorting.SortSolutionType;
import com.algorithms.sorting.exception.BubbleSortSolutionSelectionException;
import com.algorithms.sorting.exception.SortSolutionSelectionException;

import test.support.generator.IRandomInputGenerator;
import test.support.generator.RandomInputGenerator;

public class TestMassRandomNumberSortComparison {

	SortingTestRequest testRequest;
	SortingTestResponse testResponse;

	@Before
	public void setup() {
		this.testRequest = prepareTestRequest();
		this.testResponse = prepareTestResponse(testRequest);
	}

	@Test
	@Ignore
	public void testPlainSort() {
		controlProtocol(testResponse, SortSolutionType.PLAIN);
	}

	@Test
	@Ignore
	public void testBubbleSort() {
		controlProtocol(testResponse, SortSolutionType.BUBBLE_V3);
	}

	@Test
	@Ignore
	public void testSelectionSort() {
		controlProtocol(testResponse, SortSolutionType.SELECTION);
	}

	@Test
	@Ignore
	public void testInsersionSort() {
		controlProtocol(testResponse, SortSolutionType.INSERTION);
	}

	@Test
	public void testMergeSortRecursiveNaiveSorter() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_NAIVE_SORTER);
	}

	@Test
	public void testMergeSortRecursiveArrayCopy() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_ARRAY_COPY);
	}

	@Test
	public void testMergeSortRecursiveNaiveNLogNSpace() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_NLOGN_SPACE);
	}

	@Test
	public void testMergeSortRecursiveNaiveNSpace() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_N_SPACE);
	}

	@Test
	public void testMergeSortRecursiveNaiveOneSpace() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_ONE_SPACE);
	}

	@Test
	public void testMergeSortRecursivePolished() {
		controlProtocol(testResponse, SortSolutionType.MERGE_RECURSIVE_POLISHED);
	}

	private SortingTestRequest prepareTestRequest() {
		SortingTestRequest testRequest = new SortingTestRequest();
		testRequest.setLenght(1000000);
		testRequest.setLowerbound(0);
		testRequest.setUpperbound(200);
		return testRequest;
	}

	private SortingTestResponse prepareTestResponse(SortingTestRequest testRequest) {
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

	private void controlProtocol(SortingTestResponse testResponse, SortSolutionType solutionType) {
		try {
			SortSolution solution = SortSolutionFactory.getInstance().getSolution(solutionType);
			int[] realOutput = solution.sort(testResponse.getRandomInput());
			int[] expectedOutput = testResponse.getExpectedOutput();
			for (int i = 0; i < realOutput.length; i++) {
				assertEquals(expectedOutput[i], realOutput[i]);
			}
		} catch (SortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (BubbleSortSolutionSelectionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
