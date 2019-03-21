package com.hackerrank.datastructures.linkedlist.easy;

public class CompareTwoLinkedListsSolution {

	private static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

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
	}

	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		SinglyLinkedListNode cur1 = head1;
		SinglyLinkedListNode cur2 = head2;

		if (cur1 == null && cur2 != null || cur1 != null && cur2 == null) {
			return false;
		}

		while (cur1 != null && cur2 != null) {
			if (cur1.data != cur2.data) {
				return false;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
			if (cur1 == null && cur2 != null || cur1 != null && cur2 == null) {
				return false;
			}
		}
		return true;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
	}// End of Main

	static void testCompareLists(SinglyLinkedList list1, SinglyLinkedList list2, boolean expected) {
		boolean result = compareLists(list1.head, list2.head);
		assert result == expected;
	}// End of Test

	static void testCase1() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 20, 6, 2, 19, 7, 4, 15, 9 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 20, 6, 2, 19, 7, 4, 15, 9 });
		testCompareLists(list1, list2, true);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 18, 11, 5, 36, 45, 1 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 18, 11, 15, 36, 45, 1 });
		testCompareLists(list1, list2, false);
	}// End of Test Case

	static void testCase3() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 16, 12, 4, 2, 5 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 17, 12, 4, 2, 8 });
		testCompareLists(list1, list2, false);
	}// End of Test Case

	static void testCase4() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 16, 12, 4, 2, 5 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 16, 12, 4, 2 });
		testCompareLists(list1, list2, false);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
