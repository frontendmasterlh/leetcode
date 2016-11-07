package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[num.length];
        List<Integer> temp = new ArrayList<>();
        dfsHelper(num, 0, visited, temp, res);
        return res;
    }

    private void dfsHelper(int[] num, int idx, boolean[] visited, List<Integer> temp, List<List<Integer>> res) {
        if (idx == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
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
