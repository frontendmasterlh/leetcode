package array.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // // Method: Iterative
        // int k = 0, i = 0, j = 0;
        // while (2 * k < m && 2 * k < n) {
        //     for (j = k; j < n - k; j++) {
        //         res.add(matrix[k][j]);
        //     }
        //     for (i = k + 1; i < m - k; i++) {
        //         res.add(matrix[i][n - k - 1]);
        //     }
        //     if (m - 2 * k == 1 || n - 2 * k == 1) {
        //         break;
        //     }
        //     for (j = n - 1 - k - 1; j >= k; j--) {
        //         res.add(matrix[m - k - 1][j]);
        //     }
        //     for (i = m - 1 - k - 1; i >= k + 1; i--) {
        //         res.add(matrix[i][k]);
        //     }
        //     k++;
        // }

        // Method: Recursive
        helper(matrix, m, n, 0, res);
        return res;
    }

    private void helper(int[][] matrix, int m, int n, int offset, List<Integer> res) {
        if (m <= 1 || n <= 1) {
            if (m == 1 && n == 1) {
                res.add(matrix[offset][offset]);
            } else if (m == 1) {
                for (int i = 0; i < n; i++) {
                    res.add(matrix[offset][offset + i]);
                }
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    res.add(matrix[offset + i][offset]);
                }
            }
            return;
        }
        // top row
        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        // right column
        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[offset + i][offset + n - 1]);
        }
        // bottom row
        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[offset + m - 1][offset + n - 1 - i]);
        }
        // left column
        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[offset + m - 1 - i][offset]);
        }
        helper(matrix, m - 2, n - 2, offset + 1, res);
    }
}
