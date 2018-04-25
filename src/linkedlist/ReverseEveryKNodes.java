package linkedlist;

import java.util.Scanner;

public class ReverseEveryKNodes {

	static Node reverseEveryK(Node head, int k) {
		if (k <= 1 || head == null || head.next == null)
			return head;
		Node reverse = null;
		Node prevTail = null;
		while (head != null) {
			Node currentHead = null;
			Node currentTail = head;
			int n = k;
			while (head != null && n > 0) {
				Node temp = head.next;
				head.next = currentHead;
				currentHead = head;
				head = temp;
				n--;
			}
			if (reverse == null) {
				reverse = currentHead;
			}
			if (prevTail != null)
				prevTail.next = currentHead;
			prevTail = currentTail;
		}
		return reverse;
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
		int x = sc.nextInt();
		head = reverseEveryK(list, x);
		System.out.println("\nList when rotated by " + x + " : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
