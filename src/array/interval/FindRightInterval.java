package array.interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-right-interval/
 */
public class FindRightInterval {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Binary Search Tree O(NlogN)
    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            res[i] = (entry != null) ? entry.getValue() : -1;
        }
        return res;
    }
}
