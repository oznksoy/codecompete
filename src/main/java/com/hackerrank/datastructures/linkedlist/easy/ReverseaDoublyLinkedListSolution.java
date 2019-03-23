package com.hackerrank.datastructures.linkedlist.easy;

import com.hackerrank.datastructures.linkedlist.easy.ReverseaDoublyLinkedListSolution.DoublyLinkedListNode;

public class ReverseaDoublyLinkedListSolution {

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}

	/**
	 * <p>
	 * You’re given the pointer to the head node of a doubly linked list. Reverse
	 * the order of the nodes in the list. The head node might be NULL to indicate
	 * that the list is empty. Change the next and prev pointers of all the nodes so
	 * that the direction of the list is reversed. Return a reference to the head
	 * node of the reversed list.
	 * </p>
	 * 
	 * Note: Recall that an empty list (i.e., where head == null) and a list with
	 * one element are sorted lists.
	 * 
	 * @param head
	 * @return
	 */
	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

		DoublyLinkedListNode tail = head;
		while (tail != null && tail.next != null) {
			tail = tail.next;
		}
		
		return head;

	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Method

	static void testCase1() {
		DoublyLinkedList list = createDoubleLinkedList(new int[] { 1, 2, 3, 4, 5 });
		DoublyLinkedList expected = createDoubleLinkedList(new int[] { 5, 4, 3, 2, 1 });
		testReverse(list.head, expected.head);
	}

	static void testReverse(DoublyLinkedListNode head, DoublyLinkedListNode expected) {
		DoublyLinkedListNode result = reverse(head);
		DoublyLinkedListNode cur1 = result;
		DoublyLinkedListNode cur2 = expected;
		while (cur1 != null && cur2 != null) {
			assert cur1.data == cur2.data;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		assert cur1 == null && cur2 == null;
	}// End of Method

	static DoublyLinkedList createDoubleLinkedList(int[] array) {
		DoublyLinkedList newList = new DoublyLinkedList();
		for (int value : array) {
			newList.insertNode(value);
		}
		return newList;
	}// End of Method

}// End of Class
