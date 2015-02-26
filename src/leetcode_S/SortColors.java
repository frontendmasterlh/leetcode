package leetcode_S;

public class SortColors {
    // private void swap (int[] num, int i, int j) { //What if i==j? It won't work!!!
    //     num[i] ^= num[j];
    //     num[j] ^= num[i];
    //     num[i] ^= num[j];
    // }
	
	private void swap (int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    
    public void sortColors(int[] A) {
        if (A==null || A.length==0)
            return ;
        int zero = 0, two = A.length-1;
        int i=0;
        while (i <= two) {
            if (A[i]==0){
                swap(A, i, zero);
                zero++;
                i++; //Since i increases all the time, so any elment between zero and i-1 must be 1.
            }else if (A[i]==1){
                i++;
            }else {
                swap (A, i, two);
                two--;
            }
        }
    }
    
    static public void main (String[] argv) {
    	int[] A = {2,1,0,2,2,1,1,0,0,2,1,1,0,2,1,0};
    	new SortColors().sortColors(A);
    	for (int v : A){
    		System.out.println(v);
    	}
    }
}
