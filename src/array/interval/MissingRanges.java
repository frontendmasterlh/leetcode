package array.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int pre = lower - 1;
        int cur = 0;
        for (int i = 0; i <= nums.length; i++) {
            cur = i == nums.length ? upper + 1 : nums[i];
            if (cur - pre > 1) {
                res.add(getRanges(pre + 1, cur - 1));
            }
            pre = cur;
        }
        return res;
    }

    private String getRanges(int from, int to) {
        return from == to ? String.valueOf(from) : from + "->" + to;
    }

    public static void main(String[] args) {
        MissingRanges m = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        List<String> res = m.findMissingRanges(nums, 0, 99);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
