package array.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jli1 on 11/24/16.
 */
public class MaximumMedian {

    public int findMedian(List<List<Integer>> A) {
        if (A == null || A.size() == 0 || A.get(0).size() == 0) {
            return -1;
        }

        int m = A.size(), n = A.get(0).size();
        int cnt = 0, mid, size = m * n;
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            cnt = 0;
            mid = left + (right - left)/2;
            if (mid == 4) {
                System.out.println();
            }
            for (List<Integer> row: A) {
                //find last position that smaller than mid
                int smaller = upperBound(row, mid);
                cnt += smaller + 1;
            }
            if (cnt >= (size)/2 + 1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private int upperBound(List<Integer> row, int target) {
        int left = 0, right = row.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (row.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (row.get(right) < target) {
            return right;
        } else if (row.get(left) < target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        init(matrix, 1);
        init(matrix, 3);
        init(matrix, 5);
//        init(matrix, 2, 6, 9);
//        init(matrix, 3, 6, 9);
        MaximumMedian m = new MaximumMedian();
        System.out.println(m.findMedian(matrix));
    }

    private static void init(List<List<Integer>> matrix, Integer... arg) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : arg) {
            list.add(num);
        }
        matrix.add(list);
    }
}
