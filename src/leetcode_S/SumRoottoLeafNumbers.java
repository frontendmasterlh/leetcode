package leetcode_S;

public class SumRoottoLeafNumbers {
	private int dfs (TreeNode root, int presum) {
        int temp = presum * 10 + root.val;
        if (root.left==null && root.right==null)
            return temp;
        if (root.left==null)
            return dfs (root.right, temp);
        if (root.right==null)
            return dfs (root.left, temp);
        return dfs (root.left, temp) + dfs (root.right, temp);
    }
    
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        return dfs (root, 0);
    }
    
    static public void main (String[] argv){
    	;
    }
}
