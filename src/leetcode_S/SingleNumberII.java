package leetcode_S;

public class SingleNumberII {
	public int singleNumber(int[] A) {
        int bit = 0;
        int result = 0;
        for (int i=0; i< 32; i++) {// Every Integer has 32 bits (4 bytes)
            bit = 0;
            for (int j = 0; j < A.length; j++) {
                if (((A[j]>>i)&1) == 1)
                    bit++;
            }
            bit %= 3;//In each bit, find whether it can be divided or not.
            result = result | bit<<i;// Or operation.
        }
        return result;
    }
	
	static public void main (String[] argv){
		int[] A = {1,1,1,4,4,4,7,7,7,8,8,8,3};
		System.out.println(new SingleNumberII().singleNumber(A));
	}
}
