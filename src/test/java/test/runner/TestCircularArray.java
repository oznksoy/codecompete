package test.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

import org.junit.Test;

import com.algorithms.hackerrank.implementation.CircularArrayRotationSolution;

import test.support.SystemInputOperator;
import test.support.TestEnvironmentConstants;

public class TestCircularArray {
	
	@Test
	public void testInput01() {
		String dir = TestEnvironmentConstants.resourcePath + "implementation/circulararrayrotation/input/";
		File file = new File(dir);
		File[] matches = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("input") && name.endsWith("11.txt");
			}
		});
		SystemInputOperator inputOperator = new SystemInputOperator();
		for (final File match : matches) {
			try {
				InputStream inputStream = inputOperator.putToSystemInput(match);
				System.setIn(new FileInputStream(match));
				CircularArrayRotationSolution.main(null);
				inputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
