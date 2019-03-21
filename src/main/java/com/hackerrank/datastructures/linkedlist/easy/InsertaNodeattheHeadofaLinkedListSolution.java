package com.hackerrank.datastructures.linkedlist.easy;

public class InsertaNodeattheHeadofaLinkedListSolution {

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

	}

	static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			return head;
		}
		SinglyLinkedListNode toHead = new SinglyLinkedListNode(data);
		toHead.next = head;
		return toHead;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testInsertNodeAtTail(SinglyLinkedList list, int data) {
		SinglyLinkedListNode head = insertNodeAtHead(list.head, data);
		list.head = head;
	}// End of Test

	static void testCase1() {
		SinglyLinkedList list = new SinglyLinkedList();
		int[] data = new int[] { 141, 302, 164, 530, 474 };
		for (int datum : data) {
			testInsertNodeAtTail(list, datum);
		}
		printLinkedList(list);
	}// End of Test Case

	static void printLinkedList(SinglyLinkedList list) {
		SinglyLinkedListNode current = list.head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}// End of Util Method

}// End of Class
