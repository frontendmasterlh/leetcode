package array.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF
 as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class WallsAndGates {
    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfsHelper(rooms, i, j);
                }
            }
        }
    }

    private void bfsHelper(int[][] rooms, int i , int j) {
        Queue<Integer> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        q.offer(i * n + j);
        int dist = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(i * n + j);
        while (!q.isEmpty()) {
            Integer pos = q.poll();
            int x = pos / n;
            int y = pos % n;
            rooms[x][y] = Math.min(rooms[x][y], dist);

            for (int k = 0; k < 4; k++) {
                int newX = x + direction[k][0];
                int newY = y + direction[k][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited.contains(newX * n + newY)) {
                    q.offer(newX * n + newY);
                    visited.add(newX * n + newY);
                }
            }
            dist++;
        }
    }
}
