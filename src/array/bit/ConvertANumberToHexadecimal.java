package array.bit;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

 Note:

 All letters in hexadecimal (a-f) must be in lowercase.
 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 You must not use any method provided by the library which converts/formats the number to hex directly.
 Example 1:

 Input:
 26

 Output:
 "1a"
 Example 2:

 Input:
 -1

 Output:
 "ffffffff"
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = 0;
            if ((num & (1 << i)) != 0) {
                temp = 1;
            }
            count = count * 2 + temp;
            if (i % 4 == 0) {
                if (count < 10) {
                    sb.append(count);
                } else {
                    sb.append((char)(count - 10 + 'a'));
                }
                count = 0;
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') { // the min length of sb should be 1
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
