package array.dfs;

import java.util.ArrayList;
import java.util.List;

/**
    In "the 100 game," two players take turns adding, to a running
    total, any integer from 1..10. The player who first causes the running
    total to reach or exceed 100 wins.
    What if we change the game so that players cannot re-use integers?
    For example, if two players might take turns drawing from a common pool of numbers
    of 1..15 without replacement until they reach a total >= 100. This problem is
    to write a program that determines which player would win with ideal play.

    Write a procedure, "Boolean canIWin(int maxChoosableInteger, int desiredTotal)",
    which returns true if the first player to move can force a win with optimal play.

    Your priority should be programmer efficiency; don't focus on minimizing
    either space or time complexity.
*/
public class CanIWin {

    //The catch is: when the largest number remaining is greater than the target remaining, the player is sure to win
    //helper returns true if the CURRENT player can win
    public boolean canIWin(int max, int target) {
        if (max < target || target <= 0) {
            return false;
        }
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            pool.add(i);
        }
        return helper(pool, target);
    }

    private boolean helper(List<Integer> pool, int target) {
        if (pool.get(pool.size() - 1) >= target) {
            return true;
        }
        for (int i = 0; i < pool.size(); i++) {
            int removed = pool.remove(i);
            boolean win = helper(pool, target - removed);
            pool.add(i, removed);
            if (win) {
                return true;
            }
        }
        return false;
    }
}
