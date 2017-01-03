package leetcode_N;

import java.util.ArrayList;

public class NQueens {
    ArrayList<String[]> res;
    int[] row;
    int[] col;
    
    private boolean checkPosition (int[]queenlist,int row, int col) {
        for (int prerow = 0; prerow < row; prerow++) {
            int precol = queenlist[prerow];
            if (prerow==row || precol==col)
                return false;
            if (row - prerow == col - precol)
                return false;
            if (row + col == prerow + precol)
                return false;
        }
        return true;
    }
    
    private void dfs(int[]queenlist, int row, int n) {
        if (row==n) {
            StringBuilder[] str = new StringBuilder[n];
            for (int i= 0; i< n; i++) {
                str[i] = new StringBuilder ();
                for (int j = 0; j<n; j++) {
                    str[i].append('.');
                }
            }
            
            for (int i=0; i< n; i++) {
                str[i].setCharAt(queenlist[i],'Q');
            }
            String[] ss = new String[n];
            for (int i=0; i< n; i++) {
                ss[i] = str[i].toString();
            }
            res.add(ss);
            return ;
        }
        for (int col=0; col < n; col++) {
            if (checkPosition(queenlist, row, col)){
                queenlist[row] = col;
                dfs(queenlist, row+1, n);
            }
        }
    } 
    
    
    public ArrayList<String[]> solveNQueens(int n) {
        res = new ArrayList<String[]> ();
        //row = new int[1000];
        //col = new int[1000];
        int[] queenlist = new int[n];
        if (n==0)
            return res;
        dfs (queenlist,0, n);
        return res;
    }
    
    static public void main (String argv[]){
    	;
    }
}
