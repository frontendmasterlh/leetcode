package leetcode_R;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int lock=0;
        for (int i=0;i< A.length; i++){
            if (A[i]==A[lock]){
                continue;
            }
            lock++;
            A[lock] = A[i];
        }
        return lock+1;
    }
	
	static public void main (String[] argv){
		int[] num = {1,2,3,4,5,5,5,6,6,7,8,9};
		System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(num));
	}
}
