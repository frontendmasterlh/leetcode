package leetcode_P;

import java.util.*;

public class PascalsTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        res.add(1);
        for (int i=1; i <= rowIndex; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer> ();
            temp.add(1);
            for (int j=0; j < res.size()-1; j++){
                temp.add(res.get(j) + res.get(j+1));
            }
            temp.add(1);
            res = temp;
        }
        return res;
    }
    
    static public void main (String argv[]) {
    	System.out.println(new PascalsTriangleII().getRow(3));
    }
}
