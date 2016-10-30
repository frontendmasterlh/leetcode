package array.dp;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 Note: n and k are non-negative integers.
 */
public class PaintFence {

    // either i and i - 2 have the same coldr or i  and i - 1 have the same color.
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        int[] dp = new int[]{0, k, k * k, 0};
        if (n <= 2) {
            return dp[n];
        }
        int i = 3;
        while (i <= n) {
            dp[3] = (k  - 1) * dp[2] + (k - 1) * dp[1];
            dp[1] = dp[2];
            dp[2] = dp[3];
            i++;
        }
        return dp[3];
    }

    public static void main(String[] args) {
        PaintFence p = new PaintFence();
        System.out.println(p.numWays(3, 3));
    }
}
