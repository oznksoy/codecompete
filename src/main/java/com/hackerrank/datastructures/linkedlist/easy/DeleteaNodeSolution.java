package com.hackerrank.datastructures.linkedlist.easy;

public class DeleteaNodeSolution {

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

	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
		SinglyLinkedListNode current = head;
		if (position != 0) {
			int index = 0;
			while (current != null && index < position - 1) {
				current = current.next;
				index++;
			}
			SinglyLinkedListNode nodeToDelete = current.next;
			current.next = current.next.next;
			nodeToDelete = null;// helps garbage collector
			return head;
		}
		SinglyLinkedListNode newHead = head.next;
		head = null;// helps garbage collector
		return newHead;
	}

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testDeleteaNode(SinglyLinkedList list, int position, int[] expected) {
		SinglyLinkedListNode head = deleteNode(list.head, position);
		list.head = head;
		SinglyLinkedListNode current = list.head;
		int i = 0;
		while (current != null) {
//			System.out.println(current.data);
			assert current.data == expected[i];
			current = current.next;
			i++;
		}
		assert expected.length == i;
	}// End of Test

	static void testCase1() {
		int[] data = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testDeleteaNode(list, 3, new int[] { 20, 6, 2, 7, 4, 15, 9 });
	}// End of Test Case

	static void testCase2() {
		int[] data = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testDeleteaNode(list, 7, new int[] { 20, 6, 2, 19, 7, 4, 15 });
	}// End of Test Case

	static void testCase3() {
		int[] data = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testDeleteaNode(list, 0, new int[] { 6, 2, 19, 7, 4, 15, 9 });
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
