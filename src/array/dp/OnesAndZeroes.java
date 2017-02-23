package array.dp;

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

 For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

 Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

 Note:
 The given numbers of 0s and 1s will both not exceed 100
 The size of given string array won't exceed 600.
 Example 1:
 Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4

 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 Example 2:
 Input: Array = {"10", "0", "1"}, m = 1, n = 1
 Output: 2

 Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        // Method 1: Use PriorityQueue (Wrong!!! Greedy cannot solve this problem)
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
        //     public int compare(String o1, String o2) {
        //         return o1.length() - o2.length();
        //     }
        // });
        // for (String str : strs) {
        //     pq.offer(str);
        // }
        // int count = 0;
        // while (!pq.isEmpty() && (m > 0 || n > 0)) {
        //     String str = pq.poll();
        //     int num0 = 0;
        //     int num1 = 0;
        //     for (int i = 0; i < str.length(); i++) {
        //         if (str.charAt(i) == '0') {
        //             num0++;
        //         } else {
        //             num1++;
        //         }
        //     }
        //     if (num0 <= m && num1 <= n) {
        //         m -= num0;
        //         n -= num1;
        //         count++;
        //     }
        // }
        // return count;

        // DP: Time: O(kl + kmn)
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    }
}
