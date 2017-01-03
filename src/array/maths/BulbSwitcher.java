package array.maths;

/**
 * https://leetcode.com/problems/bulb-switcher/
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        // Only 1, 4, 9, ...  is on
        // Method 1:
        // int res = 1;
        // while (res * res <= n) {
        //     res++;
        // }
        // return res - 1;

        // Method 2: Use Math.sqrt()
        return (int) Math.sqrt(n);
    }
}
