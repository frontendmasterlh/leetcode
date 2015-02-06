package leetcode_G;

import java.util.*;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 0; i < n; i++){
            int large = 1 << i;
            int size = res.size();
            for (int j = size-1; j>=0 ; j--){
                res.add(large + res.get(j));
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		GrayCode gc = new GrayCode();
		int n = 3;
		ArrayList<Integer> res = gc.grayCode(n);
		for (Integer v : res) {
			System.out.println(v);
		}
	}
}
