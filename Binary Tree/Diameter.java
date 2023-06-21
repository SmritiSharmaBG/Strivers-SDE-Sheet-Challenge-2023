/*************************************************************

Following is the Binary Tree Node structure:

    class TreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		Integer maxi = 0;
		int[] max = new int[1];
		diam(root, max);
		return max[0];
	}

	private static int diam(TreeNode<Integer> root, int[] max) {
		if (root == null) return 0;
		int l = diam(root.left, max);
		int r = diam(root.right, max);
		max[0] = Math.max(max[0], (l + r));
		return Math.max(l, r) + 1;
	}
	private static int dia(TreeNode<Integer> root) {
		if (root == null) return 0;
		int lHt = height(root.left);
		int rHt = height(root.right);
		int diam = lHt + rHt;
		int lDia = dia(root.left);
		int rDia = dia(root.right);

		return Math.max(diam, Math.max(lDia, rDia));
	}

	private static int height(TreeNode<Integer> root) {
		if (root == null) return 0;
		int leftht = height(root.left);
		int rightht = height(root.right);
		return Math.max(leftht, rightht) + 1;
	}
}
