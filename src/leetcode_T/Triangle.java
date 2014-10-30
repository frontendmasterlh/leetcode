package leetcode_T;

import java.util.*;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;
        int n = triangle.size();
        int[] temp = new int[n];
        temp[0] = triangle.get(0).get(0);
        for (int i=1; i< triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j>=0; j--){
                if (j==0)
                    temp[j] = temp[j] + triangle.get(i).get(j);
                else if (j==triangle.get(i).size() - 1)
                    temp[j] = temp[j-1] + triangle.get(i).get(j);
                else
                    temp[j] = Math.min (temp[j], temp[j-1]) + triangle.get(i).get(j);
            }
        }
        
        int res = temp[0];
        for (int i=0; i< n; i++) {
            res = res > temp[i] ? temp[i] : res;
        }
        return res;
    }
	
	static public void main (String[] argv) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>> ();
		ArrayList<Integer>  one = new ArrayList<Integer> (); 
		one.add(1);
		ArrayList<Integer> two = new ArrayList<Integer> ();
		two.add(2);
		two.add(3);
		triangle.add(one);
		triangle.add(two);
		System.out.println( new Triangle().minimumTotal(triangle));
	}
}
