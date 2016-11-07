package array.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        dfsHelper(candidates, target, 0, temp, res);
        return res;
    }

    private void dfsHelper(int[] candidates, int target, int length, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || length >= candidates.length) {
            return;
        }
        for (int i = length; i < candidates.length; i++) {
            if (i > length && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfsHelper(candidates, target - candidates[i], i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }


//    public List<List<Integer>> combinationSum2WithDP(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (candidates == null || candidates.length == 0 || target == 0) {
//            return res;
//        }
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 0; i < candidates.length; i++) {
//            for (int s = 0; s <= target; s++) {
//                if (s >= candidates[i]) {
//                    dp[s] += dp[s - candidates[i]];
//                }
//            }
//        }
//        return dp[target];
//    }

    public static void main(String[] args) {
        if (Integer.MAX_VALUE + 1 == -(Integer.MIN_VALUE)) {
            System.out.println("Haha");
        } else if (Integer.MAX_VALUE + 1 > -(Integer.MIN_VALUE)) {
            System.out.println("hehe");
        }

        int i = Math.max(Integer.MAX_VALUE + 1, 9);
        System.out.println(i);

//        CombinationSumII combinationSumII = new CombinationSumII();
//        int[] nums = {10, 1, 2, 7, 6, 1, 5};
//        List<List<Integer>> res = combinationSumII.combinationSum2(nums, 8);
//        for (List<Integer> re : res) {
//            for (Integer r : re) {
//                System.out.print(r + " ");
//            }
//            System.out.println();
//        }
    }
}
