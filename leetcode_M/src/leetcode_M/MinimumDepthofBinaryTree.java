package leetcode_M;

public class MinimumDepthofBinaryTree {
	private static TreeNode root=null;
	
	/*Definition for binary tree */
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; 
	    }
	}
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left = minDepth(root.left);
        int right= minDepth(root.right);
        if (left==0 && right==0)
            return 1;
        if (left==0)
            left = Integer.MAX_VALUE;
        if (right==0)
            right = Integer.MAX_VALUE;
        if (left < right)
            return left+1;
        else
            return right +1;
    }
    
    static public void main (String argv[]){
    	System.out.println(new MinimumDepthofBinaryTree().minDepth(root));
    }
}
