package array.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 >represents land).


 We return the result as an array: [1, 1, 2, 3]
 */
public class NumberOfIslandsII {

    // Use union find to solve this question
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[m * n];
        Arrays.fill(arr, -1);
        int count = 0;

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < positions.length; i++) {
            count++;
            int index = positions[i][0] * n + positions[i][1];
            arr[index] = index;

            for (int j = 0; j < dir.length; j++) {
                int x = positions[i][0] + dir[j][0];
                int y = positions[i][1] + dir[j][1];
                if (x >= 0 && x < m && y >= 0 && y < n && arr[x * n + y] != -1) {
                    int root = getRoot(arr, x * n + y);
                    if (root != index) {
                        arr[root] = index;
                        count--;
                    }

                }
            }
            res.add(count);

//            for (int k = 0; k < arr.length; k++) {
//                if (k % n == 0) {
//                    System.out.println();
//                }
//                System.out.print(arr[k] + " ");
//            }
//            System.out.println(count);
        }
        return res;
    }

    private int getRoot(int[] arr, int index) {
        while (index != arr[index]) {
            arr[index] = arr[arr[index]];
            index = arr[index];
        }
        return index;
    }

    public static void main(String[] args) {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0,1}, {1, 2}, {2, 1}, {1, 1}, {2, 2}};
        List<Integer> res = numberOfIslandsII.numIslands2(m, n, positions);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
