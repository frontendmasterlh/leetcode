package array.strings;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAStringII {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);  // The 3rd param should be len - 1 to avoid outOfBoundException
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j - 1); // Same here
                i = j + 1;
            }
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringII r = new ReverseWordsInAStringII();
        String str = "the sky is blue";
        char[] s = str.toCharArray();
        r.reverseWords(s);
        for (char c : s) {
            System.out.print(c);
        }
    }
}
