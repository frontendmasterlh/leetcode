package array.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new ArrayList<>(res);
        }
        dfsHelper(nums, 0, new ArrayList<>(), res); // Time: O(2^n), n denotes the length of nums
        return new ArrayList<>(res);
    }

    private void dfsHelper(int[] nums, int index, List<Integer> temp, Set<List<Integer>> res) {
        if (index == nums.length) {
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (temp.isEmpty() || temp.get(temp.size() - 1) <= nums[index]) { // Take care that it may contain duplicates
            temp.add(nums[index]);
            dfsHelper(nums, index + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
        dfsHelper(nums, index + 1, temp, res);
    }
}
