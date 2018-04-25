package linkedlist;

import java.util.Scanner;

public class MergeSortedLists {

	static Node mergeLists(Node headA, Node headB) {
		Node head = null;
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;
		if (headA.data < headB.data) {
			head = headA;
			headA = headA.next;
		} else {
			head = headB;
			headB = headB.next;
		}
		Node curr = head;
		while (headA != null && headB != null) {
			if (headA.data < headB.data) {
				curr.next = headA;
				headA = headA.next;
			} else {
				curr.next = headB;
				headB = headB.next;
			}
			curr = curr.next;
		}
		if (headA == null) {
			while (headB != null) {
				curr.next = headB;
				headB = headB.next;
				curr = curr.next;
			}
		} else if (headB == null) {
			while (headA != null) {
				curr.next = headA;
				headA = headA.next;
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node headA = null;
		Node listA = null;
		Node headB = null;
		Node listB = null;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				headA = new Node(sc.nextInt());
				listA = headA;
			} else {
				Node node = new Node(sc.nextInt());
				headA.next = node;
				headA = headA.next;
			}
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				headB = new Node(sc.nextInt());
				listB = headB;
			} else {
				Node node = new Node(sc.nextInt());
				headB.next = node;
				headB = headB.next;
			}
		}
		// headB.next = listA.next;
		headA = listA;
		headB = listB;
		System.out.print("\nList A : ");
		while (headA != null) {
			System.out.print(headA.data + " -> ");
			headA = headA.next;
		}
		System.out.print("null");
		System.out.print("\nList B : ");
		while (headB != null) {
			System.out.print(headB.data + " -> ");
			headB = headB.next;
		}
		System.out.print("null");

		Node head = mergeLists(listA, listB);

		System.out.print("\nMerged List : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}

}
