package array.sort;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // Time: O(n) Space: O(1)
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j <= k) {                // Sequence matters.
            if (nums[j] == 0) {         // Consider 0 first
                swap(nums, i++, j++);
            } else if (nums[j] == 1) {
                j++;
            } else {
                swap(nums, j, k--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
