package leetcode_R;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        if (A==null || A.length==0)
            return 0;
        int  n = A.length;
        int[] B = new int[n];
        int j=0;
        for (int i=0; i< n; i++){//Store the position that can be replace.
            if (A[i]==elem){
                B[j++] = i;
            }
        }
        
        for (int i = n-1, k = 0; n-1-i < j; i--){//There are j positions which need to be replace.
            if (A[i]==elem)
                continue;
            else {
                A[B[k++]] = A[i];//The order of the element can be changed.
            }
        }
        return n - j;
    }
	
	static public void main (String[] argv){
		int[] num = {1,2,3,3,5,6,3,7,9,1,2};
		System.out.println(new RemoveElement().removeElement(num, 1));
	}
}
