package array.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {
    //Time: O(n) Space: O(n)
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (map.containsKey(secret.charAt(i))) {
                map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
            } else {
                map.put(secret.charAt(i), 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {   //Firstly consider all the matched digits.
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            Integer count = map.get(guess.charAt(i));
            if (guess.charAt(i) != secret.charAt(i) && count != null && count > 0) {
                cow++;
                map.put(guess.charAt(i), count - 1);
            }
        }
        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println(bullsAndCows.getHint("1123", "0111"));
    }
}
