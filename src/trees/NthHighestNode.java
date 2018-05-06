package trees;

public class NthHighestNode {

	static int count = 0;

	static TreeNode getNthHighestNode(TreeNode node, int n) {
		if (node == null)
			return null;
		TreeNode res = getNthHighestNode(node.right, n);
		if (res != null)
			return res;
		count++;
		if (n == count)
			return node;
		res = getNthHighestNode(node.left, n);
		if (res != null)
			return res;
		return null;
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
		int n = 5;
		TreeNode nthHighest = getNthHighestNode(tree, n);
		System.out.print("The " + n + " highest node has value : " + (nthHighest == null ? "null" : nthHighest.data));
	}

}
