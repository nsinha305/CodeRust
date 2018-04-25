package linkedlist;

import java.util.Scanner;

public class RotateByX {
	static Node rotateByX(Node head, int x) {
		Node list = head;
		if (head == null || head.next == null || x == 0)
			return head;
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		if (x < 0)
			x = count + x;
		if (x > count)
			x = x % count;
		if (x == 0)
			return list;
		else {
			x = count - x - 1;
			head = list;
			while (x > 0) {
				x--;
				head = head.next;
			}
			Node temp = list;
			list = head.next;
			head.next = null;
			head = list;
			while (head.next != null)
				head = head.next;
			head.next = temp;
			return list;

		}
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
		head = rotateByX(list, x);
		System.out.println("\nList when rotated by " + x + " : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
