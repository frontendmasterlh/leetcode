package leetcode_F;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        if (A==null && A.length==0)
            return 1;
        int n = A.length;
        for (int i = 0; i< n; i++){
            while (A[i] > 0 && A[i] != (i+1) && A[i] <= n && A[i] != A[A[i] - 1]){
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
        
        for (int i=0; i< n; i++) {
            if (A[i] != i+1)
                return i+1;
        }
        return n+1;
    }
	
	static public void main (String[] argv) {
		int[] A = {0,4,2,1};
		System.out.print(new FirstMissingPositive().firstMissingPositive(A));
	}
}
