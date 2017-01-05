package array.maths;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note: The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes {

    Queue<Character> remain = new LinkedList<>();

    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n && !remain.isEmpty()) {
            buf[i] = remain.poll();
            i++;
        }
        for (; i < n; i += 4) {
            char[] temp = new char[4];
            int len  = read4(temp);
            if (len > n - i) {
                System.arraycopy(temp, 0, buf, i, n - i);
                for (int j = n - i; j < len; j++) {
                    remain.offer(temp[j]);
                }
            } else {
                System.arraycopy(temp, 0, buf, i, len);
            }
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
}
