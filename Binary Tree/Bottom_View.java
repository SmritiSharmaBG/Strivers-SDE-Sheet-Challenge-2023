import java.util.* ;
import java.io.*; 
/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/


public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<Item> queue = new LinkedList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        queue.add(new Item(root, 0));

        while (! queue.isEmpty()) {
            Item temp = queue.remove();
            BinaryTreeNode node = temp.node;
            int vertical = temp.x;

            // add it in TreeMap -- only once so that last element gets retained all the time.
            treeMap.put(vertical, node.val);

            // add its children in queue for further iteration
            if (node.left != null) queue.add(new Item(node.left, vertical - 1));
            if (node.right != null) queue.add(new Item(node.right, vertical + 1));
        } // while

        // convert treemap to arrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : treeMap.entrySet()) ans.add(i.getValue());
        return ans;
    }

    static class Item {
        BinaryTreeNode node;
        int x;

        Item(BinaryTreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }
}
