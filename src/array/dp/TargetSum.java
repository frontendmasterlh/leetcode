package array.dp;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Method 1: Recursion
        // int[] res = new int[]{0};
        // dfsHelper(nums, 0, 0, S, res);
        // return res[0];

        // Method 2: DP
        // dp[i] denotes that for target i, how many ways to assign.
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[] dp = new int[2 * sum + 1];
        dp[0 + sum] = 1;
        for (int num : nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < 2 * sum + 1; i++) {
                if (dp[i] != 0) {
                    next[i + num] += dp[i];
                    next[i - num] += dp[i];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }

    private void dfsHelper(int[] nums, int index, int temp, int S, int[] res) {
        if (index == nums.length) {
            if (temp == S) {
                res[0]++;
            }
            return;
        }
        dfsHelper(nums, index + 1, temp + nums[index], S, res);
        dfsHelper(nums, index + 1, temp - nums[index], S, res);
    }
}
