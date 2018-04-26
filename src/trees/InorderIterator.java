package trees;

import java.util.Stack;

public class InorderIterator {

	Stack<TreeNode> stack;

	InorderIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode getNext() {
		if (stack.isEmpty())
			return null;
		TreeNode rVal = stack.pop();
		TreeNode temp = rVal.right;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		return rVal;
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

		InorderIterator it = new InorderIterator(tree);
		System.out.print("\nInorder Traversal of the Tree is : ");
		while (it.hasNext()) {
			System.out.print(it.getNext().data + " ");
		}
	}

}
