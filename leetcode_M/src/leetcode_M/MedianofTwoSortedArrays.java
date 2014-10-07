package leetcode_M;

public class MedianofTwoSortedArrays {
	private static int[] A = {1,3,5,8,10};
	private static int[] B = {2,4,9,15,18};
	
	private double findKth (int A[], int i, int m, int B[], int j, int n, int k) {
        if (m > n)
            return findKth (B,j, n, A, i, m, k);
        if (m==0)
            return B[j+k-1];
        if (k<=1)
            return Math.min(A[i], B[j]);
        int pa = Math.min(k/2, m), pb = k -pa;
        if (A[i+pa-1] < B[j+pb-1])
            return findKth (A, i+pa, m-pa, B,j, n, k-pa);
        else if (A[i+pa-1] > B[j+pb-1])
            return findKth (A, i, m, B, j+pb, n-pb, k-pb);
        else
            return A[i+pa-1];
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = m+n;
        if (k%2==1)
            return findKth(A, 0,m, B,0,n, k/2 +1);
        else 
            return (findKth(A,0,m, B,0,n, k/2) + findKth(A,0,m, B, 0, n, k/2 +1))/2;
    }
    
    static public void main (String argv[]){
		System.out.println(new MedianofTwoSortedArrays ().findMedianSortedArrays(A, B));
	}
}
