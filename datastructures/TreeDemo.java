/*
A tree is a widely used data structure in computer science and mathematics that represents hierarchical relationships between elements.
It is composed of nodes connected by edges and has the following characteristics:

Nodes: Each element in a tree is called a node. Nodes in a tree are organized into levels, with the topmost node being the root and the nodes at the bottom levels being leaves.

Root: The root is the topmost node of the tree and serves as the starting point for traversing the tree. It has no parent node.

Edges: Edges are the connections between nodes in a tree. They represent the relationships between nodes. Each node (except the root) has exactly one parent node and zero or more child nodes.

Parent and Child Nodes: A node in a tree is a parent if it has one or more child nodes. Conversely, a node is a child if it has a parent node.

Leaves: Leaves are nodes in the tree that have no children. They are the nodes at the bottom level of the tree.

Subtree: A subtree is a portion of a tree that is itself a tree. It consists of a node and all of its descendants (children, grandchildren, and so on).

Depth: The depth of a node in a tree is the number of edges on the path from the root to that node.

Height: The height of a tree is the maximum depth of any node in the tree. It represents the length of the longest path from the root to a leaf node.

Binary Tree: A binary tree is a specific type of tree in which each node has at most two children: a left child and a right child.
Binary trees are commonly used in various applications, including binary search trees (BSTs) for efficient searching and sorting.


         A
       / \
      B   C
     / \   \
    D   E   F


 */


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.val = data;
		this.left = this.right = null;
	}
}

public class TreeDemo {


		/*
		Steps:
			1. Traverse the left subtree (recursively).
			2. Visit the current node.
			3. Traverse the right subtree (recursively).
		In other words, during an inorder traversal, you start at the root of the tree and first visit all the nodes in the left subtree,
		then visit the current node, and finally visit all the nodes in the right subtree.
		This process is applied recursively to each subtree until the entire tree has been traversed.

		      4
			 / \
			2   6
		   / \ / \
		  1  3 5  7



		 */

		public static void inOrderTraversal(TreeNode root) {
			if (root == null) {
				return;
			}

			// Recursively traverse the left subtree
			inOrderTraversal(root.left);

			// Visit (print) the current node
			System.out.print(root.val + " ");

			// Recursively traverse the right subtree
			inOrderTraversal(root.right);
		}



	public static void main(String[] args) {
			/*
			  4
			 / \
			2   6
		   / \ / \
		  1  3 5  7
			 */
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);

		TreeDemo.inOrderTraversal(root);
	}
}

