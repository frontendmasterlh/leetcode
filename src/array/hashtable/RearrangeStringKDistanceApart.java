package array.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

 All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

 Example 1:
 str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3

 Answer: ""

 It is not possible to rearrange the string.
 Example 3:
 str = "aaadbbcc", k = 2

 Answer: "abacabcd"

 Another possible answer is: "abcabcda"

 The same letters are at least distance 2 from each other.
 */
public class RearrangeStringKDistanceApart {

    public String rearrangeString(String str, int k) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue( new Comparator<Map.Entry<Character, Integer>>(){
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> temp = new ArrayList<>();
            int count = Math.min(k, len);
            for (int i = 0; i < count; i++, len--) {
                if (pq.isEmpty()) {
                    return "";
                }
                Map.Entry<Character, Integer> entry = pq.poll();
                sb.append(entry.getKey());
                if (entry.getValue() > 1) {
                    entry.setValue(entry.getValue() - 1);
                    temp.add(entry);
                }
            }
            for (Map.Entry<Character, Integer> entry : temp) {
                pq.offer(entry);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RearrangeStringKDistanceApart rearrangeStringKDistanceApart = new RearrangeStringKDistanceApart();
        System.out.println(rearrangeStringKDistanceApart.rearrangeString("aabbcc", 3));
        System.out.println(rearrangeStringKDistanceApart.rearrangeString("aaabc", 3));
        System.out.println(rearrangeStringKDistanceApart.rearrangeString("aaadbbcc", 2));
        System.out.println(rearrangeStringKDistanceApart.rearrangeString("aaaabbbb", 2));
    }
}
