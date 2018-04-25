package linkedlist;

import java.util.Scanner;

class Pair {
	Node first;
	Node second;

	Pair(Node first, Node second) {
		this.first = first;
		this.second = second;
	}
}

public class MergeSort {

	static void splitInHalf(Node head, Pair pair) {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			pair.first = head;
			pair.second = null;
		} else {
			Node slow = head;
			Node fast = head.next;
			while (fast != null) {
				fast = fast.next;
				while (fast != null) {
					fast = fast.next;
					slow = slow.next;
				}
			}
			pair.first = head;
			pair.second = slow.next;
			slow.next = null;
		}
	}

	static Node mergeSortedLists(Node headA, Node headB) {
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

	static Node mergeSort(Node head) {
		if (head == null || head.next == null)
			return head;
		Pair pair = new Pair(null, null);
		splitInHalf(head, pair);
		pair.first = mergeSort(pair.first);
		pair.second = mergeSort(pair.second);
		return mergeSortedLists(pair.first, pair.second);
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
		head = mergeSort(list);
		System.out.println("\nSorted List : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}

}
