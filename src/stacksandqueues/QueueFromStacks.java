package stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class QueueFromStacks {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int size;

	QueueFromStacks() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
		size = 0;
	}

	void enqueue(int n) {
		stack1.push(n);
		size++;
	}

	int dequeue() {
		if (size == 0)
			return -1;
		else {
			size--;
			if (!stack2.isEmpty())
				return stack2.pop();
			else {
				while (stack1.size() != 1) {
					stack2.push(stack1.pop());
				}
				return stack1.pop();
			}
		}
	}

	int size() {
		return size;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueFromStacks queue = new QueueFromStacks();
		int n = sc.nextInt();
		while (n != 0) {
			queue.enqueue(n);
			if (queue.size() == 5)
				System.out.println(queue.dequeue());
			n = sc.nextInt();
		}

		sc.close();

	}

}
