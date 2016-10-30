package array.dp;

/**
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // // DP: Time: O(n) Space: O(n)
        // if (n <= 0) {
        //     return 0;
        // }
        // if (n == 1 || n == 2) {
        //     return 1;
        // }
        // if (n == 3) {
        //     return 2;
        // }
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 3;
        // for (int i = 4; i <= n; i++) {
        //     for (int j = 1; j < i; j++) {
        //         dp[i] = Math.max(dp[i], j * dp[i - j]);
        //     }
        // }
        // return dp[n];

        // Using Regularities
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int res = 1;
        if (n % 3 == 0) {
            int m = n / 3;
            res = (int) Math.pow(3, m);
        } else if (n % 3 == 1) {
            int m = (n - 4) / 3;
            res = (int) Math.pow(3, m) * 4;
        } else if (n % 3 == 2) {
            int m = n / 3;
            res = (int) Math.pow(3, m) * 2;
        }
        return res;
    }

    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        System.out.println(i.integerBreak(9));
    }
}
