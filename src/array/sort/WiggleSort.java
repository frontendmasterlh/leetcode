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
        // Method 1: Sort first. Then swap. Time: O(NLogN)
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length - 1; i += 2) {
//            swap(nums, i, i + 1);
//        }

        // Method 2: For odd index i, nums[i] >= nums[i - 1]
        //           For even index i, nums[i] <= nums[i - 1];
        //   Time: O(n)
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i -  1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i -1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        int[] nums = {1, 8, 3, 5, 6, 7, 2};
        wiggleSort.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
