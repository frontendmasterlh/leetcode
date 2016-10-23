package array.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Design a Phone Directory which supports the following operations:
 *
 get: Provide a number which is not assigned to anyone.
 check: Check if a number is available or not.
 release: Recycle or release a number.


 Example:
 // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 PhoneDirectory directory = new PhoneDirectory(3);

 // It can return any available phone number. Here we assume it returns 0.
 directory.get();

 // Assume it returns 1.
 directory.get();

 // The number 2 is available, so return true.
 directory.check(2);

 // It returns 2, the only number that is left.
 directory.get();

 // The number 2 is no longer available, so return false.
 directory.check(2);

 // Release number 2 back to the pool.
 directory.release(2);

 // Number 2 is available again, return true.
 directory.check(2);
 */
public class DesignPhoneDirectory {

    Set<Integer> set;
    Queue<Integer> queue;
    int max;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.max = maxNumbers - 1;
        set = new HashSet<>();
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer num = queue.poll();
        set.add(num);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number >= 0 && number <= max && !set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            queue.offer(number);
            set.remove(number);
        }
    }
}
