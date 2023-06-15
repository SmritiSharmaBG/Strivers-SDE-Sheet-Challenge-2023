import java.util.* ;
import java.io.*; 
/*   
    Following is the Binary Tree node structure for referance:

    class TreeNode
    {
        int data;
        TreeNode left, right;
    
        public TreeNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
*/

public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> ds = new ArrayList<>();
        rec(root, x, false, ds);
        return ds;
    }

    private static boolean rec(TreeNode root, int x, Boolean found, ArrayList<Integer> ds) {
        if (found == true) return true;
        if (root == null) return false;
        ds.add(root.data);
        if (root.data == x) {
            found = true;
            return true;
        }
        if (rec(root.left, x, found, ds)) return true;
        if (rec(root.right, x, found, ds)) return true;
        ds.remove(ds.size() - 1);
        return false;
    }
}
