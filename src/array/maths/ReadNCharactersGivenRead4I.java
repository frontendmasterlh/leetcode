package array.maths;

import java.util.Random;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note: The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4I {

    // Thought 1: if read4 value is 0 < x <= 4
    // Thought 2: return value is either n or the remaining length.
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        for (int i = 0; i < n; i += 4) {
            int len = read4(temp);
            System.arraycopy(temp, 0, buf, i, len);
            if (len < 4) {
                return Math.min(i + len, n);
            }
        }
        return n;
    }

    public int read4(char[] buf) {

        int len = new Random().nextInt(2) + 3;
        for (int i = 0; i < len; i++) {
            buf[i] = (char)('0' + i);
        }
        return len;
    }

    public static void main(String[] args) {
        ReadNCharactersGivenRead4I r = new ReadNCharactersGivenRead4I();
        int n = 10;
        char[] buf = new char[20];
        System.out.println(r.read(buf, n));
        for (char c : buf) {
            System.out.println(c);
        }
    }
}
