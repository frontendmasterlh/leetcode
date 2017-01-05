package array.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth < 0) {
            return res;
        }
        int begin = 0;
        while (begin < words.length) {
            int idx = begin;
            int curSize = 0;
            while (idx < words.length) {
                int tempSize = curSize == 0 ? words[idx].length() : curSize + words[idx].length() + 1;
                if (tempSize <= maxWidth) {
                    curSize = tempSize;
                } else {
                    break;
                }
                idx++;
            }
            int end = idx - 1;
            int eachSpace = 0;
            int remainSpace = maxWidth - curSize;
            if (end != begin && end != words.length - 1) {
                eachSpace = remainSpace / (end - begin);
                remainSpace = remainSpace % (end - begin);
            } else {
                eachSpace = 0;
            }

            StringBuilder line = new StringBuilder();
            for (int i = begin; i <= end; i++) {
                if (i == begin) {
                    line.append(words[i]);
                } else {
                    line.append(" ");
                    for (int j = 0; j < eachSpace; j++) {
                        line.append(" ");
                    }
                    if (remainSpace > 0 && end != words.length - 1) { // If it's the last line, then there's no need to add
                        line.append(" ");                             // remaining space.
                        remainSpace--;
                    }
                    line.append(words[i]);
                }
            }
            while (remainSpace > 0) {
                line.append(" ");
                remainSpace--;
            }
            res.add(line.toString());
            begin = end + 1; // Remember to change the begin variable
        }
        return res;
    }

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        String[] words = {"What","must","be","shall","be."};
        int length = 12;
        List<String> res = t.fullJustify(words, length);
        for (String str : res) {
            System.out.println(str + ",");
        }
    }
}
