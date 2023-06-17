import java.util.* ;
import java.io.*; 
/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.ArrayList;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
	  ArrayList<Integer> ans = new ArrayList<>();
	  if (root == null) return ans;
	  Queue<BinaryTreeNode> queue = new LinkedList<>();
	  queue.add(root);

	  while (! queue.isEmpty()) {
		BinaryTreeNode temp = queue.remove();
		ans.add(temp.val);
		if (temp.left != null) queue.add(temp.left);
		if (temp.right != null) queue.add(temp.right);
	  }
	  return ans;
  }
}
