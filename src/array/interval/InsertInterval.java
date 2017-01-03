package array.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jli1 on 11/6/16.
 */
public class InsertInterval {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        int insertPos = 0;

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i));
                insertPos++;
            } else if (intervals.get(i).start > newInterval.end) {
                res.add(intervals.get(i));
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        res.add(insertPos, newInterval);
        return res;
    }
}
