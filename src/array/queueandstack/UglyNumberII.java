package array.queueandstack;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        int count = 1;
        int res = 1;
        while (!q.isEmpty()) {
            Integer num = q.poll();
            if (count++ == n) {
                res = num;
                break;
            }
            q.offer(num * 2);
            q.offer(num * 3);
            q.offer(num * 5);
        }
        return res;
    }

    public static void main(String[] args) {
        UglyNumberII u = new UglyNumberII();
        System.out.println(u.nthUglyNumber(3));
    }
}
