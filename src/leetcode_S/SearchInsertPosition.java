package leetcode_S;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        int left = 0, right = A.length-1;
        while (left <= right) {
            if (A[left] >= target)
                return left;
            if (A[right] < target)
                return right +1;
                
            int mid = (left + right) / 2;
            if (A[mid]==target)
                return mid;
            else if (A[mid] > target){
                right = mid;
            }else 
                left = mid + 1;
        }
        return left; // If it doesn't find the target, it should be insert between right and left(now right + 1 == left)
    }
	
	static public void main (String[] argv){
		int[] num = {2,3,4,5,6,9};
		int target = 8;
		System.out.println(new SearchInsertPosition().searchInsert(num, target));
	}
}
