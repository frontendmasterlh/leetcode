package array.queueandstack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jli1 on 11/17/16.
 */
public class MergeKSortedIterators {
    public static class MyIterator implements Comparable<MyIterator> {
        int val;
        Iterator<Integer> iterator;

        public MyIterator(int val, Iterator<Integer> iterator) {
            this.val = val;
            this.iterator = iterator;
        }

        public boolean hasNext() {
            if (this.iterator.hasNext()) {
                this.val = this.iterator.next();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(MyIterator o) {
            return this.val - o.val;
        }
    }

    public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<MyIterator> pq = new PriorityQueue<>();

        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                pq.offer(new MyIterator(iterator.next(), iterator));
            }
        }

        while (!pq.isEmpty()) {
            MyIterator iterator = pq.poll();
            res.add(iterator.val);
            if (iterator.hasNext()) {
                pq.offer(iterator);
            }
        }
        return res;
    }
}
