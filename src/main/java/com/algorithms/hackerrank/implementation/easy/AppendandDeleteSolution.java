package com.algorithms.hackerrank.implementation.easy;

/**
 * 
 * <li>Append a lowercase English alphabetic letter to the end of the
 * string.</li>
 * <li>Delete the last character in the string.
 * <li>
 * <li>Performing deletion operation on an empty string results in an empty
 * string.</li>
 * 
 * @author Ozan Aksoy
 *
 */
public class AppendandDeleteSolution {

	// Complete the appendAndDelete function below.
	static String appendAndDelete(String s, String t, int k) {

		String yes = "Yes";
		String no = "No";

		char[] source = s.toCharArray();
		char[] target = t.toCharArray();

		int toDelete = source.length;
		for (int i = 0; i < source.length && i < target.length; i++) {
			if (source[i] == target[i]) {
				toDelete -= 1;
			} else {
				break;
			}
		}

		// Characters that match to target string
		int inorder = source.length - toDelete;
		// Number of minimum operation steps to achieve target from source
		int minNeededSteps = toDelete + (target.length - inorder);

		if (k < minNeededSteps) { // when received operation count is lower than minimum operation steps
			return no;
		} else if (k == minNeededSteps) { // equal to minimum needed operation steps
			return yes;
		} else if (k >= source.length + target.length) { // operation count is enough to totally delete and append
			return yes;
		} else { // if (k > minNeededSteps) but k < source + target char length
			if (inorder == 0) { // there are not any common characters between source and target
				return yes;
			} else { // inorder != 0 // there are common characters between source and target
				int df = k - minNeededSteps; // operations must be enough to delete and append redundantly
				if (df % 2 == 0) {
					return yes;
				}
				return no;
			}
		}

	}// End of Method

	public static void main(String[] args) {
		testAppendAndDelete("hackerhappy", "hackerrank", 21, "Yes");
		testAppendAndDelete("hackerhappy", "hackerrank", 15, "Yes");
		testAppendAndDelete("hackerhappy", "hackerrank", 9, "Yes");
		testAppendAndDelete("hackerhappy", "hackerrank", 8, "No");
		testAppendAndDelete("hacker", "hackerrank", 4, "Yes");
		testAppendAndDelete("hacker", "hackerrank", 3, "No");
		testAppendAndDelete("aba", "aba", 7, "Yes");
		testAppendAndDelete("aba", "aba", 6, "Yes");
		testAppendAndDelete("aba", "aba", 5, "No");
		testAppendAndDelete("aba", "aba", 0, "Yes");
		testAppendAndDelete("ashley", "ash", 2, "No");
		testAppendAndDelete("a", "a", 0, "Yes");
		testAppendAndDelete("hackerhappy", "hackerrank", 11, "Yes");
		testAppendAndDelete("aaaaaaaaaa", "aaaaa", 7, "Yes");
	}

	static void testAppendAndDelete(String s, String t, int k, String expected) {
		String result = appendAndDelete(s, t, k);
		System.out.println(result);
		assert expected.equals(result);
	}

}// End of Class
