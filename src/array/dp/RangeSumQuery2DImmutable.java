package array.dp;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 *
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DImmutable {
    int[][] sums;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            sums[i][0] = matrix[i][0] + sums[i - 1][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            sums[0][j] = matrix[0][j] + sums[0][j - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            int temp = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                temp += matrix[i][j];
                sums[i][j] = temp + sums[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int piece1 = 0, piece2 = 0, piece3 = 0;
        if (row1 != 0 && col1 != 0) {
            piece3 = sums[row1 - 1][col1 - 1];
        }
        if (row1 != 0) {
            piece1 = sums[row1 - 1][col2];
        }
        if (col1 != 0) {
            piece2 = sums[row2][col1 - 1];
        }
        return sums[row2][col2] - piece1 - piece2 + piece3;
    }
}
