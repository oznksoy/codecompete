package com.hackerrank.datastructures.linkedlist.easy;

public class GetNodeValueSolution {

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

	static int getNode(SinglyLinkedListNode head, int positionFromTail) {

		if (head == null) {
			return 0;
		}

		SinglyLinkedListNode current = head.next;

		int index = 0;
		SinglyLinkedListNode target = head;
		while (current != null) {
			if (index == positionFromTail) {
				target = target.next;
			}
			if (index < positionFromTail) {
				index++;
			}
			current = current.next;
		}

		return target.data;

	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testGetNode(SinglyLinkedListNode head, int positionFromTail, int expected) {
		int result = getNode(head, positionFromTail);
		assert result == expected;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 4, 3, 2, 1 });
		testGetNode(list.head, 2, 3);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 5, 6, 7, 8, 4, 3, 2, 1 });
		testGetNode(list.head, 2, 3);
	}// End of Test Case
	
	static void testCase3() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 5, 6, 7, 8, 4, 3, 2, 1 });
		testGetNode(list.head, 4, 8);
	}// End of Test Case


	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
