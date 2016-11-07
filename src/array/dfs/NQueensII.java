package array.dfs;

/**
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] row = new int[n];
        int[] res = {0};
        dfsHelper(0, n, row, res);
        return res[0];
    }

    private void dfsHelper(int idx, int n, int[] row, int[] res) {
        if (idx == n) {
            res[0]++;
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

    private boolean isValid(int[] row, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (row[i] == y || Math.abs(row[i] - y) == Math.abs(i - x)) {
                return false;
            }
        }
        return true;
    }
}
