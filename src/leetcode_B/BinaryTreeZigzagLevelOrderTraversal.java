package leetcode_B;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if (root==null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        ArrayList<Integer> temp = new ArrayList<Integer> ();
        TreeNode cur = null;
        int odd = 0;
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur!=null){
                if (odd%2==0){
                    temp.add(cur.val);
                }else{
                    temp.add(0, cur.val);
                }
                if (cur.left!=null)
                    queue.offer(cur.left);
                if (cur.right!=null)
                    queue.offer(cur.right);
            }else {
                odd++;
                ArrayList<Integer> ans = new ArrayList<Integer> (temp);
                res.add(ans);
                temp.clear();
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return res;
    }
	
	static public void main (String[] argv){
		;
	}
}
