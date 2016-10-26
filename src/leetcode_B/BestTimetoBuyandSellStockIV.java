package leetcode_B;

/**
 * http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 */
public class BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        if (k < 2 || prices == null || prices.length < 2) {
            return 0;
        }
        if (k > prices.length) {
            return maxProfit2(prices);
        }

        int n = prices.length;
        int[][] local = new int[n][k + 1];
        int[][] global = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff); // have to sell at day i
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[n - 1][k];
    }


    private int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
