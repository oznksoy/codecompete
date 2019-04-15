package com.hackerrank.test.support;

public class TestByFileRequest {

	private ITestBehaviour testBehaviour;
	private String dir;
	private String inputFileName;
	private String outputFileName;

	public ITestBehaviour getTestBehaviour() {
		return testBehaviour;
	}

	public void setTestBehaviour(ITestBehaviour testBehaviour) {
		this.testBehaviour = testBehaviour;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

}// End of Class
