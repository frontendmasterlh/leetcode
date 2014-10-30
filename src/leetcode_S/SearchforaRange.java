package leetcode_S;

public class SearchforaRange {
	private int findPos (int[] A, int min, int max, int target, boolean findleft){
        if (min > max)
            return -1;
        int mid = (min + max) / 2;
        if (A[mid]==target){
            int pos = findleft ? findPos(A, min, mid-1, target, findleft) : findPos(A, mid+1, max, target, findleft);
            return pos==-1 ? mid : pos;
        }else if (A[mid] < target){
            return findPos(A, mid+1, max, target, findleft);
        }else
            return findPos(A, min, mid-1, target, findleft);
    }
    
    public int[] searchRange(int[] A, int target) {
        int n = A.length;
        int[] res = new int[2];
        int min = findPos (A, 0, n-1, target, true);
        int max = findPos (A, 0, n-1, target, false);
        res[0] = min;
        res[1] = max;
        return res;
        
        // int x = 0, y = A.length-1;// This is O(n), it's not satisfied with O(log n)
        // while (x < A.length && y>=0 && x <= y && A[x] != A[y]){
        //     if (A[x] < target)
        //         x++;
        //     if (A[y] > target)
        //         y--;
        // }
        // if (x <= y && A[x]==target){
        //     int[] res = new int[]{x, y};
        //     return res;
        // }else{
        //     int[] res = new int[]{-1, -1};
        //     return res;
        // }
    }
    
    static public void main (String[] argv){
    	int[] A = {1,2,3,3,4,5,5,5,6,7,8,8,8,8,8,8,8,8,9};
    	int target = 8;
    	int[] result = new SearchforaRange().searchRange(A, target);
    	for (int value : result)
    		System.out.println(value);
    }
}
