package com.hackerrank.datastructures.linkedlist.easy;

public class InsertaNodeattheTailofaLinkedListSolution {

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

		public SinglyLinkedList() {
			this.head = null;
		}

	}// End of Inner Class

	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			return head;
		}
		SinglyLinkedListNode tail = head;
		while (tail != null) {
			if (tail.next == null) {
				break;
			}
			tail = tail.next;
		}
		tail.next = new SinglyLinkedListNode(data);
		return head;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testInsertNodeAtTail(SinglyLinkedList list, int data) {
		SinglyLinkedListNode head = insertNodeAtTail(list.head, data);
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
