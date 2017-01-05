package array.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        // Method 1: DP
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     dp[i] = i;
        //     for (int j = 1; j * j <= i; j++) {
        //         dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        //     }
        // }
        // return dp[n];

        // Method 2: bfs
        List<Integer> perfect = new ArrayList<>();
        int[] cur = new int[n];
        for (int i = 1; i * i <= n; i++) {
            perfect.add(i * i);
            cur[i * i - 1] = 1;
        }
        if (perfect.get(perfect.size() - 1) == n) {
            return 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer p : perfect) {
            queue.offer(p);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer temp = queue.poll();
                for (Integer p : perfect) {
                    if (temp + p == n) {
                        return count;
                    } else if ((temp + p < n) && (cur[temp + p - 1] == 0)) {
                        cur[temp + p - 1] = count;
                        queue.offer(temp + p);
                    } else if (temp + p > n) {
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
