package leetcode_L;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
        if (s.length()==0)
            return 0;
        int last=0;
        int temp = 0;
        for (int i=0; i< s.length(); i++){
            if (s.charAt(i)==' '){
                temp = 0;
            }else {
                temp++;
            }
            if (temp >0)
                last = temp;
        }
        return last;
    }
	
	static public void main (String argv[]) {
		String s = "Hello World";
		System.out.println(new LengthofLastWord().lengthOfLastWord(s));
	}
}
