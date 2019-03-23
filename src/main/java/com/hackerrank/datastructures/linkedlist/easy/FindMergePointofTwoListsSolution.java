package com.hackerrank.datastructures.linkedlist.easy;

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
	 * A linked list is said to contain a cycle if any node is visited more than
	 * once while traversing the list.
	 * </p>
	 * <p>
	 * Complete the function provided for you in your editor. It has one parameter:
	 * a pointer to a Node object named head that points to the head of a linked
	 * list. Your function must return a boolean denoting whether or not there is a
	 * cycle in the list. If there is a cycle, return true; otherwise, return false.
	 * </p>
	 * <p>
	 * Note: If the list is empty, head will be null.
	 * </p>
	 * 
	 * @param head
	 * @param expected
	 */
	static boolean hasCycle(SinglyLinkedListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		SinglyLinkedListNode tail = head.next;
		int indexTo = 1;
		while (tail != null) {
			SinglyLinkedListNode current = head;
			int index = indexTo;
			while (current != null && index > 0) {
				if (current.equals(tail)) {
					return true;
				}
				index--;
				current = current.next;
			}
			indexTo++;
			tail = tail.next;
		}
		return false;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testHasCycle(SinglyLinkedListNode head, boolean expected) {
		boolean result = hasCycle(head);
		assert result == expected;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 1, 4, 5, 8, 9 });
		SinglyLinkedListNode node = list.head.next.next;
		list.tail.next = node;
		testHasCycle(list.head, true);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 5, 6, 8, 9, 10, 11 });
		testHasCycle(list.head, false);
	}// End of Test Case

	static void testCase3() {
		SinglyLinkedList list = createFilledLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		SinglyLinkedListNode node = list.head;
		list.tail.next = node;
		testHasCycle(list.head, true);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
