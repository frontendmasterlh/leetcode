package leetcode_P;

import java.util.*;

public class PathSumII {
ArrayList<ArrayList<Integer>> res;
    
    public void dfs (TreeNode root, int cur, int sum, ArrayList<Integer> temp){
        if (root==null)
            return ;
        if (root.left==null && root.right == null){
            if (cur + root.val == sum){
                temp.add(root.val);
                //res.add(temp);
                ArrayList<Integer> now = new ArrayList<Integer> (temp);//  Java的局部变量能够在子函数里面被修改。
                res.add(now);
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        dfs (root.left,  cur + root.val, sum, temp);
        dfs (root.right, cur + root.val, sum, temp);
        temp.remove(temp.size()-1);
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<ArrayList<Integer>> ();
        if (root==null)
            return res;
        ArrayList<Integer> temp = new ArrayList<Integer> ();
        dfs (root, 0, sum, temp);
        
        return res;
    }
    
    static public void main (String argv[]) {
    	;
    }
}
