package array.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = findHappyNum(n);
        }
        return n == 1;
    }

    private int findHappyNum(int n) {
        int res = 0;
        while (n != 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(7));
    }
}
