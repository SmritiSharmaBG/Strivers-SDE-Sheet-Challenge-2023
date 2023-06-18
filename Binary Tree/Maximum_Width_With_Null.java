/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Item> queue = new LinkedList<>();
        int max = 0;
        queue.add(new Item(root, 1));

        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            int first, last;
            first = last = 0;
            for (int j = 0; j < levelSize; j ++) {
                Item temp = queue.remove();
                int i = temp.i - 1;
                // first element
                if (j == 0) first = i;
                if (j == levelSize - 1) last = i;
                if (temp.node.left != null) queue.add(new Item(temp.node.left, (2*i) - 1));
                if (temp.node.right != null) queue.add(new Item(temp.node.right, 2*i));
            }
            int width = last - first + 1;
            if (width > max) max = width;            
        }
        return max;
    }
    
    public class Item {
        TreeNode node;
        int i;
        Item(TreeNode node, int i) {
            this.node = node;
            this.i = i;
        }
    }
}
