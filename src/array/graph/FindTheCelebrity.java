package array.graph;

import java.util.Random;

/**
 * Created by jli1 on 11/15/16.
 */
public class FindTheCelebrity {

    private boolean knows(int a, int b) {
        return new Random().nextBoolean();
    }

    public int findCelebrity(int n) {
//        // Method 1:
//        for (int i = 0, j = 0; i < n; i++) {
//            for (j = 0; j < n; j++) {
//                if (knows(i, j) || !knows(j, i)) {
//                    break;
//                }
//            }
//            if (j == n) {
//                return i;
//            }
//        }
//        return -1;

//        // Method 2:
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            if (knows(res, i)) {
//                res = i;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (knows(res, i) || !knows(i, res)) {
//                return -1;
//            }
//        }
//        return res;

        // Method 3:
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == left || (knows(i, left) && !knows(left, i))) {
                continue;
            } else {
                return -1;
            }
        }
        return left;
    }
}
