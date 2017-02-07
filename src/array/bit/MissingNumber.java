package array.bit;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        // Method 1: use sum algorithm
        // int sum = 0;
        // for (int num : nums) {
        //     sum += num;
        // }
        // int n = nums.length;
        // return n * (n + 1) / 2 - sum;

        // Method 2: Swap Time: O(n)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     while (nums[i] != i && nums[i] < n && nums[nums[i]] <= nums.length) {
        //         int temp = nums[nums[i]];
        //         nums[nums[i]] = nums[i];
        //         nums[i] = temp;
        //     }
        // }
        // int res = n;
        // for (int i = 0; i < n; i++) {
        //     if (i != nums[i]) {
        //         res = i;
        //         break;
        //     }
        // }
        // return res;

        // Method 3: Use extra space
        int n = nums.length;
        boolean[] array = new boolean[n + 1];
        for (int num : nums) {
            array[num] = true;
        }
        int res = n;
        for (int i = 0; i <= n; i++) {
            if (!array[i]) {
                res = i;
                break;
            }
        }
        return res;
    }
}
