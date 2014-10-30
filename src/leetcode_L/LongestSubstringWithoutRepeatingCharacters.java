package leetcode_L;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)
            return 0;
        boolean[] c = new boolean[256];
        for (int i=0; i< c.length; i++) {
            c[i] = false;
        }
        int i=0, j=0;
        int max = 0;
        for (i=0; i< s.length(); i++) {
            if (c[(s.charAt(i))]==false) {
                c[(s.charAt(i))] = true;
                max = max > i-j+1 ? max : i - j +1;
            }else {
                while (s.charAt(i) != s.charAt(j)) {
                    c[(s.charAt(j))] = false;
                    j++;
                }
                j++;
            }
        }
        //max = 
        return max;
    }
	
	static public void main (String argv[]) {
		String s = "abcabcbb";
		
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
	}
}
