package array.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                } else {
                    return o2.start - o1.start;
                }
            }
        });
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                end = intervals[i].end;
            } else {
                count++;
            }
        }
        return count;
    }
}
