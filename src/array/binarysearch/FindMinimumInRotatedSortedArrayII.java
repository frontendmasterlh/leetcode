package array.binarysearch;

/**
 * Created by jli1 on 11/17/16.
 */
public class FindMinimumInRotatedSortedArrayII {

    int min;

    private int findM (int[] num, int left, int right) {
        if (left == right)
            return num[left];
        int mid = (left + right) / 2;
        int i = mid, j = mid;
        while (i>=left && num[i] == num[mid])
            i--;
        while (j<=right && num[j] == num[mid])
            j++;
        if (i < left) {
            if (right < j)
                return num[mid];
            else
                return Math.min(num[mid], findM(num, j, right));
        }else {
            if (right < j)
                return Math.min(num[mid], findM(num, left, i));
            else if (num[left] <= num[i])
                return Math.min(num[left], Math.min(num[mid], findM(num, j, right)));
            else
                return Math.min(num[mid], Math.min(num[j], findM(num, left, i)));
        }
    }

    public int findMin(int[] num) {
        min = Integer.MIN_VALUE;
        if (num==null || num.length==0)
            return min;
        // Method 1:
        // return findM (num, 0, num.length -1);

        // Method 2:
        int left = 0;
        int right = num.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (num[mid] == num[right]) {
                right--;
            } else if (num[mid] < num[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (num[left] <= num[right]) {
            return num[left];
        }
        return num[right];

//        // Method 3: for loop
//        int res = Integer.MAX_VALUE;
//        for (int n : num) {
//            res = Math.min(n, res);
//        }
//        return res;
    }
}
