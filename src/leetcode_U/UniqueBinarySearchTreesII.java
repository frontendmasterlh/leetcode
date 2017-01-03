package leetcode_U;

import java.util.*;

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

public class UniqueBinarySearchTreesII {
	private ArrayList<TreeNode> generate (int begin, int end) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode> ();
        if (begin > end){
            res.add(null);//We add a null to show that its one child is null.
            return res;
        }
        for (int i = begin; i<= end; i++) {
            ArrayList<TreeNode> leftTree = generate (begin, i-1);//The left side values are all less than the value of the root.
            ArrayList<TreeNode> rightTree = generate (i+1, end);//The right side values are all greater than the value of the root.
            
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++){
                    TreeNode root = new TreeNode (i);
                    root.left = leftTree.get(j);
                    root.right= rightTree.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        return generate (1, n);
    }
    
    static public void main (String[] argv) {
    	;
    }
}
