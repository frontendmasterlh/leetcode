package leetcode_N;

public class NQueensII {
	int res;
    
    private boolean checkPosition (int[] queenlist, int row, int col) {
        for (int preRow = 0; preRow < row; preRow++) {
            int preCol = queenlist[preRow];
            if (preCol == col)
                return false;
            if (preRow + preCol == row+col)
                return false;
            if (row - preRow == col - preCol)
                return false;
        }
        return true;
    }
    
    private void countqueen (int[] queenlist, int row, int n) {
        if (row==n) {
            res++;
            return ;
        }
        for (int col =0; col < n; col++) {
            if (checkPosition(queenlist,row, col)){
                queenlist[row] = col;
                countqueen(queenlist, row+1, n);
            }
        }
    }
    
    public int totalNQueens(int n) {
            int[] queenlist = new int[n];
        res = 0;
        countqueen(queenlist,0,n);
        return res;
    }
    
    static public void main (String argv[]){
    	;
    }
}
