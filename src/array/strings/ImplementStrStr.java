package array.strings;

/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        // if ((haystack == null && needle == null) || (haystack.length() == 0 && needle.length() == 0)) {
        //     return 0;
        // }
        // for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        //     int j = 0;
        //     for (; j < needle.length(); j++) {
        //         if (haystack.charAt(i + j) != needle.charAt(j)) {
        //             break;
        //         }
        //     }
        //     if (j == needle.length()) {
        //         return i;
        //     }
        // }
        // return -1;

        if ((haystack == null && needle == null) || (haystack.length() == 0 && needle.length() == 0)) {
            return 0;
        }
        //1. needleHash =
        //2. haystack 0..nee
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int n = needle.length();
        long needleHash = 0;
        long tempHash = 0;
        long scale = (long) Math.pow(26, n - 1);
        for (int  i = 0; i < n; i++) {
            needleHash = needleHash * 26 + needle.charAt(i) - 'a';
            tempHash = tempHash * 26 + haystack.charAt(i) - 'a';
        }
        if (tempHash == needleHash) {
            return 0;
        }
        for (int i = n; i < haystack.length(); i++) {
            tempHash = (tempHash % scale) * 26 + haystack.charAt(i) - 'a';
            if (tempHash == needleHash) {
                return i - n + 1;
            }
        }
        return -1;
    }


    private int primeRK = 16777619;
    public boolean isMatchII(byte[] file, byte[] str) {
        if (str == null || str.length == 0) {
            return true;
        }
        long sHash = 0;
        long fHash = 0;
        for (int i = 0; i < str.length; i++) {
            sHash = sHash * primeRK + str[i];
            fHash = fHash * primeRK + file[i];
        }
        if (sHash == fHash) {
            return true;
        }
        long base = (long)Math.pow(primeRK, str.length - 1);
        for (int i = str.length; i < file.length; i++) {
            fHash = (fHash % base) * primeRK + file[i];
            if (fHash == sHash) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementStrStr i = new ImplementStrStr();

        byte[] file = {5, 1,2 ,4};
        byte[] str = {1, 2, 4};
        System.out.println(i.isMatchII(file, str));
//        String haystack = "aaaabaaabbabbaaaaaabbabbbaaabababaaaaabbbbbbbbbbbbbbbaabbbbabbaababbbababababaaaabbbbaaabababbbaaabbaabbabbbbbababbabbaabbbabaabaaaaabbbaaaaaabaaaabababababbaabaabbaaaaaaaababbabaa";
//        String needle = "aabbaaaabbbbaabaaabaabbaaababbabbbbbaba";
//
//        System.out.println(i.strStr(haystack, needle));
    }
}
