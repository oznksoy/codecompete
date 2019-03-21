package com.hackerrank.datastructures.linkedlist.easy;

public class InsertaNodeataSpecificPositioninaLinkedListSolution {

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

	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

		int index = 0;
		SinglyLinkedListNode current = head;
		while (index < position-1 && current != null) {
			current = current.next;
			index++;
		}
		SinglyLinkedListNode nodeToInsert = new SinglyLinkedListNode(data);
		nodeToInsert.next = current.next;
		current.next = nodeToInsert;
		return head;
		
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testInsertNodeAtTail(SinglyLinkedList list, int data, int position) {
		SinglyLinkedListNode head = insertNodeAtPosition(list.head, data, position);
		list.head = head;
	}// End of Test

	static void testCase1() {
		int[] data = new int[] { 16, 13, 7 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testInsertNodeAtTail(list, 1, 2);
		printLinkedList(list);
	}// End of Test Case

	static void printLinkedList(SinglyLinkedList list) {
		SinglyLinkedListNode current = list.head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}// End of Util Method

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
