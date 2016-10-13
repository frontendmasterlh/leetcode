package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNASequences {
    // Time: O(n) Space: O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        for (int i = 0; i <= s.length() - 10; i++) {
            int j = i + 10;
            String sub = s.substring(i, j);
            Integer count = map.get(sub);
            if (count != null) {
                map.put(sub, count + 1);
                if (count == 1) {
                    res.add(sub);
                }
            } else {
                map.put(sub, 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> res = repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String re : res) {
            System.out.println(re);
        }
    }
}
