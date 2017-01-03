package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfsHelper(0, k, 1, n, temp, res);
        return res;
    }

    private void dfsHelper(int idx, int k, int num, int n, List<Integer> temp, List<List<Integer>> res) {
        if (n < 0) {
            return;
        }
        if (idx == k) {
            if (n == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = num; i < 10; i++) {
            if (temp.size() > 0 && temp.get(temp.size() - 1) == i) {
                continue;
            }
            temp.add(i);
            dfsHelper(idx + 1, k, i + 1, n - i, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII c = new CombinationSumIII();
        List<List<Integer>> res = c.combinationSum3(2, 6);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
