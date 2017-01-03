package array.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfsHelper(nums, 0, temp, res);
        return res;
    }

    private void dfsHelper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfsHelper(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII s = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = s.subsetsWithDup(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
