package leetcode_S;

public class ScrambleString {
	
	public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        for (int k=1; k <= len; k++){   //First of all, len starts from 1 to len.
            for (int i=0; i <= len - k; i++){//s1 and s2 starts from 0. With the len(k), it ranges to len-k 
                for (int j=0; j <= len - k; j++){
                    if (k==1){
                        dp[i][j][k] = (s1.charAt(i) == s2.charAt(j)); 
                    }else {
                        for (int l = 1; l < k; l++){//L is the splited point. So it must be less than k. Once found, no need to find (important).
                            if ((dp[i][j][l] && dp[i+l][j+l][k-l]) ||(dp[i][j+k-l][l] && dp[i+l][j][k-l])){
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
	
	static public void main (String[] argv){
		;
//		boolean[][][] dp = new boolean[5][5][5];
//		System.out.println(dp[0][3][0]);
	}
}
