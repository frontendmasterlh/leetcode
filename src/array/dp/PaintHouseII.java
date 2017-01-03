package array.dp;

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs0 is the cost of painting house 0 with color 0; costs1 is the cost of painting house 1 with color 2, and so on...
 Find the minimum cost to paint all houses.

 Note: All costs are positive integers.

 Follow up: Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int preMin = 0, preSec = 0, preIdx = -1;
        for (int i = 0; i < m; i++) {
            int curMin = Integer.MAX_VALUE, curSec = Integer.MAX_VALUE, curIdx = -1;
            for (int j = 0; j < n; j++) {
                costs[i][j] = costs[i][j] + (preIdx == j ? preSec : preMin);
                if (costs[i][j] < curMin) {
                    curSec = curMin;
                    curMin = costs[i][j];
                    curIdx = j;
                } else if (costs[i][j] > curMin && costs[i][j] < curSec) {
                    curSec = costs[i][j];
                }
            }
            preIdx = curIdx;
            preMin = curMin;
            preSec = curSec;
        }
        return preMin;
    }
}
