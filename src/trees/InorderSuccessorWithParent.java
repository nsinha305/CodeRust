package trees;

public class InorderSuccessorWithParent {

	static TreeNode leftMostChild(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	static TreeNode parentSuc(TreeNode node, int key) {
		while (node != null) {
			if (node.data > key)
				return node;
			node = node.parent;
		}
		return null;
	}

	static TreeNode getSuccessor(TreeNode node, int key) {
		while (node != null) {
			if (key == node.data) {
				if (node.right != null)
					return leftMostChild(node.right);
				else {
					return parentSuc(node.parent, key);
				}
			} else if (key < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
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

		tree.left.parent = tree;
		tree.right.parent = tree;
		tree.left.left.parent = tree.left;
		tree.left.left.left.parent = tree.left.left;
		tree.left.left.right.parent = tree.left.left;
		tree.left.right.parent = tree.left;
		tree.left.right.left.parent = tree.left.right;
		tree.right.right.parent = tree.right;
		tree.right.left.parent = tree.right;

		int key = 125;
		TreeNode suc = getSuccessor(tree, key);
		System.out.println("Successor of " + key + " is : " + suc.data);

	}

}
