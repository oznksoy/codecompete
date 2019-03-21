package com.hackerrank.datastructures.linkedlist.easy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintInReverseSolution {

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

	static void reversePrint(SinglyLinkedListNode head) {

		if (head != null && head.next != null) {
			reversePrint(head.next);
		}

		if (head != null) {
			System.out.println(head.data);
		}

	}// End of Method

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}// End of Main

	static void testReversePrint(SinglyLinkedList list, int[] expected) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStream systemStream = System.out;
		System.setOut(printStream);
		reversePrint(list.head);
		System.out.flush();
		System.setOut(systemStream);
		String result = byteArrayOutputStream.toString();
		String[] args = result.split("[\\r\\n]+");
		assert args.length == expected.length;
		for (int i = 0; i < args.length; i++) {
			int value = Integer.valueOf(args[i]).intValue();
			assert value == expected[i];
		}
	}// End of Test

	static void testCase1() {
		int[] data = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReversePrint(list, new int[] { 9, 15, 4, 7, 19, 2, 6, 20 });
	}// End of Test Case

	static void testCase2() {
		int[] data = new int[] { 18, 11, 5, 36, 45, 1 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReversePrint(list, new int[] { 1, 45, 36, 5, 11, 18 });
	}// End of Test Case

	static void testCase3() {
		int[] data = new int[] { 16, 12, 4, 2, 5 };
		SinglyLinkedList list = createFilledLinkedList(data);
		testReversePrint(list, new int[] { 5, 2, 4, 12, 16 });
	}// End of Test Case

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
