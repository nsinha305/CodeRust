package linkedlist;

import java.util.Scanner;

public class ReverseSinglyLinkedList {

	static Node reverseRec(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node list = reverseRec(head.next);

		head.next.next = head;
		head.next = null;
		return list;
	}

	static Node reverseList(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
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
		head = reverseRec(list);
		System.out.println("Reversed List : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}

}
