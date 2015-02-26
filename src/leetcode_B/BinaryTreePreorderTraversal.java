package leetcode_B;

import java.util.*;

public class BinaryTreePreorderTraversal {
	
	private void dfs (TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		dfs(root.left, res);
		dfs(root.right, res);
	}
	
	public ArrayList<Integer> preorderTraversal2(TreeNode root){//Recursive solution
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if (root == null)
			return result;
		dfs (root, result);
		return result;
	}
	
	
    public ArrayList<Integer> preorderTraversal(TreeNode root) {//Iterative solution
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (root== null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        stack.push(root);
        
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        
        return res;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
