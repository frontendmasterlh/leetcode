package array.maths;

import java.util.Random;

/**
 * Created by jli1 on 11/6/16.
 */
public class RandomRangeExpansion {

    public int getRandom(Random random, int oldNum, int newNum) {
        if (oldNum >= newNum) {
            int num = random.nextInt(oldNum);
            while (num > newNum) {
                num = random.nextInt(oldNum);
            }
            return num;
        } else {
            int range = 1;
            while (range * oldNum < newNum) {
                range++;
            }

            int num = getNewRandomNum(random, oldNum, range);
            while (num > newNum) {
                num = getNewRandomNum(random, oldNum, range);
            }
            return num % newNum;
        }
    }

    private int getNewRandomNum(Random random, int oldNum, int range) {
        int num = 0;
        for (int i = 0; i < range; i++) {
            num = num * oldNum + random.nextInt(oldNum);
        }
        return num;
    }

    public static void main(String[] args) {
        RandomRangeExpansion r = new RandomRangeExpansion();
        Random random = new Random();
        System.out.println(r.getRandom(random, 5, 7));
    }
}
