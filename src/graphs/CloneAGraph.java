package graphs;

import java.util.HashMap;

public class CloneAGraph {

	static GraphNode cloneRec(GraphNode node, HashMap<GraphNode, GraphNode> visited) {
		if (node == null)
			return null;
		GraphNode newNode = new GraphNode(node.data);
		visited.put(node, newNode);
		for (int i = 0; i < node.neighbors.size(); i++) {
			if (visited.get(node.neighbors.get(i)) != null)
				newNode.addEdge(visited.get(node.neighbors.get(i)));
			else
				newNode.addEdge(cloneRec(node.neighbors.get(i), visited));
		}
		return newNode;
	}

	static GraphNode deepCopy(GraphNode node) {
		HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
		return cloneRec(node, visited);
	}

	public static void main(String[] args) {
		GraphNode zero = new GraphNode(0);
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		zero.addEdge(three);
		zero.addEdge(two);
		zero.addEdge(four);

		one.addEdge(two);

		two.addEdge(zero);

		three.addEdge(two);

		four.addEdge(three);
		four.addEdge(one);
		four.addEdge(zero);

		deepCopy(one);
	}

}
