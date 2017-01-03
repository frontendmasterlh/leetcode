package leetcode_N;

public class NextPermutation {
	private void swap (int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public void nextPermutation(int[] num) {
        int n = num.length;
        int edge = -1;
        for (int i=n-2; i>=0; i--) {
            if (num[i] < num[i+1]){
                edge = i;
                break;
            }
        }
        if (edge > -1){
            int j = edge + 2;
            while (j<n && num[edge] < num[j]){
                j++;
            }
            j--;
            swap(num, edge, j);
        }
        int i = edge+1;
        int j = n-1;
        while (i<j){
            swap (num, i, j);
            i++;
            j--;
        }
    }
    
    static public void main (String argv[]){
    	int[] num = {1,2,3,4,5,6,7,8,9};
    	new NextPermutation ().nextPermutation(num);
    	for (int value : num)
    		System.out.println(value);
//		System.out.println(num);
	}
}
