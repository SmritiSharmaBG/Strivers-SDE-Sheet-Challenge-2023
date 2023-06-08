import java.util.* ;
import java.io.*; 
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
    public static List < Integer > getInOrderTraversal(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
    	rec(ds, root);
        return ds;
    }

    private static void rec(List<Integer> ds, TreeNode node) {
        if (node == null) return;
        rec(ds, node.left);
        ds.add(node.data);
        rec(ds, node.right);
    }
}
