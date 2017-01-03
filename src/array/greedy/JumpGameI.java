package array.greedy;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGameI {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        int i = 0;
        for (; i <= max && i < nums.length; i++) {
            max = Math.max(max, nums[i] + i);
        }
        return i == nums.length;
    }
}
