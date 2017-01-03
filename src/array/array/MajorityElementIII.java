package array.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Keep k-1 pointers and counters. Use HashMap to store numbers and counters, every delete operation will cost k-1,
 * however, the max times of deletion is n/(k-1) because deletion only happens when there are (k-1) numbers in the map. So the overall complexity is still O(n).
 */
public class MajorityElementIII {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() == 0 || k > nums.size()) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.size() < k && !map.containsKey(num)) {
                map.put(num, 1);
            } else if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                Map<Integer, Integer> temp = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        temp.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                map = temp;
            }
        }
        int count = 0;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
