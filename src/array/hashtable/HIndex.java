package array.hashtable;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/
 */
public class HIndex {
    // Sort  Time: O(nlogn) Space: O(1)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int h = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int curH = Math.min(citations[i], citations.length - i);
            h = Math.max(h, curH);
        }
        return h;
    }


    public int hIndexWithMapping(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] stats = new int[n + 1];// 统计各个引用次数对应多少篇文章
        for (int i = 0; i < n; i++) {
            stats[citations[i] >= n ? n : citations[i]] += 1;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += stats[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(h.hIndex(citations));
        System.out.println(h.hIndexWithMapping(citations));
    }
}
