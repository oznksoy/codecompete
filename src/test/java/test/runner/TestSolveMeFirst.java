package test.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hackerrank.algorithms.warmup.SolveMeFirstSolution;

import test.support.SystemInputOperator;
import test.support.TestEnvironmentConstants;

public class TestSolveMeFirst {

	SystemInputOperator inputOperator = new SystemInputOperator();

	@Test
	public void test() {
		String dir = TestEnvironmentConstants.resourcePath + "warmup/solvemefirst/input/";
		File file = new File(dir);
		File[] matches = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("input") && name.endsWith(".txt");
			}
		});
		for (final File match : matches) {
			try {
				InputStream inputStream = inputOperator.putToSystemInput(match);
				System.setIn(new FileInputStream(match));
				SolveMeFirstSolution.main(null);
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// End of Test Case

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

}
