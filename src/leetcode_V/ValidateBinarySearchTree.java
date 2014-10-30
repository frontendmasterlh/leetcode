package leetcode_V;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		val = x;
		left = null;
		right = null;
	};
}

public class ValidateBinarySearchTree {
	private int lastVisited = Integer.MIN_VALUE; 
    
    public boolean isValidBST(TreeNode root) {
        if (root==null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (lastVisited >= root.val)
            return false;
        lastVisited = root.val;
        if (!isValidBST(root.right))
            return false;
        return true;
    }
    
    static public void main (String[] argv) {
    	;
    }
}
