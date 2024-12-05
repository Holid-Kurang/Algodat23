package modul4;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
}

class BinaryTree {
	TreeNode root;

	BinaryTree(int val) {
		root = new TreeNode(val);
	}

	BinaryTree() {
		root = null;
	}

	// Pre-order traversal
	public void preOrder(TreeNode node) {
		if (node == null)
			return;

		System.out.print(node.val + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// In-order traversal
	public void inOrder(TreeNode node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.val + " ");
		inOrder(node.right);
	}

	// Post-order traversal
	public void postOrder(TreeNode node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " ");
	}

	// Level-order traversal
	public void levelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.print(tempNode.val + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}

public class Test {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left= new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		System.out.println("Pre-order traversal:");
		tree.preOrder(tree.root);
		System.out.println("\nIn-order traversal:");
		tree.inOrder(tree.root);
		System.out.println("\nPost-order traversal:");
		tree.postOrder(tree.root);
		System.out.println("\nLevel-order traversal:");
		tree.levelOrder(tree.root);
	}

}
