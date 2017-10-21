package array.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        if (k == 0) {
            return false;
        }
        if (k < 0) {
            k = -k;
        }
        // // Method 1: Time: O(n^2) Space: O(1)
        // for (int i = 0; i < nums.length - 1; i++) {
        //     int curSum = nums[i];
        //     for (int j = i + 1; j < nums.length; j++) {
        //         curSum += nums[j];
        //         if (curSum % k == 0) {
        //             return true;
        //         }
        //     }
        // }
        // return false;

        // Method 2: HashMap Time: O(n) Space: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Put a dummy record to denote the start point
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (k != 0) {
                curSum %= k;
            }
            Integer pre = map.get(curSum);
            if (pre != null) {
                if (i - pre > 1) {
                    return true;
                }
            } else {
                map.put(curSum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum c =new ContinuousSubarraySum();
        int[] nums = {23, 2, 6, 4, 7};
        System.out.println(c.checkSubarraySum(nums, 6));
    }
}
