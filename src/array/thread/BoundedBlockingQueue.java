package array.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement boundedBlockingQueue
 */
public class BoundedBlockingQueue<T> {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private final T[] items;
    private int head;
    private int tail;
    private int count;

    @SuppressWarnings("unchecked")
    public BoundedBlockingQueue(int capacity) {
        items = (T[]) new Object[capacity];
        count = 0;
        head = 0;
        tail = 0;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        try {
            lock.lock();
            while (count == items.length) {
                notFull.await();
            }
            items[tail++] = item;
            if (tail == items.length) {
                tail = 0;
            }
            count++;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized T dequeue() throws InterruptedException {
        try {
            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }
            T item = items[head++];
            if (head == items.length) {
                head = 0;
            }
            count--;
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
