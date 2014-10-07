package leetcode_M;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val = x;}; 
}

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right){
            return left +1;
        }else
            return right+1;
    }
	
	static public void main (String argv[]){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode left2 = new TreeNode(2);
		TreeNode right = new TreeNode(2);
		TreeNode right2 = new TreeNode(2);
		
		root.left = left;
		root.right = right;
		left.left = left2;
		right.right = right2;
		
		System.out.println(new MaximumDepthofBinaryTree ().maxDepth(root));
	}
}
