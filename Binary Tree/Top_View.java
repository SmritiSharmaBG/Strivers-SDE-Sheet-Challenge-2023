import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

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

************************************************************/

public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		if (root == null) return new ArrayList<>();
		Queue<Item> queue = new LinkedList<>();
		TreeMap<Integer, Integer> hm = new TreeMap<>();
		queue.add(new Item(root, 0));

		while (! queue.isEmpty()) {
			Item temp = queue.remove();
			int vertical = temp.x;
			BinaryTreeNode node = temp.node;

			// add it in treeMap
			if (! hm.containsKey(vertical)) hm.put(vertical, node.val);

			// add the children in queue for further traversal
			if (node.left != null) queue.add(new Item(node.left, vertical - 1));
			if (node.right != null) queue.add(new Item(node.right, vertical + 1));
		} // while

		// traverse the hashmap and add it in arraylist
		ArrayList<Integer> ans = new ArrayList<>();
		for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
			ans.add(i.getValue());
		} 
		return ans;
	}

	static class Item {
		BinaryTreeNode node;
		int x;
		Item (BinaryTreeNode node, int x) {
			this.node = node;
			this.x = x;
		}
	}
}
