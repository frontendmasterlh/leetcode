package leetcode_S;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
private ArrayList<ArrayList<Integer>> res;
    
    private void findS (int[] num, ArrayList<Integer> list, int pos) {
        res.add (new ArrayList<Integer> (list));
        
        for (int i = pos; i < num.length; i++){
            if (i!=pos && num[i]== num[i-1])
                continue;
            list.add(num[i]);
            findS (num, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        res = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        findS (num, list, 0);
        return res;
    }
    
    static public void main (String[] argv){
    	;
    }
}
