package trees;

public class LevelOrderTraversal {

	static int level = 0;

	static int height(TreeNode root) {
		if (root == null)
			return 0;
		int rHeight = height(root.right);
		int lHeight = height(root.left);
		return Integer.max(rHeight, lHeight) + 1;
	}

	static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	static void levelOrderTraversal(TreeNode root) {
		int height = height(root);
		for (int i = 1; i <= height; i++)
			printGivenLevel(root, i);
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
		System.out.print("\nLevel Order Traversal : \n");
		levelOrderTraversal(tree);

	}

}
