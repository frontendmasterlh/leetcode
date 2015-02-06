package leetcode_B;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		val = x;
		left = null;
		right = null;
	};
}

public class BalancedBinaryTree {
	private int dfs (TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs (root.left);
        int right =  dfs (root.right);
        if (left == -1 || right == -1)//Its child has been not satisfied
            return -1;
        if (Math.abs(left - right) >1)//Its child is not satisfied.
            return -1;
        return left > right ? left +1 : right + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        int res = dfs (root);
        if (res==-1)
            return false;
        else
            return true;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
