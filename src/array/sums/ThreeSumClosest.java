package array.sums;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);                          // O(nlogn)
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    left = right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }
}
