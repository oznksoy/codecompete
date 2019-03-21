package com.hackerrank.datastructures.linkedlist.easy;

public class ReverseaLinkedListSolution {

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

	static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
		
		SinglyLinkedList reverselist = new SinglyLinkedList();
		reverse(head, reverselist);
		return reverselist.head;
		
	}// End of Method

	static void reverse(SinglyLinkedListNode head, SinglyLinkedList reversed) {

		if (head != null && head.next != null) {
			reverse(head.next, reversed);
		}

		if (head != null) {
			reversed.insertNode(head.data);
		}

	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testReverse(SinglyLinkedList list, int[] expected) {
		SinglyLinkedListNode head = reverse(list.head);
		SinglyLinkedListNode current = head;
		int i = 0;
		while (current != null) {
			System.out.println(current.data);
			assert current.data == expected[i];
			current = current.next;
			i++;
		}
		assert expected.length == i;
	}// End of Test

	static void testCase1() {
		int[] data = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReverse(list, new int[] { 9, 15, 4, 7, 19, 2, 6, 20 });
	}// End of Test Case

	static void testCase2() {
		int[] data = new int[] { 18, 11, 5, 36, 45, 1 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReverse(list, new int[] { 1, 45, 36, 5, 11, 18 });
	}// End of Test Case

	static void testCase3() {
		int[] data = new int[] { 16, 12, 4, 2, 5 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReverse(list, new int[] { 5, 2, 4, 12, 16 });
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
