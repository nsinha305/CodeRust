package miscellaneous;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {
	Node head;
	Node rear;
	HashMap<Integer, Node> map;
	int capacity;
	int load;

	LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Node>();
		this.load = 0;
		this.head = null;
		this.rear = null;
	}

	Node detach(Node n) {
		if (n.next != null) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n.prev = null;
			n.next = null;
		} else {
			n.prev.next = null;
			rear = n.prev;
			n.prev = null;
		}
		load--;
		return n;
	}

	void updateHead(Node n) {
		if (head == null) {
			head = n;
			rear = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
		}
		load++;
	}

	void removeRear() {
		if (rear != null) {
			rear.prev.next = null;
			map.remove(rear.data);
			rear = rear.prev;
			load--;
		}
	}

	void print() {
		Node temp = head;
		System.out.print("\nCache : ");
		while (temp != null) {
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}
		System.out.print("null");
	}

	void addToCache(int p) {
		if (map.get(p) != null) {
			if (map.get(p) != head) {
				Node n = detach(map.get(p));
				updateHead(n);
			}
		} else {
			Node n = new Node(p);
			map.put(p, n);
			if (load == capacity) {
				removeRear();
			}
			updateHead(n);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LRUCache cache = new LRUCache(n);
		int p = sc.nextInt();
		while (p != 0) {
			cache.addToCache(p);
			cache.print();
			p = sc.nextInt();
			System.out.println("Capacity : " + cache.capacity + " Load : " + cache.load);
		}
		sc.close();
	}
}
