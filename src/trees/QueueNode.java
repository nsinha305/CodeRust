package trees;

public class QueueNode {
	TreeNode node;
	int level;

	QueueNode(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}
