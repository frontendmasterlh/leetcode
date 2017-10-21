package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                   | 0 0 1 |
 */
public class SparseMatrixMultiplication {

    // Time: O(n^3) Space: O(m * bn)
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int bn = B[0].length;
        int[][] C = new int[m][bn];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0 ; k < bn; k++) {
                    C[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return C;
    }

    // Time: O(n^3) Reduce the time to calculate with zero
    public int[][] multiplyWithHashMap(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) {
            return null;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int m = A.length;
        int n = A[0].length;
        int bn = B[0].length;
        int[][] C = new int[m][bn];
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < bn; j++) {
                if (B[i][j] != 0) {
                    map.get(i).put(j, B[i][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < bn; j++) {
                if (A[i][j] != 0) {
                    for (Integer k : map.get(j).keySet()) {
                        C[i][k] += A[i][j] * map.get(j).get(k);
                    }
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
//        int[][] res = sparseMatrixMultiplication.multiply(A, B);
        int[][] res = sparseMatrixMultiplication.multiplyWithHashMap(A, B);
        for (int[] re : res) {
            for (int r: re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

}
