package leetcode_L;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // if (s==null)//此为方法一，AC
        //     return null;
        // int n = s.length();
        // int pos=0;
        // int max=1;
        // boolean[][] dp = new boolean[n][n];
        // for (int i=0; i<n; i++) {
        //     dp[i][i] = true;
        //     if (i+1 < n){
        //         if (s.charAt(i)==s.charAt(i+1)){
        //             pos = i;
        //             max = 2;
        //             dp[i][i+1] = true;
        //         }else
        //             dp[i][i+1] = false;
        //     }
        // }
        
        // for (int len = 3; len <= n; len++) {
        //     for (int i=0; i < n-len+1; i++) {
        //         int j = i + len -1;
        //         if (dp[i+1][j-1]==true && s.charAt(i)==s.charAt(j)) {
        //             dp[i][j] = true;
        //             if (max < len) {
        //                 pos = i;
        //                 max = len;
        //             }
        //         }else
        //             dp[i][j] = false;
        //     }
        // }
        // return s.substring(pos, pos + max);//Java中的substring从头到尾的index，第二个元素不代表子串长度
        
        int n = s.length();
        int odd=0, even=0, cur, max=1, pos=0;
        for (int i=0; i< n; i++) {
            odd = isPalindrome (s, i, i);
            if (i+1< n)
                even = isPalindrome(s, i, i+1);
            cur = Math.max(even,odd);
            if (cur>max) {
                max = cur;
                if (cur %2==1) {
                    pos = i - (max)/2;
                }else
                    pos = i - (max-1)/2;
            }
        }
        return s.substring (pos, pos + max);
    }
    
    int isPalindrome (String s, int i, int j) {
        int n=s.length();
        int len = 0;
        while (i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        len = (j-1) - (i+1) +1;
        return len;
    }
	
	static public void main (String argv[]) {
		String s = "Hello world";
		System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
	}
}
