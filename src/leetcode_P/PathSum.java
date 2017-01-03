package leetcode_P;

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

public class PathSum {
	public boolean dfs (TreeNode root, int cur, int sum){
        if (root==null)
            return false;
        if (root.left==null && root.right==null)
            return cur + root.val == sum;
        return dfs(root.left, cur+root.val, sum)|| dfs(root.right, cur+root.val, sum);
    }
    
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        return  dfs(root, 0, sum);
    }
    
    static public void main (String argv[]) {
    	;
    }
}
