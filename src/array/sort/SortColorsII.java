package array.sort;

/**
 * Created by jli1 on 11/5/16.
 */
public class SortColorsII {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || k <= 1) {
            return;
        }
        int start = 0;
        int end = colors.length - 1;
        int count = 0;
        while (count < k) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) { // Note: find the max & min in the range
                max = Math.max(max, colors[i]);
                min = Math.min(min, colors[i]);
            }

            int left = start;
            int right = end;
            int cur = left;
            while (cur <= right) {
                if (colors[cur] == min) {
                    swap(colors, cur++, left++);
                } else if (colors[cur] > min && colors[cur] < max) {
                    cur++;
                } else if (colors[cur] == max) {
                    swap(colors, cur, right--);
                }
            }

            count += 2;
            start = left;
            end = right;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
