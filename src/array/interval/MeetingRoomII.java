package array.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.

 For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRoomII {
    public class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        // Greedy: Time: O(nlogn)
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start < o2.start ? -1 : 1;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return pq.size();
    }

}
