import java.util.* ;

import java.io.*;

public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> ds = new ArrayList<>();
		  morris(ds, root);
      return ds;
    }

	private static List<Integer> morris(List<Integer> ds, TreeNode node) {

		while (node != null) {
			
			if (node.left == null) {
				ds.add(node.data);
				node = node.right;
			}
			else {
				TreeNode inorderPre = node.left;
				while (inorderPre.right != null && inorderPre.right != node) {
					inorderPre = inorderPre.right;
				}
				// while ended
				if (inorderPre.right == null) {
					// inorderPredecessor found. make the temporary thread
					inorderPre.right = node;
					ds.add(node.data);
					// proceed to left traversal
					node = node.left;
				}
				else if (inorderPre.right == node) {
					// this side (left subtree) has already been traversed. 
					// we can proceed right
					node = node.right; 
				}
			} // else
		} // while
		return ds;
	}
}
