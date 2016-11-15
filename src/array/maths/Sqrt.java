package array.maths;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public double sqrt(double x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        double i = 0;
        double j = x;
        double mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            double pro = mid * mid;
            if (Math.abs(pro - x) < 0.001) {
                return mid;
            } else if (pro > x) {
                j = mid;
            } else {
                i = mid;
            }
        }
        return (i + j) / 2;
    }

//    public int sqrt(int x) {
//        if (x < 0)
//            return -1;
//        if (x == 0)
//            return 0;
//
//        long begin = 0;
//        long end = x;
//        long mid;
//        while (begin <= end) {
//            mid = begin + (end - begin) / 2;
//            if (mid * mid == x) {//Math.abs(x - mid * mid) < 0.0001
//                return (int) mid;
//            } else if (mid * mid > x) {
//                end = mid - 1;
//            } else {
//                begin = mid + 1;
//            }
//        }
//        return (int) (begin + end) / 2;
//    }

    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        System.out.println(s.sqrt(2));
    }
}
