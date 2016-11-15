package array.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * If the maximal interval is [x, y], and it belongs to machine id z,
 * when you add a new machine with id n, you should divide [x, y, z] into two intervals:

 [x, (x + y) / 2, z] and [(x + y) / 2 + 1, y, n]
 */
public class ConsistentHashing {
    public static class Range {
        int from;
        int to;
        int id;
        public Range(int id, int from, int to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }
    }

    public List<List<Integer>> consistentHashing(int n) {
        PriorityQueue<Range> pq = new PriorityQueue<>(new Comparator<Range>() {
            public int compare(Range o1, Range o2) {
                if (o1.to - o1.from > o2.to - o2.from) {
                    return -1;
                } else if (o1.to - o1.from < o2.to - o2.from) {
                    return 1;
                } else {
                    return o1.id - o2.id;
                }
            }
        });

        pq.offer(new Range(1, 0, 359));
        for (int i = 2; i <= n; i++) {
            Range range = pq.poll();
            int mid = range.from + (range.to - range.from) / 2;
            Range range1 = new Range(range.id, range.from, mid);
            Range range2 = new Range(i, mid + 1, range.to);
            pq.offer(range1);
            pq.offer(range2);
        }
        Range[] arr = pq.toArray(new Range[0]);
        List<List<Integer>> res = new ArrayList<>();
        for (Range range : arr) {
            List<Integer> list = new ArrayList<>();
            list.add(range.from);
            list.add(range.to);
            list.add(range.id);
            res.add(list);
        }
        return res;
    }
}
