package leetcode_L;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    private String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private ArrayList<String> res;
    
    private void dfs (String digits, StringBuilder temp) {
        if (digits.length()==0){
            res.add(temp.toString());
            return ;
        }
        for (int i=0; i < str[digits.charAt(0) - '2'].length() ;i++) {
            temp.append(str[digits.charAt(0) - '2'].charAt(i));
            dfs (digits.substring(1), temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
    
    
    public ArrayList<String> letterCombinations(String digits) {
        res = new ArrayList<String> ();
        if (digits==null)
            return res;
        dfs (digits, new StringBuilder(""));
        return res;
    }
	
	static public void main (String argv[]) {
		String s = "234";
		ArrayList<String> result =  new LetterCombinationsofaPhoneNumber().letterCombinations(s);
		for (String value: result){
			System.out.println(value);
		}
		//System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations(s));
	}
}
