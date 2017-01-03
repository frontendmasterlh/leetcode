package leetcode_C;

import java.util.*;

public class CombinationSum {
	
	//Typical package problem.
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
        
        for (int i = 0; i <= target/candidates[depth]; i++) {
            a[depth] = i;
            solution(depth + 1, max, candidates, target - candidates[depth] * i, a);
        }
    }
    
    
    public List<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<ArrayList<Integer>> ();
        if (candidates==null || candidates.length==0)
            return res;
        int n = candidates.length;
        int[] a = new int[n];
        Arrays.sort(candidates);
        solution (0, n, candidates, target, a);
        return res;
    }
    
    static public void main (String[] argv){
    	CombinationSum cs = new CombinationSum();
    	int[] candidates = {1, 2, 4, 6};
    	int target = 15;
    	List<ArrayList<Integer>> res = cs.combinationSum(candidates, target);
    	for (ArrayList<Integer> v1 : res){
    		for (int v2 : v1){
    			System.out.print(v2 + " ");
    		}
    		System.out.println(" ");
    	}
    }
}
