package leetcode_F;

public class FindPeakElement {
	private int findPeak (int[] num, int left, int right) {
        int mid = (left + right) /2;
        if ((mid==0 || num[mid - 1] <= num[mid]) && (mid == num.length - 1 || num[mid + 1] <= num[mid]))
            return mid;
        if (mid > 0 && num[mid - 1] > num[mid]) {
            return findPeak (num, left, mid - 1);
        }else {
            return findPeak (num, mid + 1, right);
        }
    }
    
    
    public int findPeakElement(int[] num) {
        if (num== null || num.length == 0)
            return -1;
        return findPeak (num, 0, num.length -1);
    }
    
    static public void main (String[] argv) {
    	int[] num = {1,3,7,21,1};
    	System.out.println(new FindPeakElement().findPeakElement(num));
    }
}
