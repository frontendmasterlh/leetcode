package leetcode_F;

public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] num) {
        if (num==null || num.length==0)
            return 0;
//        int min = num[0];// O(n)
//        for (int i=1; i< num.length; i++) {
//            if (num[i] < num[i-1]){
//                min = num[i];
//                break;
//            }
//        }
//        return min;
        
        int left = 0;//O(logN)
        int right = num.length-1;
        if (num[left] > num[right]){
        	while (left < right - 1){
        		int mid = (left + right) / 2;
        		if (num[left] < num[mid]){
        			left = mid;
        		}else{
        			right = mid;
        		}
        	}
        	return Math.min(num[left], num[right]);
        }
        return num[left];
    }
	
	static public void main (String[] argv) {
		int[] num = {7,8,9,10,1,2,3,4,5,6};
		System.out.println(new FindMinimuminRotatedSortedArray().findMin(num));
	}
}
