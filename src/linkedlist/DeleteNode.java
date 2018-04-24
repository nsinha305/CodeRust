package linkedlist;

import java.util.Scanner;

public class DeleteNode {

	static Node removeNode(Node head, int x) {
		Node curr = head;
		if (curr == null)
			return null;
		while (curr.next != null) {
			if (curr.next.data == x) {
				curr.next = curr.next.next;
				break;
			}
			curr = curr.next;
		}
		return head;
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
		head = removeNode(list, x);
		System.out.println("\nList with " + x + " removed : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}

}
