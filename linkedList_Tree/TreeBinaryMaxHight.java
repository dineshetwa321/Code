package a.linkedList_Tree;

class TreeNode {
	int value;
	TreeNode left, right;

	TreeNode(int item) {
		value = item;
		left = right = null;
	}
}

public class TreeBinaryMaxHight {

	TreeNode root;

	// Method to calculate the height of the tree
	public int maxHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// Recursively calculate the height of left and right subtrees
		int leftHeight = maxHeight(node.left);
		int rightHeight = maxHeight(node.right);

		// Return the larger height plus 1 for the root node
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		TreeBinaryMaxHight tree = new TreeBinaryMaxHight();

		// Creating a sample tree:
		// 1
		// / \
		// 2 3
		// / \
		// 4 5

		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("The height of the tree is: " + tree.maxHeight(tree.root));
	}
}
