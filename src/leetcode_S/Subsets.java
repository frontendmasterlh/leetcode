package leetcode_S;

import java.util.*;

public class Subsets {
	private ArrayList<ArrayList<Integer>> res;
    
    private void findSubset (ArrayList<Integer> list, int[] S, int num) {//Typical dfs.
        res.add(new ArrayList<Integer> (list));
        
        for (int i=num; i< S.length; i++) {
            list.add(S[i]);
            findSubset (list, S, i + 1);
            list.remove(list.size() -1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	// //The 1st method: iteration.  DP
        // ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer> > ();
        // res.add(new ArrayList<Integer> ());
        // if (S== null || S.length== 0 )
        //     return res;
        
        // Arrays.sort(S);             //O(NlogN)
        
        // for (int i = 0; i < S.length; i++) {
        //     int count = res.size();
        //     for (int j = 0; j < count; j++) {
        //         //res.add(new ArrayList<Integer> (res.get(j)));
        //         ArrayList<Integer> temp = new ArrayList<Integer> (res.get(j));
        //         temp.add(S[i]);
        //         res.add(temp);
        //     }
        // }
        
        // return res;
        
        //The 2nd method: recursion.   DFS
        res = new ArrayList<ArrayList<Integer> > ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        Arrays.sort(S);
        
        findSubset (list, S, 0);
        return res;
    }
    
    static public void main (String[] argv){
    	;
    }
}
