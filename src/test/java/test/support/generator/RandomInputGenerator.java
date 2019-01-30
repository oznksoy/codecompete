package test.support.generator;

import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomInputGenerator implements IRandomInputGenerator{

	public int[] generateIntegers(int lenght, int upperbound, int lowerbound) {
		Random random = new Random();
		int randomNumberOrigin = lowerbound;
		int randomNumberBound = upperbound + 1;
		IntStream stream = random.ints(randomNumberOrigin, randomNumberBound);
		OfInt iterator = stream.iterator();
		int[] array = new int[lenght];
		int i = 0;
		while(i<lenght) {
			array[i] = iterator.nextInt();
			i++;
		}
		return array;
	}

	public int[] generateIntegers(int minLenght, int maxLenght, int upperbound, int lowerbound) {
		int lenght = generateSingleRandom(minLenght, maxLenght);
		return generateIntegers(lenght, upperbound, lowerbound);
	}
	
	private int generateSingleRandom(int upperbound, int lowerbound) {
		return (new Random()).ints(lowerbound, upperbound + 1).iterator().nextInt();		
	}
	
//	private int[] generateIntegers(int lenght, int upperbound, int lowerbound) {
//		Random random = new Random();
//		int randomNumberOrigin = lowerbound;
//		int randomNumberBound = upperbound + 1;
//		IntStream stream = random.ints(randomNumberOrigin, randomNumberBound);
//		OfInt iterator = stream.iterator();
//		int[] array = new int[lenght];
//		int i = 0;
//		while(i<lenght) {
//			array[i] = iterator.nextInt();
//			i++;
//		}
//		return array;
//	}
	
	
	
}
