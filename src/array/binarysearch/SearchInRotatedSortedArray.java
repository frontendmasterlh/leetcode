package array.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A==null || A.length==0)
            return -1;
        int left = 0;
        int right = A.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[left] < A[mid]) {
                if (A[left] <= target && target <= A[mid]) { // They might be equal.
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (A[left] == target) {
            return left;
        } else if (A[right] == target) {
            return right;
        }
        return -1;
    }
}
