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
	 * Given pointers to the head nodes of linked lists that merge together at some
	 * point, find the Node where the two lists merge. It is guaranteed that the two
	 * head Nodes will be different, and neither will be NULL.
	 * </p>
	 * <p>
	 * Complete the int findMergeNode(SinglyLinkedListNode* head1,
	 * SinglyLinkedListNode* head2) method so that it finds and returns the data
	 * value of the Node where the two lists merge.
	 * </p>
	 * <li>the lists will merge</li>
	 * <li>head1 and head2 != null</li>
	 * <li>head1 != head2</li>
	 * 
	 * @param head
	 * @param expected
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode iter1 = head1;
		SinglyLinkedListNode iter2 = head2;
		int result = 0;
		while (iter1 != null && iter2 != null) {

			SinglyLinkedListNode cur1 = iter1;
			while (cur1 != null && !cur1.equals(iter2)) {
				cur1 = cur1.next;
			}
			
			SinglyLinkedListNode cur2 = iter2;
			while (cur1 != null && cur2 != null && !cur2.equals(cur1)) {
				cur2 = cur2.next;
			}

			if (cur1 != null && cur2 != null && cur1.equals(cur2)) {
				result = cur1.data;
			}

			while (cur1 != null && cur2 != null && cur1.equals(cur2)) {
				cur1 = cur1.next;
				cur2 = cur2.next;
				if (cur1 == null && cur2 == null) {
					return result;
				}
			}
			iter1 = iter1.next;
			iter2 = iter2.next;
		}
		return result;
	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testFindMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int expected) {
		int result = findMergeNode(head1, head2);
		assert result == expected;
	}// End of Method

	static void testCase1() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1, 2, 4 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1, 3, 5 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 6, 9 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 6);
	}// End of Test Case

	static void testCase2() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 2, 5, 8, 9 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 2);
	}// End of Test Case

	static void testCase3() {
		SinglyLinkedList list1 = createFilledLinkedList(new int[] { 1, 2, 15, 14 });
		SinglyLinkedList list2 = createFilledLinkedList(new int[] { 1, 3 });
		SinglyLinkedList listTail = createFilledLinkedList(new int[] { 4, 8, 11 });
		list1.tail.next = listTail.head;
		list2.tail.next = listTail.head;
		testFindMergeNode(list1.head, list2.head, 4);
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
