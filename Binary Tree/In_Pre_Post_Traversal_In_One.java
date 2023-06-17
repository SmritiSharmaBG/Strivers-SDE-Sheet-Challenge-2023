import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>()); // for inorder
		ans.add(new ArrayList<>()); // for pre order
		ans.add(new ArrayList<>()); // for post order

		rec(root, ans);
		return ans;
    }

	private static void rec(BinaryTreeNode<Integer> root, List<List<Integer>> ans) {
		if (root == null) return;
		ans.get(1).add(root.data); // preorder
		rec(root.left, ans);
		ans.get(0).add(root.data); // inorder
		rec(root.right, ans);
		ans.get(2).add(root.data); // postorder
	}
}
