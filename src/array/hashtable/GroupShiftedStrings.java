package array.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 Return:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] charArray = str.toCharArray();
            if (charArray.length > 0) {
                int diff = charArray[0] - 'a';
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] - diff < 'a') {
                        charArray[i] = (char) (charArray[i] - diff + 26);
                    } else {
                        charArray[i] = (char) (charArray[i] - diff);
                    }
                }
            }

            String ns = new String(charArray);
            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                List<String> list = new ArrayList<>();
                map.put(ns, list);
                list.add(str);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        res.addAll(map.values());

        return res;
    }

    public static void main(String[] args) {
        GroupShiftedStrings g = new GroupShiftedStrings();
        String[] strings = {"abc", "bcd", "xyz", "az", "ba", "acef", "a", "z"};
        List<List<String>> res = g.groupStrings(strings);

        for (List<String> list : res) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
