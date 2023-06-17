import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the Binary Tree node structure

class BinaryTreeNode<T> 
{
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
};

*************************************************************/
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		int ht = isBal(root);
        if (ht == -1) return false;
        return true;
	}

  // OPTIMIZED SOLUTION TIME COMPLEXITY = O(N)
    private static int isBal(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int lHt = isBal(root.left);
        int rHt = isBal(root.right);
        if (lHt == -1 || rHt == -1) return -1;
        int diff = lHt - rHt;
        if (diff > 1 || diff < -1) return -1;
        return Math.max(lHt, rHt) + 1;
    }
  
  // Time Complexity : O(n^2) because it needs to calculate the height at all the nodes

    private static boolean isBal2(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        int lHt = height(root.left);
        int rHt = height(root.right);
        int diff = lHt - rHt;
        if (diff > 1 || diff < -1) return false;
        else return(isBal2(root.left) && isBal2(root.right));
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int lHt = height(root.left);
        int rHt = height(root.right);
        return Math.max(lHt, rHt) + 1;
    }
}
