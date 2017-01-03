package array.array;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    // Time: O(n)
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == val) {
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        return nums[left] == val ? left : left + 1;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
