package leetcode_U;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
        if (n <= 1)
            return 1;
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int k = 1; k <= i; k++){// K means the value of the root
                count[i] += count[k-1] * count[(i-1) - (k -1)];
            }
        }
        return count[n];
    }
	
	static public void main (String[] argv) {
		int n= 6;
		System.out.println(new UniqueBinarySearchTrees().numTrees(n));
	}
}
