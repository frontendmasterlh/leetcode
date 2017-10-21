package array.strings;

/**
 *
 * https://stackoverflow.com/questions/37767472/check-for-the-validity-of-a-roman-number-difficult
 * */
public class ValidRoman {
    String letters = "IVXLCDM";

    public boolean isValidRoman(String roman) {
        if (roman == null || roman.length() == 0) {
            return true;
        }
        int i = 0;
        int count = 0;
        while (roman.charAt(i) == 'M') {
            count++;
            i++;
        }
        if (count > 3) {
            return false;
        }
        int j = letters.length() - 3;
        while (i < roman.length() && j >= 0) {
            if (roman.charAt(i) == letters.charAt(j)) {
                count = 0;
                while (i < roman.length() && roman.charAt(i) == letters.charAt(j)) {
                    count++;
                    i++;
                }
                if (count > 3) {
                    return false;
                } else if (count == 1) {
                    if (roman.charAt(i) != letters.charAt(j + 1) && roman.charAt(i) != letters.charAt(j + 2)) {
                        return false;
                    }
                    i++;
                }
            } else if (roman.charAt(i) == letters.charAt(j + 1)) {
                i++;
                count = 0;
                while (i < roman.length() && roman.charAt(i) == letters.charAt(j)) {
                    count++;
                    i++;
                }
                if (count > 3) {
                    return false;
                }
            }
            j -= 2;
        }
        return i == roman.length();
    }

    public static void main(String[] args) {
        ValidRoman v = new ValidRoman();
//        System.out.println(v.isValidRoman("IX"));
//        System.out.println(v.isValidRoman("VV"));
//        System.out.println(v.isValidRoman("IIII"));
        System.out.println(v.isValidRoman("IVIII"));
    }
}
