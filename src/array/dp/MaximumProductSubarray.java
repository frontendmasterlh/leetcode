package array.dp;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = max * nums[i];
            int b = min * nums[i];
            int c = nums[i];

            max = Math.max(c, Math.max(a, b)); // Find the max every time
            min = Math.min(c, Math.min(a, b)); // Find the min every time
            res = Math.max(res, max);          // Update result every time
        }
        return res;
    }
}
