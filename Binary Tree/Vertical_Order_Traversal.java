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
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        if (root == null) return new ArrayList<>();
        Queue<Item> queue = new LinkedList<>();

        // x -> y -> Node
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        queue.add(new Item(root, 0, 0));

        while (!queue.isEmpty()) {
            Item temp = queue.remove();
            //System.out.println(temp.node.data + "**");
            int vertical = temp.x;
            int height = temp.y;
            TreeNode<Integer> node = temp.node;
            int data = node.data;

            // add it in the map

            // adding for first time at given vertical
            if (map.get(vertical) == null || map.get(vertical).get(height) == null) {
                ArrayList<Integer> pq = new ArrayList<>();
                pq.add(data);
                TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
                tm.put(height, pq);
                if(map.get(vertical) == null) map.put(vertical, tm);
                else map.get(vertical).put(height, pq);
            } else {
                map.get(vertical).get(height).add(data);
            }

            // adding children in queue for next iteration
            // adding left child
            if (node.left != null) queue.add(new Item(node.left, vertical - 1, height + 1));
            // adding right child
            if (node.right != null) queue.add(new Item(node.right, vertical + 1, height + 1));
        } // while

        // add map data in ans
        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> i : map.entrySet()) {
            for (Map.Entry<Integer, ArrayList<Integer>> j : i.getValue().entrySet()) {
                for (Integer k : j.getValue()) {
                    ans.add(k);
                } // k
            } // j
        } // i
        return ans;

    }

    static class Item {
        TreeNode<Integer> node;
        int x;
        int y;
        Item(TreeNode<Integer> node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
}
