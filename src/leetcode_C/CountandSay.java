package leetcode_C;

public class CountandSay {
	private String getSolution (String s){
        StringBuilder res = new StringBuilder ();
        int count = 1;
        int pre = 0;
        for (int i =1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(pre)){
                count++;
            }else {
                res.append(count);
                res.append(s.charAt(pre));
                count = 1;
                pre = i;
            }
        }
        res.append(count); // Don't forget to add the last element.
        res.append(s.charAt(pre));
        return res.toString();
    }
    
    public String countAndSay(int n) {
        String res = "";
        if (n <= 0)
            return res;
        res += "1";
        for (int i = 1; i < n; i++) {
            res = getSolution (res);
        }
        return res;
    }
    
    static public void main (String[] argv) {
    	int n = 6;
    	System.out.println(new CountandSay().countAndSay(n));
    }
}
