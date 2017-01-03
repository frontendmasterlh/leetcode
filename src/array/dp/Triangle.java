package array.dp;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        //Construct a 1-D array
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return Integer.MAX_VALUE;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = dp[0];
        for (int num : dp) {
            res = Math.min(res, num);
        }
        return res;
    }

}
