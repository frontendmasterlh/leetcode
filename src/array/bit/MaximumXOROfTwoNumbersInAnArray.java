package array.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXOROfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int res = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         res = Math.max(res, nums[i] ^ nums[j]);
        //     }
        // }
        // return res;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(mask & num);
            }

            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(prefix ^ temp)) { // a ^ b = c   <==>  a = b ^ c
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
