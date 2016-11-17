package array.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsHelper(grid, i, j);
                    // bfsHelper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfsHelper(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (j > 0 && grid[i][j - 1] == '1') {
            dfsHelper(grid, i, j - 1);
        }
        if (i > 0 && grid[i - 1][j] == '1') {
            dfsHelper(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            dfsHelper(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            dfsHelper(grid, i, j + 1);
        }
    }

    private void bfsHelper(char[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        queue.offer(i * n + j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / n;
            int y = pos % n;
            grid[x][y] = '0';
            if (x > 0 && grid[x - 1][y] == '1') {
                queue.offer((x - 1) * n + y);
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                queue.offer(x * n + y - 1);
            }
            if (x < m - 1 && grid[x + 1][y] == '1') {
                queue.offer((x + 1) * n + y);
            }
            if (y < n - 1 && grid[x][y + 1] == '1') {
                queue.offer(x * n + y + 1);
            }
        }
    }
}
