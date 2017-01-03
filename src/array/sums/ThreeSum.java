package array.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://leetcode.com/problems/3sum/*/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);                          // O(nlogn)
        for (int i = 0; i < nums.length - 2; i++) { //O(n^2)
            if (i > 0 && nums[i] == nums[i - 1]) {  //Skip cases that the first elements are the same.
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[i]);
                    solution.add(nums[left]);
                    solution.add(nums[right]);
                    res.add(solution);

                    while (++left < right && nums[left] == nums[left - 1]); //Skip cases that elements are the same.
                    while (--right > left && nums[right] == nums[right + 1]);
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum.threeSum(nums);
        for (List<Integer> re : res) {
            for (Integer r : re) {
                System.out.println(r);
            }
            System.out.println();
        }
    }
}
