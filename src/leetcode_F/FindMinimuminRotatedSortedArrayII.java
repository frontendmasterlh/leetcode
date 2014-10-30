package leetcode_F;

public class FindMinimuminRotatedSortedArrayII {
	private int findM (int[] num, int left, int right) {
        if (left == right)
            return num[left];
        int mid = (left + right) / 2;
        int i = mid, j = mid;
        while (i>=left && num[i] == num[mid])
            i--;
        while (j<=right && num[j] == num[mid])
            j++;
        if (i < left) {
            if (right < j)
                return num[mid];
            else
                return Math.min(num[mid], findM(num, j, right));
        }else {
            if (right < j)
                return Math.min(num[mid], findM(num, left, i));
            else if (num[left] <= num[i])//it has the case that num[left]==num[right]
                return Math.min(num[left], Math.min(num[mid], findM(num, j, right)));
            else
                return Math.min(num[mid], Math.min(num[j], findM(num, left, i)));
        }
    }
    
    public int findMin(int[] num) {
        int min = Integer.MIN_VALUE;
        if (num==null || num.length==0)
            return min;
        return findM (num, 0, num.length -1);
    }
    
    static public void main (String[] argv) {
    	int[] num = {5,6,7, 1,2,3,4};
    	int res = new FindMinimuminRotatedSortedArrayII().findMin(num);
    	System.out.println(res);
    }
}
