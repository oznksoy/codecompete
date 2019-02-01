package test.runner;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

import org.junit.Ignore;
import org.junit.Test;

import com.algorithms.warmup.plusminus.Solution;

import test.support.SystemInputOperator;
import test.support.TestEnvironmentConstants;

public class TestPlusMinus {

	@Test
	@Ignore
	public void test() {

		String pathname = TestEnvironmentConstants.resourcePath + "warmup/plusminus/input/input01.txt";

		File file = new File(pathname);

		SystemInputOperator inputReader = new SystemInputOperator();
		try {
			inputReader.putToSystemInput(file);
		} catch (FileNotFoundException e) {
			fail("Exception was thrown");
			e.printStackTrace();
		}

	}

	@Test
	public void test3() {
		String dir = TestEnvironmentConstants.resourcePath + "warmup/plusminus/input/";
		File file = new File(dir);
		File[] matches = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("input") && name.endsWith(".txt");
			}
		});
		SystemInputOperator inputReader = new SystemInputOperator();
		for (File match : matches) {
			try {
				inputReader.putToSystemInput(match);
				Solution.main(null);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
