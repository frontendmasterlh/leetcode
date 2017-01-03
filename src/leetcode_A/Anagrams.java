package leetcode_A;

import java.util.*;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String> ();
        if (strs==null || strs.length==0)
            return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i= 0; i< strs.length; i++) {
            String temp = strs[i];
            char[] c = temp.toCharArray();
            Arrays.sort (c);
            String key = new String(c);
            if (map.get(key)==null){
                map.put(key, i);
            }else {
                if (map.get(key) >= 0){
                    res.add(strs[map.get(key)]);//Add the previous word found.
                    map.put(key, -1);
                }
                res.add(strs[i]);
            }
        }
        return res;
    }
	
	static public void main (String[] argv){
		String[] s = {"cat", "act", "dog","dig"};
		List<String> res = new Anagrams().anagrams(s);
		for (String v : res){
			System.out.println(v);
		}
	}
}
