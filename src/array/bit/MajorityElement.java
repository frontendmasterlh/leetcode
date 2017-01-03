package array.bit;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        // // Method 1: Time: O(n) Space: O(1)
        // if (nums == null || nums.length == 0) {
        //     return -1;
        // }
        // int res = nums[0];
        // int count = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (res == nums[i]) {
        //         count++;
        //     } else if (count == 0) {
        //         res = nums[i];
        //         count = 1;
        //     } else {
        //         count--;
        //     }
        // }
        // return res;

        // Method 2: Time: O(n * 32) Space: O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
