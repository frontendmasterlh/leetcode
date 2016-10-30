package array.dp;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // // Method 1: DP O(n^2)
        // int[] dp = new int[nums.length];
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     dp[i] = 1;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) {
        //             dp[i] = dp[i] < dp[j] + 1 ? dp[j] + 1 : dp[i];
        //         }
        //     }
        //     max = Math.max(max, dp[i]);
        // }
        // return max;

        int[] minLast = new int[nums.length + 1];
        minLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = binarySearch(minLast, nums[i]);
            minLast[idx] = nums[i];
        }

        for (int i = nums.length; i >= 0; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }

    private int binarySearch(int[] minLast, int target) {
        int left = 0;
        int right = minLast.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (minLast[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (minLast[left] > target) {
            return left;
        } else {
            return right;
        }
    }
}
