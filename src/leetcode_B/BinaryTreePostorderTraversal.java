package leetcode_B;

import java.util.*;

public class BinaryTreePostorderTraversal {
	
	private void dfs (TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return ;
		dfs (root.left, res);
		dfs (root.right, res);
		res.add(root.val);
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (root==null)
            return res;
        dfs(root, res);
        
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
