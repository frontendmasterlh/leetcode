package leetcode_P;

import java.util.*;

public class Permutations {
ArrayList<ArrayList<Integer>> res;
    
    private void dfs (int depth, int[] num, ArrayList<Integer> temp, int[] visited) {
        if (depth==num.length){
            ArrayList<Integer> ans = new ArrayList<Integer> (temp);
            res.add(ans);
            return ;
        }
        
        for (int i=0; i < num.length; i++) {
            if (visited[i]==0){
                visited[i] = 1;
                temp.add(num[i]);
                dfs (depth+1, num, temp, visited);
                temp.remove(temp.size()-1);
                visited[i] = 0;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        res = new ArrayList<ArrayList<Integer>> ();
        if (num==null || num.length==0)
            return res;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        dfs (0, num, temp, visited);
        return res;
    }
    
    static public void main (String[] argv) {
    	int[] num = {1,2,3,4,5};
    	System.out.println(new Permutations().permute(num));
    }
}
