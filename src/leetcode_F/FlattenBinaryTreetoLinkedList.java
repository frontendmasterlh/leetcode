package leetcode_F;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x){
		this.val = x;
		this.left = null;
		this.right = null;
	}
}

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if (root== null)
            return ;
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
	
	static public void main (String[] argv) {
		;
	}
}
