package leetcode_S;

public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A==null || A.length==0)
            return 0;
        for (int i=1; i< A.length; i++) {
            A[0] ^= A[i]; 
        }
        return A[0];
    }
    
    static public void main (String[] argv) {
    	int[] A = {2,3,4,5,6,2,4,5,6};
    	System.out.println(new SingleNumber().singleNumber(A));
    }
}
