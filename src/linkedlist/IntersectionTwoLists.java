package linkedlist;

import java.util.Scanner;

public class IntersectionTwoLists {
	static Node getIntersectionValue(Node headA, Node headB) {
		int l1 = 0;
		int l2 = 0;
		Node currA = headA;
		Node currB = headB;
		while (currA != null) {
			l1++;
			currA = currA.next;
		}
		while (currB != null) {
			l2++;
			currB = currB.next;
		}
		currA = headA;
		currB = headB;
		int d = 0;
		if (l1 > l2) {
			d = l1 - l2;
			while (d > 0) {
				d--;
				currA = currA.next;
			}
		}
		if (l2 > l1) {
			d = l2 - l1;
			while (d > 0) {
				d--;
				currB = currB.next;
			}
		}
		while (currA != null) {
			if (currA == currB)
				return currA;
			currA = currA.next;
			currB = currB.next;
		}
		return null;
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

		Node iPoint = getIntersectionValue(listA, listB);

		System.out.println("\nIntersection Point : " + ((iPoint == null) ? "null" : iPoint.data));
		sc.close();
	}
}
