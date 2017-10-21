package array.sums;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        int[] res = new int[]{0};
        dfsHelper(nums, target, res);
        return res[0];
    }

    private void dfsHelper(int[] nums, int target, int[] res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            dfsHelper(nums, target - nums[i], res);
        }
    }

    public static void main(String[] args) {
        CombinationSumIV c = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 32;
        System.out.println(c.combinationSum4(nums, target));
    }
}
