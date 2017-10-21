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
            int tempSize = 0;
            int curSize = 0;
            int idx = begin;
            for (; idx < words.length; idx++) {
                tempSize = curSize == 0 ? words[idx].length() : curSize + words[idx].length() + 1;
                if (tempSize > maxWidth) {
                    break;
                } else {
                    curSize = tempSize;
                }
            }

            int end = idx - 1;
            int eachSpace = 0;
            int remainSpace = maxWidth - curSize;
            if (begin != end && end != words.length - 1) {
                eachSpace = remainSpace / (end - begin);
                remainSpace %= (end - begin);
            }
            StringBuilder line = new StringBuilder();
            for (int i = begin; i <= end; i++) {
                if (i != begin) {
                    line.append(" ");
                    for (int j = 0; j < eachSpace; j++) {
                        line.append(" ");
                    }
                    if (remainSpace > 0 && end != words.length - 1) {// If it's the last line, then there's no need to add
                        line.append(" ");                            // remaining space.
                        remainSpace--;
                    }
                }
                line.append(words[i]);
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
//        String[] words = {"What","must","be","shall","be."};
//        int length = 12;
        String[] words = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
        int length = 20;
        List<String> res = t.fullJustify(words, length);
        for (String str : res) {
            System.out.println(str + ",");
        }
    }
}
