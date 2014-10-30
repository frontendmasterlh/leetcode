package leetcode_S;

public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        int x = 0, y = A.length - 1;
        int mid;
        while (x  <= y) {
            mid = (x + y) / 2;
            if (A[mid]==target)
                return mid;
            if (A[y] > A[mid]){//Must consider y first, since mid may equal to x.
                if (A[mid] <= target && target <= A[y]) {
                    x = mid +1;
                }else {
                    y = mid -1;
                }              
            }else {
                if (A[x] <= target && target <= A[mid]){ //The target can equal to A[x] or A[mid]
                    y = mid -1;
                }else {
                    x = mid +1;
                }
             
            }
        }
        // if (A[x] == target)
        //     return x;
        // if (A[y] == target)
        //     return y;
        return -1;
    }
	
	static public void main (String[] argv) {
		int[] A = {1, 3, 5};
		int target = 1;
		System.out.println(new SearchinRotatedSortedArray().search(A, target));
	}
}
