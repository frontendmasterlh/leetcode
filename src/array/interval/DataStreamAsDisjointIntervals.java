package array.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 */
public class DataStreamAsDisjointIntervals {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private TreeSet<Interval> set;

    /** Initialize your data structure here. */
    // Time: O(nlogn)
    public DataStreamAsDisjointIntervals() {
        set = new TreeSet<>(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void addNum(int val) {
        Interval cur = new Interval(val, val);

        Interval floor = set.floor(cur);
        if (floor != null) {
            if (val <= floor.end) {
                return;
            } else if (val == floor.end + 1){
                cur.start = floor.start;
                set.remove(floor);
            }
        }

        Interval ceil = set.higher(cur);
        if (ceil != null) {
            if (ceil.start == val + 1) {
                cur.end = ceil.end;
                set.remove(ceil);
            }
        }
        set.add(cur);
    }

    public List<Interval> getIntervals() {
        return Arrays.asList(set.toArray(new Interval[0]));
    }
}
