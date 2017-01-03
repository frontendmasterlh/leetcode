package array.dp;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).


 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10
 Note:
 The matrix is only modifiable by the update function.
 You may assume the number of calls to update and sumRegion function is distributed evenly.
 You may assume that row1 ≤ row2 and col1 ≤ col2.


 * More answers: https://segmentfault.com/a/1190000004238792   Update: O(m) Search: O(n)
 */
public class RangeSumQuery2DMutable {
    // Search: O(log(m*n)) Update: O(logn)
    int[][] matrix;
    int[][] btree;


    public RangeSumQuery2DMutable(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        btree = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        for (int m = row + 1; m < btree.length; m += (m & (-m))) {
            for (int n = col + 1; n < btree[0].length; n += (n & (-n))) {
                btree[m][n] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2 + 1, col2 + 1) - getSum(row2 + 1, col1) - getSum(row1, col2 + 1) + getSum(row1, col1);
    }

    private int getSum(int row, int col) {
        int res = 0;
        for (int i = row; i >= 1; i -= (i &(-i))) {
            for (int j = col; j >= 1; j -= (j&(-j))) {
                res += btree[i][j];
            }
        }
        return res;
    }
}
