package leetcode_R;

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

public class RecoverBinarySearchTree {
	TreeNode pre;
    TreeNode left;
    TreeNode right;
    
    private void dfs(TreeNode root) {
        if (root==null)
            return ;
        dfs (root.left);
        if (pre!=null && pre.val > root.val) {//will enter this condition once or twice.
            if (left==null)
                left = pre;
            right = root;
        }
        pre = root;
        dfs (root.right);
    }
    
    public void recoverTree(TreeNode root) {
        if (root==null)
            return;
        pre = null;
        left = null;
        right = null;
        dfs (root);
        if (left!=null && right!=null){
        	int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }  
        return;
    }
    
    static public void main (String[] argv) {
    	TreeNode root = new TreeNode(2);
    	TreeNode left1 = new TreeNode(1);
    	TreeNode right1 = new TreeNode(3);
    	root.left = left1;
    	root.right = right1;
    	new RecoverBinarySearchTree().recoverTree(root);
    	
    }
}
