package leetcode_S;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length-1;
        while (x < matrix.length && y >= 0){
            if (matrix[x][y]==target)
                return true;
            else if (matrix[x][y] > target)
                y--;
            else 
                x++;
        }
        return false;
    }
    
    static public void main (String[] argv){
    	int[][] matrix = {{1,2},{3,4}};
    	int target = 3;
    	System.out.println(new Searcha2DMatrix().searchMatrix(matrix, target));;
    }
}
