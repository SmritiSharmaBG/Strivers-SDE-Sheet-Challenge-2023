import java.util.* ;
import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		//Stack<Integer> stack = new Stack<>();
		queue.add(root);
		int it = 0;
		// 0 -> queue 
		// 1 -> stack
		while(! queue.isEmpty()) {
			int levelSize = queue.size();
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < levelSize; i ++) {
				BinaryTreeNode<Integer> temp = queue.remove();
				if (temp.left != null) queue.add(temp.left);
				if (temp.right != null) queue.add(temp.right);
				if (it % 2 == 0) ans.add(temp.data);
				else stack.add(temp.data);
			}

			while (! stack.isEmpty()) ans.add(stack.pop());
			it ++;

		}

		return ans;

	}
}
