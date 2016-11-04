package array.strings;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int size = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += size) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int temp = j + size - 2 * i;
                    if (temp < n) {
                        sb.append(s.charAt(temp));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        System.out.println(z.convert("A", 1));
    }
}
