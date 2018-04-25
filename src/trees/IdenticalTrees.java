package trees;

public class IdenticalTrees {

	static boolean areIdentical(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		if (tree1 == null || tree2 == null)
			return false;
		if (tree1.data == tree2.data)
			return areIdentical(tree1.left, tree2.left) && areIdentical(tree1.right, tree2.right);
		else
			return false;
	}

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(100);
		tree1.left = new TreeNode(50);
		tree1.left.left = new TreeNode(25);
		tree1.right = new TreeNode(200);
		tree1.right.right = new TreeNode(350);
		tree1.right.left = new TreeNode(125);
		TreeNode tree2 = new TreeNode(100);
		tree2.left = new TreeNode(51);
		tree2.left.left = new TreeNode(25);
		tree2.right = new TreeNode(200);
		tree2.right.right = new TreeNode(350);
		tree2.right.left = new TreeNode(125);

		System.out.println("Tree 1 and Tree 2 are identical : " + areIdentical(tree1, tree2));
	}

}
