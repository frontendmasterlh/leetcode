package array.queueandstack;

/**
 * https://leetcode.com/problems/super-ugly-number/
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        // // Time limit
        // if (n <= 0 || primes == null || primes.length == 0) {
        //     return 0;
        // }
        // PriorityQueue<Long> q = new PriorityQueue<>();
        // Set<Long> set = new HashSet<>();
        // q.offer(1L);
        // Long num = 1L;
        // int count = 1;
        // for (int i = 1; i <= n; i++) {
        //     num = q.poll();
        //     for (int prime : primes) {
        //         if (set.add(num * prime)) {
        //             q.offer(num * prime);
        //         }
        //     }
        // }
        // return num.intValue();

        int[] times = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ugly[times[j]]);
            }
            ugly[i] = min;
            for(int j = 0; j < primes.length; j++) {
                if (ugly[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
