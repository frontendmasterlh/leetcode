package leetcode_C;

import java.util.*;

public class CombinationSumII {
	private List<ArrayList<Integer>> res;
    
    private void solution (int depth, int max, int[] candidates, int target, int[] a) {
        if (target < 0)
            return ;
        if (depth==max){
            if (target == 0){
                ArrayList<Integer> temp = new ArrayList<Integer> ();
                for (int i=0; i < max; i++){
                    for (int j = 0; j< a[i]; j++){
                        temp.add(candidates[i]);
                    }
                }
                res.add(temp);
            }
            return ;
        }
        
        for (int i = 0; i <= Math.min(1, target/candidates[depth]); i++) {
            if (depth != 0 && i ==1 && candidates[depth]==candidates[depth-1] && a[depth -1]==0)
                continue;
            a[depth] = i;
            solution(depth + 1, max, candidates, target - candidates[depth] * i, a);
        }
    }
    
    
    public List<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        res = new ArrayList<ArrayList<Integer>> ();
        if (num==null || num.length==0)
            return res;
        int n = num.length;
        int[] a = new int[n];
        Arrays.sort(num);
        solution (0, n, num, target, a);
        return res;
    }
    
    static public void main (String[] argv){
    	CombinationSumII cs = new CombinationSumII();
    	int[] candidates = {1, 2, 4, 6};
    	int target = 8;
    	List<ArrayList<Integer>> res = cs.combinationSum2(candidates, target);
    	for (ArrayList<Integer> v1 : res){
    		for (int v2 : v1){
    			System.out.print(v2 + " ");
    		}
    		System.out.println(" ");
    	}
    }
}
