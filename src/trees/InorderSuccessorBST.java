package trees;

public class InorderSuccessorBST {

	static TreeNode findMin(TreeNode node) {
		while (node != null) {
			node = node.left;
		}
		return node;
	}

	static TreeNode getSuccessor(TreeNode node, int d) {
		TreeNode successor = null;
		if (node == null)
			return null;
		while (node != null) {
			if (d < node.data) {
				successor = node;
				node = node.left;
			} else if (d > node.data) {
				node = node.right;
			} else {
				if (node.right != null)
					successor = findMin(node.right);
				break;
			}
		}
		return successor;
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
		// int d = 75;
		int d = 35;
		TreeNode node = getSuccessor(tree, d);
		System.out.println("Inorder BST Successor of " + d + " is : " + node.data);
	}

}
