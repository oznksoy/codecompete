package test.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SystemInputOperator {

	public SystemInputOperator() {

	}

	public InputStream putToSystemInput(File file) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(file);
//		System.out.println("Path : " + file.getAbsolutePath());
		System.setIn(fileInputStream);
		return System.in;
	}

}
