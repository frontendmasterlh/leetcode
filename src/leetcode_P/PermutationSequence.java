package leetcode_P;

import java.util.ArrayList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numberList = new ArrayList<Integer> ();
        for (int i=1; i<=n; i++) {
            numberList.add(i);
        }
        k--;//change to be index.
        int mod = 1;
        for (int i=1; i<=n; i++) {
            mod *= i;
        }
        String result = "";
        
        for (int i=0; i<n; i++) {
            mod = mod / (n-i);
            int curIndex = k / mod;
            k = k % mod;
            
            result += numberList.get(curIndex);
            numberList.remove(curIndex);
        }
        return result.toString();
    }
    
    static public void main (String argv[]) {
    	System.out.println(new PermutationSequence().getPermutation(8, 14));
    }
}
