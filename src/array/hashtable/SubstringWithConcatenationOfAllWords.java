package array.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Better solution: http://www.cnblogs.com/springfor/p/3872516.html
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> hasMap = new HashMap<>();
        Map<String, Integer> needMap = new HashMap<>();
        int wlen = words[0].length();
        int llen = words.length;
        for (String word : words) {
            if (hasMap.containsKey(word)) {
                hasMap.put(word, hasMap.get(word) + 1);
            } else {
                hasMap.put(word, 1);
            }
        }

        for (int start = 0; start <= s.length() - wlen * llen; start++) {
            int index = start;
            int count = 0;
            needMap.clear();
            for (; count < llen && index + wlen <= s.length(); count++) {
                String sub = s.substring(index, index + wlen);
                index += wlen;
                Integer num = hasMap.get(sub);
                if (num != null &&  num > 0) {
                    Integer num2 = needMap.get(sub);
                    if (num2 != null) {
                        needMap.put(sub, num2 + 1);
                    } else {
                        needMap.put(sub, 1);
                    }
                    if (needMap.get(sub) > num) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (count == llen) {
                res.add(start);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        String[] strs = {"word","good","best","good"};
        List<Integer> res = substringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", strs);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
