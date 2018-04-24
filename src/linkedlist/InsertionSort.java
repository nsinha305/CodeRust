package linkedlist;

import java.util.Scanner;

public class InsertionSort {
	static Node sortedInsert(Node head, Node sorted) {
		if (sorted == null) {
			return head;
		}
		if (head == null || sorted.data <= head.data) {
			sorted.next = head;
			return sorted;
		}
		Node curr = head;
		while (curr.next != null && (curr.next.data < sorted.data)) {
			curr = curr.next;
		}
		sorted.next = curr.next;
		curr.next = sorted;
		return head;
	}

	static Node insertionSort(Node head) {
		Node sorted = null;
		Node curr = head;
		while (curr != null) {
			Node temp = curr.next;
			sorted = sortedInsert(sorted, curr);
			curr = temp;
		}
		return sorted;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node head = null;
		Node list = null;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				head = new Node(sc.nextInt());
				list = head;
			} else {
				Node node = new Node(sc.nextInt());
				head.next = node;
				head = head.next;
			}
		}
		head = insertionSort(list);
		System.out.println("\nSorted List : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
