package leetcode_B;

import java.util.*;

public class BinaryTreeInorderTraversal {
	public void dfs (TreeNode root, ArrayList<Integer> res){//Easy to use recursion.
        if (root==null)
            return ;
        if (root.left!=null)
            dfs(root.left, res);
        res.add(root.val);
        if (root.right!=null)
            dfs(root.right, res);
    }
    
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if (root==null)
            return res;
        // dfs (root, res);
        
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode> ();//More convenient to store pre using stack.
        while (!stack.empty() || cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    
    static public void main (String[] argv){
    	;
    }
    
}
