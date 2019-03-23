package com.hackerrank.datastructures.linkedlist.easy;

import com.hackerrank.datastructures.linkedlist.easy.InsertingaNodeIntoaSortedDoublyLinkedListSolution.DoublyLinkedListNode;

public class InsertingaNodeIntoaSortedDoublyLinkedListSolution {

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
	 * Given a reference to the head of a doubly-linked list and an integer,
	 * <i>data</i>, create a new DoublyLinkedListNode object having data value
	 * <i>data</i> and insert it into a sorted linked list while maintaining the
	 * sort.
	 * 
	 * Function Description
	 * 
	 * Complete the sortedInsert function in the editor below. It must return a
	 * reference to the head of your modified DoublyLinkedList.
	 * 
	 * sortedInsert has two parameters:
	 * 
	 * <li>head: A reference to the head of a doubly-linked list of
	 * DoublyLinkedListNode objects.</li>
	 * <li>data: An integer denoting the value of the <i>data</i> field for the
	 * DoublyLinkedListNode you must insert into the list.</li>
	 * 
	 * 
	 * 
	 * Note: Recall that an empty list (i.e., where head == null) and a list with
	 * one element are sorted lists.
	 * 
	 * @param head
	 * @param data
	 * @return
	 */
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

		if (head == null) {
			DoublyLinkedListNode toAttach = new DoublyLinkedListNode(data);
			head = toAttach;
			return head;
		}

		DoublyLinkedListNode current = head;
		while (current != null) {
			if (current.data >= data) {
				DoublyLinkedListNode toAttach = new DoublyLinkedListNode(data);
				toAttach.next = current;
				if (current.prev != null) {
					current.prev.next = toAttach;
					toAttach.prev = current.prev;
					return head;
				}
				return toAttach;
			}
			if (current.next == null) {
				break;
			}
			current = current.next;
		}

		DoublyLinkedListNode toAttach = new DoublyLinkedListNode(data);
		toAttach.prev = current;
		current.next = toAttach;
		return head;

	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
	}// End of Method

	static void testCase1() {
		DoublyLinkedList list = createDoubleLinkedList(new int[] { 1, 2, 3, 5, 6 });
		DoublyLinkedList expected = createDoubleLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });
		testSortedInsert(list.head, 4, expected.head);
	}

	static void testCase2() {
		DoublyLinkedList list = createDoubleLinkedList(new int[] { 2, 3, 4 });
		DoublyLinkedList expected = createDoubleLinkedList(new int[] { 1, 2, 3, 4 });
		testSortedInsert(list.head, 1, expected.head);
	}

	static void testCase3() {
		DoublyLinkedList list = createDoubleLinkedList(new int[] { 1, 2, 3 });
		DoublyLinkedList expected = createDoubleLinkedList(new int[] { 1, 2, 3, 4 });
		testSortedInsert(list.head, 4, expected.head);
	}

	static void testCase4() {
		DoublyLinkedList list = createDoubleLinkedList(new int[] { 1, 3, 4, 10 });
		DoublyLinkedList expected = createDoubleLinkedList(new int[] { 1, 3, 4, 5, 10 });
		testSortedInsert(list.head, 5, expected.head);
	}

	static void testSortedInsert(DoublyLinkedListNode head, int data, DoublyLinkedListNode expected) {
		DoublyLinkedListNode result = sortedInsert(head, data);
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
