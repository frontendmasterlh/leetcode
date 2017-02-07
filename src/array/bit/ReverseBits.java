package array.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 Related problem: Reverse Integer
 */
public class ReverseBits {

    private Map<Byte, Integer> cache = new HashMap<>();

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // int result = 0;
        // for (int i = 0; i < 32; i++) {
        //     int temp = n & 1;
        //     result = (result << 1) + temp;
        //     n >>>= 1;
        // }
        // return result;

        // Follow up: Use byte and then use hashmap as cache
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >>> (8 * i)) & 0xFF);
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int temp = reverseByte(bytes[i]);
            res = (res << 8) + temp;
        }
        return res;
    }

    private int reverseByte(byte b) {
        Integer num = cache.get(b);
        if (num != null) {
            return num;
        }
        num = 0;
        for (int i = 0; i < 8; i++) {
            int temp = (b >>> i) & 1;
            num = (num << 1) + temp;
        }
        cache.put(b, num);
        return num;
    }
}
