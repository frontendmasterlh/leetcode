package array.queueandstack;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 > o2 ? -1 : 1;
        }
    });
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? -1 : 1;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() > num) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
        } else if (minHeap.size() == 0 || minHeap.peek() < num) {
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
        } else {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
