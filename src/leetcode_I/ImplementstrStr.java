package leetcode_I;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        
        /*Method 1::  Time: O(mn), Space: O(1)*/
        // int hlen = haystack.length();
        // int nlen = needle.length();
        // if (hlen < nlen)
        //     return -1;
        // int start = 0;
        // while (start <= hlen - nlen) {
        //     int i = start;
        //     int j = 0;
        //     while (i<hlen && j < nlen && haystack.charAt(i) == needle.charAt(j)){
        //         i++;
        //         j++;
        //     }
        //     if (j == nlen){
        //         return start;
        //     }
        //     start++;
        // }
        // return -1;
        
        /*Method 2:: Time: O() */
        // int i = haystack.indexOf(needle);
        // return i;
        
        /*Method 3::  KMP algorithm Time: O(m+n) Space: O(n)*/
        int hlen = haystack.length();
        int nlen = needle.length();
        if (nlen==0)
            return 0;
        if (hlen < nlen)
            return -1;
        int i = 0, j=0;
        int[] next = new int[nlen + 1];
        getNext(needle, next);
        while (i < haystack.length()) {
            while (j>=0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j];
            }
            i++;
            j++;
            if (j == nlen) {
                return i - j;
            }
        }
        return -1;
    }
    
    private void getNext (String needle, int[] next) {
        int i=0, j = -1;
        next[i] = j;
        while (i < needle.length()){
            while (j >= 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j];
            }
            i++;
            j++;
            next[i] = j;
        }
    }	
	
	
	static public void main (String[] argv) {
		String haystack = "awethhafhadfg";//"a";
		String needle = "g";//"";		
		System.out.println(haystack.indexOf(needle));//Method 2
		
		System.out.println(new ImplementstrStr().strStr(haystack, needle));
	}
}
