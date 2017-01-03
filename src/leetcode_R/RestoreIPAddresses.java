package leetcode_R;

import java.util.*;

public class RestoreIPAddresses {
	
	private boolean isValid (String s) {
		if (s.charAt(0)=='0')
				return s.equals("0");
		Long num = Long.valueOf(s);//This should be Long type because String s contains at most 12 bytes.
		return num>0 && num<=255;
	}
	
	private void dfs (String s, String temp, ArrayList<String> res, int count){
		if (count==3 && isValid(s)){//Terminated condition
			res.add(temp + s);
			return;
		}
		
		for (int i=1; i< 4 && i< s.length(); i++){//For loop.
			String part = s.substring(0,i);
			if (isValid(part)){
				dfs (s.substring(i), temp + s.substring(0,i)+".", res, count+1);
			}
		}
	}
	
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String> ();
		if (s.length()<4 || s.length()>12){
			return res;
		}
		dfs (s, "", res, 0);
		return res;
	}
	
	static public void main (String[] argv) {
		;
	}
}
