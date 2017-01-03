package leetcode_P;

import java.util.*;

public class PermutationsII {
	ArrayList<ArrayList<Integer>> res;
    
    private void dfs (int depth, int[] num, ArrayList<Integer> temp, int[] visited) {
        if (depth==num.length){
            ArrayList<Integer> ans = new ArrayList<Integer> (temp);
            res.add(ans);
            return ;
        }
        for (int i=0; i< num.length; i++) {
            if (visited[i]==1 || (i!=0 && num[i]==num[i-1] && visited[i-1]==1))
                continue;
            visited[i] = 1;
            temp.add(num[i]);
            //System.out.println("depth:"+depth+"i:"+i+"num[i]"+num[i]+"visited[i]"+visited[i]);
            dfs (depth+1, num, temp, visited);
            temp.remove(temp.size()-1);
            visited[i] = 0;
        }
    }
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        res = new ArrayList<ArrayList<Integer>> ();
        if(num==null || num.length==0)
            return res;
        int[] visited = new int[num.length];
        ArrayList<Integer> temp = new ArrayList<Integer> ();
        Arrays.sort(num);// Do the sorting.
        dfs (0, num, temp, visited);
        return res;
    }
    
    static public void main (String[] argv) {
//    	int[] num = {1,2,3,4,5};
//    	int[] num = {-1,-1,3,-1};
    	int[] num = {1,1,1};
    	System.out.println(new PermutationsII().permuteUnique(num));
    }
}
