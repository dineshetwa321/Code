package a.linkedList_Tree;

import java.util.Arrays;
import java.util.List;

// Definition for a Node.
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, List<Node> children) {
		this.val = val;
		this.children = children;
	}
}

public class TreeMaximumDepth {

	public int maxDepth(Node root) {
		// Base case: if the tree is empty
		if (root == null) {
			return 0;
		}

		// If the node has no children, depth is 1 (leaf node)
		if (root.children == null || root.children.isEmpty()) {
			return 1;
		}

		// Find the maximum depth of all children
		int maxChildDepth = 0;
		for (Node child : root.children) {
			maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
		}

		// Add 1 for the current node's depth
		return maxChildDepth + 1;
	}

	public static void main(String[] args) {
		// Create a sample N-ary tree
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		Node node3 = new Node(3, Arrays.asList(node5, node6));
		Node node2 = new Node(2);
		Node node4 = new Node(4);

		Node root = new Node(1, Arrays.asList(node3, node2, node4));

		// Find maximum depth
		TreeMaximumDepth solution = new TreeMaximumDepth();
		int maxDepth = solution.maxDepth(root);
		System.out.println("Maximum Depth: " + maxDepth); // Output: 3
	}

}
