package linkedlist;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {

	static Node removeDupHashSet(Node head) {
		if (head == null)
			return null;
		Node curr = head;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(curr.data);
		while (curr.next != null) {
			if (set.contains(curr.next.data))
				curr.next = curr.next.next;
			else {
				set.add(curr.next.data);
				curr = curr.next;
			}
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
		head = removeDupHashSet(list);
		System.out.println("Duplicates Removed : ");
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.print("null");
		sc.close();
	}

}
