package array.maths;

/**
 * https://leetcode.com/problems/rotate-function/
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        // Method: f(i) = f(i - 1) + sum - n * A[n - i];
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            f0 += A[i] * i;
        }

        int max = f0;
        int fi = f0;
        for (int i = 1; i < n; i++) {
            fi += sum;
            fi -= n * A[n - i]; // Remember to multiply by n
            max = Math.max(max, fi);
        }
        return max;
    }
}
