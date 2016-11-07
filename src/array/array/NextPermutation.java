package array.array;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    private void swap (int[] num, int i, int j) {
        num[i] ^= num[j];
        num[j] ^= num[i];
        num[i] ^= num[j];
    }

    public void nextPermutation(int[] num) {
        if (num== null || num.length==0)
            return ;
        int n = num.length;
        int edge = -1;
        for (int i = n -2; i >= 0; i--) {
            if (num[i] < num[i+1]) { //Find the last position that num[i] < num[i+1].
                edge = i;
                break;
            }
        }
        if (edge > -1) {
            int j = edge + 2;
            while (j <n && num[edge] < num[j])
                j++;
            j--;
            swap(num, edge, j);    //Swap the elem between num[edge] and the one that's greater than num[edge]
        }
        int i = edge +1;
        int j = n -1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
}
