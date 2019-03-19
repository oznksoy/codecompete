package com.hackerrank.datastructures.linkedlist.easy;

/**
 * Given a pointer to the head node of a linked list, print its elements in
 * order, one element per line. If the head pointer is null (indicating the list
 * is empty), don’t print anything.
 * 
 * @author Ozan Aksoy
 *
 */
public class PrinttheElementsofaLinkedListSolution2 {

	private static class SinglyLinkedList {

		private SinglyLinkedListNode head;
		private SinglyLinkedListNode next;
		private SinglyLinkedListNode end;

		public void insertNode(int value) {

			if (head != null) {
				SinglyLinkedListNode node = new SinglyLinkedListNode(value, null);
				this.end.setNext(node);
				this.end = node;
			} else {
				this.head = new SinglyLinkedListNode(value);
				this.next = this.head;
				this.end = this.head;
			}

		}// End of Method

		public int next() {
			int value = this.next.getData();
			this.next = this.next.getNext();
			return value;
		}

		public boolean hasNext() {
			return next != null;
		}

	}// End of Inner Class

	private static class SinglyLinkedListNode {

		private int data;
		private SinglyLinkedListNode next;

		public SinglyLinkedListNode(int data) {
			this.data = data;
		}

		public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public SinglyLinkedListNode getNext() {
			return next;
		}

		public void setNext(SinglyLinkedListNode next) {
			this.next = next;
		}

	}// End of Inner Class

	static void printLinkedList(SinglyLinkedList head) {
		while (head.hasNext()) {
			System.out.println(head.next());
		}
	}

	public static void main(String[] args) {

		testPrintLinkedList(createFilledLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));

	}// End of Main

	static void testPrintLinkedList(SinglyLinkedList head) {
		printLinkedList(head);
	}

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
