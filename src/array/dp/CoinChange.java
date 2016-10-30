package array.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // // Method 1: DFS Time Limit Exception
        // if (coins == null || coins.length == 0 || amount == 0) {
        //     return 0;
        // }
        // Arrays.sort(coins);
        // int [] res = {Integer.MAX_VALUE};
        // helper(coins, amount, 0, 0, res);
        // return res[0] == Integer.MAX_VALUE ? -1 : res[0];

        if (amount == 0) {
            return 0;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    private void helper(int[] coins, int amount, int index, int count, int[] res) {
        if (amount < 0) {
            return;
        }
        if (index == coins.length) {
            if (amount == 0) {
                res[0] = Math.min(res[0], count);
            }
            return;
        }
        for (int i = 0; i <= amount / coins[index]; i++) {
            helper(coins, amount - coins[index] * i, index + 1, count + i, res);
        }
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {470,35,120,81,121};
        System.out.println(c.coinChange(coins, 9825));
    }
}
