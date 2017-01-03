package array.binarysearch;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (matrix[left / n][left % n] == target) {
            return true;
        } else if (matrix[right / n][right % n] == target) {
            return true;
        } else {
            return false;
        }
    }
}
