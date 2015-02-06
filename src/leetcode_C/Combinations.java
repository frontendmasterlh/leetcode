package leetcode_C;

import java.util.*;

public class Combinations {
	private void dfs (int depth, int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
        if (temp.size() == k){
            ArrayList<Integer> ans = new ArrayList<Integer> (temp);
            res.add(ans);
            return;
        }
        for (int i = depth + 1; i <= n; i++) {
            temp.add(i);
            dfs (i, n, k, res, temp);
            temp.remove(temp.size()-1);
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if (n == 0 || k== 0 || n< k)
            return res;
        ArrayList<Integer> temp = new ArrayList<Integer> ();
        dfs (0, n, k, res, temp);
        return res;
    }
    
    static public void main (String[] argv){
    	Combinations c = new Combinations();
    	int n = 8, k = 3;
    	ArrayList<ArrayList<Integer>> res = c.combine(n, k);
    	for (ArrayList<Integer> v1 : res){
    		for (int v2 : v1){
    			System.out.print(v2+ " ");
    		}
    		System.out.println();
    	}
    }
}
