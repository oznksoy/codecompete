package test.support.generator;

public interface IRandomInputGenerator {
	
	public int[] generateIntegers(int lenght, int upperbound, int lowerbound);
	
	public int[] generateIntegers(int minLenght, int maxLenght, int upperbound, int lowerbound);
	
}
