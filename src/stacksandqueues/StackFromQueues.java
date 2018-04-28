package stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueues {
	Queue<Integer> queue1;
	Queue<Integer> queue2;

	StackFromQueues() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	void push(int data) {
		queue1.add(data);
	}

	int pop() {
		if (queue1.isEmpty())
			return -1;
		while (queue1.size() != 1) {
			queue2.add(queue1.remove());
		}
		Queue<Integer> temp = queue1;
		queue1 = queue2;
		queue2 = temp;
		return queue2.remove();
	}

	public static void main(String[] args) {
		StackFromQueues stack = new StackFromQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
