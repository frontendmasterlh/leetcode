package array.dp;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        // Method 1: Use Recursion with Mem.
        // return dfsHelper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);

        // Method 2: Use DP
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < s.length()) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                }
            }
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    private int dfsHelper(String s, int i, int j, Integer[][] mem) {
        if (mem[i][j] != null) {
            return mem[i][j];
        }
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            mem[i][j] = dfsHelper(s, i + 1, j - 1, mem) + 2;
        } else {
            mem[i][j] = Math.max(dfsHelper(s, i, j - 1, mem), dfsHelper(s, i + 1, j, mem));
        }
        return mem[i][j];
    }
}
