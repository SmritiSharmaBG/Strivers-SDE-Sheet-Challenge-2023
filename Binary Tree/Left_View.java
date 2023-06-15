import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i ++) {
                TreeNode<Integer> temp = queue.remove();
                if (i == 0) ans.add(temp.data);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            } // level-traversal
        } // while
        return ans;
    }
}
