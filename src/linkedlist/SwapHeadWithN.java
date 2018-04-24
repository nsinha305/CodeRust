package linkedlist;

import java.util.Scanner;

public class SwapHeadWithN {
	static Node swapHeadWithN(Node head, int n) {
		Node prev = null;
		Node curr = head;
		if (n == 1 || head == null)
			return head;
		while (n > 1 && curr != null) {
			n--;
			prev = curr;
			curr = curr.next;
		}
		if (curr == null)
			return head;
		prev.next = head;
		Node temp = head.next;
		head.next = curr.next;
		curr.next = temp;
		return curr;
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
		int x = sc.nextInt();
		head = swapHeadWithN(list, x);
		System.out.print("\nSwapped List : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}
}
