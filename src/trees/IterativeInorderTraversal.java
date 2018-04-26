package trees;

import java.util.Stack;

public class IterativeInorderTraversal {
	static void iterativeInorderTraversal(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
		System.out.print("\nIterative Inorder Traversal : ");
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.print(curr.data + " : ");
			curr = curr.right;
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
		}
	}

	public static void main(String args[]) {
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
		iterativeInorderTraversal(tree);
	}
}
