package trees;

public class IsBinarySearchTree {

	static boolean isBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max)
			return false;
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
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
		System.out.print("\nThe Tree is a BST : " + isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

}
