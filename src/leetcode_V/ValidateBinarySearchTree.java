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
	private boolean first = true;			//Check if it is the first node
    
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST(root.left))
            return false;
        if (!(first && root.val == Integer.MIN_VALUE) && lastVisited >= root.val)
            return false; //In this case, it may have only one node with the val= Integer.MIN_VALUE
        first = false;
        lastVisited = root.val;
        if (!isValidBST(root.right))
            return false;
        return true;
        
        // return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);//Abandon! You don't know whether it is the last node.
    }
    
    static public void main (String[] argv) {
    	;
    }
}
