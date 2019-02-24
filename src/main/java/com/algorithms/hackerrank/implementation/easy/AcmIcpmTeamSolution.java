package com.algorithms.hackerrank.implementation.easy;

public class AcmIcpmTeamSolution {

	// Complete the acmTeam function below.
	static int[] acmTeam(String[] topic) {

		int numOfAttendees = topic.length;
		int numOfTopics = (topic[0]).length();

		int maxSubjects = 0;
		int maxMatchingTeams = 0;
		for (int i = 0; i < numOfAttendees - 1; i++) {
			for (int j = i + 1; j < numOfAttendees; j++) {
				int knonwSubjectCount = 0;
				String attendee1 = topic[i];
				String attendee2 = topic[j];
				for (int k = 0; k < numOfTopics; k++) {
					char t1 = attendee1.charAt(k);
					char t2 = attendee2.charAt(k);
					if (t1 == '1' || t2 == '1') {
						knonwSubjectCount++;
					}
				}
				if (maxSubjects < knonwSubjectCount) {
					maxSubjects = knonwSubjectCount;
					maxMatchingTeams = 1;
				} else if (maxSubjects == knonwSubjectCount) {
					maxMatchingTeams++;
				}
			}
		}

		int[] result = new int[] { maxSubjects, maxMatchingTeams };

		return result;

	}// End of Method

	public static void main(String[] args) {
		testACMTeam(new String[] { "10101", "11110", "00010" }, //
				new int[] { 5, 1 });
		testACMTeam(new String[] { "10101", "11100", "11010", "00101" }, //
				new int[] { 5, 2 });
	}// End of Main

	static void testACMTeam(String[] topic, int[] expected) {
		int[] result = acmTeam(topic);
		for (int value : result) {
			System.out.println(value);
		}
		assert result.length == expected.length;
		for (int i = 0; i < expected.length; i++) {
			assert expected[i] == result[i];
		}
	}// End of Test

}
