package array.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jli1 on 11/6/16.
 */
public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start; // Note: It will cause the wrong answer: (MIN_VALUE - MAX_VALUE) = 1!!!
                 if (o1.start < o2.start) {
                     return -1;
                 } else if (o1.start > o2.start) {
                     return 1;
                 } else {
                     return 0;
                 }
            }
        });

        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(cur.end, pre.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
        intervals.add(new Interval(Integer.MIN_VALUE, 1));
        List<Interval> res = m.merge(intervals);
        for (Interval interval : res) {
            System.out.println(interval.start);
        }
    }

}
