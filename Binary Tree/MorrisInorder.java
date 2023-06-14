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
        morris(ds, root);
        return ds;
    }

    private static void morris(List<Integer> ds, TreeNode node) {
        TreeNode curr = node;

        while (curr != null) {
            // if no left, go node -> right
            if (curr.left == null) {
                ds.add(curr.data);
                curr = curr.right;
            }
            else {
                // find inorder predecessor.
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                // out of while because of any one reason
                if (temp.right == null) {
                    // first time visiting, make threads and move left
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    // this whole sub-tree is already visited, delete and move right
                    //temp.right = null;   ------ THIS LINE CAN BE AVOIDED!!!
                    ds.add(curr.data);
                    curr = curr.right;
                }
            } // else
        } // while
    }
}
