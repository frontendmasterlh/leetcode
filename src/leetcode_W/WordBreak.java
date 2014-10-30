package leetcode_W;

import java.util.Set;


public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true; //This means before the i th elem is breakable. 
        
        for (int i =1; i<= len ; i++) {
            for (int j= 0; j<i; j++) {//If before jth elem is breakable, and dict contains the remaining.
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
	
	static public void main (String[] argv) {
		;
	}
}
