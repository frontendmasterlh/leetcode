package leetcode_A;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a==null || a.length()==0)
            return b;
        if (b==null || b.length()==0)
            return a;
        StringBuffer sb = new StringBuffer ();
        int carry =  0;
        int temp = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >=0 || j >=0){
            int al = 0;
            if (i>=0)
                al = a.charAt(i) - '0';
            int bl = 0;
            if (j>=0)
                bl = b.charAt(j) - '0';
            temp = al + bl + carry;
            carry = temp / 2;
            temp %= 2;
            sb.append(temp);
            i--;
            j--;
        }
        if (carry==1){
            sb.append(carry);
        }
        sb.reverse ();
        return sb.toString();
    }
	
	static public void main (String[] argv) {
		String a = "1";
		String b = "11";
		System.out.println(new AddBinary().addBinary(a, b));
	}
}
