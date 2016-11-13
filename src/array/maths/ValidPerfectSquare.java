package array.maths;

/**
 * Created by jli1 on 11/8/16.
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        // Method 1:
        // if (num == 1) {
        //     return true;
        // }
        // long x = num / 2;
        // long temp = x * x;
        // while (temp > num) {
        //     x /= 2;
        //     temp = x * x;
        // }
        // for (long i = x; i <= 2 * x; i++) {
        //     if (i * i == num) {
        //         return true;
        //     }
        // }
        // return false;

        // Method 2:
        // for (int i = 1; i <= num / i; i++) {
        //     if (i * i == num) {
        //         return true;
        //     }
        // }
        // return false;

        // Method 3: binary search
        // long left = 1;
        // long right = num;
        // while (left <= right) {
        //     long mid = left + (right - left) / 2;
        //     long x = mid * mid;
        //     if (x == num) {
        //         return true;
        //     } else if (x > num) {
        //         right = mid - 1;
        //     } else {
        //         left = mid + 1;
        //     }
        // }
        // return false;

        // Method 4: time: O(sqrt(N))
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare v = new ValidPerfectSquare();
        System.out.println(v.isPerfectSquare(9));
    }
}
