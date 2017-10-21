package array.dp;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 For example, costs0 is the cost of painting house 0 with color red;
 costs1 is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

 Note: All costs are positive integers.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i  = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }
}
