package array.sums;

/*https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/*/
public class TwoSumII {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = {1, 2, 4, 6, 8, 15};
        int[] res = twoSumII.twoSum(nums, 12);
        for (int r : res) {
            System.out.println(r);
        }
    }
}
