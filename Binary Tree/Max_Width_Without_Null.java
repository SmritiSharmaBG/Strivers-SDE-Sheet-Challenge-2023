import java.util.* ;

import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/

public class Solution {
	public static int getMaxWidth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int width = 0;
		while (! queue.isEmpty()) {
			int levelSize = queue.size();
			// System.out.println(levelSize + "*");
			if (levelSize > width) width = levelSize;
			// System.out.println(width);
			for (int i = 0; i < levelSize; i ++) {
				TreeNode temp = queue.remove();
				if (temp.left != null) queue.add(temp.left);
				if (temp.right != null) queue.add(temp.right);
			}
		} // while
		return width;
	}
}
