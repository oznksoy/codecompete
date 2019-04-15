package com.hackerrank.test.support;

public class TestByStringRequest {
	private ITestBehaviour behaviour;
	private String input;
	private String output;
	private boolean printOutput;

	public ITestBehaviour getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(ITestBehaviour behaviour) {
		this.behaviour = behaviour;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public boolean isPrintOutput() {
		return printOutput;
	}

	public void setPrintOutput(boolean printOutput) {
		this.printOutput = printOutput;
	}

}// End of Class
