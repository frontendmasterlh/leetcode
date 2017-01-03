package array.binarysearch;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else if (nums[right] < target) {
            return right + 1;
        } else {
            return right;
        }
    }
}
