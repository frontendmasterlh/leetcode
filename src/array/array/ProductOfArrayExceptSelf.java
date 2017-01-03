package array.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // // Method 1: Time: O(N) Space: O(N)
        // int[] left = new int[nums.length];
        // int[] right = new int[nums.length];
        // left[0] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     left[i] = left[i - 1] * nums[i];
        // }
        // right[nums.length - 1] = nums[nums.length - 1];
        // for (int i = nums.length - 2; i >= 0; i--) {
        //     right[i] = right[i + 1] * nums[i];
        // }
        // int[] res = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     int temp = 0;
        //     if (i == 0 && i < nums.length - 1) {
        //         temp = right[i + 1];
        //     } else if (i == nums.length - 1 && i > 0) {
        //         temp = left[i - 1];
        //     } else {
        //         temp = left[i - 1] * right[i + 1];
        //     }
        //     res[i] = temp;
        // }
        // return res;

        // Method 2: Time: O(N) Space: O(1)
        int[] res = new int[nums.length];
        res[0] = 1;
        int left = 1, right = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
