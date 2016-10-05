package array.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/anagrams/
 */
public class GroupAnagrams {
    // Time: O(n), Space: O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cArray = str.toCharArray();
            Arrays.sort(cArray);
            String newStr = new String(cArray);
            if (!map.containsKey(newStr)) {
                List<String> strList = new ArrayList<>();
                map.put(newStr, strList);
            }
            map.get(newStr).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams.groupAnagrams(strs);

        for (List<String> re : res) {
            for (String r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
