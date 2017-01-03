package array.dp;

/**
 * Created by jli1 on 11/6/16.
 */
public class LongestCommonSubarray {

    public int longestCommonSubarray(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int m = A.length;
        int n = B.length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubarray l = new LongestCommonSubarray();
        int[] A = {1, 2, 3, 5, 6, 7, 8, 9};
        int[] B = {1, 3, 5, 6, 8, 9};
        System.out.println(l.longestCommonSubarray(A, B));
    }
}
