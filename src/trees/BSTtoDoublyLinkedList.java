package trees;

public class BSTtoDoublyLinkedList {

	static TreeNode head;
	static TreeNode prev = null;

	static void convertToList(TreeNode root) {
		if (root == null)
			return;
		convertToList(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		convertToList(root.right);
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
		System.out.print("\nThe BST converted to a Doubly linked list is : ");
		convertToList(tree);
		while (head != null) {
			System.out.print(head.data + " <-> ");
			head = head.right;
		}
		System.out.print("null");
	}

}
