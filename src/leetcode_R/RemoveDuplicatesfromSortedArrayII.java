package leetcode_R;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A==null)
            return 0;
        if (A.length==0 || A.length==1)
            return A.length;
        int lock = 0, temp = A[0], count = 0;
        for (int i=1; i< A.length; i++){
            if (temp==A[i]){
                if (++count > 1)
                    continue;
            }else {
                temp = A[i];
                count = 0;
            }
            A[++lock] = temp;
        }
        return lock+1;
    }
    
    static public void main (String[] argv){
    	int[] num = {1,2,3,4,5,5,5,6,6,7,8,9};
		System.out.println(new RemoveDuplicatesfromSortedArrayII().removeDuplicates(num));
    }
}
