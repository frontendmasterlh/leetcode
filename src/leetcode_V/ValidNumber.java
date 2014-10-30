package leetcode_V;

public class ValidNumber {
	public boolean isNumber(String s) {
        if (s.trim().isEmpty())
            return false;
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 
        if (s.trim().matches(regex))
            return true;
        else
            return false;
    }
	
	static public void main (String[] argv) {
		String s = "e9";
		System.out.println(new ValidNumber().isNumber(s));
	}
}
