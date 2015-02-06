package leetcode_C;

public class Candy {
	public int candy(int[] ratings) {
        int n = ratings.length;
        int[] can = new int[n];
        int k = 0;
        
        for (int i=1; i< n; i++) {
            if (ratings[i] > ratings[i-1])
                can[i] = Math.max(++k, can[i]);
            else
                k = 0;
        }
        
        k = 0;
        for (int i = n-2; i>=0; i--){
            if (ratings[i] > ratings[i+1])
                can[i] = Math.max(++k, can[i]);
            else 
                k = 0;
        }
        
        int sum = n;//Each child has at least 1 candy.
        for (int i=0; i<n; i++) {
            sum += can[i];
        }
        return sum;
    }
	
	static public void main (String[] argv) {
		int[] s = {1,6,2,8,3,5,2,5,2,4,7,8,5,6,3,2,3,1};
		System.out.println(new Candy().candy(s));
	}
}
