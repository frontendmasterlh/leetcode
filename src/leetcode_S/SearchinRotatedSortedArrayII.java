package leetcode_S;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A==null || A.length==0)
            return false;
        int left = 0, right = A.length-1;
        while (left <= right){
            int mid = (left + right) /2;
            if (A[mid]==target)
                return true;
            if (A[mid] < A[right]){
                if (A[mid] < target && target <= A[right]){
                    left = mid +1;
                }else
                    right = mid -1;
            }else if (A[mid] > A[right]){
                if (A[left] <= target && target < A[mid])
                    right = mid -1;
                else
                    left = mid + 1;
            }else {
                right--;//if mid and side are the same, we have to find the difference, that will cause O(n)
            }
        }
        return false;
    }
    
    static public void main (String[] argv) {
    	int[] A = {1, 3,3, 5};
		int target = 1;
		System.out.println(new SearchinRotatedSortedArrayII().search(A, target));
    }
}
