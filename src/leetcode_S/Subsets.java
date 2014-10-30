package leetcode_S;

import java.util.*;

public class Subsets {
	private ArrayList<ArrayList<Integer>> res;
    
    private void findSubSet (int[] S, ArrayList<Integer> list, int num) {//Typical dfs.
        res.add(new ArrayList<Integer> (list));
        
        for (int i=num; i< S.length; i++) {
            list.add(S[i]);
            findSubSet (S, list, i + 1);
            list.remove(list.size() -1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        res = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        findSubSet (S,list, 0);
        return res;
    }
    
    static public void main (String[] argv){
    	;
    }
}
