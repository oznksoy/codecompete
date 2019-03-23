package com.hackerrank.datastructures.linkedlist.easy;

public class DeleteDuplicateValueNodesFromaSortedLinkedList {

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

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		SinglyLinkedListNode current = head;
		while (current != null && current.next != null) {
			while (current.next != null && current.data == current.next.data) {
				SinglyLinkedListNode node = current.next;
				current.next = current.next.next;
				node = null; // helps garbage collector
			}
			current = current.next;
		}
		return head;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	/**
	 * <p>
	 * You're given the pointer to the head node of a sorted linked list, where the
	 * data in the nodes is in ascending order. Delete as few nodes as possible so
	 * that the list does not contain any value more than once. The given head
	 * pointer may be null indicating that the list is empty.
	 * </p>
	 * <p>
	 * Delete as few nodes as possible to ensure that no two nodes have the same
	 * data. Adjust the next pointers to ensure that the remaining nodes form a
	 * single sorted linked list.
	 * </p>
	 * 
	 * @param head
	 * @param expected
	 */
	static void testRemoveDuplicates(SinglyLinkedListNode head, int[] expected) {
		SinglyLinkedListNode cleanedListHeader = removeDuplicates(head);
		SinglyLinkedListNode current = cleanedListHeader;
		int index = 0;
		while (current != null) {
			assert current.data == expected[index];
			current = current.next;
			index++;
		}
		assert expected.length == index;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 });
		int[] expected = new int[] { 1, 2, 3, 4 };
		testRemoveDuplicates(list.head, expected);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 5, 6, 8, 9, 10, 11 });
		int[] expected = new int[] { 5, 6, 8, 9, 10, 11 };
		testRemoveDuplicates(list.head, expected);
	}// End of Test Case

	static void testCase3() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8 });
		int[] expected = new int[] { 6, 7, 8 };
		testRemoveDuplicates(list.head, expected);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
