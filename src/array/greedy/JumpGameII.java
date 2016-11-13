package array.greedy;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int high = 0;
        int low = 0;
        int preHigh = 0;
        int step = 0;
        while (high < nums.length - 1) {
            step++;
            preHigh = high;
            for (int i = low; i <= preHigh; i++) { // Every time we search for a range (low, preHigh)
                high = Math.max(high, nums[i] + i);
            }
            low = preHigh + 1;
        }
        return step;
    }
}
