package array.maths;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k %= factor;
            for (int j = 0; j < n; j++) {
                if (!used[j]) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char)('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor /= (n - 1 - i);
            }
        }
        return sb.toString();
    }
}
