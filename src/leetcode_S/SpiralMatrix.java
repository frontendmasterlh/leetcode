package leetcode_S;

import java.util.ArrayList;

public class SpiralMatrix {
ArrayList<Integer> res;
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<Integer> ();
        if (matrix.length==0 || matrix[0].length==0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        int x1 = 0, y1 = 0;
        int x2 = n - 1, y2 = m - 1;
        getSolution (true, x1, y1, x2, y2, matrix);
        return res;
    }
    
    private void getSolution (boolean sign, int x1, int y1, int x2, int y2, int[][] matrix) {
        if (x1 == x2 && y1 == y2){
            res.add(matrix[y1][x1]);
            return;
        }
        if (sign){
            for (int i = x1; i <= x2; i++){
                res.add(matrix[y1][i]);
            }
            if (y1 < y2){
                for (int i = y1+1; i <= y2; i++){
                    res.add(matrix[i][x2]);
                }
            }
            int x3 = x2 - 1, y3 = y2;
            int x4 = x1, y4 = x1 + 1;
            if (x3 >= x4 && y3 >= y4){
                getSolution (!sign, x3, y3, x4, y4, matrix);
            }
        } else {
            for (int i = x1; i >= x2; i--){
                res.add(matrix[y1][i]);
            }
            if (y1 > y2){
                for (int i = y1 -1; i>= y2; i--) {
                    res.add(matrix[i][x2]);
                }
            }
            int x3 = x2 +1, y3 = y2;
            int x4 = x1, y4 = y1 -1;
            if (x3 <= x4 && y3 <= y4){
                getSolution (!sign, x3, y3, x4, y4, matrix);
            }
        }
    }
    
    static public void main (String[] argv){
    	;
    }
}
