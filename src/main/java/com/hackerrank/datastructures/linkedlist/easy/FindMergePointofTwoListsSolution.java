package com.hackerrank.datastructures.linkedlist.easy;

import java.io.File;
import java.util.Scanner;

public class FindMergePointofTwoListsSolution {

	private static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}// End of Inner Class

	private static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}// End of Inner Class

	/**
	 * <p>
	 * Given pointers to the head nodes of linked lists that merge together at some
	 * point, find the Node where the two lists merge. It is guaranteed that the two
	 * head Nodes will be different, and neither will be NULL.
	 * </p>
	 * <p>
	 * Complete the int findMergeNode(SinglyLinkedListNode* head1,
	 * SinglyLinkedListNode* head2) method so that it finds and returns the data
	 * value of the Node where the two lists merge.
	 * </p>
	 * <li>the lists will merge</li>
	 * <li>head1 and head2 != null</li>
	 * <li>head1 != head2</li>
	 * 
	 * @param head
	 * @param expected
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		SinglyLinkedListNode cur1 = head1;
		SinglyLinkedListNode cur2 = head2;

		int result = 0;

		while (cur1 != null && cur2 != null) {

			SinglyLinkedListNode iter1 = cur1;
			SinglyLinkedListNode iter2 = cur2;

			while (iter2 != null && !cur1.equals(iter2)) {
				iter2 = iter2.next;
			}

			while (iter1 != null && iter2 != null && !iter1.equals(iter2)) {
				iter1 = iter1.next;
			}

			if (iter1 != null && iter2 != null && iter1.equals(iter2)) {
				result = iter1.data;
			}

			while (iter1 != null && iter2 != null && iter1.equals(iter2)) {
				iter1 = iter1.next;
				iter2 = iter2.next;
				if (iter1 == null && iter2 == null) {
					return result;
				}
			}
			cur1 = cur1.next;
		}

		return result;

	}// End of Method

	public static void main(String[] args) {

		testCase1();
		testCase2();
		testCase3();

		testInput02();

	}// End of Main

	static void testFindMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int expected) {
		int result = findMergeNode(head1, head2);
		assert result == expected;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1, 2, 4 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1, 3, 5 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 6, 9 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 6);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 2, 5, 8, 9 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 2);
	}// End of Test Case

	static void testCase3() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1, 2, 15, 14 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1, 3 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 4, 8, 11 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 4);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

	static void testInput02() {

		String dir = "src/main/resources/datastructures/findmergepointoftwolists/";
		File inputFile = new File(dir + "input02.txt");
		File outputFile = new File(dir + "output02.txt");

		try {

			Scanner inputScanner = new Scanner(inputFile);

			int tests = inputScanner.nextInt();

			inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			Scanner outputScanner = new Scanner(outputFile);

			outputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int testsItr = 0; testsItr < tests; testsItr++) {
				int index = inputScanner.nextInt();
				inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				SinglyLinkedList llist1 = new SinglyLinkedList();

				int llist1Count = inputScanner.nextInt();
				inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int i = 0; i < llist1Count; i++) {
					int llist1Item = inputScanner.nextInt();
					inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

					llist1.insertNode(llist1Item);
				}

				SinglyLinkedList llist2 = new SinglyLinkedList();

				int llist2Count = inputScanner.nextInt();
				inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int i = 0; i < llist2Count; i++) {
					int llist2Item = inputScanner.nextInt();
					inputScanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

					llist2.insertNode(llist2Item);
				}

				SinglyLinkedListNode ptr1 = llist1.head;
				SinglyLinkedListNode ptr2 = llist2.head;

				for (int i = 0; i < llist1Count; i++) {
					if (i < index) {
						ptr1 = ptr1.next;
					}
				}

				for (int i = 0; i < llist2Count; i++) {
					if (i != llist2Count - 1) {
						ptr2 = ptr2.next;
					}
				}

				ptr2.next = ptr1;

				String output = outputScanner.nextLine();

				int expected = Integer.valueOf(output);

				testFindMergeNode(llist1.head, llist2.head, expected);

			}

			inputScanner.close();
			outputScanner.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// End of Test from file source

}// End of Class
