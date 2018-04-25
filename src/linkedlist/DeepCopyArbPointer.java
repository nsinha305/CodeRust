package linkedlist;

import java.util.HashMap;
import java.util.Iterator;

class NodeA {
	int data;
	NodeA next;
	NodeA arb;

	NodeA(int data) {
		this.data = data;
		this.next = null;
		this.arb = null;
	}

}

public class DeepCopyArbPointer {

	static HashMap<NodeA, NodeA> createHashMap(NodeA head) {
		HashMap<NodeA, NodeA> map = new HashMap<NodeA, NodeA>();
		NodeA newNode = new NodeA(head.data);
		map.put(head, newNode);
		while (head.next != null) {
			newNode.next = new NodeA(head.next.data);
			newNode = newNode.next;
			map.put(head.next, newNode);
			head = head.next;
		}
		return map;
	}

	static NodeA deepCopy(NodeA head) {
		if (head == null)
			return null;
		HashMap<NodeA, NodeA> map = createHashMap(head);
		Iterator<NodeA> it = map.keySet().iterator();
		NodeA head2 = map.get(head);
		while (it.hasNext()) {
			NodeA node = it.next();
			map.get(node).arb = (node.arb == null) ? null : map.get(node.arb);
		}
		return head2;
	}

	public static void main(String[] args) {
		NodeA one = new NodeA(1);
		NodeA two = new NodeA(5);
		NodeA three = new NodeA(8);
		NodeA four = new NodeA(3);
		one.next = two;
		two.next = three;
		three.next = four;
		one.arb = three;
		two.arb = one;
		three.arb = null;
		four.arb = three;
		NodeA head = one;
		NodeA head2 = deepCopy(head);
		while (head != null) {
			System.out.println((head == head2) && (head != null));
			System.out.println((head.next == head2.next) && (head.next != null));
			System.out.println((head.arb == head2.arb) && (head.arb != null));
			head = head.next;
			head2 = head2.next;
		}
	}

}
