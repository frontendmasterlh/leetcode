package array.sort;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it in-place such that

 nums[0] <= nums[1] >= nums[2] <= nums[3]....
 */
public class WiggleSort {

    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
