package com.hackerrank.datastructures.linkedlist.easy;

/**
 * Given a pointer to the head node of a linked list, print its elements in
 * order, one element per line. If the head pointer is null (indicating the list
 * is empty), don’t print anything.
 * 
 * @author Ozan Aksoy
 *
 */
public class PrinttheElementsofaLinkedListSolution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
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
    
	static void printLinkedList(SinglyLinkedListNode head) {
		SinglyLinkedListNode current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static void main(String[] args) {

		testPrintLinkedList(createFilledLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));

	}// End of Main

	static void testPrintLinkedList(SinglyLinkedList list) {
		printLinkedList(list.head);
	}

	static SinglyLinkedList createFilledLinkedList(int[] values) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		for (int value : values) {
			linkedList.insertNode(value);
		}
		return linkedList;
	}// End of Method

}// End of Class
