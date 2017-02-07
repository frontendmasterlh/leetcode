package array.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * A string such as "word" contains the following abbreviations:
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
 Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.
 Note:
 In the case of multiple answers as shown in the second example below, you may return any one of them.
 Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
 Examples:
 "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

 "apple", ["plain", "amber", "blade"] -> "1p3" (other match answers include "ap3", "a3e", "2p2", "3le", "3l1").
 */
public class MinimumUniqueWordAbbreviation {

    // This question can be divided into 2 questions: generate abbr and check valid abbr
    // Use a min heap to store the candidate string.
    public String minAbbreviation(String target, List<String> dictionary) {
        if (target == null || target.length() == 0) {
            return "";
        }
        if (dictionary == null || dictionary.isEmpty()) {
            return Integer.toString(target.length());
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        generateWords(target, pq);

        while (!pq.isEmpty()) {
            String curStr = pq.poll();
            boolean noConflict = true;
            for (String word : dictionary) {
                if (match(word, curStr)) {
                    noConflict = false;
                    break;
                }
            }
            if (noConflict) {
                return curStr;
            }
        }
        return "";
    }

    private void generateWords(String target, PriorityQueue<String> pq) {
        explore(target, 0, new StringBuilder(), 0, pq);
    }

    private void explore(String target, int index, StringBuilder sb, int count, PriorityQueue<String> pq) {
        if (index == target.length()) {
            int i = sb.length();
            if (count != 0) {
                sb.append(count);
            }
            pq.offer(sb.toString());
            sb.delete(i, sb.length());
            return;
        }
        // abbr this char
        explore(target, index + 1, sb, count + 1, pq);

        // keep this char
        int i = sb.length();
        if (count != 0) {
            sb.append(count);
        }
        sb.append(target.charAt(index));
        explore(target, index + 1, sb, 0, pq);
        sb.delete(i, sb.length());
    }

    private boolean match(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                int start = j;
                while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    j++;
                }
                i += Integer.parseInt(abbr.substring(start, j));
            } else {
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        MinimumUniqueWordAbbreviation m = new MinimumUniqueWordAbbreviation();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("blade");
        String target = "apple";
        System.out.println(m.minAbbreviation(target, dictionary));
    }
}
