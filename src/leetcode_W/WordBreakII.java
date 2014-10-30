package leetcode_W;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
boolean[][] dp;
    
    private void dfs (String s, Set<String> dict, int pos, StringBuffer temp, ArrayList<String> res) {
        if (pos==s.length()){       //Simply using dfs cannot pass the big data.
            res.add(temp.toString().trim());
        }
        
        for (int len = 1; len <= s.length() - pos; len++) {
             String t = s.substring(pos, pos + len);
             if (dict.contains(t)) {
            	 StringBuffer newtmp = new StringBuffer (temp.toString());
                 newtmp.append(s.substring(pos, pos + len)).append(" ");
                 
//                 System.out.println("newtmp "+newtmp+"POS " + pos +"s.Len "+s.length());
                 
                 dfs (s, dict, pos + 1, newtmp, res);
             }
         }
//        for (int i = pos+1; i < s.length()+1; i++) {
//            if (dp[pos][i]){        // Add this condition.
//                if (dict.contains(s.substring(pos, i))){
//                    StringBuffer newtmp = new StringBuffer (temp.toString());
//                    newtmp.append(s.substring(pos, i)).append(" ");
//                    
//                    System.out.println("HAHA "+newtmp+"POS " + pos +"s.Len "+s.length());
//                    
//                    dfs (s, dict, pos + 1, newtmp, res);
//                }                
//            }
//        }
    }
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String> ();
        if (s==null || s.length()==0 || dict==null || dict.size()==0)
            return res;
        int len = s.length();
        dp = new boolean[len][len + 1];
        for (int i=1; i<=len; i++) {            // i means the length of the substring.
            for (int j = 0; j < len - i + 1; j++){// j means the start of the substring.
                String t = s.substring(j, j + i);
                if (dict.contains(t)) {
                    dp[j][i] = true;
                    continue;               // once found, it can have another solution, i.e, find next starting point. 
                }
                for (int k= 1; k < i; k++){ //seperate the length i into 2 parts: k length and i - k.
                    if (dp[j][k] && dp[j+k][i - k]) {
                        dp[j][i] = true;
                        break;				//Jump out of this loop.
                    }
                }
            }
        }
        
//		for (int i=0; i< dp.length; i++){
//			StringBuffer tmp = new StringBuffer ();
//			for (int j = 0; j < dp[i].length; j++){
//				tmp.append(dp[i][j]).append(" ");
//			}
//			System.out.println(tmp);
//		}
        
        if (!dp[0][len])
            return res;
        
        StringBuffer temp = new StringBuffer ();
        dfs (s, dict, 0, temp, res);
        return res;
    }
	
	static public void main (String[] argv) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String> ();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
//		String s = "ab";
//		dict.add("a");
//		dict.add("b");
		System.out.println(new WordBreakII().wordBreak(s, dict));
	}
}
