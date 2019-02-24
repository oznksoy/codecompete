package com.algorithms.hackerrank.implementation.easy;

/**
 * <p>
 * Two cats and a mouse are at various positions on a line. You will be given
 * their starting positions. Your task is to determine which cat will reach the
 * mouse first, assuming the mouse doesn't move and the cats travel at equal
 * speed. If the cats arrive at the same time, the mouse will be allowed to move
 * and it will escape while they fight.
 * </p>
 * <p>
 * Complete the catAndMouse function in the editor below. It should return one
 * of the three strings as described.
 * 
 * catAndMouse has the following parameter(s):
 * <li>x: an integer, Cat A's position</li>
 * <li>y: an integer, Cat B's position</li>
 * <li>z: an integer, Mouse C's position</li>
 * </p>
 * 
 * @author Ozan Aksoy
 *
 */
public class CatsAndAMouseSolution {

	// Complete the catAndMouse function below.
	static String catAndMouse(int x, int y, int z) {

		int catA = x;
		int catB = y;
		int mouseC = z;

		int catAtoMouseC = Math.abs(mouseC - catA);
		int catBtoMouseC = Math.abs(mouseC - catB);

		if(catAtoMouseC < catBtoMouseC) {
			return "Cat A";
		} else if(catAtoMouseC > catBtoMouseC) {
			return "Cat B";
		} else {
			return "Mouse C";
		}
		
	}// End of Method

	public static void main(String[] args) {
		testCatAndMouse(1, 2, 3, "Cat B");
		testCatAndMouse(1, 3, 2, "Mouse Cs");
	}// End of Main

	static void testCatAndMouse(int x, int y, int z, String expected) {
		String result = catAndMouse(x, y, z);
		System.out.println(result);
		assert result.equals(expected);
	}

}
