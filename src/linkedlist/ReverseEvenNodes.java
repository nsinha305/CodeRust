package linkedlist;

import java.util.Scanner;

public class ReverseEvenNodes {
	static Node reverseEvenNodes(Node head) {
		if (head == null || head.next == null)
			return head;
		Node odd = head;
		Node even = head.next;
		Node oddRef = odd;
		Node evenRef = even;
		head = head.next.next;
		int count = 2;
		while (head != null) {
			count++;
			if (count % 2 == 1) {
				odd.next = head;
				head = head.next;
				odd = odd.next;
			} else {
				Node temp = head.next;
				head.next = even;
				even = head;
				head = temp;
			}
		}
		evenRef.next = null;
		evenRef = even;
		head = oddRef;
		Node headRef = head;
		oddRef = oddRef.next;
		count = 2;
		while (evenRef != null && oddRef != null) {
			if (count % 2 == 0) {
				head.next = evenRef;
				evenRef = evenRef.next;
			} else {
				head.next = oddRef;
				oddRef = oddRef.next;
			}
			head = head.next;
			count++;
		}
		if (evenRef != null)
			head.next = evenRef;
		else if (oddRef != null)
			head.next = oddRef;
		return headRef;
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
		head = reverseEvenNodes(list);
		System.out.println("\nList after reversing even Nodes : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
