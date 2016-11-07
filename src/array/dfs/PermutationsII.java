package array.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[num.length];
        dfsHelper(num, 0, visited, temp, res);
        return res;
    }

    private void dfsHelper(int[] num, int idx, boolean[] visited, List<Integer> temp, List<List<Integer>> res) {
        if (idx == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1] && visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                temp.add(num[i]);
                dfsHelper(num, idx + 1, visited, temp, res);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
