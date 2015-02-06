package leetcode_B;

public class BinaryTreeMaximumPathSum {
	static int max = Integer.MIN_VALUE;
    
    private int dfs (TreeNode root) {
        if (root==null)
            return 0;
        int left = dfs (root.left);
        int right = dfs(root.right);
        int m = root.val;
        
        if (left > 0)
            m += left;
        if (right > 0)
            m += right;
        max = Math.max(m, max);
        
        int side = Math.max(left, right);
        return side > 0 ? side + root.val : root.val;
    }
    
    
    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
//        max = Integer.MIN_VALUE;
        dfs (root);
        return max;
    }
    
    static public void main (String[] argv) {
    	TreeNode root = new TreeNode (-3);
    	System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }
}
