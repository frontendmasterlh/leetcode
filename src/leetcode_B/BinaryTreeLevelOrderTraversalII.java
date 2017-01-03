package leetcode_B;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if (root== null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        List<Integer> temp = new ArrayList<Integer> ();
        
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur!= null) {
                temp.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }else {
                ArrayList<Integer> ans = new ArrayList<Integer> (temp);
                res.add(0,ans);//Just reverse the sequence of the result.
                temp.clear();
                if (!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
        return res;
    }
	
	static public void main (String[] argv){
		;
	}
}
