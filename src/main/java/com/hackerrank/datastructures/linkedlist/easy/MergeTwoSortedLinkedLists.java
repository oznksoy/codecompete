package com.hackerrank.datastructures.linkedlist.easy;

public class MergeTwoSortedLinkedLists {

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

	// Both lists are in ascending order
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode cur1 = head1;
		SinglyLinkedListNode cur2 = head2;

		SinglyLinkedList mergedList = new SinglyLinkedList();

		while (cur1 != null && cur2 != null) {
			if (cur1.data < cur2.data) {
				mergedList.insertNode(cur1.data);
				cur1 = cur1.next;
			} else {
				mergedList.insertNode(cur2.data);
				cur2 = cur2.next;
			}
		}

		while (cur1 != null) {
			mergedList.insertNode(cur1.data);
			cur1 = cur1.next;
		}

		while (cur2 != null) {
			mergedList.insertNode(cur2.data);
			cur2 = cur2.next;
		}

		return mergedList.head;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
	}// End of Main

	static void testMergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int[] expected) {

		SinglyLinkedListNode merged = mergeLists(head1, head2);
		int index = 0;
		while (merged != null) {
			assert merged.data == expected[index];
			merged = merged.next;
			index++;
		}
		assert index == expected.length;

	}// End of Method

	static void testCase1() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 5, 7, 9 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 4, 6, 8, 10 });
		int[] expected = new int[] { 4, 5, 6, 7, 8, 9, 10 };
		testMergeLists(list1.head, list2.head, expected);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
