package array.hashtable;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (j > 0) { // Now matrix[i][j] must be '1'
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        int max = 0;
        int curArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i;
                int minWidth = dp[i][j];
                while (k >= 0 && dp[k][j] != 0) {
                    minWidth = Math.min(minWidth, dp[k][j]);
                    curArea = minWidth * (i - k + 1);
                    max = Math.max(max, curArea);
                    k--;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(m.maximalRectangle(matrix));
    }
}
