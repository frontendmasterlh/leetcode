package array.graph;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {

    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfsHelper(matrix, memo, i, j);
                res = Math.max(res, len);
            }
        }
        return res;
    }

    private int dfsHelper(int[][] matrix, int[][] memo, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfsHelper(matrix, memo, x , y));
            }
        }
        return ++memo[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(l.longestIncreasingPath(matrix));
    }
}
