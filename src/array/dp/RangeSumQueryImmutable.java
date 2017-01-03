package array.dp;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 *
 */
public class RangeSumQueryImmutable {
    int[] sums;
    int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        if (nums.length != 0) {
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = nums[i] + sums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i] + nums[i];
        }
    }
}
