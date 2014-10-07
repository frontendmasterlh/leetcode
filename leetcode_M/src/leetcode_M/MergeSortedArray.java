package leetcode_M;

import java.util.Arrays;

public class MergeSortedArray {
	//private static int[] A = {1,3,5,0,0,0,0,0,0,0,0,0,0};
	//private static int[] B = {2,4,6,7,8,9,10};
	
	public void merge(int A[], int m, int B[], int n) {
        if (m!=0 && n!=0) {
            int lastA = m-1;
            int lastB = n-1;
            int last = m+n-1;
            while (true) {
                if (A[lastA] <= B[lastB]){
                    A[last--] = B[lastB--];
                    if (lastB<0)
                        break;
                }else if (A[lastA] > B[lastB]) {
                    A[last--] = A[lastA--];
                    if (lastA<0)
                        break;
                }
            }
            if (lastA <0){
                while (lastB>=0)
                    A[last--] = B[lastB--];
            }
            if (lastB <0) {
                while (lastA>=0)
                    A[last--] = A[lastA--];
            }
        }
        if (m==0 || A==null || A.length==0){
            for (int i=0; i<n; i++) {
                A[i] = B[i];
            }
        }
    }
	
	static public void main (String argv[]) {
		int[] A = new int[10];
		A[0] = 1; A[1] = 3; A[2] = 5;
		int[] B = {2,4,6,7,8,9,10};
		new MergeSortedArray().merge(A, 3, B, B.length);
		for (int value : A){
			System.out.println(value);
		}
		//System.out.println(Arrays.asList(A));
	}
}
