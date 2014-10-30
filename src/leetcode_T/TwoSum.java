package leetcode_T;

import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        // List res = new ArrayList ();
        int[] res = new int [2];
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        // if (numbers.length < 2)
        //     return res;
        for (int i=0; i < len; i++){
            if (mp.get(numbers[i])==null){//找不到，所以为null。
                mp.put(numbers[i],i);
                //list.put();
            }
            if (mp.get(target - numbers[i])!=null){//找得到，所以不为null。
                int n = mp.get(target-numbers[i]);
                if (n<i){
                    // res.add(n+1);
                    // res.add(i+1);
                    res[0] = n+1;
                    res[1] = i+1;
                    break;
                    // return res;
                }
                //list.put(i+1);
            }
        }
        return res;
    }
	
	static public void main (String[] argv) {
		int[] num = {1,2,3,4,5,6,7,8,9, 20};
		int target = 25;
		int[] res  = new TwoSum().twoSum(num, target);
		for (int v : res ){
			System.out.println(v);
		}
	}
}
