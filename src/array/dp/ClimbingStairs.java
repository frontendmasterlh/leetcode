package array.dp;

/**
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // Method 1: DP
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        // // Method 2: Recursion
        // if (n == 1) {
        //     return 1;
        // }
        // if (n == 2) {
        //     return 2;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
