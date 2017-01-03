package array.array;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix== null || matrix.length==0 || matrix[0].length == 0)
            return ;
        int n = matrix.length;
        // // Method: Iterative
        // for (int k = 0; k < n /2; k++) {
        //     int first = k;
        //     int last = n -1 - k;
        //     for (int i = first; i < last; i++) {
        //         int offset = i - first;

        //         int temp = matrix[first][i];

        //         matrix[first][i] = matrix[last - offset][first];

        //         matrix[last - offset][first] = matrix[last][last - offset];

        //         matrix[last][last - offset] = matrix[i][last];

        //         matrix[i][last] = temp;
        //     }
        // }

        // Method: Recursion
        helper(matrix, n, 0);
    }

    private void helper(int[][] matrix, int n, int offset) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int temp = matrix[offset][offset + i];
            matrix[offset][offset + i] = matrix[offset + n - 1 - i][offset];
            matrix[offset + n - 1 - i][offset] = matrix[offset + n - 1][offset + n - 1 - i];
            matrix[offset + n - 1][offset + n - 1 - i] = matrix[offset + i][offset + n - 1];
            matrix[offset + i][offset + n - 1] = temp;
        }
        helper(matrix, n - 2, offset + 1);
    }
}
