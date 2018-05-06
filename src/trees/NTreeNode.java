package trees;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {
	int data;
	List<NTreeNode> children;

	NTreeNode(int data) {
		this.data = data;
		children = new ArrayList<NTreeNode>();
	}
}
