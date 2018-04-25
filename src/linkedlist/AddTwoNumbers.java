package linkedlist;

import java.util.Scanner;

public class AddTwoNumbers {
	static Node addTwoNumbers(Node headA, Node headB) {
		Node sum = new Node((headA.data + headB.data) % 10);
		Node returnNode = sum;
		int carry = (headA.data + headB.data) / 10;
		headA = headA.next;
		headB = headB.next;
		while (headA != null && headB != null) {
			sum.next = new Node((carry + headA.data + headB.data) % 10);
			carry = (carry + headA.data + headB.data) / 10;
			headA = headA.next;
			headB = headB.next;
			sum = sum.next;
		}
		if (headA != null) {
			while (headA != null) {
				sum.next = new Node((carry + headA.data) % 10);
				carry = (carry + headA.data) / 10;
				headA = headA.next;
				sum = sum.next;
			}
		}
		if (headB != null) {
			while (headB != null) {
				sum.next = new Node((carry + headB.data) % 10);
				carry = (carry + headB.data) / 10;
				headB = headB.next;
				sum = sum.next;
			}
		}
		if (carry != 0)
			sum.next = new Node(carry);
		return returnNode;
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

		Node head = addTwoNumbers(listA, listB);

		System.out.print("\nSum of the Lists : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
