package array.maths;

/**
 * https://leetcode.com/problems/integer-replacement/
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {

        // // Method 1: Stack overflow
        // if (n == 1) {
        //     return 0;
        // }
        // if (n % 2 == 0) {
        //     return integerReplacement(n >> 1) + 1;
        // } else {
        //     return Math.min(integerReplacement((n + 1) >> 1), integerReplacement((n - 1) >> 1)) + 1;
        // }

        // // Method 1.1: long
        // return (int)longReplacement(n);

        // Method 2: Bit Manipulation
        // if n == 3 || n end with 01, delete 1 is better
        // else if n end with 11, add 1 is better
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else {
                if (n == 3 || ((n >>> 1) & 1) == 0) {
                    n--;
                } else {
                    n++;
                }
            }
            count++;
        }
        return count;
    }

    private long longReplacement(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return longReplacement(n >> 1) + 1;
        } else {
            return Math.min(longReplacement(n + 1), longReplacement(n - 1)) + 1;
        }
    }
}
