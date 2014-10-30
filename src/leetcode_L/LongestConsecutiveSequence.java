package leetcode_L;

import java.util.HashMap;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean> ();
        for (int i=0; i< num.length; i++) {
            visited.put(num[i], false);
        }
        int maxLen = 1;
        for (int i=0; i< num.length; i++) {
            if (visited.get(num[i])==true)
                continue;
            int count = 1;
            int left = num[i];
            while (visited.containsKey(--left)) {
                count++;
                visited.put(left,true);
            }
            int right = num[i];
            while (visited.containsKey(++right)) {
                count++;
                visited.put(right, true);
            }
            maxLen = Math.max (maxLen, count);
        }
        return maxLen;
    }
	
	static public void main (String argv[]) {
		int[] num = {100, 4, 200, 1, 3, 2};
		int result = new LongestConsecutiveSequence().longestConsecutive(num);
		System.out.println(result);
	}
}
