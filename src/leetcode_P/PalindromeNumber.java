package leetcode_P;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x == 0)
            return true;
        if (x < 0)
            return false;
        int temp = x, res = 0;
        while (temp!=0) {
            res = res * 10 + temp %10;
            temp = temp / 10;
        }
        return res==x;
    }
	static public void main (String argv[]) {
		int x = 1234321;
		System.out.println(new PalindromeNumber().isPalindrome(x));
	}
}
