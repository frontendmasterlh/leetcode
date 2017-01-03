package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        int[] row = new int[n];
        dfsHelper(0, n, row, res);
        return res;
    }

    private void dfsHelper(int idx, int n, int[] row, List<List<String>> res) {
        if (idx == n) {
            List<String> temp = translate(row);
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, idx, i)) {
                row[idx] = i;
                dfsHelper(idx + 1, n, row, res);
                row[idx] = 0;
            }
        }
    }

    private List<String> translate(int[] row) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (j == row[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean isValid(int[] row, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (row[i] == y || Math.abs(row[i] - y) == Math.abs(i - x)) {
                return false;
            }
        }
        return true;
    }
}
