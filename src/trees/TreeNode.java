package trees;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	TreeNode parent;

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
		this.parent = null;
	}
}
