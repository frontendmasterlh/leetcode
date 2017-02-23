package array.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur + 1 == nums[i]) {
                cur++;
            } else {
                if (cur == start) {
                    res.add(Integer.toString(cur));
                } else {
                    res.add(start + "->" + cur);
                }
                start = nums[i];
                cur = nums[i];
            }
        }
        if (cur == start) {
            res.add(Integer.toString(cur));
        } else {
            res.add(start + "->" + cur);
        }
        return res;
    }
}
