package leetcode_G;

import java.util.*;

public class GenerateParentheses {
	private ArrayList<String> res;
    
    private void dfs (String s, int left, int right, int n) {
        if (left > n)
            return ;
        if (n== left && right == left){
            res.add(s);
        }else {
            dfs (s+"(", left+ 1, right, n);
            if (left > right) {
                dfs (s+")", left, right + 1, n);
            }
        }
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        res = new ArrayList<String> ();
        if (n==0)
            return res;
        dfs ("", 0,0,n);
        return res;
    }
    
    static public void main (String[] argv) {
    	GenerateParentheses g = new GenerateParentheses();
    	int n = 5;
    	ArrayList<String> res = g.generateParenthesis(n);
    	
    	for (String v : res) {
    		System.out.println(v);
    	}
    }
}
