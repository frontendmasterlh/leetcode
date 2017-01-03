package array.hashtable;

/**
 * https://leetcode.com/problems/count-primes/
 */
public class CountPrimes {
    public int countPrimes(int n) {
        // Time: O(n) Space: O(n)
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(15));
    }
}
