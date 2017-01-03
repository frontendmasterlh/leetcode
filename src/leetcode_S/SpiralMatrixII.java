package leetcode_S;

public class SpiralMatrixII {
	private int[][] res;
    private int cur;
    public int[][] generateMatrix(int n) {
        if (n < 0)
            return null;
        res = new int[n][n];
        if (n==0)
            return res;
        cur = 1;
        getSolution (true,0,n-1, 0, n-1);
        return res;
    }
    
    private void getSolution (boolean sign,int x1, int y1, int x2, int y2) {
        if (x1==x2 && y1==y2){
            res[y1][x1] = cur++;
            return ;
        }
        if (sign){
            for (int i = x1; i <= x2; i++){
                res[y1][i] = cur++;
            }
            if (y1 < y2) {
                for (int i = y1 + 1; i <= y2; i++){
                    res[i][x2] = cur++;
                }
            }
            int x3 = x2 -1, y3 = y2;
            int x4 = x1, y4 = y1 +1;
            if (x3 >= x4 && y3 >= y4){
                getSolution (!sign, x3, y3, x4, y4);
            }
        } else {
            for (int i = x1; i>= x2; i--){
                res[y1][i] = cur++;
            }
            if (y1 > y2) {
                for (int i = y1 -1; i >= y2 ; i--) {
                    res[i][x2] = cur++;
                }
            }
            int x3 = x2 +1, y3 = y2;
            int x4 = x1, y4 = y1 - 1;
            if (x3 <= x4 && y3 <= y4){
                getSolution (!sign, x3, y3, x4, y4);
            }
        }
    }
    
    static public void main (String[] argv){
    	;
    }
}
