package trees;

public class MirrorBST {

	static void printTree(TreeNode node) {
		if (node == null)
			return;
		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}

	static void mirrorBST(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			mirrorBST(node.left);
		if (node.right != null)
			mirrorBST(node.right);
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
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
		printTree(tree);
		System.out.print("\n");
		mirrorBST(tree);
		printTree(tree);
	}

}
