package array.binarysearch;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 Hint:

 Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = citations.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int h = citations.length - mid;
            if (citations[mid] >= h) {
                res = Math.max(res, h);
                right = mid;
            } else {
                res = Math.max(res, citations[mid]);
                left = mid;
            }
        }
        int h = Math.min(citations[left], citations.length - left);
        res = Math.max(res, h);
        h = Math.min(citations[right], citations.length - right);
        return Math.max(res, h);
    }
}
