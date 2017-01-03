package array.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.sort(nums);
        int max = 0;
        int mIdx = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if (max < dp[i]) {
                        max = dp[i];
                        mIdx = i;
                    }
                }
            }
        }

        for (int i = 0; i < max; i++) {
            res.add(nums[mIdx]);
            mIdx = parent[mIdx];
        }
        return res;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        int[] nums = {1, 2, 3};
        List<Integer> res = l.largestDivisibleSubset(nums);
        for (Integer num : res) {
            System.out.println(num);
        }
    }
}
