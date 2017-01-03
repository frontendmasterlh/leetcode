package leetcode_S;

public class SymmetricTree {
	private boolean dfs (TreeNode a, TreeNode b) {//Typical dfs.
        if (a==null && b==null)
            return true;
        if (a==null || b==null)
            return false;
        if (a.val != b.val)
            return false;
        return dfs (a.left, b.right) && dfs (a.right, b.left);
    } 
    
    public boolean isSymmetric(TreeNode root) {
        if (root== null)
            return true;
        return dfs (root.left, root.right);
    }
    
    static public void main (String[] argv)	{
    	;
    }
}
