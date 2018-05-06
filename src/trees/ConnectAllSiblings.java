package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

	static void printConnectedTree(TreeNode node) {
		// int level = 0;
		while (node != null) {
			// System.out.print("Level " + level + " : ");
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print("null\n");
	}

	static void connectSiblings(TreeNode node) {
		Queue<QueueNode> q = new LinkedList<QueueNode>();
		q.add(new QueueNode(node, 0));
		while (!q.isEmpty()) {
			QueueNode qNode = q.poll();
			if (qNode.node.left != null)
				q.add(new QueueNode(qNode.node.left, qNode.level + 1));
			if (qNode.node.right != null)
				q.add(new QueueNode(qNode.node.right, qNode.level + 1));
			if (q.peek() != null) {
				if (q.peek().level == qNode.level || q.peek().level == qNode.level + 1) {
					qNode.node.next = q.peek().node;
				}
			} else {
				qNode.node.next = null;
			}
		}
		printConnectedTree(node);
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.left.left = new TreeNode(25);
		tree.left.left.left = new TreeNode(12);
		tree.left.left.right = new TreeNode(35);
		tree.left.right = new TreeNode(75);
		tree.left.right.left = new TreeNode(60);
		tree.right = new TreeNode(200);
		tree.right.right = new TreeNode(300);
		tree.right.left = new TreeNode(125);
		connectSiblings(tree);

	}

}
