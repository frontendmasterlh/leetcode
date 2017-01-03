package array.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        while(++left < right && nums[left] == nums[left - 1]);
                        while(--right > left && nums[right] == nums[right + 1]);
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum.fourSum(nums, 0);
        for (List<Integer> re : res) {
            for (Integer aRe : re) {
                System.out.print(aRe + " ");
            }
            System.out.println();
        }
    }
}
