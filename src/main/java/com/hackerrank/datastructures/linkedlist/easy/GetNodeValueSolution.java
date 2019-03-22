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

	// Both lists are in ascending order
	static int getNode(SinglyLinkedListNode head, int positionFromTail) {

		return 0;
	}

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testGetNode(SinglyLinkedListNode head, int positionFromTail, int expected) {
		int result = getNode(head, positionFromTail);
		assert result == expected;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 5, 7, 9 });
		testGetNode(list.head, 0, 0);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
