package array.strings;

/**
 * Created by jli1 on 11/2/16.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder roman = new StringBuilder();
        int scale = 1000;
        for (int i = 6; i >= 0; i -= 2) {
            int digit = num / scale;
            if (digit >= 0 && digit <= 3) {
                for (int j = digit; j > 0; j--) {
                    roman.append(symbol[i]);
                }
            } else if (digit == 4) {
                roman.append(symbol[i]).append(symbol[i + 1]);
            } else if (digit == 5) {
                roman.append(symbol[i + 1]);
            } else if (digit <= 8) {
                roman.append(symbol[i + 1]);
                for (int j = digit; j >= 6; j--) {
                    roman.append(symbol[i]);
                }
            } else {
                roman.append(symbol[i]).append(symbol[i + 2]);
            }
            num %= scale;
            scale /= 10;
        }
        return roman.toString();
    }
}
