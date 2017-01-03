package leetcode_S;

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

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p!=null && q!=null){
            if (p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)){
                return true;
            }else
                return false;
        }else if (p==null && q==null)
            return true;
        else 
            return false;
    }
    
    static public void main (String[] argv){
    	;
    }
}
