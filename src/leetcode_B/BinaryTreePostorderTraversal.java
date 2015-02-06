package leetcode_B;

import java.util.*;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(0, temp.val);//Post from left to right == pre from right to left.
            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }
        return res;
    }
	
	static public void main (String[] argv) {
		;
	}
}
