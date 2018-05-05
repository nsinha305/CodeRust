package trees;

public class BoundaryTraversal {

	static void printLeftBoundary(TreeNode node) {
		if (node != null) {
			if (node.left != null) {
				System.out.print(node.data + " ");
				printLeftBoundary(node.left);
			} else if (node.right != null) {
				System.out.println(node.data + " ");
				printLeftBoundary(node.right);
			}
		}
	}

	static void printLeaves(TreeNode node) {
		if (node != null) {
			printLeaves(node.left);
			if (node.left == null && node.right == null)
				System.out.print(node.data + " ");
			printLeaves(node.right);
		}
	}

	static void printRightBoundary(TreeNode node) {
		if (node != null) {
			if (node.right != null) {
				printRightBoundary(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				printRightBoundary(node.left);
				System.out.print(node.data + " ");
			}
		}
	}

	static void boundaryTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printLeftBoundary(root.left);

			printLeaves(root.left);
			printLeaves(root.right);

			printRightBoundary(root.right);
		}
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

//		TreeNode tree = new TreeNode(20);
//		tree.left = new TreeNode(8);
//		tree.left.left = new TreeNode(4);
//		tree.left.right = new TreeNode(12);
//		tree.left.right.left = new TreeNode(10);
//		tree.left.right.right = new TreeNode(14);
//		tree.right = new TreeNode(22);
//		tree.right.right = new TreeNode(25);
		boundaryTraversal(tree);
	}

}
