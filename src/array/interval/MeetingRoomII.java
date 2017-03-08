package array.interval;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.

 For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRoomII {
    public static class Interval {
        int start;
        int end;
        public Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
//        // Greedy: Time: O(nlogn)
//        if (intervals == null || intervals.length == 0) {
//            return 0;
//        }
//        Arrays.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start < o2.start ? -1 : 1;
//            }
//        });
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.offer(intervals[0].end);
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i].start >= pq.peek()) {
//                pq.poll();
//            }
//            pq.offer(intervals[i].end);
//        }
//        return pq.size();


        // Method 2: Use HashMap to store the clock O(n + nlogn)
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start,0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        int room = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            room += entry.getValue();
            res = Math.max(res, room);
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoomII m = new MeetingRoomII();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(m.minMeetingRooms(intervals));
    }
}
