package leetcode_R;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
        if (s==null || s.length()==0)
            return s;
        int i = s.length()-1;// Remember the index begins from 0 to length()-1;
        //StringBuffer sb = new StringBuffer();
        String res = new String();
        while (i >= 0 ){
            while (i >= 0 && s.charAt(i)==' '){
                i--;
            }
            if (i < 0)
                break;
            if (res.length() != 0)
                res = res + ' ';
            String temp = new String ();
            while (i>=0 && s.charAt(i)!=' '){
                temp = s.charAt(i) + temp;
                i--;
            }
            res = res + temp;
        }
        return res;
    }
	
	static public void main (String[] argv) {
		String s = "the sky is blue";
		System.out.println(new ReverseWordsinaString().reverseWords(s));
	}
}
