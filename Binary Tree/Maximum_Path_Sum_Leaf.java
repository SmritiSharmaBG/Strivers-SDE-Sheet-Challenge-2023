import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

public class Solution {
	public static long findMaxSumPath(TreeNode root) {
		if (root == null || root.left == null || root.right == null) return -1;
		long[] max = {0};
		rec(root, max);
		return max[0];
	}

	private static long rec(TreeNode root, long[] max) {
		if (root == null) return 0;
		long l = rec(root.left, max);
		long r = rec(root.right, max);
		max[0] = Math.max(max[0], (l + r + root.data)); // I am the max
		return Math.max(l, r) + root.data;
	}
	
}
