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
        int n = nums.length;
        int[] p = new int[n]; // p denotes from 0 to i the biggest number of wiggle sequence and the diff is positive
        int[] q = new int[n];
        Arrays.fill(p, 1);
        Arrays.fill(q, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    p[i] = Math.max(p[i], q[j] + 1);
                } else if (nums[j] > nums[i]) {
                    q[i] = Math.max(q[i], p[j] + 1);
                }
            }
        }
        return Math.max(p[n - 1], q[n - 1]);
    }

    public static void main(String[] args) {
        WiggleSubsequence w = new WiggleSubsequence();
        int[] nums = {1,7,4,9,2,5};
        System.out.println(w.wiggleMaxLength(nums));
    }
}
