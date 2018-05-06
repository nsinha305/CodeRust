package trees;

public class NaryToBinaryTree {

	static TreeNode convertToBinaryRec(NTreeNode node, boolean isLeft) {
		if (node == null)
			return null;
		TreeNode tNode = new TreeNode(node.data);
		TreeNode lastNode = tNode;
		for (int i = 0; i < node.children.size(); i++) {
			if (isLeft) {
				lastNode.left = convertToBinaryRec(node.children.get(i), !isLeft);
				lastNode = lastNode.left;
			} else {
				lastNode.right = convertToBinaryRec(node.children.get(i), !isLeft);
				lastNode = lastNode.right;
			}
		}
		return tNode;
	}

	static TreeNode convertToBinary(NTreeNode node) {
		return convertToBinaryRec(node, true);
	}

	public static void main(String[] args) {
		NTreeNode one = new NTreeNode(1);
		NTreeNode two = new NTreeNode(2);
		NTreeNode three = new NTreeNode(3);
		NTreeNode four = new NTreeNode(4);
		NTreeNode five = new NTreeNode(5);
		NTreeNode six = new NTreeNode(6);

		one.children.add(two);
		one.children.add(three);
		one.children.add(four);

		three.children.add(five);
		three.children.add(six);

		TreeNode bstNode = convertToBinary(one);
	}

}
