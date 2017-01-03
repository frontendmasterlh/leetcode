package array.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        // // DFS: Time Limit
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // Arrays.sort(nums);
        // List<Integer> temp = new ArrayList<>();
        // int[] res = {0};
        // dfsHelper(nums, target, temp, res);
        // return res[0];

        // DP
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1; // start with dp[0] which denotes the target num is 0;
        Arrays.sort(nums); // DP 2 optimization
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // if (i >= num) {
                //     dp[i] += dp[i - num];
                // }
                if (num > i) { // DP 2 if num1 > i, then num2 must be greater than i since num2 > num1
                    break;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    private void dfsHelper(int[] nums, int target, List<Integer> temp, int[] res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            dfsHelper(nums, target - nums[i], temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
