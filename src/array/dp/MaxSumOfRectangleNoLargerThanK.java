package array.dp;

import java.util.TreeSet;

/**
 * Given a non-empty 2D matrix matrix and an integer k,
 * find the max sum of a rectangle in the matrix such that its sum is no larger than k.

 Example:
 Given matrix = [
 [1,  0, 1],
 [0, -2, 3]
 ]
 k = 2
 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

 Note:
 The rectangle inside the matrix must have an area > 0.
 What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // Method 1: Brute force. Time: O(n^6) Space: O(1)

        // Method 2: Use extra space. Time: O(n^4) Space: O(n^2)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] areas = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area = matrix[i][j];
                if (i > 0) {
                    area += areas[i - 1][j];
                }
                if (j > 0) {
                    area += areas[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    area -= areas[i - 1][j - 1];
                }
                areas[i][j] = area;
            }
        }
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         for (int p = i; p < m; p++) {
        //             for (int q = j; q < n; q++) {
        //                 int area = areas[p][q];
        //                 if (i > 0) {
        //                     area -= areas[i - 1][q];
        //                 }
        //                 if (j > 0) {
        //                     area -= areas[p][j - 1];
        //                 }
        //                 if (i > 0 && j > 0) {
        //                     area += areas[i - 1][j - 1];
        //                 }
        //                 if (area <= k) {
        //                     max = Math.max(max, area);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return max;

        // Method 3: Use binary search to find i. Time: O(n^3 * logn) Space: O(n^2)
        // To find j - i < k, we need to find i > j - k.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int p = 0; p < n; p++) {
                    int area = areas[j][p];
                    if (i > 0) {
                        area -= areas[i - 1][p];
                    }
                    Integer ceiling = set.ceiling(area - k);
                    if (ceiling != null) {
                        max = Math.max(max, area - ceiling);
                    }
                    set.add(area);
                }
            }
        }
        return max;
    }
}
