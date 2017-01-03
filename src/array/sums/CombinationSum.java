package array.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        int[] temp = new int[candidates.length];
        Arrays.sort(candidates);
        dfsHelper(candidates, target, 0, temp, res);
        return res;
    }

    private void dfsHelper(int[] candidates, int target, int length, int[] temp, List<List<Integer>> res) {
        if (length == candidates.length) {
            if (target == 0) {
                List<Integer> solution = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < temp[i]; j++) {
                        solution.add(candidates[i]);
                    }
                }
                res.add(solution);
            }
            return;
        }
        for (int i = 0; i <= target / candidates[length]; i++) {
            temp[length] = i;
            dfsHelper(candidates, target - candidates[length] * i, length + 1, temp, res);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> res = combinationSum.combinationSum(nums, 7);
        for (List<Integer> re : res) {
            for (Integer r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
