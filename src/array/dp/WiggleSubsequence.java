package array.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Method 1: DP Time: O(n^2) Space: O(n)
        // int n = nums.length;
        // int[] p = new int[n]; // p denotes from 0 to i the biggest number of wiggle sequence and the diff is positive
        // int[] q = new int[n];
        // Arrays.fill(p, 1);
        // Arrays.fill(q, 1);
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) {
        //             p[i] = Math.max(p[i], q[j] + 1);
        //         } else if (nums[j] > nums[i]) {
        //             q[i] = Math.max(q[i], p[j] + 1);
        //         }
        //     }
        // }
        // return Math.max(p[n - 1], q[n - 1]);

        // Method 2: DP Time: O(N) Space: O(N)
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);

        // Method 3: Greedy Time: O(n) Space: O(n)
        // int k = 1;
        // while (k < nums.length && nums[k] == nums[k - 1]) {
        //     k++;
        // }
        // if (k == nums.length) {
        //     return 1;
        // }

        // int increase = 1;
        // int decrease = 1;
        // for (int i = k; i < nums.length; i++) {
        //     if (nums[i] > nums[i - 1]) {
        //         increase = decrease + 1;
        //     } else if (nums[i] < nums[i - 1]){
        //         decrease = increase + 1;
        //     }
        // }
        // return Math.min(nums.length, Math.max(increase, decrease));
    }

    public static void main(String[] args) {
        WiggleSubsequence w = new WiggleSubsequence();
        int[] nums = {1,7,4,9,2,5};
        System.out.println(w.wiggleMaxLength(nums));
    }
}
