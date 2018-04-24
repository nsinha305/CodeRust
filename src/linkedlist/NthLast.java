package linkedlist;

import java.util.Scanner;

public class NthLast {

	static Node getNthLast(Node head, int n) {
		Node first = head;
		Node second = head;
		while (first != null && n > 0) {
			n--;
			first = first.next;
		}
		if (n != 0)
			return null;
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		return second;
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
		Node nthLast = getNthLast(list, x);
		System.out.println("Nth Last Element : " + ((nthLast == null) ? "null" : nthLast.data));
		sc.close();
	}

}
