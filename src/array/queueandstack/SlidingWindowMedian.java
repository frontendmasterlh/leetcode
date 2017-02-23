package array.queueandstack;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 */
public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            if (o1 == o2) {
                return 0;
            } else if (o1 < o2){
                return 1;
            } else {
                return -1;
            }
        }
    });

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) {
            return new double[0];
        }
        double[] res = new double[n];
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                res[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return res;
    }

    private double getMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0;
        }
        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }

    private void remove(int num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        int[] nums = {2147483647,1,2,3,4,5,6,7,2147483647};
//        int[] nums = {Integer.MAX_VALUE, Integer.MAX_VALUE};//{1,3,-1,-3,5,3,6,7};
        int k = 2;
        double[] res = s.medianSlidingWindow(nums, k);
        for (double d : res) {
            System.out.println(d);
        }
    }
}
