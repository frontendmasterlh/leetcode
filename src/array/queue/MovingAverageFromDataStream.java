package array.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {

    Queue<Integer> queue;
    double sum;
    int size;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}
