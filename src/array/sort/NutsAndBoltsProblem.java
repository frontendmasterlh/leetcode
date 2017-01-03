package array.sort;

/**
 * http://www.lintcode.com/en/problem/nuts-bolts-problem/#
 */
/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
 */
public class NutsAndBoltsProblem {
    public interface NBComparator {
        public int cmp(String a, String b);
    }

    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || bolts == null) {
            return;
        }
        if (nuts.length != bolts.length) {
            return;
        }
        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void qsort(String[] nuts, String[] bolts, NBComparator compare, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivotIdx = partition(nuts, bolts[l], compare, l, r);
        partition(bolts, nuts[pivotIdx], compare, l, r);

        qsort(nuts, bolts, compare, l, pivotIdx - 1);
        qsort(nuts, bolts, compare, pivotIdx + 1, r);
    }

    private int partition(String[] str, String pivot, NBComparator compare, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (compare.cmp(str[i], pivot) == 0 ||
                compare.cmp(pivot, str[i]) == 0) {
                swap(str, i, r);
                break;
            }
        }
        String now = str[r];
        int left = l;
        int right = r - 1;
        while (left <= right) {
            if (compare.cmp(str[left], pivot) == 1 ||
                compare.cmp(pivot, str[left]) == -1) {
                left++;
            } else if (compare.cmp(str[right], pivot) == -1 ||
                       compare.cmp(pivot, str[right]) == 1) {
                right--;
            } else {
                swap(str, left++, right--);
            }
        }
        swap(str, left, r);
        // str[left] = now;
        return left;
    }

    private void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
