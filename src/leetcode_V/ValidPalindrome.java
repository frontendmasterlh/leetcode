package leetcode_V;

public class ValidPalindrome {
	private boolean isValid (String s, int i) {
        if ((s.charAt(i) >='0' && s.charAt(i) <= '9')||(s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='A' && s.charAt(i)<='Z'))
            return true;
        else
            return false;
    }
    
    public boolean isPalindrome(String s) {
        if (s== null || s.equals(""))
            return true;

        StringBuffer temp = new StringBuffer ();
        for (int i=0; i< s.length(); i++) {
            if (isValid(s, i)){
                if (s.charAt(i)>='A' && s.charAt(i) <= 'Z')
                    temp.append((char)(s.charAt(i) - 'A' + 'a'));//cast the type into char
                else
                    temp.append(s.charAt(i));
            }
        }
        String temp2 = temp.toString();
        int i = 0, k = temp2.length()-1;
        while (i <= k) {
            if (temp2.charAt(i)==temp2.charAt(k)){
                i++;
                k--;
            }else
                return false;
        }
        return true;
    }
    
    static public void main (String[] argv){
    	String s = "ASDF33fdsa";
    	System.out.println(new ValidPalindrome().isPalindrome(s));
    }
}
