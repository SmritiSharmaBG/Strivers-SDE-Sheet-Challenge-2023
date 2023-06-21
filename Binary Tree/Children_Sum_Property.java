import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if (root == null || root.left == null && root.right == null) return;
        rec(root);
    }

    private static void rec(BinaryTreeNode < Integer > root) {
        if (root == null) return;
        rec(root.left);
        rec(root.right);
        // no need if leaf node
        if (root.left == null && root.right == null) return;
        int childSum = 0;
        if (root.left != null) childSum = childSum + root.left.data;
        if (root.right != null) childSum = childSum + root.right.data;
        if (childSum > root.data) root.data = childSum;
        else if (childSum < root.data) {
            if (root.left == null) {
                root.right.data = root.data;
            } else if (root.right == null) {
                root.left.data = root.data;
            } else {
                int half = root.data / 2;
                if (root.left.data > half) {
                    root.right.data = root.data - root.left.data;
                } else if (root.right.data > half) {
                    root.left.data = root.data - root.right.data;
                } else {
                    root.right.data = half;
                    root.left.data = root.data - root.right.data;
                }
            }
            // we have changed the children which can disturb the child-sum property.
            // we need to re-check
            rec(root);
        }
    }
}
