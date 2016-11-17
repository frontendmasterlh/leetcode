package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
   = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfsHelper(n, 2, temp, res);
        return res;
    }

    private void dfsHelper(int n, int factor, List<Integer> temp, List<List<Integer>> res) {
        if (n == 1) {
            if (temp.size() > 1) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = factor; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                temp.add(i);
                dfsHelper(n / i, i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
        temp.add(n);
        dfsHelper(1, n, temp, res);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        FactorCombinations f = new FactorCombinations();
        List<List<Integer>> nums = f.getFactors(8);
        for (List<Integer> list : nums) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
