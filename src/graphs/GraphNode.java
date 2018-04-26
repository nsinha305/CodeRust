package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	int data;
	List<GraphNode> neighbors;

	GraphNode(int data) {
		this.data = data;
		neighbors = new ArrayList<GraphNode>();
	}

	void addEdge(GraphNode node) {
		neighbors.add(node);
	}
}
