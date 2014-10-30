package leetcode_P;

import java.util.*;

public class PalindromePartitioning {
	private void dfs (ArrayList<ArrayList<String>> res, ArrayList<String> temp, String s) {
        if (s.length()==0) {
            res.add(new ArrayList<String> (temp));
            return ;
        }
        
        for (int i=0; i< s.length(); i++) {
            int begin = 0;
            int end = i;
            while (begin < end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    break;
                }else {
                    begin++;
                    end--;
                }
            }
            if (begin >= end) {
                temp.add(s.substring(0, i+ 1));
                dfs (res, temp, s.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>> ();
        ArrayList<String> temp = new ArrayList<String> ();
        dfs (res, temp, s);
        return res;
    }
    
    static public void main (String argv[]){
    	String s = "amanaplanacanalpanama";
    	ArrayList<ArrayList<String>> result = new PalindromePartitioning().partition(s);
    	for (ArrayList<String> value : result) {
    		String temp = "";
    		for (String value2 : value) {
    			temp = temp +", " + value2;
    		}
    		System.out.println(temp);
    	}
    }
}
